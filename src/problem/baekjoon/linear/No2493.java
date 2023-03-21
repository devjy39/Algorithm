package problem.baekjoon.linear;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No2493 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(getTopNumber(n, arr));
    }

    private static StringBuilder getTopNumber(int n, int[] arr) {
        StringBuilder result = new StringBuilder();
        int[] stack = new int[n];
        int top = -1;

        for (int i = 0; i < n; i++) {
            while (top >= 0 && arr[stack[top]] < arr[i]) {
                top--;
            }

            result.append(top < 0 ? 0 : stack[top] + 1).append(" ");
            stack[++top] = i;
        }

        return result;
    }

}
