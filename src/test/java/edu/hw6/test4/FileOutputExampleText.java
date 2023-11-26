package edu.hw6.test4;

import edu.hw6.task4.FileOutputExample;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class FileOutputExampleText {
    @ParameterizedTest
    @ValueSource(strings = {"Hello, World!", "UJUJ", "dfgkjl;asdfg"})
    @DisplayName("Вывод данных в файл")
    void testWriteToFile_successTest(String inputText) throws IOException {
        Path filePath = Path.of("src/test/java/edu/hw6/test4/testFile.txt");

        FileOutputExample.writeToFile(inputText, "src/test/java/edu/hw6/test4/testFile.txt");
        String actualText = Files.readString(filePath);

        assertThat(inputText).isEqualTo(actualText);
    }
}
