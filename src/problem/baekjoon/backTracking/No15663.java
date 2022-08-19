package problem.baekjoon.backTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class No15663 {
    static StringBuilder result;
    static int m;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        List<Integer> list = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            list.add(Integer.parseInt(st.nextToken()));
        }

        Collections.sort(list);
        visited = new boolean[list.size()];
        result = new StringBuilder();

        dfs(list, 0, new StringBuilder());
        System.out.println(result);
    }

    private static void dfs(List<Integer> list, int count, StringBuilder str) {
        if (count == m) {
            result.append(str).append("\n");
            return;
        }

        int prev = 0;
        for (int i = 0; i < list.size(); i++) {
            if (!visited[i] && prev != list.get(i)) {
                visited[i] = true;
                dfs(list, count + 1, new StringBuilder().append(str).append(list.get(i)).append(" "));
                visited[i] = false;
                prev = list.get(i);
            }

        }
    }
}