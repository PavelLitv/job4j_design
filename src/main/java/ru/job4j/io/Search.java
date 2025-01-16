package ru.job4j.io;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.function.Predicate;

public class Search {
    public static void main(String[] args) throws IOException {
        validate(args);
        Path start = Paths.get(args[0]);
        String formatFile = args[1];
        search(start, path -> path.toFile().getName().endsWith(formatFile))
                .forEach(System.out::println);
    }

    public static List<Path> search(Path root, Predicate<Path> condition) throws IOException {
        SearchFiles searcher = new SearchFiles(condition);
        Files.walkFileTree(root, searcher);
        return searcher.getPaths();
    }

    public static void validate(String[] args) {
        if (args.length == 0) {
            throw new IllegalArgumentException("Root folder and search param is null. Usage ROOT_FOLDER and SEARCH_PARAM");
        }
        if (args.length == 1) {
            throw new IllegalArgumentException("Search param is null. Usage SEARCH_PARAM");
        }
        Path path = Path.of(".");
        if (!Files.exists(path)) {
            throw new IllegalArgumentException(String.format("Not exist %s", path.toAbsolutePath()));
        }
        if (!Files.isDirectory(path)) {
            throw new IllegalArgumentException(String.format("Not directory %s", path.toAbsolutePath()));
        }
    }
}
