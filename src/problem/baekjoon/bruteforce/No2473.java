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
            if (result == 0) {
                break;
            }
        }

        Arrays.sort(resultIdx);
        System.out.printf("%d %d %d", resultIdx[0], resultIdx[1], resultIdx[2]);
    }

    private static void twoPointer(int[] arr, int value, int idx) {
        int left = idx + 1;
        int right = arr.length - 1;
        int reverseValue = -value;
        long twoSum;

        while (left < right) {
            twoSum = arr[left] + arr[right];

            long absSum = Math.abs(twoSum + value);
            if (absSum < result) {
                result = absSum;
                resultIdx[0] = arr[left];
                resultIdx[1] = arr[right];
                resultIdx[2] = value;
            }

            if (twoSum < reverseValue) {
                left++;
            } else {
                right--;
            }
        }
    }

}