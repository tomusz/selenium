package com.sii.selenium.widgets;

import com.sii.selenium.BaseTest;
import com.sii.selenium.constants.TestTagConstants;
import com.sii.selenium.utils.WebPageUtils;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProgressBar extends BaseTest {

    private final String progressBarUrl = baseUrl + webAddresses.get("widgets.progressbar");

    @Test
    @Tag(TestTagConstants.PROGRESS_BAR)
    @Tag("FAKE-JIRA-NO-0019")
    public void waitUntilHasCompletedText() {
        driver.get(progressBarUrl);
        WebPageUtils.maximiseWindow.accept(driver);

        WebDriverWait wait = new WebDriverWait(driver, WAIT_TIME);
        wait.until(ExpectedConditions.textToBePresentInElement(driver.findElement(By.xpath("//div[contains(@class,'progress-label')]")), "Complete!"));
    }

    @Test
    @Tag(TestTagConstants.PROGRESS_BAR)
    @Tag("FAKE-JIRA-NO-0020")
    public void waitUntilClassChanged() {
        driver.get(progressBarUrl);
        WebPageUtils.maximiseWindow.accept(driver);

        WebDriverWait wait = new WebDriverWait(driver, WAIT_TIME);
        wait.until(ExpectedConditions.attributeContains(driver.findElement(By.cssSelector("div.ui-progressbar-value")), "class","ui-progressbar-complete"));
    }
}