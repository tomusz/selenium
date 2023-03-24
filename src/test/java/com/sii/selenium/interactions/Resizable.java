package com.sii.selenium.interactions;

import com.sii.selenium.BaseTest;
import com.sii.selenium.constants.TestTagConstants;
import com.sii.selenium.utils.WebPageUtils;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;

public class Resizable extends BaseTest {

    private final String resizeableWebPageUrl = baseUrl + webAddresses.get("interactions.resizable");

    @Test
    @Tag(TestTagConstants.RESIZEABLE)
    @Tag("FAKE-JIRA-NO-0016")
    public void resizeObject() {
        driver.get(resizeableWebPageUrl);
        WebPageUtils.maximiseWindow.accept(driver);

        Actions actions = new Actions(driver);

        actions.dragAndDropBy(driver.findElement(By.cssSelector(".ui-resizable-e")), 10, 0).perform();
        actions.dragAndDropBy(driver.findElement(By.cssSelector(".ui-resizable-s")), 0, 10).perform();
        actions.dragAndDropBy(driver.findElement(By.cssSelector(".ui-resizable-se")), 10, 10).perform();
    }

}