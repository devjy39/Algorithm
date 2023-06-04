package problem.baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No12904 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        String t = br.readLine();

        System.out.println(isEqualString(s, t));
    }

    private static int isEqualString(String s, String t) {
        boolean isReverse = false;
        int left = 0;
        int right = t.length() - 1;

        for (int i = s.length(); i < t.length(); i++) {
            char pop = isReverse ? t.charAt(left++) : t.charAt(right--);

            if (pop == 'B') {
                isReverse = !isReverse;
            }
        }

        for (int i = 0; i < s.length(); i++) {
            char cur = isReverse ? t.charAt(right--) : t.charAt(left++);

            if (cur != s.charAt(i)) {
                return 0;
            }
        }

        return 1;
    }

}