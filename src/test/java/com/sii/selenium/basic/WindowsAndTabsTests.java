package com.sii.selenium.basic;

import com.sii.selenium.BaseTest;
import com.sii.selenium.constants.TestTagConstants;
import com.sii.selenium.utils.WebPageUtils;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

public class WindowsAndTabsTests extends BaseTest {

    private final String windowsWebPageUrl = baseUrl + webAddresses.get("widowsAndTabs");

    @Test
    @Tag(TestTagConstants.WINDOWS_AND_TABS)
    @Tag("FAKE-JIRA-NO-0009")
    public void moveAroundWindowsAndTabs() {
        driver.get(windowsWebPageUrl);
        WebPageUtils.maximiseWindow.accept(driver);

        String baseWindow = driver.getWindowHandle();
        driver.findElement(By.cssSelector("#newBrowserWindow")).click();

        switchWindowOrTab(baseWindow);

        driver.findElement(By.cssSelector(".table"));
        //•Execute steps from Tables exercise on the newly opened window

        //•Close window

        // •Click 'New Message Window' button

        //•Switch to a new window

        //•7.Print out the text that is written in a new window

        //•Close window
        // •Click on 'New Browser Tab' button

        //•Switch to a new tab
        //•Execute steps from Tables exercise on the new opened window
        //•Close tab
    }

    private void switchWindowOrTab(String baseWindow) {
        for (String windowHandle : driver.getWindowHandles()) {
            if (!baseWindow.contentEquals(windowHandle)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }
    }

}
