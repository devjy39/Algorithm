package problem.baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class No30108 {
    static class Node{
        int number;
        int weight;

        public Node(int number, int weight) {
            this.number = number;
            this.weight = weight;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        List<List<Integer>> graph = new ArrayList<>(n + 1);
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 2; i <= n; i++) {
            int p = Integer.parseInt(st.nextToken());
            graph.get(p).add(i);
        }

        Node[] nodes = new Node[n + 1];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 1; i <= n; i++) {
            nodes[i] = new Node(i, Integer.parseInt(st.nextToken()));
        }

        System.out.print(getMaxNodeSum(nodes, graph));
    }

    private static String getMaxNodeSum(Node[] nodes, List<List<Integer>> graph) {
        PriorityQueue<Node> queue = new PriorityQueue<>((n1, n2) -> n2.weight - n1.weight);
        queue.add(nodes[1]);

        StringBuilder result = new StringBuilder();
        long sum = 0;
        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            sum += cur.weight;
            result.append(sum).append('\n');

            for (int next : graph.get(cur.number)) {
                queue.add(nodes[next]);
            }
        }

        return result.toString();
    }

}

