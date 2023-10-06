package problem.baekjoon.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No1240 {
    static class Node {
        int root;
        int distance;
        Node next;

        public Node(int root, int distance, Node next) {
            this.root = root;
            this.distance = distance;
            this.next = next;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        queue = new int[n + 1];
        Node[] nodes = new Node[n + 1];
        for (int i = 1; i <= n; i++) {
            nodes[i] = new Node(i, 0, null);
        }
        for (int i = 1; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            nodes[a].next = new Node(b, d, nodes[a].next);
            nodes[b].next = new Node(a, d, nodes[b].next);
        }

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            result.append(getDistance(nodes, a, b)).append("\n");
        }

        System.out.println(result);
    }

    static int[] queue;
    static int front, rear;

    private static int getDistance(Node[] nodes, int a, int b) {
        front = -1;
        rear = -1;
        queue[++front] = a;
        int[] distances = new int[nodes.length];
        distances[a] = 1;

        while (front != rear) {
            int cur = queue[++rear];

            for (Node next = nodes[cur].next; next != null; next = next.next) {
                if (distances[next.root] == 0) {
                    distances[next.root] = distances[cur] + next.distance;
                    queue[++front] = next.root;
                }
            }
        }

        return distances[b] - 1;
    }

}

