package com.sii.selenium;

import com.sii.selenium.utils.files.PropertiesProvider;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.Properties;

public class BaseTest {

    protected WebDriver driver;
    protected Properties webAddresses = PropertiesProvider.getWebAddresses();

    protected String baseUrl = webAddresses.get("baseUrl").toString();

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
        ChromeOptions options = new ChromeOptions().addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
    }
}
