package problem.baekjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No27210 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int scoreOne = 0;
        int scoreTwo = 0;
        int result = 0;

        for (int i : arr) {
            if (i == 1) {
                scoreOne++;
                scoreTwo = Math.max(0, scoreTwo - 1);
            } else {
                scoreOne = Math.max(0, scoreOne - 1);
                scoreTwo++;
            }

            result = Math.max(result, Math.max(scoreOne, scoreTwo));
        }

        System.out.print(result);
    }
}