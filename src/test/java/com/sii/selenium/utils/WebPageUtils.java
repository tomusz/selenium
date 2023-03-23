package com.sii.selenium.utils;

import org.openqa.selenium.WebDriver;

import java.util.function.Consumer;

public class WebPageUtils {

    public static Consumer<WebDriver> maximiseWindow = d -> d.manage().window().maximize();

    public static void switchWindowOrTab(String baseWindow, WebDriver driver) {
        for (String windowHandle : driver.getWindowHandles()) {
            if (!baseWindow.contentEquals(windowHandle)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }
    }

    public static void closeWindowAndGetBackToBase(String baseWindow, WebDriver driver) {
        driver.close();
        driver.switchTo().window(baseWindow);
    }
}
