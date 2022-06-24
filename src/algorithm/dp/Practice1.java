package algorithm.dp;
// Practice
// 정수 n 이 주어졌을 때 아래의 연산을 통해 1로 만들려고 한다.
    // 2로 나누어 떨어지면 2로 나누기
    // 3으로 나누어 떨어지면 3으로 나누기
    // 1 빼기
// 위의 연산을 통해 1로 만들 때 필요한 최소한의 연산 횟수를 출력하는 프로그램을 작성하세요.

// 입출력 예시
// n: 2
// 출력: 1

// n: 9
// 출력: 2

import java.util.Arrays;

// 타뷸레이션 상향식, n을 1부터 채워나가서 해결. 반복문
public class Practice1 {
    public static int solution(int n) {
        int[] dp = new int[n + 1];

        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + 1;
            for (int j = 2; j <= 3; j++) {
                if (i % j == 0) {
                    dp[i] = Math.min(dp[i], dp[i / j] + 1);
                }
            }
        }

        System.out.println(Arrays.toString(dp));
        return dp[n];
    }

    public static void main(String[] args) {
        // Test code
        System.out.println(solution(2));    // 1
        System.out.println(solution(4));    // 2
        System.out.println(solution(9));    // 2
        System.out.println(solution(10));   // 3
    }
}
