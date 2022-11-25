package problem.baekjoon.linear;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class No1918 {

    static final Map<Character, Integer> operator = new HashMap<>(
            Map.of('+', 1, '-', 1, '*', 2, '/', 2, '(', 0));

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print(postOrder(br.readLine()));
        br.close();
    }

    private static StringBuilder postOrder(String str) {
        StringBuilder result = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (Character.isUpperCase(c)) {
                result.append(c);
                continue;
            }

            if (c == ')') {
                char pop;
                while ((pop = stack.pop()) != '(') {
                    result.append(pop);
                }
            } else if (c == '(') {
                stack.add(c);
            } else {
                while (!stack.isEmpty() && operator.get(stack.peek()) >= operator.get(c)) {
                    result.append(stack.pop());
                }
                stack.add(c);
            }
        }

        while (!stack.isEmpty()) {
            result.append(stack.pop());
        }
        return result;
    }

}