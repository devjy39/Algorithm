package problem.baekjoon.etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No11438 {
    static class Node {
        int root;
        Node child;

        public Node(int root, Node child) {
            this.root = root;
            this.child = child;
        }

    }

    static int[][] sparse;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        Node[] nodes = new Node[N + 1];
        for (int i = 1; i <= N; i++) {
            nodes[i] = new Node(i, null);
        }

        for (int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            nodes[a].child = new Node(b, nodes[a].child);
            nodes[b].child = new Node(a, nodes[b].child);
        }

        int[] level = new int[N + 1];
        sparse = new int[(int) (Math.log(100_000) / Math.log(2)) + 1][N + 1];
        dfs(nodes, nodes[1], level, 1);
        getSparseTable(N);

        int M = Integer.parseInt(br.readLine());
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            result.append(getLCA(level, Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()))).append("\n");
        }

        System.out.print(result);
    }

    private static void getSparseTable(int N) {
        for (int i = 1; i < sparse.length; i++) {
            for (int j = 1; j <= N; j++) {
                sparse[i][j] = sparse[i - 1][sparse[i - 1][j]];
            }
        }
    }

    private static int getLCA(int[] level, int a, int b) {
        if (level[a] > level[b]) {
            a = levelUp(a, level[a] - level[b]);
        } else if (level[b] > level[a]) {
            b = levelUp(b, level[b] - level[a]);
        }
        if (a == b) {
            return a;
        }

        return upLCA(a, b);
    }

    private static int upLCA(int a, int b) {
        if (sparse[0][a] == sparse[0][b]) {
            return sparse[0][a];
        }

        for (int i = 1; i < sparse.length; i++) {
            if (sparse[i][a] == sparse[i][b]) {
                return upLCA(sparse[i - 1][a], sparse[i - 1][b]);
            }
        }

        return -1;
    }

    private static int levelUp(int node, int h) {
        for (int i = 0; i < sparse.length; i++) {
            if ((h & (1 << i)) > 0) {
                node = sparse[i][node];
            }
        }

        return node;
    }

    private static void dfs(Node[] nodes, Node root, int[] level, int l) {
        int number = root.root;
        level[number] = l;
        nodes[root.root].root = -1;

        for (Node node = root.child; node != null; node = node.child) {
            if (nodes[node.root].root > 0) {
                sparse[0][node.root] = number;
                dfs(nodes, nodes[node.root], level, l + 1);
            }
        }
    }


}