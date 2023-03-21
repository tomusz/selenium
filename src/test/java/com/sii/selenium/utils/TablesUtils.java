package com.sii.selenium.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static com.sii.selenium.constants.TestHeaderConstants.*;

public class TablesUtils {

    public static void printRowsWithHeightMoreThan(List<WebElement> rows, int height) {
        for (WebElement row : rows) {
            if (Integer.parseInt(row.findElement(By.xpath(TABLE_HEIGHT_HEADER.xpath)).getText()) > height) {
                printCellValueWithCellName(TABLE_RANK_HEADER.name,
                        row.findElement(By.xpath(TABLE_RANK_HEADER.xpath)).getText());
                printCellValueWithCellName(TABLE_PEAK_HEADER.name,
                        row.findElement(By.xpath(TABLE_PEAK_HEADER.xpath)).getText());
                printCellValueWithCellName(TABLE_MOUNTAIN_RANGE_HEADER.name,
                        row.findElement(By.xpath(TABLE_MOUNTAIN_RANGE_HEADER.xpath)).getText());
                printCellValueWithCellName(TABLE_STATE_HEADER.name,
                        row.findElement(By.xpath(TABLE_STATE_HEADER.xpath)).getText());
                printCellValueWithCellName(TABLE_HEIGHT_HEADER.name,
                        row.findElement(By.xpath(TABLE_HEIGHT_HEADER.xpath)).getText());
                System.out.print("\n");
            }
        }
    }

    private static void printCellValueWithCellName(String cellName, String cellValue) {
        System.out.print(cellName + " : " + cellValue + " ");
    }
}