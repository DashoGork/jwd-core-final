package com.epam.jwd.core_final.util;

import com.epam.jwd.core_final.domain.ApplicationProperties;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.io.FileInputStream;

public final class PropertyReaderUtil {

    private static final Properties properties = new Properties();

    private PropertyReaderUtil() {
    }

    /**
     * try-with-resource using FileInputStream
     *
     * @see {https://www.netjstech.com/2017/09/how-to-read-properties-file-in-java.html for an example}
     * <p>
     * as a result - you should populate {@link ApplicationProperties} with corresponding
     * values from property file
     */
    public static void loadProperties() {
        InputStream iStream = null;
        try {
            iStream = new FileInputStream("C:\\jwd-core-final-master\\jwd-core-final-master\\src\\main\\resources\\application.properties");
            properties.load(iStream);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if(iStream != null){
                    iStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void initApplicationProperties(){
        ApplicationProperties applicationProperties=ApplicationProperties.getInstance(properties.getProperty("inputRootDir"),properties.getProperty("outputRootDir"),properties.getProperty("crewFileName"),
                properties.getProperty("missionsFileName"),properties.getProperty("spaceshipsFileName"),properties.getProperty("fileRefreshRate"),
                properties.getProperty("dateTimeFormat"));
    }
}
