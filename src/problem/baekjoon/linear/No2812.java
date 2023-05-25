package problem.baekjoon.linear;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No2812 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        String stringNumber = br.readLine();
        System.out.println(getResult(n, k, stringNumber));
    }

    private static String getResult(int n, int k, String stringNumber) {
        StringBuilder result = new StringBuilder();
        int[] stack = new int[n];
        int top = -1;
        int idx;
        for (idx = 0; idx < n; idx++) {
            int number = stringNumber.charAt(idx) - '0';

            if (top < 0 || stack[top] >= number) {
                stack[++top] = number;
            } else {
                while (top>= 0 && stack[top] < number && k-- > 0) {
                    top--;
                }

                if (k <= 0) {
                    break;
                }
                stack[++top] = number;
            }
        }

        while (k-- > 0) {
            top--;
        }
        for (int i = 0; i <= top; i++) {
            result.append(stack[i]);
        }
        for (int i = idx; i < n; i++) {
            result.append(stringNumber.charAt(i));
        }

        return result.toString();
    }

}
