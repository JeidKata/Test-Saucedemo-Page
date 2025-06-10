package com.globant.sauceProject.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CheckoutCompletePage extends BasePage{

    @FindBy(className = "complete-header")
    private WebElement completeHeader;

    @FindBy(id = "back-to-products")
    private WebElement backHomeButton;

    public CheckoutCompletePage(WebDriver driver) {
        super(driver);
    }

    /**
     * Metodo para verificar que la compra se haya completado.
     */
    public void isCheckoutComplete() {
        try {
            this.wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("complete-header")));
            logs.info("Purchase successfully completed.");
        } catch (Exception e) {
            logs.info("Error while completing the purchase: " + e.getMessage());
        }
    }

    /**
     * Obtiene el texto del mensaje de confirmación de la compra.
     * @return El texto del encabezado de completado de compra.
     */
    public String getCompleteHeaderText() {
        return wait.until(ExpectedConditions.visibilityOf(completeHeader)).getText();
    }

    /**
     * Verifica si la página de completado de compra se muestra correctamente.
     * @return true si el encabezado de completado es visible, false en caso contrario.
     */
    public boolean isPageDisplayed() {
        return wait.until(ExpectedConditions.visibilityOf(completeHeader)).isDisplayed();
    }

    /**
     * Metodo para hacer clic en el botón "Back Home".
     */
    public void clickBackHomeButton() {
        wait.until(ExpectedConditions.elementToBeClickable(backHomeButton)).click();
        logs.info("Clicked on the back home button.");
    }
}
