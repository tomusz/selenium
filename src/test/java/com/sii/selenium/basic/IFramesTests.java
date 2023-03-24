package com.sii.selenium.basic;

import com.sii.selenium.BaseTest;
import com.sii.selenium.constants.TestTagConstants;
import com.sii.selenium.utils.WebPageUtils;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class IFramesTests extends BaseTest {
    
    private final String iFrameDemoQAWebPageUrl = webAddresses.get("demoqa.iframe").toString();

    private final Runnable validateText = () -> {
        String actualIFrameText = driver.findElement(By.cssSelector("h1")).getText();
        String expectedIFrameText = "This is a sample page";
        assertThat(actualIFrameText).isEqualTo(expectedIFrameText);
    };

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