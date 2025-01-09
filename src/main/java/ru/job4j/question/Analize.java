package ru.job4j.question;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Analize {
    public static Info diff(Set<User> previous, Set<User> current) {
        int added = 0;
        int changed = 0;
        Map<Integer, String> map = new HashMap<>();
        previous.forEach(user -> map.put(user.getId(), user.getName()));
        for (User user : current) {
            String result = map.put(user.getId(), user.getName());
            if (result == null) {
                added++;
            } else if (!result.equals(user.getName())) {
                changed++;
            }
        }
        return new Info(added, changed, previous.size() - current.size() + added);
    }
}
