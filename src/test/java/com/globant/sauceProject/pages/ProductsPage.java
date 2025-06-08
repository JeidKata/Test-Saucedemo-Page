package com.globant.sauceProject.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.support.PageFactory.initElements;

public class ProductsPage extends BasePage {
    @FindBy(linkText = "Add to cart")
    private WebElement addToCartButton;

    @FindBy(className = "shopping_cart_link")
    private WebElement shoppingCartLink;

    public ProductsPage(WebDriver driver, String url, WebDriverWait wait) {
        super(driver);
        driver.get(url);
        initElements(driver, this);
    }

    /**
     * Metodo para agregar 3 productos al carrito.
     */
    public void addThreeProductsToCart() {
        for (int i = 0; i < 3; i++) {
            addToCartButton.click();
            System.out.println("Product " + (i + 1) + " added to cart.");
        }
    }

    /**
     * Metodo para hacer clic en el enlace del carrito de compras.
     */
    public void clickShoppingCart() {
        this.wait.until(ExpectedConditions.visibilityOf(shoppingCartLink));
        shoppingCartLink.click();
        System.out.println("Clicked on the shopping cart link.");
    }
}
