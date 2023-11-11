package problem.baekjoon.backTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No23284 {
    static StringBuilder sequences = new StringBuilder();
    static int[] stack, result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        stack = new int[n];
        result = new int[n];

        findStackSequence(1, -1, 0);
        System.out.print(sequences);
    }

    private static void findStackSequence(int number, int top, int index) {
        if (number > result.length) {
            addSequence(top, index);
            return;
        }

        if (top >= 0) { // pop
            int num = stack[top];
            result[index] = stack[top];
            findStackSequence(number, top - 1, index + 1);
            stack[top] = num;
        }

        stack[++top] = number; // add
        findStackSequence(number + 1, top, index);
    }

    private static void addSequence(int top, int index) {
        for (int i = 0; i < index; i++) {
            sequences.append(result[i]).append(' ');
        }
        while (top >= 0) {
            sequences.append(stack[top--]).append(' ');
        }
        sequences.append('\n');
    }

}

