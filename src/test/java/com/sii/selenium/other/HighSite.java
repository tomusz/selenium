package com.sii.selenium.other;

import com.sii.selenium.BaseTest;
import com.sii.selenium.constants.TestTagConstants;
import com.sii.selenium.utils.WebPageUtils;
import com.sii.selenium.utils.files.FileHandler;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;

import java.io.File;

public class HighSite extends BaseTest {

    private final String highSiteWebPageUrl = baseUrl + webAddresses.get("other.highsite");

    @Test
    @Tag(TestTagConstants.HIGH_SITE)
    @Tag("FAKE-JIRA-NO-0017")
    public void scrollWithJavaScript() {
        driver.get(highSiteWebPageUrl);
        WebPageUtils.maximiseWindow.accept(driver);

        WebElement scrollButton = driver.findElement(By.id("scroll-button"));

        scrollUntilVisibleJS(scrollButton);
        System.out.println("stop");
//        FileHandler.makeAScreenShot(driver);
        //TODO:need to finish
    }

    @Test
    @Tag(TestTagConstants.HIGH_SITE)
    @Tag("FAKE-JIRA-NO-0018")
    public void scrollWithSelenium() {
        driver.get(highSiteWebPageUrl);
        WebPageUtils.maximiseWindow.accept(driver);


        WebElement scrollButton = driver.findElement(By.cssSelector("#scroll-button"));

        scrollUntilVisibleJS(scrollButton);
//        FileHandler.makeAScreenShot(driver);
        System.out.println("stop");


        //TODO:need to finish
    }

    private void scrollUntilVisibleJS(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;


        while (!element.isEnabled()) {
            js.executeScript("window.scrollBy(0,100)");
        }
    }

    private void scrollUntilElementVisible(WebElement element) {
        Actions actions = new Actions(driver);
        while (!element.isEnabled()) {
            actions.scrollByAmount(100,0);
        }
    }


}