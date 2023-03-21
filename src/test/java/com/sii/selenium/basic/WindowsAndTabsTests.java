package com.sii.selenium.basic;

import com.sii.selenium.BaseTest;
import com.sii.selenium.constants.TestTagConstants;
import com.sii.selenium.utils.TablesUtils;
import com.sii.selenium.utils.WebPageUtils;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static com.sii.selenium.utils.WebPageUtils.*;

import java.util.List;

public class WindowsAndTabsTests extends BaseTest {

    private final String windowsWebPageUrl = baseUrl + webAddresses.get("basic.widowsAndTabs");
    private final int REQUIRED_MOUNTAIN_HEIGHT = 4000;

    @Test
    @Tag(TestTagConstants.WINDOWS_AND_TABS)
    @Tag("FAKE-JIRA-NO-0009")
    public void moveAroundWindowsAndTabs() {
        driver.get(windowsWebPageUrl);
        WebPageUtils.maximiseWindow.accept(driver);

        String baseWindow = driver.getWindowHandle();
        driver.findElement(By.cssSelector("#newBrowserWindow")).click();

        switchWindowOrTab(baseWindow, driver);

        List<WebElement> rowsWithSwitzerland = driver.findElements(
                By.xpath("//tr/td[contains(.,'Switzerland')]/.."));
        TablesUtils.printRowsWithHeightMoreThan(rowsWithSwitzerland, REQUIRED_MOUNTAIN_HEIGHT);

        closeWindowAndGetBackToBase(baseWindow, driver);

        driver.findElement(By.xpath("//button[@id='newMessageWindow']")).click();

        switchWindowOrTab(baseWindow, driver);

        System.out.println(driver.findElement(By.xpath("//body")).getText());

        closeWindowAndGetBackToBase(baseWindow, driver);

        driver.findElement(By.xpath("//button[@id='newBrowserTab']")).click();

        switchWindowOrTab(baseWindow, driver);

        rowsWithSwitzerland = driver.findElements(
                By.xpath("//tr/td[contains(.,'Switzerland')]/.."));
        TablesUtils.printRowsWithHeightMoreThan(rowsWithSwitzerland, REQUIRED_MOUNTAIN_HEIGHT);

        closeWindowAndGetBackToBase(baseWindow, driver);
    }
}