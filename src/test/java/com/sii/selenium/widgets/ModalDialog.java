package com.sii.selenium.widgets;

import com.sii.selenium.BaseTest;
import com.sii.selenium.constants.TestTagConstants;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class ModalDialog extends BaseTest {

    private final String modalDialogUrl = baseUrl + webAddresses.get("widgets.modaldialog");

    @ParameterizedTest
    @CsvFileSource(resources = "/testData.csv")
    @Tag(TestTagConstants.MODAL_DIALOG)
    @Tag("FAKE-JIRA-NO-0011")
    void shouldCreateAccount(String name, String email, String password) {
        driver.get(modalDialogUrl);
        driver.findElement(By.cssSelector("#create-user")).click();

        WebElement nameInput = driver.findElement(By.cssSelector("#name"));
        nameInput.clear();
        nameInput.sendKeys(name);

        WebElement emailNInput = driver.findElement(By.cssSelector("#email"));
        emailNInput.clear();
        emailNInput.sendKeys(email);

        WebElement passwordInput = driver.findElement(By.cssSelector("#password"));
        passwordInput.clear();
        passwordInput.sendKeys(password);

        driver.findElements(By.cssSelector(".ui-dialog-buttonset .ui-button")).get(0).click();

        assertThat(driver.findElement(By.xpath("//tbody/tr[2]/td[1]")).getText()).isEqualTo(name);
        assertThat(driver.findElement(By.xpath("//tbody/tr[2]/td[2]")).getText()).isEqualTo(email);
        assertThat(driver.findElement(By.xpath("//tbody/tr[2]/td[3]")).getText()).isEqualTo(password);
        driver.quit();
    }
}
