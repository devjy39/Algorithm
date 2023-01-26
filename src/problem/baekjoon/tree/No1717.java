package problem.baekjoon.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No1717 {
    static int[] parents;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        StringBuilder result = new StringBuilder();
        parents = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            parents[i] = i;
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int op = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if (op == 0) { // 합
                union(a, b);
            } else { // check
                result.append(find(a) == find(b) ? "YES" : "NO").append("\n");
            }
        }

        System.out.print(result);
    }

    private static void union(int a, int b) {
        a = find(a);
        b = find(b);

        parents[a] = b;
    }

    private static int find(int n) {
        if (n == parents[n]) {
            return n;
        }

        return parents[n] = find(parents[n]);
    }

}