package problem.baekjoon.linear;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class No9935 {

    static class CharNumber {
        char c;
        int number;

        public CharNumber(char c, int number) {
            this.c = c;
            this.number = number;
        }
    }
    static final String EMPTY = "FRULA";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder result = replace(br.readLine(), br.readLine());
        br.close();

        System.out.print(result.length() == 0 ? EMPTY : result);
    }

    private static StringBuilder replace(String str, String bomb) {
        Stack<CharNumber> stack = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            int prev = stack.size() > 0 ? stack.peek().number : 0;

            if (str.charAt(i) == bomb.charAt(prev)) {
                stack.add(new CharNumber(str.charAt(i), ++prev));

                if (prev == bomb.length()) {
                    for (int j = 0; j < bomb.length(); j++) {
                        stack.pop();
                    }
                }
            } else {
                stack.add(new CharNumber(str.charAt(i), str.charAt(i) == bomb.charAt(0) ? 1 : 0));
            }
        }

        StringBuilder result = new StringBuilder();
        for (CharNumber charNumber : stack) {
            result.append(charNumber.c);
        }

        return result;
    }

}