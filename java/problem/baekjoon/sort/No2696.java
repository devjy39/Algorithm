package problem.baekjoon.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class No2696 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder result = new StringBuilder();

        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            result.append((n + 1) / 2).append("\n");

            int[] arr = new int[n];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                if (i > 0 && i % 10 == 0) {
                    st = new StringTokenizer(br.readLine());
                }
                arr[i] = Integer.parseInt(st.nextToken());
            }

            addCenterValue(n, arr, result);
            result.append("\n");
        }

        System.out.print(result);
    }

    private static void addCenterValue(int n, int[] arr, StringBuilder result) {
        PriorityQueue<Integer> maxQueue = new PriorityQueue<>(Comparator.reverseOrder());
        PriorityQueue<Integer> minQueue = new PriorityQueue<>();
        int count = 0;

        for (int i = 0; i < n; i++) {
            if (maxQueue.isEmpty() || arr[i] > maxQueue.peek()) {
                minQueue.add(arr[i]);
                if (minQueue.size() >= maxQueue.size()) {
                    maxQueue.add(minQueue.poll());
                }
            } else {
                maxQueue.add(arr[i]);
                if (minQueue.size() + 1 < maxQueue.size()) {
                    minQueue.add(maxQueue.poll());
                }
            }

            if (i % 2 == 0) {
                result.append(maxQueue.peek()).append(" ");
                if (++count % 10 == 0) {
                    result.append("\n");
                }
            }
        }
    }

}

