package problem.baekjoon.divide_conquer;

import java.util.Scanner;

// int = - 31bit ~ + 31bit -1
// long = - 63bit ~ + 63bit -1
public class Main1629 {
    static int mod;

    static long divideCon(int a, int b) {
        if(b==0)
            return 1;

        if (b % 2 == 0) {
            long d = divideCon(a, b / 2);
            return (d%mod * d%mod) % mod;
        } else {
            long d = divideCon(a, (b-1) / 2);
            return (d%mod * d%mod * (a%mod)) % mod;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt(),b = sc.nextInt();
        mod = sc.nextInt();
        System.out.println(divideCon(a,b));
        sc.close();
    }
}