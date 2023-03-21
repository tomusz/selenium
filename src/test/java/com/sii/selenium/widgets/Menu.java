package com.sii.selenium.widgets;

import com.sii.selenium.BaseTest;
import com.sii.selenium.constants.TestTagConstants;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;

public class Menu extends BaseTest {

    private final String menuUrl = baseUrl + webAddresses.get("widgets.menu");

    @Test
    @Tag(TestTagConstants.MENU)
    @Tag("FAKE-JIRA-NO-0010")
    public void clickModern() {
        driver.get(menuUrl);
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(By.xpath("//li[contains(.,'Music')]")))
                .moveToElement(driver.findElement(By.xpath("//li[contains(.,'Jazz')]")))
                .moveToElement(driver.findElement(By.xpath("//li[contains(.,'Modern')]")))
                .click().build();
    }

}