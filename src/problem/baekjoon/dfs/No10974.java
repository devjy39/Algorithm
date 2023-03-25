package problem.baekjoon.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No10974 {
    static StringBuilder result = new StringBuilder();
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        dfs(new boolean[n + 1], new StringBuilder(), 1);

        System.out.print(result);
    }

    private static void dfs(boolean[] visited, StringBuilder sb, int depth) {
        if (depth > n) {
            result.append(sb).append("\n");
            return;
        }

        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(visited, new StringBuilder(sb).append(i).append(" "), depth + 1);
                visited[i] = false;
            }
        }
    }

}
