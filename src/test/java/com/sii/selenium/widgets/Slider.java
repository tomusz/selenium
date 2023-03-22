package com.sii.selenium.widgets;

import com.sii.selenium.BaseTest;
import com.sii.selenium.constants.TestTagConstants;
import com.sii.selenium.utils.SliderUtils;
import com.sii.selenium.utils.WebPageUtils;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Slider extends BaseTest {

    private final String sliderUrl = baseUrl + webAddresses.get("widgets.slider");

    @Test
    @Tag(TestTagConstants.SLIDER)
    @Tag("FAKE-JIRA-NO-0024")
    public void moveSlider() {
        driver.get(sliderUrl);
        WebPageUtils.maximiseWindow.accept(driver);


        SliderUtils.moveSliderTo(driver, 50);
        assertSlider(driver, 50);
        SliderUtils.moveSliderTo(driver, 80);
        assertSlider(driver, 80);
        SliderUtils.moveSliderTo(driver, 80);
        assertSlider(driver, 80);
        SliderUtils.moveSliderTo(driver, 20);
        assertSlider(driver, 20);
        SliderUtils.moveSliderTo(driver, 0);
        assertSlider(driver, 0);
    }

    private void assertSlider(WebDriver driver, int expectedValue) {
        WebElement slider = driver.findElement(By.id("custom-handle"));
        assertThat(slider.getText()).isEqualTo(expectedValue + "");
    }
}