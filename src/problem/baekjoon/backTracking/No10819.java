package problem.baekjoon.backTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No10819 {
    static int[] arr;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        arr = new int[n];
        visited = new boolean[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(dfs(0, 0, 0));
    }

    private static int dfs(int depth, int prev, int sum) {
        if (depth >= arr.length) {
            return sum;
        }

        int result = 0;
        for (int i = 0; i < arr.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                result = Math.max(result, dfs(depth + 1, arr[i],
                        sum + (depth > 0 ? Math.abs(prev - arr[i]) : 0)));
                visited[i] = false;
            }
        }

        return result;
    }

}

