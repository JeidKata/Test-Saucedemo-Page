package com.globant.sauceProject.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.logging.Logger;

public class LoginPage {
    private WebDriver driver;
    private WebDriverWait wait;
    public Logger logs = Logger.getLogger(LoginPage.class.getName());

    @FindBy(id = "user-name")
    private WebElement userNameField;

    @FindBy(id = "password")
    private WebElement passwordField;

    @FindBy(id = "login-button")
    private WebElement loginButton;

    /**
     * Constructor para LoginPage.
     * driver Instancia de WebDriver.
     */
    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
        this.wait = new WebDriverWait(driver,  Duration.ofSeconds(5));
    }

    /**
     * Metodo para ingresar el usuaria.
     */
    public void enterUsername(String username) {
        userNameField.sendKeys(username);
        logs.info("Username entered: " + username);
    }

    /**
     * Metodo para ingresar la contrasena.
     */
    public void enterPassword(String password) {
        passwordField.sendKeys(password);
        logs.info("Password entered: " + password);
    }

    /**
    * Metodo para dar clic en el boton Login.
    */
    public void clickLoginButton() {
        loginButton.click();
        logs.info("Login button clicked.");
    }

    /**
     * metodo para validar que esta en la pagina de login.
     */
    public boolean isLoginPage() {
        try {
            wait.until(ExpectedConditions.visibilityOf(loginButton));
            logs.info("Login page is displayed.");
            return true;
        } catch (Exception e) {
            logs.warning("Login page is not displayed: " + e.getMessage());
            return false;
        }
    }
}
