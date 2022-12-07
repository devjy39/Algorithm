package problem.baekjoon.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class No2473 {

    static long result;
    static int[] resultIdx;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        result = Long.MAX_VALUE;
        resultIdx = new int[3];

        for (int i = 0; i < n; i++) {
            twoPointer(arr, arr[i], i);
        }

        Arrays.sort(resultIdx);
        System.out.printf("%d %d %d", resultIdx[0], resultIdx[1], resultIdx[2]);
    }

    private static void twoPointer(int[] arr, int value, int idx) {
        int left = 0;
        int right = arr.length - 1;

        while (left < right) {
            long sum = arr[left] + arr[right];

            if (left != idx && right != idx) {
                if (Math.abs(result) > Math.abs(sum + value)) {
                    result = sum + value;
                    resultIdx[0] = arr[left];
                    resultIdx[1] = arr[right];
                    resultIdx[2] = value;
                }
            }

            if (sum < -value) {
                left++;
            } else {
                right--;
            }
        }
    }

}