package com.globant.sauceProject.tests;

import com.globant.sauceProject.pages.*;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class PurchaseProductTest extends BaseTest{
    @Parameters ({"username", "password", "firstName", "lastName", "postalCode"})
    @Test(description = "Verifica el flujo de compra completo.")
//            (groups = {"dataLogin"}, description = "Inicio sesión",dataProvider = "loginData", dataProviderClass = Data.class)
    public void testLogin (String username, String password, String firstName, String lastName, String postalCode) {
        BasePage base = new BasePage(driver);
        LoginPage login = new LoginPage(driver);
        ProductsPage products = new ProductsPage(driver);
        CartPage cart = new CartPage(driver);
        CheckoutInformationPage checkoutInformation = new CheckoutInformationPage(driver);
        CheckoutOverviewPage checkoutOverview = new CheckoutOverviewPage(driver);
        CheckoutCompletePage checkoutComplete = new CheckoutCompletePage(driver);
        logger.info("Probando Login con: ");
        logger.info("Username: " + username + System.lineSeparator() +
                "Contraseña: " + password + System.lineSeparator());
        base.getLogo();
        login.enterUsername(username);
        login.enterPassword(password);
        login.clickLoginButton();
        logger.info("Probando agregar productos al carrito.");
        products.addThreeProductsToCart();
        products.clickShoppingCart();
        logger.info("Productos agregados al carrito y se ha hecho clic en el enlace del carrito de compras.");
        Assert.assertTrue(cart.getCartItemCount() > 0, "El carrito debería contener al menos un producto.");
        cart.clickCheckoutButton();
        checkoutInformation.enterFirstName(firstName);
        checkoutInformation.enterLastName(lastName);
        checkoutInformation.enterPostalCode(postalCode);
        checkoutInformation.clickContinueButton();
        checkoutOverview.isCheckoutOverviewPageLoaded();
        checkoutOverview.clickFinishButton();
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
