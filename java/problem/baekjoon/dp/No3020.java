package problem.baekjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No3020 {

    static int h;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());

        int[] up = new int[h + 1];
        int[] down = new int[h + 1];

        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                down[Integer.parseInt(br.readLine())]++;
            } else {
                up[Integer.parseInt(br.readLine())]++;
            }
        }
        br.close();

        printMinWallCount(up, down);
    }

    private static void printMinWallCount(int[] up, int[] down) {
        cumulatedSum(up, down);

        int result = Integer.MAX_VALUE;
        int count = 0;
        for (int i = 1; i <= h; i++) {
            int wall = countWall(up, down, i);
            if (wall < result) {
                result = wall;
                count = 1;
            } else if (wall == result) {
                count++;
            }
        }

        System.out.println(result + " " + count);
    }

    private static void cumulatedSum(int[] up, int[] down) {
        for (int i = 1; i <= h; i++) {
            up[i] += up[i - 1];
            down[i] += down[i - 1];
        }
    }

    private static int countWall(int[] up, int[] down, int num) {
        return up[h] - up[num - 1] + down[h] - down[h - num];
    }

}