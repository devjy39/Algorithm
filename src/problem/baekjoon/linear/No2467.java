package problem.baekjoon.linear;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No2467 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[t];
        for (int i = 0; i < t; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        findMinDifferent(arr);
    }

    private static void findMinDifferent(int[] arr) {
        int left = 0;
        int right = arr.length - 1;

        int diff = Integer.MAX_VALUE;
        int[] result = new int[2];

        while (left < right) {
            int abs = Math.abs(arr[left] + arr[right]);
            if (abs < diff) {
                diff = abs;
                result[0] = arr[left];
                result[1] = arr[right];
            }

            if (Math.abs(arr[left]) < arr[right]) {
                right--;
            } else {
                left++;
            }
        }

        System.out.printf("%d %d", result[0], result[1]);
    }


}