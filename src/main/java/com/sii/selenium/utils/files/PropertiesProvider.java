package com.sii.selenium.utils.files;

import java.io.IOException;
import java.util.Properties;
import java.util.function.Function;

public class PropertiesProvider {

    public static Properties getWebAddresses() {
        return getPropertiesFromFile.apply("addresses.properties");
    }

    private static Function<String, Properties> getPropertiesFromFile = address -> {
        try {
            return FileHandler.loadFile(address);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    };
}