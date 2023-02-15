package problem.baekjoon.dp;

import java.io.*;
import java.util.*;

public class No1208 {
    static int[] arr;
    static int maxSize;
    static int[][] sums;
    static long count;
    static int N, S;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int min = 0;
        int max = 0;
        for (int i = 0; i < N / 2; i++) {
            if (arr[i] > 0) {
                max += arr[i];
            } else {
                min += arr[i];
            }
        }
        maxSize = Math.max(max, -min);

        sums = new int[maxSize + 1][2]; // 0 : -, 1 : +
        dfs(N / 2, 0, 0);
        mapping(N, N / 2, 0);

        System.out.println(S == 0 ? count - 1 : count);
    }

    private static void mapping(int end, int idx, int sum) {
        if (idx >= end) {
            int abs = Math.abs(S - sum);
            if (abs >= -maxSize && abs <= maxSize) {
                count += sums[abs][S < sum ? 0 : 1];
            }
            return;
        }

        mapping(end, idx + 1, sum + arr[idx]);
        mapping(end, idx + 1, sum);
    }

    private static void dfs(int end, int idx, int sum) {
        if (idx >= end) {
            sums[Math.abs(sum)][sum < 0 ? 0 : 1]++;
            return;
        }

        dfs(end, idx + 1, sum + arr[idx]);
        dfs(end, idx + 1, sum);
    }

}