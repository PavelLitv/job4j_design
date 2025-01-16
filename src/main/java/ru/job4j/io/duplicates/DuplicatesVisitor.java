package ru.job4j.io.duplicates;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.HashMap;

public class DuplicatesVisitor extends SimpleFileVisitor<Path> {
    private HashMap<FileProperty, String> fileProperties = new HashMap<>();

    @Override
    public FileVisitResult visitFile(Path file,
                                     BasicFileAttributes attributes) throws IOException {
        if (attributes.isRegularFile()) {
            FileProperty fileProperty = new FileProperty(attributes.size(), file.getFileName().toString());
            fileProperties.compute(fileProperty, (k, v) ->
                    v == null ? file.toAbsolutePath().toString() : v + System.lineSeparator() + file.toAbsolutePath());
        }
        return super.visitFile(file, attributes);
    }

    public void printDuplicates() {
        fileProperties.forEach((key, value) -> {
            if (value.contains(System.lineSeparator())) {
                System.out.printf("%s - %.1f Mb%n", key.getName(), key.getSize() / 1024.0);
                System.out.println(value);
                System.out.println();
            }
        });
    }
}
