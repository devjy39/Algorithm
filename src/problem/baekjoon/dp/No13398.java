package problem.baekjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No13398 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(getMaxSequenceSum(arr));
    }

    private static int getMaxSequenceSum(int[] arr) {
        int removedSum = 0;
        int sum = 0;
        int maxSum = 0;

        boolean isAllMinus = true;
        int minusMin = Integer.MIN_VALUE;

        for (int num : arr) {
            if (num >= 0) {
                sum += num;
                removedSum += num;
                isAllMinus = false;
            } else {
                minusMin = Math.max(minusMin, num);
                removedSum = Math.max(removedSum + num, sum);
                sum = Math.max(0, sum + num);
            }
            maxSum = Math.max(maxSum, Math.max(sum, removedSum));
        }

        return isAllMinus ? minusMin : maxSum;
    }

}

