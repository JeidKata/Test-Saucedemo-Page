package com.globant.sauceProject.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CheckoutOverviewPage extends BasePage{

    @FindBy(id = "finish")
    private WebElement finishButton;

    public CheckoutOverviewPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    /**
     * Metodo para verificar si la página de vista previa del checkout se ha cargado correctamente.
     */
    public boolean isCheckoutOverviewPageLoaded() {
        try {
            this.wait.until(ExpectedConditions.visibilityOf(finishButton));
            logs.info("Checkout Overview page loaded successfully.");
            return true;
        } catch (Exception e) {
            logs.info("Error loading Checkout Overview page: " + e.getMessage());
            return false;
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
