package models;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Config {
    
    private Config() {}

    private static Properties attache() {
        Properties properties = null;
        try {
            properties = tryAttache();
        } catch (FileNotFoundException e) {
            System.err.println("Hiba! A fájl nem található!");
            System.err.println(e.getMessage());
        } catch (IOException e) {
            System.err.println("Hiba! A konfiguráció betöltése sikertelen!");
            System.err.println(e.getMessage());
        }
        return properties;
    }

    private static Properties tryAttache() throws IOException {
        Properties properties;
        InputStream stream;

        properties = new Properties();
        stream = new FileInputStream("synchttpclient.config");
        properties.load(stream);
        return properties;
    }

    public static Properties newProperties() {
        return attache();
    }
}
