package problem.baekjoon.backTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No25795 {
    static int n,a,b,c;
    static long result;
    static final int MOD = 100_000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        maxChocolateScore(0, 0, a);
        System.out.println(result);
    }

    private static void maxChocolateScore(int white, int dark, long score) {
        if (dark + white == 2 * n) {
            result = Math.max(result, score);
            return;
        }

        if (dark < white) {
            maxChocolateScore(white, dark + 1, (score * c) % MOD);
        }
        if (white < n) {
            maxChocolateScore(white + 1, dark, (score + b) % MOD);
        }
    }

}

