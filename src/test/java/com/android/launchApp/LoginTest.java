package com.android.launchApp;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class LoginTest {
    AndroidDriver androidDriver;

    @Test
    public void openApp() throws MalformedURLException, InterruptedException {
        UiAutomator2Options androidOptions = new UiAutomator2Options();
        androidOptions.setPlatformVersion("14.0");
        androidOptions.setPlatformName("Android");
        androidOptions.setDeviceName("IQOO");
        androidOptions.setAutomationName("UiAutomator2");
        androidOptions.setApp(System.getProperty("user.dir") + "/src/main/resources/app-release.apk");
        androidOptions.setCapability("noReset", false);

        androidDriver = new AndroidDriver(new URL("http://127.0.0.1:4723"), androidOptions);

        androidDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        login();
        androidDriver.findElement(AppiumBy.xpath("(//*[@content-desc='Tasks']/following-sibling::*)[2]")).click();

        androidDriver.findElement(AppiumBy.xpath("(//android.widget.EditText)[1]")).click();
        androidDriver.findElement(AppiumBy.xpath("(//android.widget.EditText)[1]")).sendKeys("TestAuto");

        androidDriver.findElement(AppiumBy.xpath("(//android.widget.EditText)[2]")).click();
        androidDriver.findElement(AppiumBy.xpath("(//android.widget.EditText)[2]")).sendKeys("TestAuto");


    }

    public void login() {
        tapOnElement((AppiumBy) AppiumBy.className("android.widget.EditText"));
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        typeValue((AppiumBy) AppiumBy.className("android.widget.EditText"), "test.com");
        tapOnElement((AppiumBy) AppiumBy.className("android.widget.CheckBox"));
        tapOnElement((AppiumBy) AppiumBy.accessibilityId("Continue"));

        tapOnElement((AppiumBy) AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.EditText\").instance(1)"));
        typeValue((AppiumBy) AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.EditText\").instance(1)"), "pwd");

        tapOnElement((AppiumBy) AppiumBy.accessibilityId("Login"));
    }

    public void tapOnElement(AppiumBy appiumBy) {
        androidDriver.findElement(appiumBy).click();
    }

    public void typeValue(AppiumBy appiumBy, String data) {
        androidDriver.findElement(appiumBy).sendKeys(data);
    }
}
