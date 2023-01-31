package problem.baekjoon.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class No15681 {

    static class Node {
        int subTree;
        List<Integer> edges = new ArrayList<>();
    }

    static Node[] tree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());
        tree = new Node[N + 1];
        for (int i = 0; i <= N; i++) {
            tree[i] = new Node();
        }

        for (int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            tree[u].edges.add(v);
            tree[v].edges.add(u);
        }

        leveling(R, new boolean[N + 1]);

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < Q; i++) {
            result.append(tree[Integer.parseInt(br.readLine())].subTree).append("\n");
        }

        System.out.print(result);
    }

    private static int leveling(int root, boolean[] visited) {
        int child = 1;
        visited[root] = true;

        for (int node : tree[root].edges) {
            if (!visited[node]) {
                child += leveling(node, visited);
            }
        }

        return tree[root].subTree = child;
    }

}