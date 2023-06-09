package problem.baekjoon.shotestPath;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class No2660 {
    static final int MAX_DIST = 1_000_000_000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] dist = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                dist[i][j] = MAX_DIST;
            }
        }

        String read;
        while (!(read = br.readLine()).equals("-1 -1")) {
            StringTokenizer st = new StringTokenizer(read);
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            dist[a][b] = dist[b][a] = 1;
        }

        floydWarshall(dist, n);
        List<Integer> list = new ArrayList<>();
        printResult(list, getMinCloseness(n, dist, list));
    }

    private static void printResult(List<Integer> list, int minCloseness) {
        StringBuilder result = new StringBuilder();
        result.append(minCloseness).append(" ").append(list.size()).append("\n");
        for (Integer number : list) {
            result.append(number).append(" ");
        }

        System.out.println(result);
    }

    private static int getMinCloseness(int n, int[][] dist, List<Integer> list) {
        int minCloseness = MAX_DIST;

        for (int i = 1; i <= n; i++) {
            int closeness = 0;
            for (int j = 1; j <= n; j++) {
                if (dist[i][j] != MAX_DIST) {
                    closeness = Math.max(closeness, dist[i][j]);
                }
            }

            if (minCloseness > closeness) {
                minCloseness = closeness;
                list.clear();
                list.add(i);
            } else if (minCloseness == closeness) {
                list.add(i);
            }
        }
        return minCloseness;
    }

    private static void floydWarshall(int[][] dist, int n) {
        for (int via = 1; via <= n; via++) {
            for (int i = 1; i <= n; i++) {
                if (via == i) {
                    continue;
                }
                for (int j = 1; j <= n; j++) {
                    if (i != j) {
                        dist[i][j] = Math.min(dist[i][j], dist[i][via] + dist[via][j]);
                    }
                }
            }
        }

    }

}

