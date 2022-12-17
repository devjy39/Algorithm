package problem.baekjoon.linear;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No1806 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int target = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        System.out.print(twoPointerSearch(arr, target));
    }

    private static int twoPointerSearch(int[] arr, int target) {
        int minCount = Integer.MAX_VALUE;

        int left = 0;
        int right = 1;
        int sum = arr[0];

        while (right < arr.length) {
            if (sum < target) {
                sum += arr[right++];
            } else {
                minCount = Math.min(minCount, right - left);
                sum -= arr[left++];
            }
        }

        while (sum >= target && left < arr.length) {
            minCount = Math.min(minCount, right - left);
            sum -= arr[left++];
        }

        return minCount == Integer.MAX_VALUE ? 0 : minCount;
    }

}