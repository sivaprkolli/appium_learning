package com.android.launchApp;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class LaunchApplication {
    AndroidDriver androidDriver;

    @Test
    public void openApp() throws MalformedURLException {
        UiAutomator2Options androidOptions = new UiAutomator2Options();
        androidOptions.setPlatformVersion("14.0");
        androidOptions.setPlatformName("Android");
        androidOptions.setDeviceName("IQOO");
        androidOptions.setAutomationName("UiAutomator2");
        androidOptions.setApp(System.getProperty("user.dir")+"/src/main/resources/NoBroker.apk");
        androidOptions.setAppPackage("com.nobroker.app");
        androidOptions.setAppWaitActivity("com.nobroker.app.activities.NBLauncherActivity");

        androidDriver = new AndroidDriver(new URL("http://127.0.0.1:4723"), androidOptions);

        WebDriverWait wait = new WebDriverWait(androidDriver, Duration.ofSeconds(20));

        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.nobroker.app:id/yesPhoneState"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.androidUIAutomator("new UiSelector().text(\"While using the app\")"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"com.android.permissioncontroller:id/permission_allow_button\")"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"com.android.permissioncontroller:id/permission_allow_button\")"))).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.androidUIAutomator("new UiSelector().textContains(\"Search\")"))).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.androidUIAutomator("//new UiSelector().textContains(\"Search up\")"))).sendKeys("BTM Layout, ");

    }
}
