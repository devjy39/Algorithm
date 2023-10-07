package problem.baekjoon.binarySearch;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No2792 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] colors = new int[m];
        int max = 0;
        for (int i = 0; i < m; i++) {
            max = Math.max(max, colors[i] = Integer.parseInt(br.readLine()));
        }

        System.out.println(getMinJealousy(n, colors, max));
    }

    private static int getMinJealousy(int n, int[] colors, int right) {
        int left = 1;

        while (left <= right) {
            int mid = (right + left) >> 1;

            if (isPossible(n, colors, mid)) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    private static boolean isPossible(int n, int[] colors, int amount) {
        for (int color : colors) {
            n -= (color - 1) / amount + 1;
        }

        return n >= 0;
    }

}

