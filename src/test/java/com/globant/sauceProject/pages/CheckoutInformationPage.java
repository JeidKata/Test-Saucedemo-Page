package com.globant.sauceProject.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CheckoutInformationPage extends BasePage{

    @FindBy(id = "first-name")
    private WebElement firstNameField;

    @FindBy(id = "last-name")
    private WebElement lastNameField;

    @FindBy(id = "postal-code")
    private WebElement postalCodeField;

    @FindBy(id = "continue")
    private WebElement continueButton;

    public CheckoutInformationPage(WebDriver driver) {
        super(driver);
    }

    /**
     * Metodos para ingresar firstName, lastName y postCode de checkout.
     */
    public void enterFirstName(String firstName) {
        this.wait.until(ExpectedConditions.visibilityOf(firstNameField)).isDisplayed();
        firstNameField.sendKeys(firstName);
        logs.info("Entered first name: " + firstName);
    }

    public void enterLastName(String lastName) {
        lastNameField.click();
        lastNameField.sendKeys(lastName);
        logs.info("Entered last name: " + lastName);
    }

    public void enterPostalCode(String postalCode) {
        postalCodeField.click();
        postalCodeField.sendKeys(postalCode);
        logs.info("Entered postal code: " + postalCode);
    }

    /**
     * Metodo para hacer clic en el botón de continuar.
     */
    public void clickContinueButton() {
        this.wait.until(ExpectedConditions.elementToBeClickable(continueButton)).isDisplayed();
        continueButton.click();
        logs.info("Clicked on the continue button.");
    }
}
