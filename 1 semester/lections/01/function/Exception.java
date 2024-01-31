package tinkoff.function;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Exception {

    public static void main(String[] args) throws IOException {
        readFromFile("fileName.txt");
    }


    public static void createReader(String fileName) throws FileNotFoundException {
        FileReader fileReader = new FileReader(fileName);
    }

    public static void readFromFile(String fileName) throws IOException {
        FileReader fileReader = new FileReader(fileName);
        fileReader.read();
    }
}
