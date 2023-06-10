package problem.baekjoon.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class No2230 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        System.out.println(getDifference(arr, n, m));
    }

    private static int getDifference(int[] arr, int n, int m) {
        if (m == 0) {
            return 0;
        }
        Arrays.sort(arr);
        int left = 0;
        int right = 1;
        int difference = Integer.MAX_VALUE;

        while (right < n) {
            if (arr[right] - arr[left] >= m) {
                difference = Math.min(difference, arr[right] - arr[left]);
                left++;
            } else {
                right++;
            }
        }

        return difference;
    }

}

