package com.sii.selenium.widgets;

import com.sii.selenium.BaseTest;
import com.sii.selenium.constants.TestTagConstants;
import com.sii.selenium.utils.ArithmeticUtils;
import com.sii.selenium.utils.WebPageUtils;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class AutoComplete extends BaseTest {

    private final String autoCompleteUrl = baseUrl + webAddresses.get("widgets.autocomplete");

    @Test
    @Tag(TestTagConstants.AUTO_COMPLETE)
    @Tag("FAKE-JIRA-NO-0022")
    public void waitUntilHasCompletedText() {
        driver.get(autoCompleteUrl);
        WebPageUtils.maximiseWindow.accept(driver);

        WebElement searchElement = driver.findElement(By.id("search"));
        searchElement.sendKeys("a");

        List<WebElement> options = driver.findElements(By.cssSelector(".ui-menu-item"));

        System.out.println("\n");
        for (WebElement element : options) {
            System.out.println(element.getText());
        }
        System.out.println("\n");

        WebElement chosenOption = options.get(ArithmeticUtils.getRandomNumberInRange(0, options.size() - 1));
        chosenOption.click();

        String actualText = searchElement.getAttribute("innerText");
        assertThat(actualText).isEqualTo(chosenOption.getText());
    }
}