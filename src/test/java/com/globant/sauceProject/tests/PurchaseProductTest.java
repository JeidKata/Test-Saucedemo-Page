package com.globant.sauceProject.tests;

import com.globant.sauceProject.data.Data;
import com.globant.sauceProject.pages.BasePage;
import com.globant.sauceProject.pages.LoginPage;
import com.globant.sauceProject.pages.ProductsPage;
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
    private LoginPage login;
    private BasePage base;
    private ProductsPage products;

    @BeforeMethod
    public void setUp() {
        logs.info("Setting up the test environment.");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(URL);
        login = new LoginPage(driver, URL);
        base = new BasePage(driver);
        products = new ProductsPage(driver, URL);
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
    }
}
