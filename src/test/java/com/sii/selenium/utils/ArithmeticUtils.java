package com.sii.selenium.utils;

import java.util.concurrent.ThreadLocalRandom;

public class ArithmeticUtils {

    public static int getRandomNumberInRange(int min, int max) {
        return ThreadLocalRandom.current().nextInt(min, max);
    }
}