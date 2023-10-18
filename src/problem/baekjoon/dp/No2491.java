package problem.baekjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No2491 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int prev = Integer.parseInt(st.nextToken());

        int increase = 1;
        int decrease = 1;
        int maxCount = 1;

        for (int i = 1; i < n; i++) {
            int number = Integer.parseInt(st.nextToken());
            if (number >= prev) {
                maxCount = Math.max(maxCount, ++increase);
            } else {
                increase = 1;
            }

            if (number <= prev) {
                maxCount = Math.max(maxCount, ++decrease);
            } else {
                decrease = 1;
            }

            prev = number;
        }

        System.out.println(maxCount);

    }

}

