package problem.baekjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No1949 {

    static class Node {
        int root;
        Node child;

        public Node(int root) {
            this.root = root;
        }

        public Node(int root, Node child) {
            this.root = root;
            this.child = child;
        }
    }

    static Node[] nodes;
    static int[] headcount;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        nodes = new Node[N + 1];
        for (int i = 1; i <= N; i++) {
            nodes[i] = new Node(i);
        }

        headcount = new int[N + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            headcount[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            nodes[s].child = new Node(e, nodes[s].child);
            nodes[e].child = new Node(s, nodes[e].child);
        }

        dp = new int[N + 1][2];

        System.out.println(dfs(1, 0, true));
    }

    static int[][] dp;

    private static int dfs(int n, int prev, boolean use) {
        if (dp[n][use ? 1 : 0] > 0) {
            return dp[n][use ? 1 : 0];
        }

        int sum = use ? headcount[n] : 0;

        for (Node node = nodes[n].child; node != null; node = node.child) {
            if (node.root == prev) {
                continue;
            }

            sum += dfs(node.root, n, !use);
        }

        return use ? Math.max((dp[n][1] = sum), dfs(n, prev, false)) : (dp[n][0] = sum);
    }

}