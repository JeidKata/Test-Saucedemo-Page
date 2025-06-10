package com.globant.sauceProject.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class BasePage {
    private WebDriver driver;
    private static final int TIMEOUT = 10;
    protected WebDriverWait wait;
    protected Logger logs;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
        this.logs = Logger.getLogger(this.getClass().getName());
        this.wait = new WebDriverWait(this.driver, Duration.ofSeconds(TIMEOUT));
    }

    /**
     * metodo para manejar las alertas de la pagina.
     */
    public void handleAlert() {
        try {
            this.wait.until(ExpectedConditions.alertIsPresent());
            Alert alert = this.driver.switchTo().alert();
            alert.accept();
            logs.info("Alert accepted.");
        } catch (Exception e) {
            logs.error("No alert present: " + e.getMessage());
        }
    }

}
