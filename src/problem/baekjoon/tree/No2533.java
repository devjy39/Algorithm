package problem.baekjoon.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No2533 {

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
    static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;

        nodes = new Node[N + 1];
        for (int i = 1; i <= N; i++) {
            nodes[i] = new Node(i);
        }

        for (int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            nodes[s].child = new Node(e, nodes[s].child);
            nodes[e].child = new Node(s, nodes[e].child);
        }

        dfs(1, 0);
        System.out.println(count);
    }

    // leaf 노드가 아닌 것을 사용한다. 이미 사용된 노드는 자식에서 제외
    private static boolean dfs(int n, int prev) {
        boolean isLeaf = true;

        for (Node node = nodes[n].child; node != null; node = node.child) {
            if (node.root == prev) {
                continue;
            }

            if (dfs(node.root, n)) { // leaf 노드를 갖고 있는가?
                isLeaf = false;
            }
        }

        if (!isLeaf) {
            count++;
        }
        return isLeaf;
    }

}