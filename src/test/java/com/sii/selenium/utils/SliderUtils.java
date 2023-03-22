package com.sii.selenium.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class SliderUtils {


    public static void moveSliderTo(WebDriver driver, int value) {
        int difference = Integer.parseInt(driver.findElement(By.cssSelector("#custom-handle")).getText()) - value;
        driver.findElement(By.id("custom-handle")).click();
        if (difference > 0) {
            moveSliderLeftToValue(driver, difference);
        } else if (difference < 0) {
            moveSliderRightToValue(driver, difference * -1);
        }
    }

    private static void moveSliderRightToValue(WebDriver driver, int value) {
        for (int i = 1; i <= value; i++) {
            new Actions(driver).sendKeys(Keys.ARROW_RIGHT).perform();
        }
    }

    private static void moveSliderLeftToValue(WebDriver driver, int value) {
        for (int i = 1; i <= value; i++) {
            new Actions(driver).sendKeys(Keys.ARROW_LEFT).perform();
        }
    }
}