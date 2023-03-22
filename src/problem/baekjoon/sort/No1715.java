package problem.baekjoon.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class No1715 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            pq.add(Integer.parseInt(br.readLine()));
        }

        System.out.println(getTotalSum(pq));
    }

    private static long getTotalSum(PriorityQueue<Integer> pq) {
        long totalSum = 0;

        while (pq.size() > 1) {
            int sum = pq.poll() + pq.poll();
            totalSum += sum;
            pq.add(sum);
        }

        return totalSum;
    }

}
