package problem.baekjoon.binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No2343 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        int sum = 0;
        int max = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            sum += arr[i];
            max = Math.max(max, arr[i]);
        }

        System.out.println(getMinBlu_ray(m, arr, sum, max));
    }

    private static int getMinBlu_ray(int m, int[] arr, int sum, int max) {
        int left = max;
        int right = sum;

        while (left <= right) {
            int mid = (left + right) >> 1;

            if (isPossibleSize(arr, mid, m)) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    private static boolean isPossibleSize(int[] arr, int blu_ray, int m) {
        int size = blu_ray;

        for (int s : arr) {
            size -= s;

            if (size < 0) {
                if (--m <= 0) {
                    return false;
                }

                size = blu_ray - s;
            }
        }

        return true;
    }

}

