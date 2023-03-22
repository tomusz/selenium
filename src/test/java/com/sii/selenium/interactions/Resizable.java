package com.sii.selenium.interactions;

import com.sii.selenium.BaseTest;
import com.sii.selenium.constants.TestTagConstants;
import com.sii.selenium.utils.WebPageUtils;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.Interaction;

import java.util.Collections;

public class Resizable extends BaseTest {

    private final String resizeableWebPageUrl = baseUrl + webAddresses.get("interactions.resizable");

    @Test
    @Tag(TestTagConstants.RESIZEABLE)
    @Tag("FAKE-JIRA-NO-0016")
    public void resizeObject() {
        driver.get(resizeableWebPageUrl);
        WebPageUtils.maximiseWindow.accept(driver);

        WebElement resizable = driver.findElement(By.id("resizable"));
        int resizibleY = resizable.getLocation().getY();
        int resizibleX = resizable.getLocation().getX();


        Actions actions = new Actions(driver);
//        actions


        //TODO:need to finish
    }

}
