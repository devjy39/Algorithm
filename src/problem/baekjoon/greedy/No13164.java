package problem.baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class No13164 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] heights = new int[n - 1];

        st = new StringTokenizer(br.readLine());
        int prev = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n - 1; i++) {
            int number = Integer.parseInt(st.nextToken());

            heights[i] = number - prev;
            prev = number;
        }

        Arrays.sort(heights);

        int price = 0;
        for (int i = 0; i < n-k; i++) {
            price += heights[i];
        }

        System.out.println(price);
    }
}

