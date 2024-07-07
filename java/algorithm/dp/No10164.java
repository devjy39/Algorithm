package algorithm.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No10164 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        System.out.println(getPathSum(n, m, k));
    }

    private static int getPathSum(int n, int m, int k) {
        int[][] sum = new int[n + 1][m + 1];
        sum[1][0] = 1;
        int x = k == 0 ? 1 : ((k - 1) / m) + 1;
        int y = k == 0 ? 1 : ((k % m) == 0 ? m : k % m);

        for (int i = 1; i <= x; i++) {
            for (int j = 1; j <= y; j++) {
                sum[i][j] = sum[i][j - 1] + sum[i - 1][j];
            }
        }

        for (int i = x; i <= n; i++) {
            for (int j = y; j <= m; j++) {
                sum[i][j] = sum[i][j - 1] + sum[i - 1][j];
            }
        }

        return sum[n][m];
    }

}

