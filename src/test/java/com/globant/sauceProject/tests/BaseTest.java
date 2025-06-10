package com.globant.sauceProject.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.time.Duration;

public class BaseTest {
    private static final String URL = "https://www.saucedemo.com/";
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected static final Logger logger = Logger.getLogger(BaseTest.class);

    /**
     * Configura WebDriverManager para Chrome antes de todas las pruebas.
     */
    @BeforeSuite
    public void setupWebDriverManager() {
        WebDriverManager.chromedriver().setup();
        logger.info("WebDriverManager configured for Chrome.");
    }

    /**
     * Inicializa el WebDriver y navega a la URL base antes de cada método de prueba.
     * Realiza el login automático con el usuario estándar.
     */
    @BeforeMethod
    public void setup() {
        logger.info("Starting the test setup...");
        logger.info("Setting up the test environment.");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-extensions"); // Deshabilita extensiones

        this.wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        driver.get("https://www.saucedemo.com/");
        logger.info("Navigating to: https://www.saucedemo.com/");
    }

    /**
     * Cierra el navegador después de cada metodo de prueba.
     */
    @AfterMethod
    public void teardown() {
        if (driver != null) {
            driver.quit();
            logger.info("Close browser.");
        }
        logger.info("Test configuration completed.");
    }
}
