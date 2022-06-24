package problem.baekjoon.dp;

import java.util.Scanner;

/* 모듈러 연산 특
* (a+b) % m = ((a % m) + (a % m)) % m
* (a*b) % m = ((a % m) * (b % m)) % m
* /는 불가
* 이항계수 = combination C = nCk = n-1Ck + n-1Ck-1
* */
public class 이항계수11051 {

    static int[][] memory;

    static int bino_coef(int n, int k) {
        if (k==0 || n == k)
            return memory[n][k] = 1;
        if (memory[n-1][k]==0)
            memory[n-1][k] = bino_coef(n-1,k) % 10007;
        if (memory[n-1][k-1]==0)
            memory[n-1][k-1] = bino_coef(n-1,k-1) % 10007;
        return memory[n-1][k]+memory[n-1][k-1];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(),k = sc.nextInt();
        memory = new int[n+1][k+1];

        System.out.println(bino_coef(n,k)%10007);
    }
}