package com.globant.sauceProject.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CheckoutOverviewPage extends BasePage{

    @FindBy(id = "finish")
    private WebElement finishButton;

    public CheckoutOverviewPage(WebDriver driver) {
        super(driver);
    }

    /**
     * Metodo para verificar si la página de vista previa del checkout se ha cargado correctamente.
     */
    public void isCheckoutOverviewPageLoaded() {
        try {
            this.wait.until(ExpectedConditions.titleContains("Checkout: Overview"));
            logs.info("Checkout Overview page loaded successfully.");
        } catch (Exception e) {
            logs.info("Error loading Checkout Overview page: " + e.getMessage());
        }
    }

    /**
     * Metodo para hacer clic en el botón de finalizar compra.
     */
    public void clickFinishButton() {
        this.wait.until(ExpectedConditions.elementToBeClickable(finishButton)).click();
        logs.info("Clicked on the finish button.");
    }
}
