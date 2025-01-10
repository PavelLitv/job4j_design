package ru.job4j.io;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class EvenNumberFile {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        try (InputStream is = new FileInputStream("data/even.txt")) {
            int read;
            while ((read = is.read()) != -1) {
                sb.append((char) read);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        String[] array = sb.toString().split(System.lineSeparator());
        for (String number : array) {
            System.out.println((Integer.parseInt(number) % 2 == 0));
        }
    }
}
