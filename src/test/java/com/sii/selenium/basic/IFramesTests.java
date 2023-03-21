package com.sii.selenium.basic;

import com.sii.selenium.BaseTest;
import com.sii.selenium.constants.TestTagConstants;
import com.sii.selenium.utils.WebPageUtils;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class IFramesTests extends BaseTest {

    private final String iFrameWebPageUrl = baseUrl + webAddresses.get("iframe");
    private final String iFrameDemoQAWebPageUrl = webAddresses.get("iframe.other").toString();
    private final Runnable fillFormInFirstFrame = () -> {
        //logic for filling form 1
        //will be implemented when page is up
    };
    private final Runnable fillFormInSecondFrame = () -> {
        //logic for filling form 2
        //will be implemented when page is up
    };
    private final Runnable validateText = () -> {
        String actualIFrameText = driver.findElement(By.cssSelector("h1")).getText();
        String expectedIFrameText = "This is a sample page";
        assertThat(actualIFrameText).isEqualTo(expectedIFrameText);
    };

    @Test
    @Tag(TestTagConstants.I_FRAMES)
    @Tag("FAKE-JIRA-NO-0007")
    public void moveAround() {
        driver.get(iFrameWebPageUrl);
        WebPageUtils.maximiseWindow.accept(driver);

        execute("iframe1", fillFormInFirstFrame);
        execute("iframe2", fillFormInSecondFrame);
        //•Switch to the main frame and click on 'Basic' button in the main menu
//        driver.findElement(By.cssSelector("Button_selector")).click();
    }

    @Test
    @Tag(TestTagConstants.I_FRAMES)
    @Tag("FAKE-JIRA-NO-0008")
    public void moveAroundDemoQA() {
        driver.get(iFrameDemoQAWebPageUrl);
        WebPageUtils.maximiseWindow.accept(driver);

        execute("frame1", validateText);
        execute("frame2", validateText);
    }

    private void execute(String frameName, Runnable command) {
        driver.switchTo().frame(frameName);
        command.run();
        driver.switchTo().defaultContent();
    }
}