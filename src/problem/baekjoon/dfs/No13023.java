package problem.baekjoon.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No13023 {
    static class Node {
        int number;
        Node next;

        public Node(int number, Node next) {
            this.number = number;
            this.next = next;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Node[] nodes = new Node[n];
        for (int i = 0; i < n; i++) {
            nodes[i] = new Node(i, null);
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            nodes[a].next = new Node(b, nodes[a].next);
            nodes[b].next = new Node(a, nodes[b].next);
        }

        System.out.println(isPossibleDepth5(nodes) ? 1 : 0);
    }

    private static boolean isPossibleDepth5(Node[] nodes) {
        boolean[] visited = new boolean[nodes.length];
        for (int i = 0; i < nodes.length; i++) {
            if (dfs(nodes, visited, i, 1)) {
                return true;
            }
        }

        return false;
    }

    private static boolean dfs(Node[] nodes, boolean[] visited, int number, int depth) {
        if (depth >= 5) {
            return true;
        }
        visited[number] = true;

        for (Node node = nodes[number].next; node != null; node = node.next) {
            if (!visited[node.number] && dfs(nodes, visited, node.number, depth + 1)) {
                return true;
            }
        }

        visited[number] = false;
        return false;
    }

}

