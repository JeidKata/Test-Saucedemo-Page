package com.globant.sauceProject.tests;

import com.globant.sauceProject.data.Data;
import org.testng.annotations.Test;

import java.util.logging.Logger;

public class PurchaseProductTest {

    public Logger logs = Logger.getLogger(LogoutTest.class.getName());

    @Test(groups = {"dataLogin"}, description = "Inicio sesión", dataProvider = "loginData", dataProviderClass = Data.class)
    public void testLogin (String username, String password){
        logs.info("Probando Login con: ");
        logs.info("Username: " + username + System.lineSeparator() +
                "Contraseña: " + password + System.lineSeparator());
    }

    @Test(groups = {"example"})
    public void funtionExample(){
        logs.info("Hola ejemplo");
    }

}
