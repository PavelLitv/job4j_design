package ru.job4j.template;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.*;

@Disabled("Тесты отключены. Удалить аннотацию после реализации всех методов по заданию.")
class PhraseGeneratorTest {

    @Test
    void whenCorrectArgsThenGetPhrase() {
        String template = "I am ${name}, Who are ${subject}?";
        Map<String, String> args = new HashMap<>();
        args.put("name", "Petr");
        args.put("subject", "you");
        PhraseGenerator generator = new PhraseGenerator();
        assertThat("I am a Petr, Who are you?").isEqualTo(generator.produce(template, args));
    }

    @Test
    void whenOneArgMissingThenGetException() {
        String template = "I am ${name}, Who are ${subject}?";
        Map<String, String> args = new HashMap<>();
        args.put("name", "Petr");
        PhraseGenerator generator = new PhraseGenerator();
        assertThatThrownBy(() -> generator.produce(template, args))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void whenOneIncorrectArgsThenGetException() {
        String template = "I am ${name}, Who are ${subject}?";
        Map<String, String> args = new HashMap<>();
        args.put("name", "Petr");
        args.put("object", "you");
        PhraseGenerator generator = new PhraseGenerator();
        assertThatThrownBy(() -> generator.produce(template, args))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void whenMoreArgsThenGetException() {
        String template = "I am ${name}, Who are ${subject}?";
        Map<String, String> args = new HashMap<>();
        args.put("name", "Petr");
        args.put("subject", "you");
        args.put("object", "Pavel");
        PhraseGenerator generator = new PhraseGenerator();
        assertThatThrownBy(() -> generator.produce(template, args))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
