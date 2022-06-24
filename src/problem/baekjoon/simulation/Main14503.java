package problem.baekjoon.simulation;

import java.io.*;
import java.util.*;

public class Main14503 {
    static int n, m;
    static int[] robot;
    static int[][] map;
    static final int[][] dirs = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    public static void setInput() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        robot = new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),
                Integer.parseInt(st.nextToken())};
        map = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        br.close();
    }

    public static void main(String[] args) throws IOException {
        setInput();
        int cnt = 1;

        clean:
        while (map[robot[0]][robot[1]] != 1) {
            map[robot[0]][robot[1]] = 2;

            for (int i = 0; i < 4; i++) {
                robot[2] = (robot[2] + 3) % 4; //left
                int[] dir = dirs[robot[2]];
                if (map[robot[0] + dir[0]][robot[1] + dir[1]] == 0) {
                    robot[0] += dir[0];
                    robot[1] += dir[1];
                    cnt++;
                    continue clean;
                }
            }

            int back = (robot[2] + 2) % 4;
            robot[0] += dirs[back][0];
            robot[1] += dirs[back][1];
        }

        System.out.println(cnt);
    }
}