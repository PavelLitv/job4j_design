package ru.job4j.algo;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SmallestRangeFinder {
    public static int[] findSmallestRange(int[] nums, int k) {
        int left = 0;
        int minLength = nums.length;
        int[] result = null;
        Map<Integer, Integer> frequencyMap = new HashMap<>();

        for (int right = 0; right < nums.length; right++) {
            System.out.println(nums[right]);
            frequencyMap.put(nums[right], frequencyMap.getOrDefault(nums[right], 0) + 1);

            while (frequencyMap.size() >= k) {
                if (frequencyMap.size() == k && right - left + 1 < minLength) {
                    minLength = right - left + 1;
                    result = new int[]{left, right};
                }
                int count = frequencyMap.get(nums[left]);
                if (count == 1) {
                    frequencyMap.remove(nums[left]);
                } else {
                    frequencyMap.put(nums[left], count - 1);
                }
                left++;
            }
            if (minLength == k) {
                break;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 7, 9};
        int k = 3;
        int[] result = findSmallestRange(nums, k);
        if (result != null) {
            System.out.println("Наименьший диапазон с " + k + " различными элементами: " + Arrays.toString(result));
        } else {
            System.out.println("Такой диапазон не существует.");
        }
    }
}
