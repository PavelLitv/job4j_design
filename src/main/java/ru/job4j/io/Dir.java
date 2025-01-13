package ru.job4j.io;

import java.io.File;

public class Dir {
    public static void main(String[] args) {
        File file = new File("d:\\projects\\job4j_design");
        if (!file.exists()) {
            throw new IllegalArgumentException(String.format("Директория не существует: %s", file.getAbsoluteFile()));
        }
        if (!file.isDirectory()) {
            throw new IllegalArgumentException(String.format("Это не директория: %s", file.getAbsoluteFile()));
        }
        System.out.printf("Размер директории: %s%n", file.getTotalSpace());
        File[] files = file.listFiles();
        if (files != null) {
            for (File subfile : files) {
                if (subfile.isDirectory()) {
                    System.out.printf("Имя директории: %s, размер файлов в директории %d%n", subfile.getName(), calcDirectorySize(subfile));
                } else {
                    System.out.printf("Имя файла: %s, размер файла %d%n", subfile.getName(), subfile.length());
                }
            }
        }
    }

    private static long calcDirectorySize(File dir) {
        long size = 0;
        File[] files = dir.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    size += calcDirectorySize(file);
                } else {
                    size += file.length();
                }
            }
        }
        return size;
    }
}
