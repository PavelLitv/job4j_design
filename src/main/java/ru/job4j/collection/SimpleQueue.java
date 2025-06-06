package ru.job4j.collection;

import java.util.NoSuchElementException;

public class SimpleQueue<T> {
    private final SimpleStack<T> input = new SimpleStack<>();
    private final SimpleStack<T> output = new SimpleStack<>();
    private int inputSize = 0;
    private int outputSize = 0;

    public T poll() {
        if (inputSize == 0 && outputSize == 0) {
            throw new NoSuchElementException("Queue is empty");
        }
        if (inputSize > 0) {
            for (int i = 0; i < inputSize; i++) {
                output.push(input.pop());
                outputSize++;
            }
            inputSize = 0;
        }
        outputSize--;
        return output.pop();
    }

    public void push(T value) {
        if (outputSize > 0) {
            for (int i = 0; i < outputSize; i++) {
                input.push(output.pop());
                inputSize++;
            }
            outputSize = 0;
        }
        input.push(value);
        inputSize++;
    }
}
