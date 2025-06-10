package com.globant.sauceProject.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class LoginPage extends BasePage{

    @FindBy(id = "user-name")
    private WebElement userNameField;

    @FindBy(id = "password")
    private WebElement passwordField;

    @FindBy(id = "login-button")
    private WebElement loginButton;

    @FindBy(css = "h3[data-test='error']")
    private WebElement errorMessage;

    /**
     * Constructor para LoginPage.
     * driver Instancia de WebDriver.
     */
    public LoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
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
            logs.warn("Login page is not displayed: " + e.getMessage());
            return false;
        }
    }

    /**
     * Metodo para verificar si el mensaje de error se muestra.
     * Este metodo se utiliza para validar que un usuario bloqueado no pueda iniciar sesion.
     */
    public boolean isErrorMessageDisplayed() {
        try {
            wait.until(ExpectedConditions.visibilityOf(errorMessage));
            logs.info("Error message is displayed for blocked user.");
            return true;
        } catch (Exception e) {
            logs.warn("Error message is not displayed: " + e.getMessage());
            return false;
        }
    }
}
