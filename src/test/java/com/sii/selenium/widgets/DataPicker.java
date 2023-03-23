package com.sii.selenium.widgets;

import com.sii.selenium.BaseTest;
import com.sii.selenium.constants.TestTagConstants;
import com.sii.selenium.utils.ArithmeticUtils;
import com.sii.selenium.utils.DataPickerUtils;
import com.sii.selenium.utils.DateUtils;
import com.sii.selenium.utils.WebPageUtils;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import java.text.SimpleDateFormat;
import java.util.Date;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class DataPicker extends BaseTest {

    private final String dataPickerWebPageUrl = baseUrl + webAddresses.get("widgets.datapicker");

    @Test
    @Tag(TestTagConstants.DATA_PICKER)
    @Tag("FAKE-JIRA-NO-0026")
    public void dataPickerTests() {
        driver.get(dataPickerWebPageUrl);
        WebPageUtils.maximiseWindow.accept(driver);

        Date today = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");


        DataPickerUtils.moveToDate(driver, driver.findElement(By.id("datepicker")), today);

        compare(formatter.format(today));

        DateUtils dU = new DateUtils(today);
        Date firstDayNextMonth = dU.addMonth(1).setFirstOfDayMonth().getDate();

        DataPickerUtils.moveToDate(driver, driver.findElement(By.id("datepicker")), firstDayNextMonth);
        compare(formatter.format(firstDayNextMonth));

        Date lastDayJanuaryNextYear = dU.setMonth(1).setLastDayOfMonth().addYear(1).getDate();
        DataPickerUtils.moveToDate(driver, driver.findElement(By.id("datepicker")), lastDayJanuaryNextYear);
        compare(formatter.format(lastDayJanuaryNextYear));

        DataPickerUtils.moveToDate(driver, driver.findElement(By.id("datepicker")), today);
        compare(formatter.format(today));

        Date randomDayFromPreviousMonth = dU.addMonth(-1)
                .setDay(ArithmeticUtils.getRandomNumberInRange(1, dU.getLastDayOfMonth()))
                .getDate();
        DataPickerUtils.moveToDate(driver, driver.findElement(By.id("datepicker")), randomDayFromPreviousMonth);
        compare(formatter.format(randomDayFromPreviousMonth));

        Date lastYearDate = dU.addYear(-1)
                .setMonth(ArithmeticUtils.getRandomNumberInRange(1,12))
                .setDay(dU.getLastDayOfMonth())
                .getDate();
        DataPickerUtils.moveToDate(driver, driver.findElement(By.id("datepicker")), lastYearDate);
        compare(formatter.format(lastYearDate));
    }

    private void compare(String expectedDate) {
        String actualDate = driver.findElement(By.id("datepicker")).getAttribute("value");
        assertThat(actualDate).isEqualTo(expectedDate);
    }

}
