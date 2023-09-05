package problem.baekjoon.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class No9024 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder result = new StringBuilder();

        while (t-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            int[] arr = new int[n];
            st = new StringTokenizer(br.readLine(), " ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            result.append(getPairs(arr, k)).append("\n");
        }

        System.out.println(result);
    }

    private static int getPairs(int[] arr, int k) {
        Arrays.sort(arr);
        int minDifference = Integer.MAX_VALUE;
        int pairs = 0;

        int left = 0;
        int right = arr.length - 1;

        while (left < right) {
            int sum = arr[left] + arr[right];

            int difference = Math.abs(sum - k);
            if (difference < minDifference) {
                minDifference = difference;
                pairs = 1;
            } else if (difference == minDifference) {
                pairs++;
            }

            if (sum < k) {
                left++;
            } else {
                right--;
            }
        }

        return pairs;
    }

}

