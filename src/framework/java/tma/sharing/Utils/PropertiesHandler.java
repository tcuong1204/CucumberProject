package tma.sharing.Utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesHandler {

    public static Properties properties = new Properties();
    private static FileInputStream fis;

    public static Properties loadApplicationProperties() {
        try {
            fis = new FileInputStream("src/test/resources/properties/application.properties");
            properties.load(fis);

        } catch (IOException io) {
            io.printStackTrace();
        }

        return properties;

    }


    public static Properties loadCredentialProperties() {
        try {
            fis = new FileInputStream("src/test/resources/properties/credential.properties");
            properties.load(fis);

        } catch (IOException io) {
            io.printStackTrace();
        }

        return properties;
    }

}
