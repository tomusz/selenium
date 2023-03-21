package com.sii.selenium.basic;

import com.sii.selenium.BaseTest;
import com.sii.selenium.TestConstants;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class TablesTests extends BaseTest {

    private final String tablesWebPageUrl = baseUrl + webAddresses.get("table");

    @Test
    @Tag(TestConstants.TABLES)
    @Tag("FAKE-JIRA-NO-0009")
    public void getRows() {
        //•Get all rows from table to List
        //•Print out 'Rank', 'Peak' and 'Mountain range' of mountains that are in "Switzerland" and are higher than 4000 m
    }
}