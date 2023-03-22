package com.sii.selenium.interactions;

import com.sii.selenium.BaseTest;
import com.sii.selenium.constants.TestTagConstants;
import com.sii.selenium.utils.WebPageUtils;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Droppable extends BaseTest {

    private final String droppableWebPageUrl = baseUrl + webAddresses.get("interactions.droppable");

    @Test
    @Tag(TestTagConstants.DROPPABLE)
    @Tag("FAKE-JIRA-NO-0013")
    public void moveElement() {
        driver.get(droppableWebPageUrl);
        WebPageUtils.maximiseWindow.accept(driver);

        WebElement draggable = driver.findElement(By.id("draggable"));
        WebElement droppable = driver.findElement(By.id("droppable"));
        Actions actions = new Actions(driver);
        actions.clickAndHold(draggable).moveToElement(droppable)
                .release().perform();
        String expectedText = "Dropped!";
        String actualText = droppable.getText();
        assertThat(actualText).isEqualTo(expectedText);
    }
}