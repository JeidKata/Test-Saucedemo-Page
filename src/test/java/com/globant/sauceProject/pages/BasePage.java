package com.globant.sauceProject.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class BasePage {
    private WebDriver driver;
    private static final int TIMEOUT = 8;
    protected WebDriverWait wait;
    private Logger logs = Logger.getLogger(BasePage.class.getName());

    @FindBy(className = "login_logo")
    private WebElement logo;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
        this.wait = new WebDriverWait(this.driver, Duration.ofSeconds(TIMEOUT));
    }

    /**
     * metodo para obtener el logo de la pagina.
     */
    public void getLogo(){
        this.wait.until(ExpectedConditions.visibilityOf(logo));
        logs.info("Logo is visible on the page.");
    }

}
