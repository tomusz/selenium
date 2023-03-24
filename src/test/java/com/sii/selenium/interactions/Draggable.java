package com.sii.selenium.interactions;

import com.sii.selenium.BaseTest;
import com.sii.selenium.constants.TestTagConstants;
import com.sii.selenium.utils.WebPageUtils;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Draggable extends BaseTest {

    private final String draggableWebPageUrl = baseUrl + webAddresses.get("interactions.draggable");

    @Test
    @Tag(TestTagConstants.DRAGGABLE)
    @Tag("FAKE-JIRA-NO-0012")
    public void moveElement() {
        driver.get(draggableWebPageUrl);
        WebPageUtils.maximiseWindow.accept(driver);

        WebElement draggable = driver.findElement(By.id("draggable"));

        int windowWidth = driver.manage().window().getSize().getWidth();
        int windowHeight = driver.manage().window().getSize().getHeight();
        int elementWidth = draggable.getSize().getWidth();
        int elementHeight = draggable.getSize().getHeight();
        int elementLocationX = draggable.getLocation().x;
        int elementLocationY = draggable.getLocation().y;

        Actions actions = new Actions(driver);
        actions.dragAndDropBy(draggable, (windowWidth - elementWidth - elementLocationX), elementLocationY).perform();

        //not working do not know why???
        actions.dragAndDropBy(draggable, 0, windowHeight - elementLocationY - elementHeight / 2).perform();

        actions.dragAndDropBy(draggable, -(windowWidth / 2 - elementWidth / 2), -(windowHeight / 2 - elementHeight / 2))
                .perform();

        actions.dragAndDropBy(draggable, -(windowWidth / 2 - elementWidth / 2), (windowHeight / 2 - elementHeight / 2))
                .perform();
    }
}