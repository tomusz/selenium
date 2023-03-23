package com.sii.selenium.other;

import com.sii.selenium.BaseTest;
import com.sii.selenium.constants.TestTagConstants;
import com.sii.selenium.utils.WebPageUtils;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class DemoQa extends BaseTest {

    private final String demoQaWebPageUrl = webAddresses.get("demoqa.form").toString();

    @Test
    @Tag(TestTagConstants.FORMS)
    @Tag("FAKE-JIRA-NO-0025")
    public void fillInForm() {
        driver.get(demoQaWebPageUrl);
        WebPageUtils.maximiseWindow.accept(driver);

        Actions actions = new Actions(driver);
        actions.click(driver.findElement(By.id("subjectsInput")))
                .sendKeys("m").perform();
                actions.moveToElement(driver.findElement(
                        By.xpath("//div[contains(@class,'subjects-auto-complete__menu-list')]/*[contains(.,'Maths')]")))
                .click().perform();

        actions.click(driver.findElement(By.id("subjectsInput")))
                .sendKeys("a").perform();
                actions.moveToElement(driver.findElement(
                        By.xpath("//div[contains(@class,'subjects-auto-complete__menu-list')]/*[contains(.,'Arts')]")))
                .click().perform();

        List<WebElement> elements = driver.findElements(By.cssSelector("#subjectsContainer .subjects-auto-complete__multi-value"));

        List<String> actualValues = elements.stream().map(WebElement::getText).collect(Collectors.toList());
        List<String> expectedValues = Arrays.asList("Maths", "Arts");

        assertThat(actualValues).usingRecursiveComparison().isEqualTo(expectedValues);
    }
}