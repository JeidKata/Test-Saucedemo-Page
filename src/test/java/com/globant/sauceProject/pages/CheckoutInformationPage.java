package com.globant.sauceProject.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.logging.Logger;

public class CheckoutInformationPage extends BasePage{
    private Logger log = Logger.getLogger(CheckoutInformationPage.class.getName());

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
     * Metodo para ingresar firstName, lastName y postCode de checkout.
     */
    public void enterCheckoutInformation(String firstName, String lastName, String postalCode) {
        firstNameField.sendKeys(firstName);
        lastNameField.sendKeys(lastName);
        postalCodeField.sendKeys(postalCode);
        log.info("Checkout information entered: " + firstName + " " + lastName + ", Postal Code: " + postalCode);
    }

    /**
     * Metodo para hacer clic en el botón de continuar.
     */
    public void clickContinueButton() {
        continueButton.click();
        log.info("Clicked on the continue button.");
    }
}
