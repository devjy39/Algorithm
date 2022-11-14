package problem.baekjoon.binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class No2110 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(br.readLine());
        }
        br.close();

        Arrays.sort(array);

        int dist = Integer.MAX_VALUE;
        for (int i = 1; i < n; i++) {
            dist = Math.min(dist, array[i] - array[i - 1]);
        }

        System.out.println(findMaxDistance(array, dist, c));
    }

    private static int findMaxDistance(int[] array, int left, int c) {
        int right = array[array.length - 1] - array[0];

        while (left <= right) {
            int mid = (left + right) >> 1;
            int count = countC(array, mid, c);

            if (count >= c) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return right;
    }

    private static int countC(int[] array, int mid, int target) {
        int prev = array[0];
        int count = 1;

        for (int i = 1; i < array.length; i++) {
            if (array[i] - prev >= mid) {
                prev = array[i];
                if (++count >= target) {
                    break;
                }
            }
        }

        return count;
    }

}