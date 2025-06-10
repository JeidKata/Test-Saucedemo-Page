package com.globant.sauceProject.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class CartPage extends BasePage{

    @FindBy(className = "cart_item")
    private List<WebElement> cartItemsList;

    @FindBy(id = "cart_contents_container")
    private WebElement cartContentsContainer;

    @FindBy(id = "checkout")
    private WebElement checkoutButton;

    public CartPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    /**
     * Obtiene el número de elementos en el carrito.
     * muestra El número de elementos actualmente en el carrito.
     */
    public int getCartItemCount() {
        this.wait.until(ExpectedConditions.visibilityOf(cartContentsContainer));
        int itemCount = cartItemsList.size();
        if (itemCount > 0) {
            this.logs.info("Number of products in the cart " + itemCount);
        } else {
            this.logs.info("Cart is empty.");
        }
        return itemCount;
    }

    /**
     * Elimina un producto del carrito por su nombre.
     * productName El nombre del producto a eliminar.
     */
    public void removeProduct() {
        wait.until(ExpectedConditions.visibilityOfAllElements(cartItemsList));
        for (WebElement item : cartItemsList) {
            String currentProductName = item.findElement(By.cssSelector(".inventory_item_name")).getText();
            WebElement removeButton = item.findElement(By.cssSelector("button[id^='remove-']"));
            removeButton.click();
            logs.info("Product '" + currentProductName + "' removed from cart.");
        }
        for (WebElement item : cartItemsList) {
            String currentProductName = item.findElement(By.cssSelector(".inventory_item_name")).getText();
            logs.info("Product '" + currentProductName + "' is still in the cart.");
        }
    }

    /**
     * Metodo para hacer clic en el botón de checkout.
     */
    public void clickCheckoutButton() {
        this.wait.until(ExpectedConditions.elementToBeClickable(checkoutButton));
        checkoutButton.click();
        this.logs.info("Click on the checkout button.");
    }
}
