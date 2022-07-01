package problem.Practice.ProblemSolving_02.src;

public class Practice1 {

    public static int solution(int[][] maps, int stairLen) {
        int n = maps.length;
        int m = maps[0].length;
        int result = 0;

        for (int[] arr : maps) {
            if (check(arr, n, stairLen)) {
                result++;
            }
        }
        for (int i = 0; i < m; i++) {
            int[] arr = new int[n];
            for (int j = 0; j < n; j++) {
                arr[j] = maps[j][i];
            }
            if (check(arr, n, stairLen)) {
                result++;
            }
        }

        return result;
    }

    static boolean check(int[] arr, int n, int stairCnt) {
        int prev = 0;
        int flatCnt = 0;
        boolean downStair = false;

        for (int i = 0; i < n; i++) {
            int cur = arr[i];
            if (prev == 0 || arr[i] == prev) { // 같음
                flatCnt++;
                if (downStair && flatCnt == stairCnt) {
                    downStair = false;
                    flatCnt = 0;
                }
            } else {
                if (Math.abs(prev - cur) > 1 || downStair) {
                    return false;
                }

                if (prev > cur) { // 내리막
                    downStair = true;
                } else { //오르막
                    if (flatCnt < stairCnt) {
                        return false;
                    }
                }

                flatCnt = 1;
            }

            prev = cur;
        }

        return !downStair;
    }

    public static void main(String[] args) {
        // Test code
        int[][] maps = {
                {2, 2, 2, 2, 2, 2},
                {2, 2, 3, 3, 3, 3},
                {2, 2, 2, 3, 2, 3},
                {2, 1, 1, 1, 1, 2},
                {2, 1, 1, 3, 3, 1},
                {2, 1, 2, 3, 3, 2}};
        System.out.println(solution(maps, 2));
        System.out.println(solution(maps, 3));
    }
}
