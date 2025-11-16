// src/test/java/utilities/ConfigReader.java
package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    private static Properties properties;

    // Статический блок для загрузки файла конфигурации один раз
    static {
        try {
            String path = "C:\\Users\\Vladiklimanadik\\Desktop\\CleanProjectForInterview\\config.properties";
            FileInputStream input = new FileInputStream(path);
            properties = new Properties();
            properties.load(input);
            input.close();
        } catch (IOException e) {
            System.out.println("ERROR: Could not load configuration file!");
            e.printStackTrace();
        }
    }

    /**
     * Возвращает значение по заданному ключу из config.properties.
     * @param key Ключ в файле конфигурации.
     * @return Значение в виде строки.
     */
    public static String getProperty(String key) {
        return properties.getProperty(key);
    }
}