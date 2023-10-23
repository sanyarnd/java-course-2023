package tinkoff2.exception.finaly;

import java.io.FileReader;
import java.io.IOException;


public class ResourcesExample {

    public static void main(String[] args) throws IOException {

    }

    public static void readFromFile() throws IOException {
        FileReader fileReader = null;
        try {
            fileReader = new FileReader("file.txt");
            fileReader.read();
        } catch (IOException e) {

        } finally {

            if (fileReader != null) {
                fileReader.close();
            }
        }
    }

    public static void readFromFileResources() throws IOException {
        try (FileReader fileReader = new FileReader("file.txt")) {
            fileReader.read();
        } catch (IOException e) {

        }
    }

    public static void readFromFileResourcesExisted() throws IOException {
        FileReader fileReader = new FileReader("file.txt");
        try (fileReader) {
            fileReader.read();
        } catch (IOException e) {

        }
    }
}
