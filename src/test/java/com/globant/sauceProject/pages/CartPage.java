package com.globant.sauceProject.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
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
    }

    /**
     * Obtiene el número de elementos en el carrito.
     * muestra El número de elementos actualmente en el carrito.
     */
    public int getCartItemCount() {
        this.wait.until(ExpectedConditions.visibilityOf(cartContentsContainer));
        int itemCount = cartItemsList.size();
        if (itemCount > 0) {
            this.logs.info("Número de productos en el carrito: " + itemCount);
        } else {
            this.logs.info("El carrito está vacío.");
        }
        return itemCount;
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
