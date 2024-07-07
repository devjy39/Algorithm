package problem.baekjoon.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No1976 {
    static int[] parents;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        parents = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            parents[i] = i;
        }

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 1; j <= n; j++) {
                int e = Integer.parseInt(st.nextToken());
                if (j <= i) { // 양방향 그래프
                    continue;
                }
                if (e == 1) {
                    union(i, j);
                }
            }
        }

        System.out.println(getNavigability(new StringTokenizer(br.readLine()), m));
    }

    private static String getNavigability(StringTokenizer st, int m) {
        int commonParent = find(Integer.parseInt(st.nextToken()));

        for (int i = 1; i < m; i++) {
            if (find(Integer.parseInt(st.nextToken())) != commonParent) {
                return "NO";
            }
        }

        return "YES";
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