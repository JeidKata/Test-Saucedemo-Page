package com.globant.sauceProject.tests;

import com.globant.sauceProject.pages.*;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class PurchaseProductTest extends BaseTest{
    @Parameters ({"username", "password", "firstName", "lastName", "postalCode"})
    @Test(description = "Verifica el flujo de compra completo.")
//            (groups = {"dataLogin"}, description = "Inicio sesión",dataProvider = "loginData", dataProviderClass = Data.class)
    public void testPurchaseProductComplete (String username, String password, String firstName, String lastName, String postalCode) {
        MenuSection menu = new MenuSection(driver);
        LoginPage login = new LoginPage(driver);
        ProductsPage products = new ProductsPage(driver);
        CartPage cart = new CartPage(driver);
        CheckoutInformationPage checkoutInformation = new CheckoutInformationPage(driver);
        CheckoutOverviewPage checkoutOverview = new CheckoutOverviewPage(driver);
        CheckoutCompletePage checkoutComplete = new CheckoutCompletePage(driver);
        logger.info("Testing Login with: \nUsername: " + username + System.lineSeparator() +
                "Password: " + password + System.lineSeparator());
        menu.getLogo();
        login.enterUsername(username);
        login.enterPassword(password);
        login.clickLoginButton();
        logger.info("Trying to add products to the cart.");
        products.addThreeProductsToCart();
        products.clickShoppingCart();
        logger.info("Products added to the cart and the shopping cart link has been clicked.");
        Assert.assertTrue(cart.getCartItemCount() > 0, "The cart should contain at least one product.");
        cart.clickCheckoutButton();
        logger.info("Proceeding to checkout information.");
        checkoutInformation.enterFirstName(firstName);
        checkoutInformation.enterLastName(lastName);
        checkoutInformation.enterPostalCode(postalCode);
        checkoutInformation.clickContinueButton();
        logger.info("Proceeding to checkout overview.");
        checkoutOverview.isCheckoutOverviewPageLoaded();
        checkoutOverview.clickFinishButton();
        logger.info("Proceeding to checkout complete.");
        checkoutComplete.isCheckoutComplete();
        checkoutComplete.clickBackHomeButton();
    }
//    @AfterMethod
//    public void testCheckout(String firstName, String lastName, String postalCode) {
//        logger.info("Probando Checkout con: ");
//        logger.info("First Name: " + firstName + System.lineSeparator() +
//                "Last Name: " + lastName + System.lineSeparator() +
//                "Postal Code: " + postalCode + System.lineSeparator());
//        checkoutInformation.enterCheckoutInformation(firstName, lastName, postalCode);
//        checkoutInformation.clickContinueButton();
//    }
}
