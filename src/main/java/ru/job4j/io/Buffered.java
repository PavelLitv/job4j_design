package ru.job4j.io;

import ru.job4j.question.Info;

import java.io.*;

public class Buffered {
    public static void main(String[] args) {
        Info info = new Info(1, 2, 3);
        System.out.println(info);
        try (BufferedInputStream input = new BufferedInputStream(new FileInputStream("data/input.txt"));
             BufferedOutputStream output = new BufferedOutputStream(new FileOutputStream("data/output.txt", true))) {
            output.write(input.readAllBytes());
            output.write(System.lineSeparator().getBytes());
            output.write(info.toString().getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}