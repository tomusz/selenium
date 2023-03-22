package com.sii.selenium.interactions;

import com.sii.selenium.BaseTest;
import com.sii.selenium.constants.TestTagConstants;
import com.sii.selenium.utils.WebPageUtils;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.util.Collections;

public class Resizable extends BaseTest {

    private final String resizeableWebPageUrl = baseUrl + webAddresses.get("interactions.resizable");

    @Test
    @Tag(TestTagConstants.RESIZEABLE)
    @Tag("FAKE-JIRA-NO-0016")
    public void selectMultiple() {
        driver.get(resizeableWebPageUrl);
        WebPageUtils.maximiseWindow.accept(driver);

        //TODO:need to finish
    }

}
