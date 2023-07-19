package problem.baekjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No9656 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        boolean[] p1IsWin = new boolean[Math.max(3, n + 1)];
        p1IsWin[0] = p1IsWin[2] = true;

        for (int i = 3; i <= n; i++) {
            p1IsWin[i] = !p1IsWin[i - 1] || !p1IsWin[i - 3];
        }

        System.out.println(p1IsWin[n] ? "SK" : "CY");
    }

}

