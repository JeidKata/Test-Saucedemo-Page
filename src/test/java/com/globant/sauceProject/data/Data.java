package com.globant.sauceProject.data;

import org.testng.annotations.DataProvider;

public class Data {

    @DataProvider(name = "loginData")
    public Object [] [] loginData(){
        return new Object[][]{
                {"standard_user", "secret_sauce"},
                {"locked_out_user", "secret_sauce"},
                {"problem_user", "secret_sauce"},
                {"performance_glitch_user", "secret_sauce"},
                {"error_user", "secret_sauce"},
                {"visual_user", "secret_sauce"},
        };
    }

    @DataProvider(name = "checkoutData")
    public Object[][] checkoutData() {
        return new Object[][]{
                {"John", "Doe", "12345"},
        };
    }
}
