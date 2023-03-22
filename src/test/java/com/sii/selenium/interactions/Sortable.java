package com.sii.selenium.interactions;

import com.sii.selenium.BaseTest;
import com.sii.selenium.constants.TestTagConstants;
import com.sii.selenium.utils.WebPageUtils;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Sortable extends BaseTest {

    private final String sortableWebPageUrl = baseUrl + webAddresses.get("interactions.sortable");
    List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5, 6, 7);

    @Test
    @Tag(TestTagConstants.SORTABLE)
    @Tag("FAKE-JIRA-NO-0015")
    public void sortList() {
        driver.get(sortableWebPageUrl);
        WebPageUtils.maximiseWindow.accept(driver);

        Collections.shuffle(integers);
        Actions actions = new Actions(driver);

        int iterator = 1;
        for (int itemNO : integers) {
            actions.dragAndDrop(driver.findElement(By.xpath(String.format("//ul[contains(@class,'sortable')]//li[contains(.,'Item %s')]", itemNO))),
                            driver.findElement(By.xpath("//ul[contains(@class,'sortable')]//li[" + iterator +"]")))
                    .release().perform();
            iterator++;
        }
    }
}