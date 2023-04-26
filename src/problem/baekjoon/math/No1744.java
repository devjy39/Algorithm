package problem.baekjoon.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class No1744 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        System.out.println(getMaxSum(arr));
    }

    private static int getMaxSum(int[] arr) {
        if (arr.length == 1) {
            return arr[0];
        }
        Arrays.sort(arr);
        int sum = 0;
        int right = -1;

        for (int i = arr.length - 2; i >= 0; i -= 2) { // 1보다 큰 수 처리
            if (arr[i] > 1) {
                sum += arr[i] * arr[i + 1];
                right = i - 1;
            } else {
                if (arr[i + 1] > 1) {
                    sum += arr[i + 1];
                    right = i;
                } else {
                    right = i + 1;
                }
                break;
            }
        }

        for (int r = right; r >= 0; r--) { // 1 처리
            if (arr[r] == 1) {
                sum++;
                right--;
            } else {
                break;
            }
        }

        int left = -1;
        for (int i = 1; i <= right; i += 2) { // 음수 처리
            sum += arr[i] * arr[i - 1];
            left = i;
        }

        if (left != right) { // 음수와 양수 사이 남는 수 처리
            sum += arr[right];
        }

        return sum;
    }

}

