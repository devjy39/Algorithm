package problem.baekjoon.simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No15684 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());
        int[][] line = new int[n + 1][h + 1];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            // b와 b+1을 a 줄에서 연결
            line[b][a] = 1;
            line[b + 1][a] = -1;
        }

        System.out.println(getMinLineCount(line));
    }

    private static int getMinLineCount(int[][] line) {
        for (int i = 0; i <= 3; i++) {
            if (dfs(line, i, 0, 1, 1)) {
                return i;
            }
        }

        return -1;
    }

    private static boolean dfs(int[][] line, int max, int depth, int x, int y) {
        if (max == depth) {
            return isPossible(line);
        }

        for (int i = x; i < line.length - 1; i++) {
            for (int j = i == x ? y : 1; j < line[i].length; j++) {
                if (line[i][j] == 0 && line[i + 1][j] == 0) {
                    line[i][j] = 1;
                    line[i + 1][j] = -1;
                    if (dfs(line, max, depth + 1, i, j + 1)) {
                        return true;
                    }
                    line[i][j] = 0;
                    line[i + 1][j] = 0;
                }
            }
        }

        return false;
    }

    private static boolean isPossible(int[][] line) {
        for (int i = 1; i < line.length; i++) {
            int cur = i;
            for (int j = 1; j < line[i].length; j++) {
                if (line[cur][j] == 1) {
                    cur++;
                } else if (line[cur][j] == -1) {
                    cur--;
                }
            }

            if (cur != i) {
                return false;
            }
        }

        return true;
    }

}

