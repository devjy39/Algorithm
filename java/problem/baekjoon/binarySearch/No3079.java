package problem.baekjoon.binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No3079 {

    public static void main(String[] args) throws IOException {
        //System.setIn(new FileInputStream("src/data.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] times = new int[n];
        int max = 0;
        for (int i = 0; i < n; i++) {
            times[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, times[i]);
        }

        System.out.println(getShortestTime(times, n, m, max));
    }

    private static long getShortestTime(int[] times, int n, int m, int max) {
        long left = 0;
        long right = (long) m / n * max;
        long mid;

        while (left <= right) {
            mid = (left + right) >> 1;

            long count = getTime(times, mid);
            if (count < m) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return left;
    }

    private static long getTime(int[] times, long mid) {
        long count = 0;

        for (int time : times) {
            count += mid / time;
        }

        return count;
    }

}