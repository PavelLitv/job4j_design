package ru.job4j.io;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

public class CSVReader {
    private static final String STDOUT = "stdout";

    public static void handle(ArgsName argsName) {
        String separator = argsName.get("delimiter");
        String[] filters = argsName.get("filter").split(",");
        int[] indexes = new int[filters.length];
        List<String[]> lines = new ArrayList<>();

        try (Scanner scanner = new Scanner(new File(argsName.get("path")), StandardCharsets.UTF_8)) {
            while (scanner.hasNextLine()) {
                lines.add(scanner.nextLine().split(separator));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        for (int i = 0; i < filters.length; i++) {
            indexes[i] = Arrays.stream(lines.getFirst()).toList().indexOf(filters[i]);
        }
        List<String> result = lines.stream()
                .map(line -> Arrays.stream(indexes)
                        .mapToObj(i -> line[i])
                        .collect(Collectors.joining(separator)))
                .toList();
        if (STDOUT.equals(argsName.get("out"))) {
            for (String line : result) {
                System.out.println(line);
            }
        } else {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(argsName.get("out"), StandardCharsets.UTF_8))) {
                writer.write(String.join(System.lineSeparator(), result) + System.lineSeparator());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void validate(ArgsName argsName) {
        if (!new File(argsName.get("path")).exists()) {
            throw new IllegalArgumentException(String.format("Not exist: %s", argsName.get("path")));
        }
        if (!Files.isRegularFile(Paths.get(argsName.get("out"))) && !STDOUT.equals(argsName.get("out"))) {
            throw new IllegalArgumentException(String.format("Param 'out' not equals 'stdout' or not a path to file: %s", argsName.get("out")));
        }
        if (!argsName.get("filter").matches("([a-zA-Z_]+)(,[a-zA-Z_]+)*")) {
            throw new IllegalArgumentException(String.format("Param 'filter' %s, does not match the template: education,age", argsName.get("filter")));
        }
    }

    public static void main(String[] args) {
        ArgsName argsName = ArgsName.of(args);
        validate(argsName);
        handle(argsName);
    }
}
