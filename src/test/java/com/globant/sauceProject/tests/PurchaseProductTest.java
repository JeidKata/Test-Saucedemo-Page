package com.globant.sauceProject.tests;

import com.globant.sauceProject.pages.*;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class PurchaseProductTest extends BaseTest{

    @Parameters ({"username", "password", "firstName", "lastName", "postalCode"})
    @Test(groups = {"success"},description = "Verify the complete purchase flow.")
    public void testPurchaseProductComplete (String username, String password, String firstName, String lastName, String postalCode) {

        MenuSection menu = new MenuSection(driver);
        LoginPage login = new LoginPage(driver);
        ProductsPage products = new ProductsPage(driver);
        CartPage cart = new CartPage(driver);
        CheckoutInformationPage checkoutInformation = new CheckoutInformationPage(driver);
        CheckoutOverviewPage checkoutOverview = new CheckoutOverviewPage(driver);
        CheckoutCompletePage checkoutComplete = new CheckoutCompletePage(driver);

        menu.getLogo();
        logger.info("Testing Login with: \nUsername: " + username + System.lineSeparator() +
                "Password: " + password + System.lineSeparator());
        login.enterUsername(username);
        login.enterPassword(password);
        login.clickLoginButton();

        logger.info("Trying to add products to the cart.");
        products.addThreeProductsToCart();
        products.clickShoppingCart();

        logger.info("Products added to the cart and the shopping cart link has been clicked.");
        Assert.assertTrue(cart.getCartItemCount() > 0, "The cart should contain at least one product.");
        cart.clickCheckoutButton();

        logger.info("Proceeding to checkout information. \nFirst Name: " + firstName + System.lineSeparator() +
                "Last Name: " + lastName + System.lineSeparator() +
                "Postal Code: " + postalCode + System.lineSeparator());
        checkoutInformation.enterFirstName(firstName);
        checkoutInformation.enterLastName(lastName);
        checkoutInformation.enterPostalCode(postalCode);
        checkoutInformation.clickContinueButton();

        logger.info("Proceeding to checkout overview.");
        Assert.assertTrue(checkoutOverview.isCheckoutOverviewPageLoaded(),"Checkout Overview page loaded successfully.");
        checkoutOverview.clickFinishButton();

        logger.info("Proceeding to checkout complete.");
        checkoutComplete.isCheckoutComplete();
        checkoutComplete.clickBackHomeButton();
    }

    @Parameters({"username1", "password1"})
    @Test(groups = {"locked"},description = "Blocked user cannot log in.")
    public void testBlockedUserCannotLogin(String username, String password) {

        LoginPage login = new LoginPage(driver);

        logger.info("Testing blocked user login with: \nUsername: " + username + System.lineSeparator() +
                "Password: " + password + System.lineSeparator());
        login.enterUsername(username);
        login.enterPassword(password);
        login.clickLoginButton();

        Assert.assertTrue(login.isErrorMessageDisplayed(), "Error message is displayed for blocked user.");
    }
}
