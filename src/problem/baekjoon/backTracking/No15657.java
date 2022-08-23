package problem.baekjoon.backTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class No15657 {
    static StringBuilder result;
    static int n,m;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        result = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        br.close();

        Arrays.sort(arr);
        dfs(arr, 0, 0, new StringBuilder());

        System.out.println(result);
    }

    private static void dfs(int[] arr, int depth, int idx, StringBuilder builder) {
        if (depth == m) {
            result.append(builder).append("\n");
            return;
        }

        for (int i = idx; i < n; i++) {
            dfs(arr, depth + 1, i, new StringBuilder(builder).append(arr[i]).append(" "));
        }
    }

}