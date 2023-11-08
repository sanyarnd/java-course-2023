package tinkoff2.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertyFiles {
    public static void main(String[] args) throws IOException {
        Properties catalogProps = new Properties();
        catalogProps.load(new FileInputStream("app.properties"));

        System.out.println(catalogProps);
    }
}
