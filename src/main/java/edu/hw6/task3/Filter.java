package edu.hw6.task3;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Filter {
    public static AbstractFilter largerThan(long size) {
        return (Path entry) -> {
            try {
                return Files.size(entry) > size;
            } catch (IOException e) {
                return false;
            }
        };
    }

    public static AbstractFilter magicNumber(int... magicBytes) {
        return (Path entry) -> {
            try {
                byte[] bytes = Files.readAllBytes(entry);
                if (bytes.length < magicBytes.length) {
                    return false;
                }
                for (int i = 0; i < magicBytes.length; i++) {
                    if ((bytes[i] & 0xFF) != magicBytes[i]) {
                        return false;
                    }
                }
                return true;
            } catch (IOException e) {
                return false;
            }
        };
    }

    public static AbstractFilter globMatches(String glob) {
        return (Path entry) -> entry.getFileName().toString().matches(glob);
    }

    public static AbstractFilter regexContains(String regex) {
        return (Path entry) -> entry.getFileName().toString().matches(regex);
    }
}
