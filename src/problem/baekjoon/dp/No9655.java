package problem.baekjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No9655 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        boolean[] isWin = new boolean[Math.max(4, n + 1)];
        isWin[1] = isWin[3] = true;
        for (int i = 4; i <= n; i++) {
            isWin[i] = !(isWin[i - 1] || isWin[i - 3]);
        }

        System.out.println(isWin[n] ? "SK" : "CY");
    }

}
