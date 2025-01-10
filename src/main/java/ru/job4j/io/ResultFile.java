package ru.job4j.io;

import java.io.FileOutputStream;
import java.io.IOException;

public class ResultFile {
    public static void main(String[] args) {
        try (FileOutputStream output = new FileOutputStream("data/dataresult.txt")) {
            StringBuilder sb = new StringBuilder();
            for (int i = 2; i <= 10; i++) {
                for (int j = 1; j <= 10; j++) {
                    sb.append(i * j).append(" ");
                }
                sb.append(System.lineSeparator());
            }
            output.write(sb.toString().getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
