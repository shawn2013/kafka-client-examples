package com.demo.common;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @author shawn
 * @Description //TODO
 * @createTime 2022年12月28日 17:46:00
 */
public class PropertiesUtil {

    public static Properties getProperties() {
        Properties properties = new Properties();
        InputStream input = null;
        try {
            // input = ClassLoader.getSystemResourceAsStream("client.properties");
            input = new FileInputStream("src/main/resources/client.properties");
            properties.load(input);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties;
    }
}
