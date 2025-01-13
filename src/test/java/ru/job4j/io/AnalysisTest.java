package ru.job4j.io;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.*;
import java.nio.file.Path;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class AnalysisTest {
    @Test
    void whenUnavailableThenTwoPeriod(@TempDir Path tempdir) throws IOException {
        StringBuilder expected = new StringBuilder();
        expected.append("10:57:01;10:59:01")
                .append("11:01:02;11:02:02");
        File source = tempdir.resolve("source.txt").toFile();
        try (PrintWriter out = new PrintWriter(source)) {
            out.println("200 10:56:01");
            out.println("500 10:57:01");
            out.println("400 10:58:01");
            out.println("300 10:59:01");
            out.println("500 11:01:02");
            out.println("200 11:02:02");
        }
        StringBuilder actual = new StringBuilder();
        File target = tempdir.resolve("target.txt").toFile();
        new Analysis().unavailable(source.getPath(), target.getPath());
        try (BufferedReader input = new BufferedReader(new FileReader(target))) {
            input.lines().forEach(actual::append);
        }
        assertThat(actual.toString()).isEqualTo(expected.toString());
    }

    @Test
    void whenUnavailableThenNoPeriod(@TempDir Path tempdir) throws IOException {
        String expected = "";
        File source = tempdir.resolve("source.txt").toFile();
        try (PrintWriter out = new PrintWriter(source)) {
            out.println("200 10:56:01");
            out.println("200 10:57:01");
        }
        StringBuilder actual = new StringBuilder();
        File target = tempdir.resolve("target.txt").toFile();
        new Analysis().unavailable(source.getPath(), target.getPath());
        try (BufferedReader input = new BufferedReader(new FileReader(target))) {
            input.lines().forEach(actual::append);
        }
        assertThat(actual.toString()).isEqualTo(expected);
    }

    @Test
    void whenUnavailableThenPeriodDontClosed(@TempDir Path tempdir) throws IOException {
        String expected = "10:57:01;";
        File source = tempdir.resolve("source.txt").toFile();
        try (PrintWriter out = new PrintWriter(source)) {
            out.println("200 10:56:01");
            out.println("400 10:57:01");
        }
        StringBuilder actual = new StringBuilder();
        File target = tempdir.resolve("target.txt").toFile();
        new Analysis().unavailable(source.getPath(), target.getPath());
        try (BufferedReader input = new BufferedReader(new FileReader(target))) {
            input.lines().forEach(actual::append);
        }
        assertThat(actual.toString()).isEqualTo(expected);
    }
}