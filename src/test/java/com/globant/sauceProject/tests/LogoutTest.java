package com.globant.sauceProject.tests;

import com.globant.sauceProject.pages.BasePage;
import com.globant.sauceProject.pages.LoginPage;
import com.globant.sauceProject.pages.MenuSection;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class LogoutTest extends BaseTest{

    @Parameters({"username", "password"})
    @Test(description = "Verifica el cierre de sesión exitoso.")
    public void testLogout(String username, String password) {
        BasePage base = new BasePage(driver);
        LoginPage login = new LoginPage(driver);
        MenuSection menu = new MenuSection(driver);

        menu.getLogo();

        logger.info("Testing Login with: \nUsername: " + username + System.lineSeparator() +
                "Password: " + password + System.lineSeparator());
        login.enterUsername(username);
        login.enterPassword(password);
        login.clickLoginButton();

        logger.info("Login successful, now opening the menu to log out.");
        menu.openMenu();
        menu.clickLogout();

        logger.info("Logout link clicked, now verifying logout.");
        login.isLoginPage();
        logger.info("You are now logged out and on the login page.");
    }
}
