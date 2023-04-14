package problem.baekjoon.linear;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class No2504 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(getScore(br.readLine()));
    }

    static final char ROUND_OPEN = '(', ROUND_CLOSE = ')', SQUARE_OPEN = '[', SQUARE_CLOSE = ']';

    private static int getScore(String str) {
        Stack<Character> stack = new Stack<>();

        int result = 0;
        int op = 1;

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);

            if (c == ROUND_OPEN) {
                op *= 2;
                stack.push(c);
            } else if (c == SQUARE_OPEN) {
                op *= 3;
                stack.push(c);
            } else if (c == ROUND_CLOSE) {
                if (stack.isEmpty() || stack.pop() != ROUND_OPEN) {
                    return 0;
                }
                if (str.charAt(i - 1) == ROUND_OPEN) {
                    result += op;
                }
                op /= 2;
            } else { // SQUARE_CLOSE
                if (stack.isEmpty() || stack.pop() != SQUARE_OPEN) {
                    return 0;
                }
                if (str.charAt(i - 1) == SQUARE_OPEN) {
                    result += op;
                }
                op /= 3;
            }
        }

        return stack.isEmpty() ? result : 0;
    }

}
