package problem.baekjoon.linear;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No6198 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] stack = new int[n];
        int top = -1;
        long count = 0;

        for (int i = 0; i < n; i++) {
            int height = Integer.parseInt(br.readLine());
            while (top >= 0 && stack[top] <= height) {
                top--;
            }

            count += top + 1;
            stack[++top] = height;
        }

        System.out.println(count);
    }

}

