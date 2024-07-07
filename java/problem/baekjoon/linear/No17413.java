package problem.baekjoon.linear;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class No17413 {
    static final char OPEN_TAG = '<', CLOSE_TAG = '>', SPACE = ' ';

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        System.out.println(flippingWords(str));
    }

    private static StringBuilder flippingWords(String str) {
        StringBuilder result = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        boolean isTag = false;

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);

            if (isTag) {
                if (c == CLOSE_TAG) {
                    isTag = false;
                }
            } else if (c == OPEN_TAG) {
                stackAllPop(result, stack);
                isTag = true;
            } else if (c == SPACE) {
                stackAllPop(result, stack);
            } else {
                stack.push(c);
                continue;
            }
            result.append(c);
        }
        stackAllPop(result, stack);

        return result;
    }

    private static void stackAllPop(StringBuilder result, Stack<Character> stack) {
        while (!stack.isEmpty()) {
            result.append(stack.pop());
        }
    }

}

