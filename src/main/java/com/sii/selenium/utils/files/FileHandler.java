package com.sii.selenium.utils.files;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Timestamp;
import java.util.Properties;

public class FileHandler {

    public static Properties loadFile(String path) throws IOException {
        InputStream configFile = null;
        Properties properties = null;

        try {
            configFile = ClassLoader.getSystemClassLoader().getResourceAsStream(path);
            properties = new Properties();
            properties.load(configFile);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            assert configFile != null;
            configFile.close();
        }
        return properties;
    }

    public static void makeAScreenShot(WebDriver driver) {
        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(scrFile, new File("src/main/resources/screenshots/" + new java.util.Date().getTime() +".png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
