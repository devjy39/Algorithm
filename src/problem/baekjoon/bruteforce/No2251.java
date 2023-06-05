package problem.baekjoon.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class No2251 {
    static boolean[][] dp;
    static Set<Integer> result = new TreeSet<>();
    static int A, B, C;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        int max = Math.max(A, B) + 1;
        dp = new boolean[max][max];
        dfs(0, 0, C);

        StringBuilder answer = new StringBuilder();
        for (int liter : result) {
            answer.append(liter).append(" ");
        }
        System.out.println(answer);
    }

    private static void dfs(int a, int b, int c) {
        if (dp[a][b]) {
            return;
        }
        dp[a][b] = true;
        if (a == 0) {
            result.add(c);
        }

        if (a > 0) {
            int give = Math.min(a + b, B);
            dfs(a - give+b, give, c);
            give = Math.min(a + c, C);
            dfs(a - give+c, b, give);
        }

        if (b > 0) {
            int give = Math.min(b + a, A);
            dfs(give, b - give+a, c);
            give = Math.min(b + c, C);
            dfs(a, b - give+c, give);
        }

        if (c > 0) {
            int give = Math.min(c + a, A);
            dfs(give, b, c - give+a);
            give = Math.min(c + b, B);
            dfs(a, give, c - give+b);
        }
    }

}