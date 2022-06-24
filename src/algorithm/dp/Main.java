package algorithm.dp;
/*  알고리즘 - 다이나믹 프로그래밍
*   한글로는 동적 계획법
*   부분 문제가 중복되는 경우 계산결과를 기록해서 재활용한다.
*   메모리는 더 들지만 속도가 빠르다.
*   그리디와의 차이는 dp는 모든 방법을 확인 후 최적해를 구한다.
*
*   타뷸레이션 : 상향식 접근 작은 하위 문제부터 풀면서 올라감 - 반복문
*   메모이제이션 : 하향식 접근 큰 문제에서 하위 문제를 확인해가며 진행 - 재귀
* */

import java.util.Arrays;

public class Main {
    //피보나치
    // 단순 재귀   O(n^2)
    public static int fib(int n)
    {
        if (n <= 1) {
            return n;
        }
        return fib(n - 1) + fib(n - 2);
    }

    // 타뷸레이션 - 반복문    O(n)
    public static int fibDP(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    // 메모이제이션 재귀 - O(n)
    static int[] dp = new int[8];
    public static int fibDP2(int n) {
        if (n < 2) {
            return n;
        }
        if (dp[n] != 0) {
            return dp[n];
        }
        return dp[n] = fibDP2(n - 1) + fibDP2(n - 2);
    }

    public static void main(String[] args) {
        // Test code
        System.out.println(fib(7));
        System.out.println(fibDP(7));
        System.out.println(fibDP2(7));
        System.out.println(Arrays.toString(dp));
    }
}
