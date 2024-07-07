package problem.baekjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No2618 {

    static int[][] points;
    static int w;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        //System.setIn(new FileInputStream("src/data.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        w = Integer.parseInt(br.readLine());

        points = new int[w + 2][2];
        points[w][0] = 1;
        points[w][1] = 1;
        points[w + 1][0] = n;
        points[w + 1][1] = n; // 간편하게 접근하기 위해 시작좌표를 저장

        StringTokenizer st;
        for (int i = 0; i < w; i++) {
            st = new StringTokenizer(br.readLine());
            points[i] = new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
        }
        dp = new int[w + 1][w + 2];

        System.out.print(getResult());
    }

    private static StringBuilder getResult() {
        StringBuilder result = new StringBuilder();
        result.append(getMinPath(0, w, w + 1)).append("\n");

        int p1 = w;
        int p2 = w + 1;

        for (int i = 0; i < w; i++) { // getMinPath 에서 했던 과정을 구한 dp값과 함께 그대로 재연
            if (dist(p1, i) + dp[i][p2] < dist(p2, i) + dp[p1][i]) {
                result.append(1).append("\n");
                p1 = i;
            } else {
                result.append(2).append("\n");
                p2 = i;
            }
        }

        return result;
    }

    private static int getMinPath(int idx, int a, int b) { // a차의 좌표번호, b차의 좌표번호, idx = 사건번호
        if (idx >= w) {
            return 0;
        }
        if (dp[a][b] > 0) {
            return dp[a][b];
        }

        return dp[a][b] = Math.min(dist(a, idx) + getMinPath(idx + 1, idx, b), dist(b, idx) + getMinPath(idx + 1, a, idx));
    }// a가 해결하거나 b가 해결하거나

    private static int dist(int p1, int p2) {
        return Math.abs(points[p1][0] - points[p2][0]) + Math.abs(points[p1][1] - points[p2][1]);
    }

}