package problem.baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class No2212 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(getMinSize(arr, n, k - 1));
    }

    private static int getMinSize(int[] arr, int n, int k) {
        Arrays.sort(arr);
        for (int i = 1; i < n; i++) {
            arr[i - 1] = arr[i] - arr[i - 1];
        }
        arr[n - 1] = 0;
        Arrays.sort(arr);

        int sum = 0;
        for (int i = 0; i < n - k; i++) {
            sum += arr[i];
        }

        return sum;
    }


}

