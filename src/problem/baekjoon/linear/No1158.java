package problem.baekjoon.linear;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class No1158 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        System.out.println(getJosephusPermutation(n, k));
    }

    private static StringBuilder getJosephusPermutation(int n, int k) {
        Deque<Integer> deque = new ArrayDeque<>(n + 1);
        for (int i = 1; i <= n; i++) {
            deque.addLast(i);
        }

        StringBuilder result = new StringBuilder();
        result.append("<");

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j < k; j++) {
                deque.addLast(deque.pollFirst());
            }

            result.append(deque.pollFirst());
            if (i < n) {
                result.append(", ");
            }
        }
        result.append(">");
        return result;
    }

}
