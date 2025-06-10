package com.globant.sauceProject.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class ProductsPage extends BasePage {
    @FindBy(css = ".inventory_item")
    private List<WebElement> productList;

    @FindBy(className = "shopping_cart_link")
    private WebElement shoppingCartLink;

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    /**
     * Metodo para agregar 3 productos al carrito.
     */
    public void addThreeProductsToCart() {
        this.wait.until(ExpectedConditions.visibilityOfAllElements(productList));
        if (productList != null && productList.size() >= 3) {
            try{
                for (int i = 0; i < 3; i++) {
                    WebElement addToCartButton = productList.get(i).findElement(By.cssSelector(".btn_inventory"));
                    addToCartButton.click();
                    logs.info("Added product " + (i + 1) + " to the cart.");
                }
            } catch (Exception e) {
                logs.info("Error while adding products: " + e.getMessage());
            }
        } else {
            logs.info("Not enough products available to add to the cart.");
        }
    }

    /**
     * Metodo para hacer clic en el enlace del carrito de compras.
     */
    public void clickShoppingCart() {
        this.wait.until(ExpectedConditions.visibilityOf(shoppingCartLink));
        shoppingCartLink.click();
        logs.info("Clicked on the shopping cart link.");
    }
}
