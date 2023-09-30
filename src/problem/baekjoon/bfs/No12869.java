package problem.baekjoon.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class No12869 {
    static class SCV {
        int a;
        int b;
        int c;

        public SCV() {}

        public SCV(int a, int b, int c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }

        public void set(int a, int b, int c) {
            this.a = Math.max(0, a);
            this.b = Math.max(0, b);
            this.c = Math.max(0, c);
        }

        protected SCV clone() {
            return new SCV(a, b, c);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int[] arr = new int[3];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(bfs(arr[0], arr[1], arr[2], Arrays.stream(arr).max().getAsInt() + 1));
    }

    private static int bfs(int a, int b, int c, int max) {
        Queue<SCV> queue = new LinkedList<>();
        queue.add(new SCV(a, b, c));
        int[][] cases = {{1, 3, 9}, {1, 9, 3}, {3, 1, 9}, {3, 9, 1}, {9, 3, 1}, {9, 1, 3}};
        int[][][] dp = new int[max][max][max];
        SCV scv = new SCV();

        while (!queue.isEmpty()) {
            SCV cur = queue.poll();

            scv.set(cur.a, cur.b, cur.c);

            for (int[] aCase : cases) {
                scv.set(cur.a - aCase[0], cur.b - aCase[1], cur.c - aCase[2]);
                if (dp[scv.a][scv.b][scv.c] == 0 || dp[cur.a][cur.b][cur.c] + 1 < dp[scv.a][scv.b][scv.c]) {
                    dp[scv.a][scv.b][scv.c] = dp[cur.a][cur.b][cur.c] + 1;
                    queue.add(scv.clone());
                }
            }
        }

        return dp[0][0][0];
    }

}
