package problem.baekjoon.linear;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No16120 {
    static final String PPAP = "PPAP";
    static final String NP = "NP";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        System.out.println(isPPAP(str));
    }

    private static String isPPAP(String str) {
        char[] ppap = PPAP.toCharArray();
        int[] stack = new int[str.length() + 2];
        int top = 0;
        stack[top] = -1;
        int count;

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            count = stack[top];

            if (ppap[count + 1] == c) {
                if (stack[top] == 2) {
                    top -= 2;
                } else {
                    stack[++top] = count + 1;
                }
            } else {
                if (c == 'P') {
                    stack[++top] = count;
                } else {
                    return NP;
                }
            }

        }

        return top == 1 ? PPAP : NP;
    }

}

