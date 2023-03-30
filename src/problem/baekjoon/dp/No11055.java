package problem.baekjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No11055 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(getIncreaseSeqMaxSum(n, arr));
    }

    private static int getIncreaseSeqMaxSum(int n, int[] arr) {
        int[] sum = new int[n];
        int maxSum = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i]) {
                    sum[i] = Math.max(sum[i], sum[j] + arr[i]);
                }
            }
            if (sum[i] == 0) {
                sum[i] = arr[i];
            }

            maxSum = Math.max(maxSum, sum[i]);
        }

        return maxSum;
    }

}

