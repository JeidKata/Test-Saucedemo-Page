package com.globant.sauceProject.listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.util.logging.Logger;

public class Listeners implements ITestListener {
    public Logger logs = Logger.getLogger(Listeners.class.getName());

    @Override
    public void onTestStart(ITestResult result) {
        logs.info("Test EMPEZO " + result.getName());

    }

    @Override
    public void onTestSuccess(ITestResult result) {
        logs.info("Test PASO " + result.getName());

    }

    @Override
    public void onTestFailure(ITestResult result) {
        logs.info("Test FALLO " + result.getName());

    }

    @Override
    public void onTestSkipped(ITestResult result) {
        logs.info("Test SKIPPED " + result.getName());

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        logs.info("Test CON ALGUNAS FALLAS " + result.getName());
        // This method is not commonly used, so we can leave it empty or log a message if needed

    }

    @Override
    public void onStart(ITestContext context) {
        logs.info("INICIO Test " + context.getName());

    }

    @Override
    public void onFinish(ITestContext context) {
        logs.info("FINALIZO Test " + context.getName());

    }
}
