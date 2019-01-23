package ru.autotests.properties;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class AppProperties {
    private final Properties properties = new Properties();

    private static AppProperties INSTANCE = null;

    //Считываем файл ресурсов
    private AppProperties(){
        System.setProperty("environment", "application");
        try {
            properties.load(new FileInputStream("src/main/resources/variable.properties"));
        } catch (IOException e) {
            System.err.println("ОШИБКА: Файл свойств отсуствует!");
        }
    }

    public static AppProperties getInstance() {
        if (INSTANCE == null){
            INSTANCE = new AppProperties();
        }
        return INSTANCE;
    }

    public Properties getProperties() {
        return properties;
    }
}
