package problem.baekjoon.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class No1005 {

    static class Node {
        int number;
        int time;
        int inputs;
        List<Integer> outputs;

        public Node(int number, int time) {
            this.number = number;
            this.time = time;
            this.outputs = new ArrayList<>();
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < t; i++) {
            result.append(searchTarget(getNodeGraph(br), Integer.parseInt(br.readLine())))
                    .append('\n');
        }

        System.out.print(result);
    }

    private static Node[] getNodeGraph(BufferedReader br) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());

        Node[] nodes = new Node[n + 1];
        for (int j = 1; j <= n; j++) {
            nodes[j] = new Node(j, Integer.parseInt(st.nextToken()));
        }

        for (int j = 0; j < k; j++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            nodes[a].outputs.add(b);
            nodes[b].inputs++;
        }
        return nodes;
    }

    private static int searchTarget(Node[] nodes, int target) {
        int accTime = 0;
        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(n -> n.time));
        for (int i = 1; i < nodes.length; i++) {
            if (nodes[i].inputs == 0) {
                pq.add(nodes[i]);
            }
        }

        while (!pq.isEmpty()) {
            int spendTime = pq.peek().time - accTime;
            accTime += spendTime;

            while (pq.peek().time <= accTime) {
                Node node = pq.poll();
                if (node.number == target) {
                    return accTime;
                }

                for (int outNode : node.outputs) {
                    if (--nodes[outNode].inputs == 0) {
                        nodes[outNode].time += accTime;
                        pq.add(nodes[outNode]);
                    }
                }
            }
        }

        return -1;
    }

}