package com.sii.selenium.widgets;

import com.sii.selenium.BaseTest;
import com.sii.selenium.constants.TestTagConstants;
import com.sii.selenium.utils.WebPageUtils;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Tooltip extends BaseTest {

    private final String tooltipUrl = baseUrl + webAddresses.get("widgets.tooltip");

    @Test
    @Tag(TestTagConstants.TOOLTIP)
    @Tag("FAKE-JIRA-NO-0021")
    public void waitUntilHasCompletedText() {
        driver.get(tooltipUrl);
        WebPageUtils.maximiseWindow.accept(driver);

        System.out.println(driver.findElement(By.id("age")).getAttribute("title").toString());
    }
}