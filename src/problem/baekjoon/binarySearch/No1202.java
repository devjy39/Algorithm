package problem.baekjoon.binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class No1202 {
    static class Gem implements Comparable<Gem> {
        int m;
        int price;

        public Gem(int m, int price) {
            this.m = m;
            this.price = price;
        }

        @Override
        public int compareTo(Gem o) {
            return o.price == this.price ? this.m - o.m : o.price - this.price;
        }
    }

    static int N, K;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        PriorityQueue<Gem> priorityQueue = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            priorityQueue.add(new Gem(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        int[] bags = new int[K];
        for (int i = 0; i < K; i++) {
            bags[i] = Integer.parseInt(br.readLine());
        }

        System.out.println(getMaxValue(priorityQueue, bags));
    }

    private static long getMaxValue(PriorityQueue<Gem> priorityQueue, int[] bags) {
        Arrays.sort(bags);
        int[] parents = new int[K + 1];
        for (int i = 1; i <= K; i++) {
            parents[i] = i;
        }

        long values = 0;
        while (!priorityQueue.isEmpty()) {
            Gem cur = priorityQueue.poll();

            if (findBag(parents, bags, cur.m)) {
                values += cur.price;
            }
        }

        return values;
    }

    private static boolean findBag(int[] parents, int[] bags, int m) {
        int idx = binarySearch(bags, m);

        if (idx < K) {
            int parent = find(parents, idx);
            if (parent < K) {
                parents[parent] = parent + 1;
                return true;
            }
        }

        return false;
    }

    private static int find(int[] parents, int node) {
        if (parents[node] == node) {
            return node;
        }

        return parents[node] = find(parents, parents[node]);
    }

    private static int binarySearch(int[] bags, int m) {
        int left = 0;
        int right = bags.length - 1;

        while (left <= right) {
            int mid = (left + right) >> 1;

            if (bags[mid] < m) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return left;
    }

}