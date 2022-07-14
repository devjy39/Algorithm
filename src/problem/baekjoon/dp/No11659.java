package problem.baekjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No11659 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] cumSum = new int[n + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i < cumSum.length; i++) {
            cumSum[i] = cumSum[i - 1] + Integer.parseInt(st.nextToken());
        }

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            result.append(cumSum[end] - cumSum[start - 1]).append("\n");
        }
        br.close();

        System.out.println(result);
    }
}