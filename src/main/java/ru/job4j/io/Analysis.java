package ru.job4j.io;

import java.io.*;

public class Analysis {
    public void unavailable(String source, String target) {
        boolean isHealthy = true;
        StringBuilder range = new StringBuilder();
        try (BufferedReader input = new BufferedReader(new FileReader(source));
             BufferedWriter output = new BufferedWriter(new FileWriter(target))) {
            for (String line : input.lines().toList()) {
                if (containsErrorCode(line) && isHealthy) {
                    range.append(line.split(" ")[1]).append(";");
                    isHealthy = false;
                }
                if (!containsErrorCode(line) && !isHealthy) {
                    range.append(line.split(" ")[1]).append(System.lineSeparator());
                    isHealthy = true;
                }
            }
            output.write(range.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private boolean containsErrorCode(String line) {
        return (line.startsWith("400") || line.startsWith("500"));
    }

    public static void main(String[] args) {
        Analysis analysis = new Analysis();
        analysis.unavailable("data/server.log", "data/target.csv");
    }
}
