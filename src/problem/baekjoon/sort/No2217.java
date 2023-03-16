package problem.baekjoon.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class No2217 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        System.out.println(getMaxWeight(n, arr));
    }

    private static int getMaxWeight(int n, int[] arr) {
        Arrays.sort(arr);

        int result = 0;
        for (int length : arr) {
            result = Math.max(result, length * n--);
        }
        return result;
    }

}
