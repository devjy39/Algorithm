package algorithm.backtracking;
// Practice1
// 정수형 n과 m이 주어졌을 때,
// 1 부터 n 까지의 정수 중에서 중복 없이 m 개를 고른 수열을 출력하는 프로그램을 작성하세요.

// 입출력 예시
// n: 3
// m: 2
// 출력: [1, 2], [1, 3], [2, 1], [2, 3], [3, 1], [3, 2]

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Practice1 {
    static List<int[]> list;
    static boolean[] visited;

    public static void solution(int n, int m) {
        list = new ArrayList<>();
        visited = new boolean[n + 1];
        backTracking(0, n, m, new int[m]);

        System.out.println(Arrays.deepToString(list.toArray()));
    }

    public static void backTracking(int depth, int n, int m, int[] arr) {
        if (depth == m) {
            list.add(arr.clone());
            return;
        }

        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                arr[depth] = i;
                backTracking(depth + 1, n, m, arr);
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        // Test code
        solution(3, 2);
        System.out.println();
        solution(4, 3);
    }
}
