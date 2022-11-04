package problem.baekjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class No2565 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }
        br.close();
        Arrays.sort(arr, Comparator.comparingInt(x -> x[0]));

        int[] dp = new int[n + 1];
        int top = 0;

        for (int i = 0; i < n; i++) {
            int num = arr[i][1];
            if (num > dp[top]) {
                dp[++top] = num;
            } else {
                dp[binSearch(dp, top, num)] = num;
            }
        }

        System.out.println(n - top);
    }

    private static int binSearch(int[] arr, int top, int num) {
        int low = 0;
        int high = top;

        while (low <= high) {
            int mid = (low + high) >> 1;

            if (num < arr[mid]) {
                high = mid - 1;
            } else if (num > arr[mid]) {
                low = mid + 1;
            } else {
                return mid;
            }
        }

        return low;
    }

}