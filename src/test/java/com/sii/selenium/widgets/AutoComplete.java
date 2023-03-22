package com.sii.selenium.widgets;

import com.sii.selenium.BaseTest;
import com.sii.selenium.constants.TestTagConstants;
import com.sii.selenium.utils.ArithmeticUtils;
import com.sii.selenium.utils.TablesUtils;
import com.sii.selenium.utils.WebPageUtils;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.stream.Collectors;

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

        List<WebElement> options = driver.findElements(By.xpath("//ul[@id='ui-id-1']/li"));

        System.out.println("\n");
        for (WebElement element : options) {
            System.out.println(element.getText());
        }
        System.out.println("\n");

        int randomNumberInRange = ArithmeticUtils.getRandomNumberInRange(0, options.size());
        String chosenOptionText = searchElement.findElement(By.xpath("./li[" + randomNumberInRange + "]")).getText();
        searchElement.findElement(By.xpath("./li[" + randomNumberInRange + "]")).click();

        String actualText = searchElement.getText();
        assertThat(actualText).isEqualTo(chosenOptionText);
    }
}