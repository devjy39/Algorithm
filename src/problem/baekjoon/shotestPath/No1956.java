package problem.baekjoon.shotestPath;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No1956 {
    static int MAX_LENGTH = 1_000_000_000;

    public static void main(String[] args) throws IOException {
        //System.setIn(new FileInputStream("src/data.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());

        int[][] graph = new int[v + 1][v + 1];
        for (int i = 1; i <= v; i++) {
            for (int j = 1; j <= v; j++) {
                if (i != j) {
                    graph[i][j] = MAX_LENGTH;
                }
            }
        }

        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            graph[start][end] = w;
        }

        int result = getShortestCycle(v, graph);
        System.out.println(result == MAX_LENGTH ? -1 : result);
    }

    private static int getShortestCycle(int v, int[][] graph) {
        for (int via = 1; via <= v; via++) {
            for (int i = 1; i <= v; i++) {
                for (int j = 1; j <= v; j++) {
                    if (i == j) {
                        continue;
                    }
                    if (graph[i][via] == MAX_LENGTH || graph[via][j] == MAX_LENGTH) {
                        continue;
                    }
                    if (graph[i][via] + graph[via][j] < graph[i][j]) {
                        graph[i][j] = graph[i][via] + graph[via][j];
                    }
                }
            }
        }

        int result = MAX_LENGTH;
        for (int i = 1; i <= v; i++) {
            for (int j = 1; j <= v; j++) {
                if (i != j) {
                    result = Math.min(result, graph[i][j] + graph[j][i]);
                }
            }
        }
        return result;
    }
}