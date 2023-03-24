package com.sii.selenium.basic;

import com.sii.selenium.BaseTest;
import com.sii.selenium.constants.FileConstants;
import com.sii.selenium.constants.Genders;
import com.sii.selenium.constants.Profession;
import com.sii.selenium.constants.TestTagConstants;
import com.sii.selenium.utils.ArithmeticUtils;
import com.sii.selenium.utils.WebPageUtils;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import java.io.File;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class FormTests extends BaseTest {

    private final String formWebPageUrl = baseUrl + webAddresses.get("basic.form");

    @Test
    @Tag(TestTagConstants.FORMS)
    @Tag("FAKE-JIRA-NO-0006")
    public void fillInForm() {
        driver.get(formWebPageUrl);
        WebPageUtils.maximiseWindow.accept(driver);


        driver.findElement(By.cssSelector("#inputFirstName3")).sendKeys("John");

        driver.findElement(By.cssSelector("#inputLastName3")).sendKeys("Bluebox");

        driver.findElement(By.cssSelector("#inputEmail3")).sendKeys("realemail@real.com");

        driver.findElement(By.id(
                Genders.getByNumber(ArithmeticUtils.getRandomNumberInRange(1, 3)).id)).click();

        driver.findElement(By.cssSelector("#inputAge3")).sendKeys("20");

        driver.findElement(By.cssSelector("#gridRadios" +
                ArithmeticUtils.getRandomNumberInRange(1, 7))).click();

        driver.findElement(By.id(Profession.getByNumber(
                ArithmeticUtils.getRandomNumberInRange(1, 3)).id)).click();

        Select continents = new Select(driver.findElement(By.id("selectContinents")));
        continents.selectByIndex(ArithmeticUtils.getRandomNumberInRange(1, 7));

        Select seleniumCommands = new Select(driver.findElement(By.id("selectSeleniumCommands")));

        seleniumCommands.selectByValue("switch-commands");
        seleniumCommands.selectByValue("wait-commands");

        File file = FileConstants.getPathToSomeFile().toFile();
        driver.findElement(By.id("chooseFile")).sendKeys(file.getAbsolutePath());

        driver.findElement(By.className("btn-primary")).click();

        String actualLabel = driver.findElement(By.cssSelector("#validator-message")).getText();
        String expectedLabel = "Form send with success";
        assertThat(actualLabel).isEqualTo(expectedLabel);
    }
}