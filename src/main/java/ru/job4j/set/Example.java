package ru.job4j.set;

public class Example {
    private static int count = 0;

    public Example() {
        System.out.println("Example #" + ++count);
    }

    public static int getCount() {
        return count;
    }

    public static void main(String[] args) {
        Example example = new Example();
        System.out.println(getCount());
    }
}
