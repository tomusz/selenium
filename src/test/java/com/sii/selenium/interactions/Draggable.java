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
        //default upper left corner
        // 150

        System.out.println("300 and 300");
//                .dragAndDropBy(draggable,300,300)
        System.out.println("W : " +
                (driver.manage().window().getSize().getWidth() -
                draggable.getSize().getWidth()/2 - draggable.getLocation().getX()));
        System.out.println("H : " + (driver.manage().window().getSize().getHeight() - draggable.getSize().getHeight()/2
                - draggable.getLocation().getY()));

        System.out.println("after W - size/2 - location");
        //TODO:Not finished
        //3456 - 1175 - 150 //browser - position - object
        // - position
        dragObject(draggable, driver.manage().window().getSize().getWidth() - draggable.getLocation().getX()
                        - draggable.getSize().getWidth(),
                -draggable.getLocation().getY());
        WebElement draggableRightTop = driver.findElement(By.id("draggable"));

        System.out.println("X obj " + draggableRightTop.getLocation().getX());
        System.out.println("Y obj " + draggableRightTop.getLocation().getY());

        System.out.println("Width obj " + draggableRightTop.getSize().getWidth()); //75
        System.out.println("Height obj " + draggableRightTop.getSize().getHeight()); //75

        System.out.println("Height web " + driver.manage().window().getSize().getHeight());
        System.out.println("Width web " + driver.manage().window().getSize().getWidth());


        dragObject(draggableRightTop, 0,
                driver.manage().window().getSize().getHeight() - draggableRightTop.getSize().getHeight()/2
        - draggableRightTop.getLocation().getY());
        WebElement draggableRightBottom = driver.findElement(By.id("draggable"));

        System.out.println("X obj " + draggableRightBottom.getLocation().getX());
        System.out.println("Y obj " + draggableRightBottom.getLocation().getY());

        System.out.println("Width obj " + draggableRightBottom.getSize().getWidth()); //75
        System.out.println("Height obj " + draggableRightBottom.getSize().getHeight()); //75

        System.out.println("Height web " + driver.manage().window().getSize().getHeight());
        System.out.println("Width web " + driver.manage().window().getSize().getWidth());

//        dragObject(draggableRightBottom, );
        // 0
        // window - obj/2 - pos

        //- brow w/2 + sizew/2
        // - brow h/2 + sizew/2

        // left bot
        // brow - pos
        // brow - pos
//        dragObject(draggable,300,300);

//        System.out.println("0 and 0");
//        dragObject(draggable, 0,0);
//
//        System.out.println("widt and heit");
//        dragObject(draggable,driver.manage().window().getSize().getWidth(),
//                driver.manage().window().getSize().getHeight());
//        System.out.println();
    }

    private void dragObject(WebElement element, int distanceX, int distanceY) {
        Actions actions = new Actions(driver);
        actions.clickAndHold(element).moveByOffset(distanceX,distanceY)
                .release().perform();
    }


}
