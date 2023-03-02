package problem.baekjoon.simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No2567 {

    static final int MAX_SIZE = 100;
    static int[][] dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        boolean[][] papers = new boolean[MAX_SIZE + 1][MAX_SIZE + 1];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            draw(papers, x, y);
        }

        System.out.println(getCount(papers));
    }

    private static void draw(boolean[][] papers, int x, int y) {
        for (int row = 0; row < 10; row++) {
            for (int col = 0; col < 10; col++) {
                papers[x + row][y + col] = true;
            }
        }
    }

    private static int getCount(boolean[][] papers) {
        int count = 0;
        for (int i = 1; i <= MAX_SIZE; i++) {
            for (int j = 1; j <= MAX_SIZE; j++) {
                if (!papers[i][j]) {
                    continue;
                }
                for (int[] dir : dirs) {
                    int x = i + dir[0];
                    int y = j + dir[1];

                    if (!papers[x][y]) {
                        count++;
                    }
                }
            }
        }
        return count;
    }
}