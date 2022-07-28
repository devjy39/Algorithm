package problem.baekjoon.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class No11286 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>(
                (x, y) -> x == -y ? x - y : Math.abs(x) - Math.abs(y));
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            int x = Integer.parseInt(br.readLine());
            if (x == 0) {
                sb.append(pq.isEmpty() ? 0 : pq.poll()).append("\n");
            } else {
                pq.add(x);
            }
        }
        br.close();

        System.out.println(sb);
    }
}