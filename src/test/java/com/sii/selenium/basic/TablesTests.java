package com.sii.selenium.basic;

import com.sii.selenium.BaseTest;
import com.sii.selenium.utils.TablesUtils;
import com.sii.selenium.constants.TestTagConstants;
import com.sii.selenium.utils.WebPageUtils;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class TablesTests extends BaseTest {

    private final String tablesWebPageUrl = baseUrl + webAddresses.get("basic.table");
    private final int REQUIRED_MOUNTAIN_HEIGHT = 4000;

    @Test
    @Tag(TestTagConstants.TABLES)
    @Tag("FAKE-JIRA-NO-0009")
    public void getRows() {
        driver.get(tablesWebPageUrl);
        WebPageUtils.maximiseWindow.accept(driver);

        List<WebElement> rowsWithSwitzerland = driver.findElements(By.xpath("//tr/td[contains(.,'Switzerland')]/.."));
        TablesUtils.printRowsWithHeightMoreThan(rowsWithSwitzerland, REQUIRED_MOUNTAIN_HEIGHT);
    }
}