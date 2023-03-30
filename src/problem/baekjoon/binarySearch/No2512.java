package problem.baekjoon.binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No2512 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        int max = 0;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, arr[i] = Integer.parseInt(st.nextToken()));
        }

        int budget = Integer.parseInt(br.readLine());

        System.out.println(getMaxBudget(arr, budget, max));
    }

    private static int getMaxBudget(int[] arr, int budget, int right) {
        int left = 1;

        while (left <= right) {
            int mid = (left + right) >> 1;
            if (isPossible(arr, budget, mid)) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return right;
    }

    private static boolean isPossible(int[] arr, int budget, int mid) {
        int sum = 0;
        for (int money : arr) {
            sum += Math.min(money, mid);
        }

        return sum <= budget;
    }

}

