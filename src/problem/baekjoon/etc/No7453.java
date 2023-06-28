package problem.baekjoon.etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class No7453 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[4][n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < arr.length; j++) {
                arr[j][i] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(get4SumZeroCount(n, arr));
    }

    private static long get4SumZeroCount(int n, int[][] arr) {
        int[] arr1 = new int[n * n];
        int[] arr2 = new int[n * n];

        int top = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr1[top] = arr[0][i] + arr[1][j];
                arr2[top] = arr[2][i] + arr[3][j];
                top++;
            }
        }

        Arrays.sort(arr1);
        Arrays.sort(arr2);

        return twoPointer(arr1, arr2);
    }

    private static long twoPointer(int[] arr1, int[] arr2) {
        long count = 0;
        int left = 0;
        int right = arr2.length - 1;

        while (left < arr1.length && right >= 0) {
            int sum = arr1[left] + arr2[right];
            if (sum < 0) {
                left++;
            } else if (sum > 0) {
                right--;
            } else {

                int idx = left;
                int leftEquals = 1;
                int rightEquals = 1;
                while (++left < arr1.length) {
                    if (arr1[left] == arr1[idx]) {
                        leftEquals++;
                    } else {
                        break;
                    }
                }

                idx = right;
                while (--right >= 0) {
                    if (arr2[right] == arr2[idx]) {
                        rightEquals++;
                    } else {
                        break;
                    }
                }

                count += (long) leftEquals * rightEquals;
            }
        }
        return count;
    }

}

