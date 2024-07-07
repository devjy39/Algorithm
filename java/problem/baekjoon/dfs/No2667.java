package problem.baekjoon.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class No2667 {
    static List<Integer> answer;
    static boolean[][] visited;
    static int[][] map;
    static int[][] dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        answer = new ArrayList<>();
        map = new int[n][n];
        visited = new boolean[n][n];
        List<int[]> list = new ArrayList<>(); //방문 후보

        for (int i = 0; i < n; i++) {
            char[] charArray = br.readLine().toCharArray();
            for (int j = 0; j < n; j++) {
                int num = charArray[j] - '0';
                map[i][j] = num;
                if (num == 1) {
                    list.add(new int[]{i, j});
                }
            }
        }
        br.close();

        for (int[] ints : list) {
            if (!visited[ints[0]][ints[1]]) {
                answer.add(dfs(n, ints[0], ints[1]));
            }
        }

        Collections.sort(answer);

        StringBuilder sb = new StringBuilder();
        sb.append(answer.size()).append("\n");
        for (Integer a : answer) {
            sb.append(a).append("\n");
        }
        System.out.println(sb);
    }

    private static int dfs(int n,int x, int y) {
        int count = 1;
        visited[x][y] = true;

        for (int[] dir : dirs) {
            int moveX = x + dir[0];
            int moveY = y + dir[1];

            if (moveX < 0 || moveY < 0 || moveX >= n || moveY >= n ||
                    visited[moveX][moveY] || map[moveX][moveY] == 0) {
                continue;
            }
            count += dfs(n, moveX, moveY);
        }

        return count;
    }

}