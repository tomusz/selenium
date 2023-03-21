package com.sii.selenium.utils;

import org.openqa.selenium.WebDriver;

import java.util.function.Consumer;

public class WebPageUtils {

    public static Consumer<WebDriver> maximiseWindow = d -> d.manage().window().maximize();
}
