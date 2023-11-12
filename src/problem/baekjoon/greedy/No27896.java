package problem.baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class No27896 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine(), " ");
        int[] scores = new int[n];
        for (int i = 0; i < n; i++) {
            scores[i] = Integer.parseInt(st.nextToken());
        }


        System.out.println(getMinCount(scores, m));
    }

    private static int getMinCount(int[] scores, int m) {
        int count = 0;
        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());

        int sum = 0;
        for (int score : scores) {
            queue.add(score);
            sum += score;

            if (sum >= m) {
                int cur = queue.poll();
                sum -= cur * 2;
                count++;
            }
        }

        return count;
    }

}

