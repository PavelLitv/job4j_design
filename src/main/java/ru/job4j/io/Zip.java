package ru.job4j.io;

import java.io.*;
import java.nio.file.Path;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Zip {
    private static void validate(ArgsName argsName) {
        if (!new File(argsName.get("d")).exists()) {
            throw new IllegalArgumentException(String.format("Not exist: %s", argsName.get("d")));
        }
        if (!argsName.get("e").startsWith(".")) {
            throw new IllegalArgumentException(String.format("Incorrect file format: %s", argsName.get("e")));
        }
        if (!argsName.get("o").endsWith(".zip")) {
            throw new IllegalArgumentException(String.format("Incorrect archive format: %s", argsName.get("o")));
        }
    }

    public void packFiles(List<Path> sources, File target) {
        try (ZipOutputStream zip = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(target)))) {
            for (Path source : sources) {
                if (source.toFile().isDirectory()) {
                    zip.putNextEntry(new ZipEntry(source.toString()));
                } else {
                    zip.putNextEntry(new ZipEntry(source.toString()));
                    try (BufferedInputStream input = new BufferedInputStream(new FileInputStream(source.toFile()))) {
                        zip.write(input.readAllBytes());
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void packSingleFile(File source, File target) {
        try (ZipOutputStream zip = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(target)))) {
            zip.putNextEntry(new ZipEntry(source.getPath()));
            try (BufferedInputStream output = new BufferedInputStream(new FileInputStream(source))) {
                zip.write(output.readAllBytes());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        ArgsName argsName = ArgsName.of(args);
        validate(argsName);
        Zip zip = new Zip();
        List<Path> sources = Search.search(
                        Path.of(argsName.get("d")),
                        path -> !path.toFile().getName().endsWith(argsName.get("e")))
                .stream()
                .map(path -> Path.of(argsName.get("d")).relativize(path))
                .toList();
        zip.packFiles(sources, new File(argsName.get("o")));
    }
}
