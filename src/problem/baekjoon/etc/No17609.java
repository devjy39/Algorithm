package problem.baekjoon.etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No17609 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder result = new StringBuilder();

        while (t-- > 0) {
            String str = br.readLine();
            result.append(getPalindromeType(str, 0, str.length() - 1, false)).append('\n');
        }

        System.out.print(result);
    }

    private static int getPalindromeType(String s, int left, int right, boolean chance) {
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                if (chance) {
                    return 2;
                }
                if (s.charAt(left + 1) == s.charAt(right) && getPalindromeType(s, left + 1, right, true) == 0) {
                    return 1;
                }
                if (s.charAt(left) == s.charAt(right - 1) && getPalindromeType(s, left, right - 1, true) == 0) {
                    return 1;
                }
                return 2;
            }
            left++;
            right--;
        }

        return 0;
    }


}