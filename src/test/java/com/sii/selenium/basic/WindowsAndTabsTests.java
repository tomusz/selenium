package com.sii.selenium.basic;

import com.sii.selenium.BaseTest;
import com.sii.selenium.TestConstants;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class WindowsAndTabsTests extends BaseTest {

    @Test
    @Tag(TestConstants.WINDOWS_AND_TABS)
    @Tag("FAKE-JIRA-NO-0009")
    public void moveAroundWindowsAndTabs() {
        //•Click on 'New Browser Window' button
        //•Switch to a new window
        //•Execute steps from Tables exercise on the newly opened window
        //•Close window•Click 'New Message Window' button
        //•Switch to a new window
        //•7.Print out the text that is written in a new window
        //•Close window•Click on 'New Browser Tab' button
        //•Switch to anew tab
        //•Execute steps from Tables exercise on the new opened window
        //•Close tab
    }

}
