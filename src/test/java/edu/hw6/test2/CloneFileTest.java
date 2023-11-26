package edu.hw6.test2;

import edu.hw6.task2.CloneFile;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CloneFileTest {
    @Test
    @DisplayName("Клонирование файлов")
    void cloneFileInTempDirectory_successTest() throws IOException {
        //чтобы не создавать множество копий в текущем каталоге используем временную
        Path temporaryDirectory = Files.createTempDirectory("temporaryDirectory");

        Path newFileInDirectory = Paths.get(temporaryDirectory.toString(), "cloneFileTest.txt");
        Files.write(newFileInDirectory, "dassadasdasd".getBytes());

        CloneFile.getCloneFile(newFileInDirectory);

        File[] files = temporaryDirectory.toFile().listFiles();
        String[] fileNames = new String[files.length];
        for (int i = 0; i < files.length; i++) {
            fileNames[i] = files[i].getName();
        }
        assertTrue(Arrays.asList(fileNames).contains("cloneFileTest — копия.txt"));
    }
}
