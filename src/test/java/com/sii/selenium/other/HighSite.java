package com.sii.selenium.other;

import com.sii.selenium.BaseTest;
import com.sii.selenium.constants.TestTagConstants;
import com.sii.selenium.utils.WebPageUtils;
import com.sii.selenium.utils.files.FileHandler;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.interactions.Actions;

public class HighSite extends BaseTest {

    private final String highSiteWebPageUrl = baseUrl + webAddresses.get("other.highsite");

    @Test
    @Tag(TestTagConstants.HIGH_SITE)
    @Tag("FAKE-JIRA-NO-0017")
    public void scrollWithJavaScript() {
        driver.get(highSiteWebPageUrl);
        WebPageUtils.maximiseWindow.accept(driver);

        scrollUntilVisibleJS();
        FileHandler.makeAScreenShot(driver);
    }

    @Test
    @Tag(TestTagConstants.HIGH_SITE)
    @Tag("FAKE-JIRA-NO-0018")
    public void scrollWithSelenium() {
        driver.get(highSiteWebPageUrl);
        WebPageUtils.maximiseWindow.accept(driver);

        scrollUntilElementVisible();
        FileHandler.makeAScreenShot(driver);
    }

    private void scrollUntilVisibleJS() {
        JavascriptExecutor js = (JavascriptExecutor) driver;

        while (true) {
            js.executeScript("window.scrollBy(0,100)", "");
            try {
                driver.findElement(By.cssSelector("#scroll-button")).click();
                break;
            } catch (NoSuchElementException e) {

            }
        }
    }

    private void scrollUntilElementVisible() {
        Actions actions = new Actions(driver);
        while (true) {
            actions.scrollByAmount(0, 100).perform();
            try {
                driver.findElement(By.cssSelector("#scroll-button")).click();
                break;
            } catch (NoSuchElementException e) {
            }
        }
    }
}