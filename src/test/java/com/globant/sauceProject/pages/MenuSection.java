package com.globant.sauceProject.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MenuSection extends BasePage{

    @FindBy(className = "login_logo")
    private WebElement logo;

    @FindBy(id = "react-burger-menu-btn")
    private WebElement menuButton;

    @FindBy(id = "logout_sidebar_link")
    private WebElement logoutLink;

    public MenuSection(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    /**
     * metodo para obtener el logo de la pagina.
     */
    public void getLogo(){
        this.wait.until(ExpectedConditions.visibilityOf(logo));
        logs.info("Logo is visible on the page.");
    }

    /**
     * Abre el menú lateral (hamburguesa).
     */
    public void openMenu() {
        wait.until(ExpectedConditions.elementToBeClickable(menuButton)).click();
        logs.info("Menu button clicked.");
    }

    /**
     * Hace clic en el enlace de cerrar sesión.
     */
    public void clickLogout() {
        wait.until(ExpectedConditions.elementToBeClickable(logoutLink)).click();
        logs.info("Logout link clicked.");
    }
}
