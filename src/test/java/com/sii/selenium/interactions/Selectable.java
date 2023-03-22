package com.sii.selenium.interactions;

import com.sii.selenium.BaseTest;
import com.sii.selenium.constants.TestTagConstants;
import com.sii.selenium.utils.WebPageUtils;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Selectable extends BaseTest {

    private final String selectableWebPageUrl = baseUrl + webAddresses.get("interactions.selectable");

    @Test
    @Tag(TestTagConstants.SELECTABLE)
    @Tag("FAKE-JIRA-NO-0014")
    public void selectMultiple() {
        driver.get(selectableWebPageUrl);
        WebPageUtils.maximiseWindow.accept(driver);

        Actions actions = new Actions(driver);
        actions
                .keyDown(Keys.LEFT_CONTROL)
                .moveToElement(driver.findElement(By.xpath("//ol//li[contains(.,'Item 1')]"))).click()
                .moveToElement(driver.findElement(By.xpath("//ol//li[contains(.,'Item 3')]"))).click()
                .moveToElement(driver.findElement(By.xpath("//ol//li[contains(.,'Item 4')]"))).click()
                .perform();

        String actualText = driver.findElement(By.id("feedback")).getText();
        String expectedText = "You've selected: #1 #3 #4.";
        assertThat(actualText).isEqualTo(expectedText);
    }
}