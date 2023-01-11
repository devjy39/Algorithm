package problem.baekjoon.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class No1707 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder result = new StringBuilder();
        StringTokenizer st;

        tLoop:
        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            List<List<Integer>> edges = getEdges(br, n, Integer.parseInt(st.nextToken()));
            int[] nodes = new int[n + 1];

            for (int node = 1; node <= n; node++) {
                if (nodes[node] == 0 && dfs(edges, nodes, node, 1)) {
                    result.append("NO\n");
                    continue tLoop;
                }
            }
            result.append("YES\n");
        }

        System.out.print(result);
    }

    private static List<List<Integer>> getEdges(BufferedReader br, int n, int e) throws IOException {
        StringTokenizer st;
        List<List<Integer>> edges = new ArrayList<>(n + 1);
        for (int j = 0; j <= n; j++) {
            edges.add(new ArrayList<>());
        }

        for (int j = 0; j < e; j++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            edges.get(start).add(end);
            edges.get(end).add(start);
        }
        return edges;
    }

    private static boolean dfs(List<List<Integer>> edges, int[] nodes, int node, int flag) {
        nodes[node] = flag;

        for (Integer adjNode : edges.get(node)) {
            if (nodes[adjNode] == flag) {
                return true;
            } else if (nodes[adjNode] == 0) {
                if (dfs(edges, nodes, adjNode, flag ^ 2 + 1)) {
                    return true;
                }
            }
        }

        return false;
    }

}