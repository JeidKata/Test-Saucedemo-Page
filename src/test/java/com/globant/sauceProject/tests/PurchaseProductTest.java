package com.globant.sauceProject.tests;

import com.globant.sauceProject.data.Data;
import com.globant.sauceProject.pages.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.logging.Logger;

public class PurchaseProductTest {

    public Logger logs = Logger.getLogger(LogoutTest.class.getName());
    private static final String URL = "https://www.saucedemo.com/";
    private WebDriver driver;
    private BasePage base;
    private LoginPage login;
    private ProductsPage products;
    private CartPage cart;

    @BeforeMethod
    public void setUp() {
        logs.info("Setting up the test environment.");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(URL);
        base = new BasePage(driver);
        login = new LoginPage(driver);
        products = new ProductsPage(driver);
        cart = new CartPage(driver);
    }

    @Test(groups = {"dataLogin"}, description = "Inicio sesión", dataProvider = "loginData", dataProviderClass = Data.class)
    public void testLogin (String username, String password) {
        logs.info("Probando Login con: ");
        logs.info("Username: " + username + System.lineSeparator() +
                "Contraseña: " + password + System.lineSeparator());
        base.getLogo();
        login.enterUsername(username);
        login.enterPassword(password);
        login.clickLoginButton();
        logs.info("Probando agregar productos al carrito.");
        products.addThreeProductsToCart();
        products.clickShoppingCart();
        logs.info("Productos agregados al carrito y se ha hecho clic en el enlace del carrito de compras.");
        cart.getCartItemCount();
        cart.clickCheckoutButton();
    }
}
