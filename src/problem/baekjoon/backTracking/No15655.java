package problem.baekjoon.backTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class No15655 {
    static StringBuilder result = new StringBuilder();
    static int m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        dfs(arr, new StringBuilder(), 0, 0);

        System.out.print(result);
    }

    private static void dfs(int[] arr, StringBuilder sb, int idx, int prev) {
        if (idx >= m) {
            result.append(sb).append("\n");
            return;
        }

        for (int i = prev; i < arr.length; i++) {
            dfs(arr, new StringBuilder(sb).append(arr[i]).append(" "), idx + 1, i + 1);
        }
    }

}

