package edu.hw6.task2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class CloneFile {
    public static void getCloneFile(Path path) {
        int copyNumber = 1;
        Path newFilePath = path.resolveSibling(path.getFileName().toString());
        while (Files.exists(newFilePath)) {
            String fileName = path.getFileName().toString();
            int dotIndex = fileName.lastIndexOf(".");
            String name = dotIndex == -1 ? fileName : fileName.substring(0, dotIndex);
            String extension = dotIndex == -1 ? "" : fileName.substring(dotIndex);
            newFilePath =
                path.resolveSibling(name + " — копия" + (copyNumber > 1 ? " (" + copyNumber + ")" : "") + extension);
            copyNumber++;
        }
        try {
            Files.copy(path, newFilePath);
            System.out.println("Файл успешно создан!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
