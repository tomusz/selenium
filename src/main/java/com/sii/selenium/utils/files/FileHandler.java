package com.sii.selenium.utils.files;

import java.io.IOException;
import java.io.InputStream;
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

}
