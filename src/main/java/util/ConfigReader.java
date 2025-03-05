package util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    static Properties properties;

    public static Properties initProperties() {
        properties = new Properties();

        try {
            FileInputStream fs = new FileInputStream("src/test/resources/config.properties");
            properties.load(fs);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return getProperties();
    }

    public static Properties getProperties() {
        return properties;
    }
}
