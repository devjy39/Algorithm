package problem.baekjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No11660 {
    static int[][] cumulativeSum;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder result = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        cumulativeSum = new int[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            int sum = 0;

            for (int j = 1; j <= n; j++) {
                sum += getPoint(st);
                cumulativeSum[i][j] = sum + cumulativeSum[i - 1][j];
            }
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            findCumulativeSum(getPoint(st), getPoint(st), getPoint(st), getPoint(st), result);
        }
        br.close();

        System.out.println(result);
    }

    private static int getPoint(StringTokenizer st) {
        return Integer.parseInt(st.nextToken());
    }
    private static void findCumulativeSum(int x1, int y1, int x2, int y2, StringBuilder result) {
        int sum = cumulativeSum[x2][y2]
                    - cumulativeSum[x1 - 1][y2]
                    - cumulativeSum[x2][y1 - 1]
                    + cumulativeSum[x1 - 1][y1 - 1];

        result.append(sum).append("\n");
    }

}