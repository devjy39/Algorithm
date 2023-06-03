package problem.baekjoon.etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class No1253 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(getGoodNumber(n, arr));
    }

    private static int getGoodNumber(int n, int[] arr) {
        Arrays.sort(arr);
        int count = 0;

        for (int i = 0; i < n; i++) {
            int left = i == 0 ? 1 : 0;
            int right = i == n - 1 ? n - 2 : n - 1;

            while (left < right) {
                int sum = arr[left] + arr[right];

                if (sum > arr[i]) {
                    right--;
                    if (right == i) {
                        right--;
                    }
                } else if (sum < arr[i]) {
                    left++;
                    if (left == i) {
                        left++;
                    }
                } else {
                    count++;
                    break;
                }
            }
        }
        return count;
    }

}

