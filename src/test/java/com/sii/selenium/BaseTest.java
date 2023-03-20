package com.sii.selenium;

import com.sii.selenium.utils.files.PropertiesProvider;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Properties;

public class BaseTest {

    protected WebDriver driver;
    protected Properties webAddresses = PropertiesProvider.getWebAddresses();

    public BaseTest() {
    }

    @BeforeAll
    static void setup() {
        WebDriverManager.chromedriver().setup();
    }

    @AfterEach
    void teardown() {
        driver.quit();
    }

    @BeforeEach
    void setupDriver() {
        driver = new ChromeDriver();
    }
}
