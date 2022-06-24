package problem.baekjoon.dp;

import java.util.Scanner;

public class Main1904 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int ans = 1, pre = 1;
        int temp;
        for (int i = 1; i < n; i++) {
            temp = ans;
            ans = (ans+pre)%15746;
            pre = temp;
        }

        System.out.println(ans);
        sc.close();
    }
}