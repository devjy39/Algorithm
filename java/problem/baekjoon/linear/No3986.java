package problem.baekjoon.linear;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class No3986 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int count = 0;

        for (int i = 0; i < n; i++) {
            String word = br.readLine();
            if (isGoodWord(word)) {
                count++;
            } else {
                stack.clear();
            }
        }

        System.out.println(count);
    }

    static Stack<Character> stack = new Stack<>();
    private static boolean isGoodWord(String word) {

        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (stack.isEmpty() || stack.peek() != c) {
                stack.add(c);
            } else {
                stack.pop();
            }
        }

        return stack.isEmpty();
    }

}

