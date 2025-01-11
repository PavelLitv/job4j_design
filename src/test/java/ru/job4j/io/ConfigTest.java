package ru.job4j.io;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class ConfigTest {

    @Test
    void whenPairWithoutComment() {
        String path = "./data/pair_without_comment.properties";
        Config config = new Config(path);
        config.load();
        assertThat(config.value("name")).isEqualTo("Petr Arsentev");
    }

    @Test
    void whenPairWithCommentAndEmptyLines() {
        String path = "./data/with_comment_and_empty_lines.properties";
        Config config = new Config(path);
        config.load();
        assertThat(config.value("name")).isEqualTo("Petr Arsentev");
        assertThat(config.value("hibernate.connection.driver_class")).isEqualTo("org.postgresql.Driver");
    }

    @Test
    void whenPairHasOnlyKey() {
        String path = "./data/doesnt_template_only_key.properties";
        Config config = new Config(path);
        assertThatThrownBy(config::load)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Invalid config file: " + path + ", line: hibernate.connection.password=");
    }

    @Test
    void whenPairHasOnlyValue() {
        String path = "./data/doesnt_template_only_value.properties";
        Config config = new Config(path);
        assertThatThrownBy(config::load)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Invalid config file: " + path + ", line: =password");
    }

    @Test
    void whenPairDoesntContainsSymbolEquals() {
        String path = "./data/doesnt_template_not_has_symbol_equals.properties";
        Config config = new Config(path);
        assertThatThrownBy(config::load)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Invalid config file: " + path + ", line: hibernate.connection.driverpostgresql.Driver");
    }

    @Test
    void whenValueContainsSymbolEquals() {
        String path = "./data/value_contains_symbol_equals.properties";
        Config config = new Config(path);
        config.load();
        assertThat(config.value("hibernate.connection.password")).isEqualTo("password=1");
    }
}
