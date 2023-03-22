package com.sii.selenium.widgets;

import com.sii.selenium.BaseTest;
import com.sii.selenium.constants.TestTagConstants;
import com.sii.selenium.utils.WebPageUtils;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Accordion extends BaseTest {

    private final String accordionUrl = baseUrl + webAddresses.get("widgets.accordion");

    @Test
    @Tag(TestTagConstants.ACCORDION)
    @Tag("FAKE-JIRA-NO-0023")
    public void printTextFromSections() {
        driver.get(accordionUrl);
        WebPageUtils.maximiseWindow.accept(driver);

        List<WebElement> sections = driver.findElements(By.cssSelector("#accordion h3"));

        for (WebElement element : sections) {
            if (!element.getAttribute("aria-expanded").equals("true")) {
                element.click();
            }
            System.out.println(element.findElement(By.xpath("./following-sibling::*[1]")).getText());
        }
    }
}