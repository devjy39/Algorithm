package problem.baekjoon.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No1027 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int maxCount = 0;
        for (int i = 0; i < n; i++) {
            maxCount = Math.max(maxCount, getCount(arr, i));
        }

        System.out.println(maxCount);
    }

    private static int getCount(int[] arr, int cur) {
        int count = 0;

        double gradient = Double.MAX_VALUE;

        for (int i = cur - 1; i >= 0; i--) {
            double g = (double) (arr[cur] - arr[i]) / (cur - i);

            if (g < gradient) {
                count++;
                gradient = g;
            }
        }

        gradient = -Double.MAX_VALUE;

        for (int i = cur + 1; i < arr.length; i++) {
            double g = (double) (arr[i] - arr[cur]) / (i - cur);

            if (g > gradient) {
                count++;
                gradient = g;
            }
        }

        return count;
    }

}

