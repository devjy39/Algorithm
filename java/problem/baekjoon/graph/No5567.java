package problem.baekjoon.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No5567 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        boolean[][] map = new boolean[n + 1][n + 1];
        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            map[a][b] = true;
            map[b][a] = true;
        }

        System.out.println(getInvitePeople(n, map));
    }

    private static int getInvitePeople(int n, boolean[][] map) {
        int count = 0;
        boolean[] visited = new boolean[n + 1];

        for (int i = 2; i <= n; i++) {
            if (map[1][i]) {
                for (int j = 2; j <= n; j++) {
                    if (map[i][j] && !visited[j]) {
                        visited[j] = true;
                        count++;
                    }
                }

                if (!visited[i]) {
                    visited[i] = true;
                    count++;
                }
            }
        }

        return count;
    }

}

