package com.globant.sauceProject.listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.util.logging.Logger;

public class Listeners implements ITestListener {
    public Logger logs = Logger.getLogger(Listeners.class.getName());

    @Override
    public void onTestStart(ITestResult result) {
        logs.info("Test started " + result.getName());

    }

    @Override
    public void onTestSuccess(ITestResult result) {
        logs.info("Test Success ✅ " + result.getName());

    }

    @Override
    public void onTestFailure(ITestResult result) {
        logs.info("Test Fail ❌ " + result.getName());

    }

    @Override
    public void onTestSkipped(ITestResult result) {
        logs.info("Test Skipped ⏭\uFE0F " + result.getName());

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        logs.info("Test with some failures " + result.getName());
        // This method is not commonly used, so we can leave it empty or log a message if needed

    }

    @Override
    public void onStart(ITestContext context) {
        logs.info("--- STARTING TEST " + context.getName());

    }

    @Override
    public void onFinish(ITestContext context) {
        logs.info("--- FINISH TEST " + context.getName());

    }
}
