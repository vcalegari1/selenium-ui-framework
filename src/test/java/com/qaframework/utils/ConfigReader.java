package com.viniciuscalegari.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    private static final Properties properties = new Properties();
    private static final String CONFIG_PATH = "src/test/resources/config.properties";

    static {
        try (FileInputStream inputStream = new FileInputStream(CONFIG_PATH)) {
            properties.load(inputStream);
        } catch (IOException e) {
            throw new RuntimeException("Failed to load config.properties from " + CONFIG_PATH, e);
        }
    }

    private ConfigReader() {
        // prevents instantiation
    }

    public static String get(String key) {
        String value = properties.getProperty(key);
        if (value == null) {
            throw new RuntimeException("Property '" + key + "' not found in config.properties");
        }
        return value;
    }
}