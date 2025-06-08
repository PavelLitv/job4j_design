package ru.job4j.algo.hash;

import java.util.HashSet;
import java.util.Set;

public class LongestUniqueSubstring {
    public static String longestUniqueSubstring(String str) {
        Set<Character> uniqChars = new HashSet<>();
        int left = 0;
        int right = 0;
        int maxStart = 0;
        int maxLength = 0;

        while (right < str.length()) {
            char c = str.charAt(right);
            while (uniqChars.contains(c)) {
                uniqChars.remove(str.charAt(left++));
            }
            uniqChars.add(c);
            if (right - left + 1 > maxLength) {
                maxLength = right - left + 1;
                maxStart = left;
            }
            right++;
        }
        return str.substring(maxStart, maxStart + maxLength);
    }
}
