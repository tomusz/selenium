package com.sii.selenium.widgets;

import com.sii.selenium.BaseTest;
import com.sii.selenium.constants.TestTagConstants;
import com.sii.selenium.utils.ArithmeticUtils;
import com.sii.selenium.utils.WebPageUtils;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.Select;

public class Selectable extends BaseTest {

    private final String selectWebPageUrl = baseUrl + webAddresses.get("widgets.selectmenu");

    @Test
    @Tag(TestTagConstants.SELECTABLE)
    @Tag("FAKE-JIRA-NO-0027")
    public void selectOptions() {
        driver.get(selectWebPageUrl);
        WebPageUtils.maximiseWindow.accept(driver);

        Select speed = new Select(driver.findElement(By.cssSelector("#speed-menu")));
        speed.getWrappedElement().sendKeys(Keys.SPACE);
        speed.selectByIndex(ArithmeticUtils.getRandomNumberInRange(1, speed.getOptions().size()));

        Select files = new Select(driver.findElement(By.cssSelector("#files-menu")));
        files.getWrappedElement().click();
        files.selectByVisibleText("Select a file");

        Select number = new Select(driver.findElement(By.cssSelector("#number-menu")));
        number.getWrappedElement().click();
        number.selectByIndex(10);

        Select salutation = new Select(driver.findElement(By.cssSelector("#salutation-menu")));
        salutation.getWrappedElement().click();
        salutation.selectByIndex(ArithmeticUtils.getRandomNumberInRange(1, salutation.getOptions().size()));
    }

}
