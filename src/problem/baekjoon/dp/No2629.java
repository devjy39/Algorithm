package problem.baekjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No2629 {
    static final int MAX_WEIGHT = 500;
    static int MAX;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        MAX = n * MAX_WEIGHT; // dp의 max value 최적화
        StringTokenizer st = new StringTokenizer(br.readLine());
        boolean[] prev = new boolean[MAX + 1];
        boolean[] cur = new boolean[MAX + 1];
        boolean[] temp;

        for (int i = 0; i < n; i++) {
            checkAllCount(prev, cur, Integer.parseInt(st.nextToken()));

            temp = prev;
            prev = cur;
            cur = temp;
        }

        System.out.print(getResult(br, prev));
    }

    // 모든 파생될 수 있는 숫자 조합 체크
    private static void checkAllCount(boolean[] prev, boolean[] cur, int num) {
        cur[num] = true;

        for (int j = 0; j <= MAX; j++) {
            if (prev[j]) {
                cur[j >= num ? j - num : num - j] = cur[j + num] = cur[j] = true;
            }
        }
    }

    private static StringBuilder getResult(BufferedReader br, boolean[] prev) throws IOException {
        int t = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < t; i++) {
            int num = Integer.parseInt(st.nextToken());
            result.append(num <= MAX && prev[num] ? "Y " : "N ");
        }
        return result;
    }

}