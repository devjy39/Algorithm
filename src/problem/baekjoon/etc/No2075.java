package problem.baekjoon.etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class No2075 {
    static class Number {
        int x;
        int y;
        int number;

        public Number(int x, int y, int number) {
            this.x = x;
            this.y = y;
            this.number = number;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(getNthNumber(n, arr));
    }

    private static int getNthNumber(int n, int[][] arr) {
        PriorityQueue<Number> pq = new PriorityQueue<>((n1, n2) -> n2.number - n1.number);

        for (int i = 0; i < n; i++) {
            pq.add(new Number(n - 1, i, arr[n - 1][i]));
        }

        while (--n > 0) {
            Number cur = pq.poll();

            if (cur.x > 0) {
                cur.x--;
                cur.number = arr[cur.x][cur.y];
                pq.add(cur);
            }
        }

        return pq.peek().number;
    }

}


