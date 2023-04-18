package problem.baekjoon.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No1068 {
    static class Node {
        int root;
        Node children;

        public Node(int root, Node children) {
            this.root = root;
            this.children = children;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Node[] nodes = new Node[n];
        for (int i = 0; i < n; i++) {
            nodes[i] = new Node(i, null);
        }

        int root = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int node = 0; node < n; node++) {
            int parent = Integer.parseInt(st.nextToken());
            if (parent == -1) {
                root = node;
                continue;
            }
            nodes[parent].children = new Node(node, nodes[parent].children);
        }

        int removeNode = Integer.parseInt(br.readLine());
        nodes[removeNode].root = -1;

        System.out.println(dfs(nodes, nodes[root].root));
    }

    private static int dfs(Node[] nodes, int root) {
        if (root == -1) {
            return 0;
        }
        int childCount = 0;

        for (Node node = nodes[root].children; node != null; node = node.children) {
            childCount += dfs(nodes, nodes[node.root].root);
        }

        return Math.max(1, childCount); // leaf : 1
    }

}
