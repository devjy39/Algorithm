package problem.baekjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No1509 {
    static int[] bests;
    static int[] odd, even;
    static char[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        arr = br.readLine().toCharArray();
        int N = arr.length;
        odd = new int[N]; // 가운데 일 때 최대 펠린 개수
        even = new int[N]; // 가운데 왼쪽 일 때 최대 펠린 개수
        bests = new int[N]; // 인덱까지 팰린 최소 개수

        System.out.println(dfs(N - 1));
    }

    private static int dfs(int idx) {
        if (idx < 0) {
            return 0;
        } else if (bests[idx] > 0) {
            return bests[idx];
        }

        int count = dfs(idx - 1) + 1;
        for (int i = 0; i < idx; i++) {
            if (arr[i] == arr[idx] && isPalindrome(i, idx)) {
                count = Math.min(count, dfs(i - 1) + 1);
            }
        }

        return bests[idx] = count;
    }

    private static boolean isPalindrome(int left, int right) {
        int idx = (left + right) >> 1;
        if ((right - left + 1) % 2 == 0) { //even
            if (even[idx] != 0) {
                return right - left + 1 <= even[idx];
            }
            caching(idx, idx + 1, even, idx);
            if (even[idx] > 1) even[idx]--;
        } else {
            if (odd[idx] != 0) {
                return right - left + 1 <= odd[idx];
            }
            caching(idx - 1, idx + 1, odd, idx);
        }

        return isPalindrome(left, right);
    }

    private static void caching(int left, int right, int[] table, int idx) {
        table[idx] = 1;
        while (left >= 0 && right < arr.length) {
            if (arr[left--] == arr[right++]) {
                table[idx] += 2;
            } else {
                break;
            }
        }
    }

}