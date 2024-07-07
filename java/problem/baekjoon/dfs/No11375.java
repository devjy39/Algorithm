package problem.baekjoon.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class No11375 {
    static boolean[] visited;
    static boolean[] raw;
    static int[] col;
    static List<List<Integer>> graphs;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        raw = new boolean[n + 1];
        col = new int[m + 1];
        graphs = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graphs.add(new ArrayList<>());
        }
        for (int i = 1; i <= m; i++) {
            col[i] = -1;
        }

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            for (int j = 0; j < num; j++) {
                graphs.get(i).add(Integer.valueOf(st.nextToken()));
            }
        }
        br.close();

        int answer = 0;
        for (int i = 1; i <= n; i++) {
            visited = new boolean[i + 1];
            if (dfs(i)) { // raw 당 col 하나씩 매칭한다.
                answer++;
            }
        }
        System.out.println(answer);
    }

    private static boolean dfs(int node) {
        if (visited[node]) {
            return false;
        }
        visited[node] = true;

        for (int idx : graphs.get(node)) {
            /*  이미 매칭된 col의 raw에서 다른 col로 변경 가능한지 탐색
            * */
            if (col[idx] == -1 || dfs(col[idx])) {
                col[idx] = node;
                return true;
            }
        }

        return false;
    }
}