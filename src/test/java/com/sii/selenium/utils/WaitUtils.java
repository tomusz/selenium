package com.sii.selenium.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.function.BiFunction;

public class WaitUtils {

    public static final Duration WAIT_TIME = Duration.ofSeconds(10);

    public static BiFunction<WebDriver, WebElement, WebElement> waitForElementVisible = (driver, element) -> {
        WebDriverWait wait = new WebDriverWait(driver, WAIT_TIME);
        wait.until(ExpectedConditions.visibilityOf(element));
        return element;
    };

}
