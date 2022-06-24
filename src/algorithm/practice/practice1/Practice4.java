package algorithm.practice.practice1;

public class Practice4 {

    final static int numOfTree = 2;
    public static int solution(int[] order, int k) {
        if (order == null || order.length == 0) {
            return -1;
        }

        int n = order.length;
        int[][][] dp = new int[k + 2][numOfTree + 1][n];

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < k + 2; j++) {
                if (order[i] == 1) {    // 1번 나무 쪽에서 떨어질 때
                    dp[j][1][i] = Math.max(dp[j][1][i - 1], dp[j - 1][2][i - 1]) + 1;
                    dp[j][2][i] = Math.max(dp[j][2][i - 1], dp[j - 1][1][i - 1]);
                } else {    // 2번 나무 쪽에서 떨어질 때
                    if (i == 1 && j == 1) {
                        // 이동하지 않는 case 일 때 1 번 나무에서 시작하므로 continue
                        continue;
                    }

                    dp[j][1][i] = Math.max(dp[j][1][i - 1], dp[j - 1][2][i - 1]);
                    dp[j][2][i] = Math.max(dp[j][2][i - 1], dp[j - 1][1][i - 1]) + 1;
                }
            }
        }

//        for (int i = 0; i < k + 2; i++) {
//            System.out.println(Arrays.deepToString(dp[i]));
//        }

        int result = 0;
        for (int i = 1; i < k + 2; i++) {
            result = Math.max(result, Math.max(dp[i][1][n - 1], dp[i][2][n - 1]));
        }

        return result;
    }

    static int[] orders;
    static int[][][] dp;

    public static int solution2(int[] order, int k) {
        dp = new int[k + 1][2][order.length];
        orders = order;
        return Math.max(memoization(k, 0, order.length - 1),
                memoization(k, 1, order.length - 1));
    }

    public static int memoization(int cnt, int tree, int idx) {
        if (cnt < 0 || (cnt == 0 && tree != 0) || idx < 0) {
            return 0;
        }
        if (dp[cnt][tree][idx] != 0) {
            return dp[cnt][tree][idx];
        }

        int opp = 1 ^ tree; // tree 반대 쪽 1 -> 0, 0 -> 1

        // k-1번 바꿀 수 있고 이전 idx 상황에서 바꾼 경우와,
        // 같은 k번을 바꿀 수 있고 이전 idx 상황에서 그대로 가는 경우
        // 두 경우를 비교해서 현재 점수를 정한다. 이럴려면 0~k 별로 경우의 수를 다 고려해야 함.
        // 고로 dp로 조질 수 있다.

        if (tree == orders[idx] - 1) {
            return dp[cnt][tree][idx] = 1 + Math.max(memoization(cnt - 1, opp, idx - 1),
                    memoization(cnt, tree, idx - 1));
        }
        return dp[cnt][tree][idx] = Math.max(memoization(cnt - 1, opp, idx - 1),
                    memoization(cnt, tree, idx - 1));
    }

    public static void main(String[] args) {
        // Test code
        int[] order = new int[]{2, 1, 1, 2, 2, 1, 1,1,2,1,2,1,1,1,1,1,1,1,1,2,2,2,1,1,1,1,1,2,2,2,1,1,2,1,2,1,1,1,1,1,1,1,1,2,2,2,1,1,1,1,1,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,1,1,1,1,1,1,1,1,1,1,1,1,1,1};
        int k = 9;
        for (int i = 0; i < 10; i++) {
            solution(order, k);
        }

        long start = System.nanoTime();

        System.out.println(solution(order, k));

        long end = System.nanoTime();
        System.out.println("수행시간: " + (end - start) + " ns");

        start = System.nanoTime();
        System.out.println(solution2(order, k));
        end = System.nanoTime();
        System.out.println("수행시간: " + (end - start) + " ns");

//        for (int i = 0; i <= k; i++) {
//            System.out.println(Arrays.deepToString(dp[i]));
//        }
    }
}
