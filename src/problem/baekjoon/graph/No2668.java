package problem.baekjoon.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No2668 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] graph = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = Integer.parseInt(br.readLine());
        }

        boolean[] isSet = new boolean[n + 1];

        StringBuilder result = new StringBuilder();
        result.append(getSetCount(n, graph, isSet)).append("\n");
        for (int i = 1; i <= n; i++) {
            if (isSet[i]) {
                result.append(i).append("\n");
            }
        }
        System.out.print(result);
    }

    private static int getSetCount(int n, int[] graph, boolean[] isSet) {
        int[] visited = new int[n + 1];
        int sequence = 1;
        int count = 0;

        for (int i = 1; i <= n; i++) {
            if (visited[i] == 0) {

                int number = i;
                while (visited[number] == 0) {
                    visited[number] = sequence;
                    number = graph[number];
                }

                if (visited[number] != sequence++) {
                    continue;
                }

                int findNumber = number;
                do {
                    isSet[number] = true;
                    count++;
                    number = graph[number];
                }
                while (number != findNumber);

            }
        }

        return count;
    }

}

