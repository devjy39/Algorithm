package problem.baekjoon.sort;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class No1766 {
    static class Node {
        int number;
        int inputs;
        List<Integer> outputs;

        public Node(int number) {
            this.number = number;
            this.outputs = new ArrayList<>();
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        Node[] nodes = new Node[n + 1];
        for (int i = 1; i <= n; i++) {
            nodes[i] = new Node(i);
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            nodes[a].outputs.add(b);
            nodes[b].inputs++;
        }

        System.out.print(topologicalSort(nodes, n));
    }

    private static String topologicalSort(Node[] nodes, int n) {
        StringBuilder result = new StringBuilder();
        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(n2 -> n2.number));
        for (int i = 1; i <= n; i++) {
            if (nodes[i].inputs == 0) {
                pq.add(nodes[i]);
            }
        }

        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            result.append(cur.number).append(' ');

            for (Integer output : cur.outputs) {
                if (--nodes[output].inputs == 0) {
                    pq.add(nodes[output]);
                }
            }
        }

        return result.toString();
    }

}