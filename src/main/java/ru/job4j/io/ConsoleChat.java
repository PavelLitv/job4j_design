package ru.job4j.io;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class ConsoleChat {
    private static final String OUT = "закончить";
    private static final String STOP = "стоп";
    private static final String CONTINUE = "продолжить";
    private final String path;
    private final String botAnswers;
    private final Scanner scanner = new Scanner(System.in);
    private final Random random = new Random();

    public ConsoleChat(String path, String botAnswers) {
        this.path = path;
        this.botAnswers = botAnswers;
    }

    public void run() {
        List<String> botAnswers = readPhrases();
        List<String> log = new ArrayList<>();
        boolean isEnd = false;
        boolean isStopAnswer = false;
        while (!isEnd) {
            String userPhrase = scanner.nextLine();
            if (STOP.equals(userPhrase)) {
                isStopAnswer = true;
            }
            if (CONTINUE.equals(userPhrase)) {
                isStopAnswer = false;
            }
            if (OUT.equals(userPhrase)) {
                isEnd = true;
                System.out.println("Давай до свиданья!");
            }
            if (!isStopAnswer && !isEnd) {
                System.out.println(botAnswers.get(random.nextInt(botAnswers.size())));
            }
            log.add(userPhrase);
        }
        saveLog(log);
    }

    private List<String> readPhrases() {
        List<String> phrases = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(botAnswers, StandardCharsets.UTF_8))) {
            reader.lines().forEach(phrases::add);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return phrases;
    }

    private void saveLog(List<String> log) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(path, StandardCharsets.UTF_8))) {
            writer.write(String.join(System.lineSeparator(), log));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ConsoleChat consoleChat = new ConsoleChat("data/log_chat.txt", "data/answer.txt");
        consoleChat.run();
    }
}
