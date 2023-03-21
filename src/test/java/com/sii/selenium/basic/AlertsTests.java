package com.sii.selenium.basic;

import com.sii.selenium.BaseTest;
import com.sii.selenium.TestTagConstants;
import com.sii.selenium.WebPageUtils;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class AlertsTests extends BaseTest {

    private final String alertWebPageUrl = baseUrl + webAddresses.get("alertsPractice");


    @Test
    @Tag(TestTagConstants.ALERTS)
    @Tag("FAKE-JIRA-NO-0001")
    public void getSimpleAlertText() {
        driver.get(alertWebPageUrl);
        WebPageUtils.maximiseWindow.accept(driver);

        driver.findElement(By.cssSelector("#simple-alert")).click();

        String actualAlertText = driver.switchTo().alert().getText();
        String expectedAlertText = "OK button pressed";
        assertThat(actualAlertText).isEqualTo(expectedAlertText);
    }

    @Test
    @Tag(TestTagConstants.ALERTS)
    @Tag("FAKE-JIRA-NO-0002")
    public void getSimpleAlertLabel() {
        driver.get(alertWebPageUrl);
        WebPageUtils.maximiseWindow.accept(driver);

        driver.findElement(By.cssSelector("#simple-alert")).click();
        driver.switchTo().alert().accept();

        String actualLabel = driver.findElement(By.cssSelector("#simple-alert-label")).getText();
        String expectedLabel = "OK button pressed";
        assertThat(actualLabel).isEqualTo(expectedLabel);
    }

    @Test
    @Tag(TestTagConstants.ALERTS)
    @Tag("FAKE-JIRA-NO-0003")
    public void getPromptAlertLabel() {
        final String testName = "Lord Vader";
        driver.get(alertWebPageUrl);
        WebPageUtils.maximiseWindow.accept(driver);

        driver.findElement(By.cssSelector("#prompt-alert")).click();
        driver.switchTo().alert().sendKeys(testName);
        driver.switchTo().alert().accept();

        String actualLabel = driver.findElement(By.cssSelector("#prompt-label")).getText();
        String expectedLabel = String.format("Hello %s! How are you today?", testName);
        assertThat(actualLabel).isEqualTo(expectedLabel);
    }

    @Test
    @Tag(TestTagConstants.ALERTS)
    @Tag("FAKE-JIRA-NO-0004")
    public void getConfirmAlertLabel() {
        final By confirmAlertBy = By.cssSelector("#confirm-alert");
        final By confirmAlertLabelBy = By.cssSelector("#confirm-label");
        driver.get(alertWebPageUrl);
        WebPageUtils.maximiseWindow.accept(driver);

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

    @Test
    @Tag(TestTagConstants.ALERTS)
    @Tag("FAKE-JIRA-NO-0005")
    public void getDelayedAlertLabel() {
        driver.get(alertWebPageUrl);
        WebPageUtils.maximiseWindow.accept(driver);

        driver.findElement(By.cssSelector("#delayed-alert")).click();

        WebDriverWait wait = new WebDriverWait(driver, WAIT_TIME);
        wait.until(ExpectedConditions.alertIsPresent());

        driver.switchTo().alert().accept();
        String actualLabel = driver.findElement(By.cssSelector("#delayed-alert-label")).getText();
        String expectedLabel = "OK button pressed";
        assertThat(actualLabel).isEqualTo(expectedLabel);
    }
}