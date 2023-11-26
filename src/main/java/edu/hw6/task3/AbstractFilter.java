package edu.hw6.task3;

import java.nio.file.DirectoryStream;
import java.nio.file.Path;

public interface AbstractFilter extends DirectoryStream.Filter<Path> {
    default AbstractFilter and(AbstractFilter other) {
        return (Path entry) -> this.accept(entry) && other.accept(entry);
    }

    default AbstractFilter or(AbstractFilter other) {
        return (Path entry) -> this.accept(entry) || other.accept(entry);
    }
}
