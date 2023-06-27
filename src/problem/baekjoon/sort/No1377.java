package problem.baekjoon.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No1377 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        int max = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, arr[i]);
        }

        System.out.println(getBubbleSortMoveCount(n, arr, max) + 1);
    }

    private static int getBubbleSortMoveCount(int n, int[] arr, int max) {
        int[] countingArray = new int[max + 1];
        for (int i = 0; i < n; i++) {
            countingArray[arr[i]]++;
        }

        int prev = 0;
        for (int i = 0; i <= max; i++) {
            int temp = countingArray[i];
            countingArray[i] = prev;
            if (temp > 0) {
                prev += temp;
            }
        }

        int move = 0;

        for (int i = 0; i < n; i++) {
            if (i > countingArray[arr[i]]) {
                move += Math.max(0, i - countingArray[arr[i]] - move);
            }
            countingArray[arr[i]]++;
        }

        return move;
    }

}

