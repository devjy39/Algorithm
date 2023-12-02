package problem.baekjoon.etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No9625 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        printBABBA(n, 1, 0);
    }

    private static void printBABBA(int n, int a, int b) {
        if (n <= 0) {
            System.out.println(a + " " + b);
            return;
        }

        printBABBA(n - 1, b, b + a);
    }

}

