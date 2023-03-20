package com.sii.selenium.basic;

import com.sii.selenium.BaseTest;
import com.sii.selenium.TestConstants;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class AlertTests extends BaseTest {

    private final String alertWebPageUrl = webAddresses.get("baseUrl").toString() + webAddresses.get("alertsPractice").toString();


    @Test
    @Tag(TestConstants.ALERTS)
    @Tag("FAKE-JIRA-NO-0001")
    public void getSimpleAlertText() {
        driver.get(alertWebPageUrl);

        driver.findElement(By.cssSelector("#simple-alert")).click();

        String actualAlertText = driver.switchTo().alert().getText();
        String expectedAlertText = "OK button pressed";
        assertThat(actualAlertText).isEqualTo(expectedAlertText);
    }
    @Test
    @Tag(TestConstants.ALERTS)
    @Tag("FAKE-JIRA-NO-0002")
    public void getSimpleAlertLabel() {
        driver.get(alertWebPageUrl);

        driver.findElement(By.cssSelector("#simple-alert")).click();
        driver.switchTo().alert().accept();

        String actualLabel = driver.findElement(By.cssSelector("#simple-alert-label")).getText();
        String expectedLabel = "OK button pressed";
        assertThat(actualLabel).isEqualTo(expectedLabel);
    }

    @Test
    @Tag(TestConstants.ALERTS)
    @Tag("FAKE-JIRA-NO-0003")
    public void getPromptAlertLabel() {
        final String testName = "Lord Vader";
        driver.get(alertWebPageUrl);

        driver.findElement(By.cssSelector("#prompt-alert")).click();
        driver.switchTo().alert().sendKeys(testName);
        driver.switchTo().alert().accept();

        String actualLabel = driver.findElement(By.cssSelector("#prompt-label")).getText();
        String expectedLabel = String.format("Hello %s! How are you today?",testName);
        assertThat(actualLabel).isEqualTo(expectedLabel);
    }

    @Test
    @Tag(TestConstants.ALERTS)
    @Tag("FAKE-JIRA-NO-0004")
    public void getConfirmAlertLabel() {
        final By confirmAlertBy = By.cssSelector("#confirm-alert");
        final By confirmAlertLabelBy = By.cssSelector("#confirm-label");
        driver.get(alertWebPageUrl);

        driver.findElement(confirmAlertBy).click();
        driver.switchTo().alert().accept();

        String actualLabel = driver.findElement(confirmAlertLabelBy).getText();
        String expectedLabel = "You pressed OK!";
        assertThat(actualLabel).isEqualTo(expectedLabel);

        driver.findElement(confirmAlertBy).click();
        driver.switchTo().alert().dismiss();

        actualLabel = driver.findElement(confirmAlertLabelBy).getText();
         expectedLabel = "You pressed Cancel!";
        assertThat(actualLabel).isEqualTo(expectedLabel);
    }

//    @Test
//    @Tag(TestConstants.ALERTS)
//    @Tag("FAKE-JIRA-NO-0005")
//    public void getDelayedAlertLabel() {
//        driver.get(alertWebPageUrl);
//
//        driver.findElement(By.cssSelector("#delayed-alert")).click();
//        //wait
//        driver.switchTo().alert().accept();
//        String actualLabel = driver.findElement(By.cssSelector("#delayed-alert-label")).getText();
//        String expectedLabel = "OK button pressed";
//        assertThat(actualLabel).isEqualTo(expectedLabel);
//    }

}
