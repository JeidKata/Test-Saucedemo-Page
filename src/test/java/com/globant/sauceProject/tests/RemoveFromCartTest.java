package com.globant.sauceProject.tests;

import com.globant.sauceProject.pages.*;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class RemoveFromCartTest extends BaseTest{

    @Parameters({"username", "password"})
    @Test(description = "Verifica la eliminación de productos del carrito de compras.")
    public void testRemoveItemsFromCart(String username, String password) {
        /** Inicializar Page Objects específicos de la prueba*/
        MenuSection menu = new MenuSection(driver);
        LoginPage login = new LoginPage(driver);
        ProductsPage products = new ProductsPage(driver);
        CartPage cart = new CartPage(driver);

        menu.getLogo();
        logger.info("Testing Login with: \nUsername: " + username + System.lineSeparator() +
                "Password: " + password + System.lineSeparator());
        login.enterUsername(username);
        login.enterPassword(password);
        login.clickLoginButton();

        logger.info("Add 3 products to cart.");
        products.addThreeProductsToCart();
        products.clickShoppingCart();

        logger.info("Navigating to the cart page.");
        Assert.assertEquals(cart.getCartItemCount(), 3, "The cart should contain 3 elements.");
        cart.removeProduct();
        logger.info("Products removed from your cart.");

        Assert.assertEquals(cart.getCartItemCount(), 0, "Cart should be empty after removing products.");
    }
}
