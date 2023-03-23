package com.sii.selenium.utils;

import com.sii.selenium.constants.Months;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class DataPickerUtils {

    public static void moveToDate(WebDriver driver, WebElement element, Date date) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        String formattedDate = formatter.format(date);

        String[] splitDate = formattedDate.split("-");

        int day = Integer.parseInt(splitDate[0]);
        int month = Integer.parseInt(splitDate[1]);
        int year = Integer.parseInt(splitDate[2]);

        element.click();
        moveYearMonth(driver, getMonthsDifference(driver, month, year));
        pickDayOfMonth(driver, element, day);
    }

    private static void pickDayOfMonth(WebDriver driver, WebElement element, int day) {
        WaitUtils.waitForElementVisible.apply(driver, element.findElement(
                By.xpath("//a[contains(@class,'ui-state-default')]" +
                        "[not(contains(@class,'ui-priority-secondary'))][.="
                        + day + "]"))).click();
    }

    private static int getMonthsDifference(WebDriver driver, int expectedMonth, int expectedYear) {
        int displayedYear = Integer.parseInt(WaitUtils.waitForElementVisible.apply(driver,
                driver.findElement(By.cssSelector(".ui-datepicker-year"))).getText());
        int displayedMonth = getMontNumberByName(WaitUtils.waitForElementVisible.apply(driver,
                driver.findElement(By.cssSelector(".ui-datepicker-month"))).getText());

        return (expectedYear - displayedYear) * 12 + expectedMonth - displayedMonth;
    }

    private static void moveYearMonth(WebDriver driver, int monthDifference) {
        if (monthDifference > 0) {
            moveMonthsForwards(driver, monthDifference);
        } else if (monthDifference < 0) {
            moveMonthsBack(driver, monthDifference * -1);
        }
    }

    private static void moveMonthsBack(WebDriver driver, int months) {
        for (int i = 0; i < months; i++) {
            WebElement moveToPast = WaitUtils.waitForElementVisible.apply(driver,
                    driver.findElement(By.xpath("//span[.='Prev']")));
            Actions actions = new Actions(driver);
            actions.moveToElement(moveToPast).click().perform();
        }
    }

    private static void moveMonthsForwards(WebDriver driver, int months) {
        for (int i = 0; i < months; i++) {
            WebElement moveToPast = WaitUtils.waitForElementVisible.apply(driver,
                    driver.findElement(By.xpath("//span[.='Next']")));
            Actions actions = new Actions(driver);
            actions.moveToElement(moveToPast).click().perform();
        }
    }

    private static int getMontNumberByName(String monthName) {
        return Arrays.stream(Months.values())
                .filter(x -> x.getName().equals(monthName))
                .map(x -> Integer.parseInt(x.getNumber()))
                .findFirst().get();
    }
}
