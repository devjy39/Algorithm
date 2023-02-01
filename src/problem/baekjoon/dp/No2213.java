package problem.baekjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class No2213 {

    static List<List<Integer>> edges;
    static int[] w;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        //System.setIn(new FileInputStream("src/data.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        dp = new int[N + 1][2];
        StringTokenizer st = new StringTokenizer(br.readLine());
        w = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            w[i] = Integer.parseInt(st.nextToken());
        }

        edges = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            edges.add(new ArrayList<>());
        }
        for (int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            edges.get(s).add(e);
            edges.get(e).add(s);
        }

        StringBuilder result = new StringBuilder();
        result.append(dfs(1, 0, true)).append("\n");
        for (Integer node : getVisitedNodes(N)) {
            result.append(node).append(" ");
        }

        System.out.println(result);
    }

    private static List<Integer> getVisitedNodes(int N) {
        List<Integer> list = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        boolean[] visited = new boolean[N + 1];

        while (!queue.isEmpty()) {
            Integer cur = queue.poll();
            visited[cur] = true;

            if (dp[cur][1] >= dp[cur][0]) {
                list.add(cur);
                for (Integer idj : edges.get(cur)) {
                    if (visited[idj]) {
                        continue;
                    }
                    visited[idj] = true;
                    for (Integer idj2 : edges.get(idj)) {
                        if (!visited[idj2]) {
                            queue.add(idj2);
                        }
                    }
                }
            } else {
                for (Integer idj : edges.get(cur)) {
                    if (!visited[idj]) {
                        queue.add(idj);
                    }
                }
            }
        }
        Collections.sort(list);
        return list;
    }

    private static int dfs(int n, int prev, boolean isIn) {
        if (dp[n][isIn ? 1 : 0] > 0) {
            return dp[n][isIn ? 1 : 0];
        }
        int sum = isIn ? w[n] : 0;

        for (Integer idjNode : edges.get(n)) {
            if (idjNode == prev) {
                continue;
            }

            sum += dfs(idjNode, n, !isIn);
        }

        dp[n][isIn ? 1 : 0] = sum;
        return isIn ? Math.max(sum, dfs(n, prev, false)) : sum;
    }

}