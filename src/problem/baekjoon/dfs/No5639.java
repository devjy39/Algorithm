package problem.baekjoon.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No5639 {

    static StringBuilder result = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer[] graph = new Integer[10000];
        int top = 0;
        String read;
        while ((read = br.readLine()) != null) {
            if (read.equals(" ")) {
                break;
            }
            graph[top++] = Integer.valueOf(read);
        }
        br.close();

        order(graph, 0, top - 1);
        System.out.print(result);
    }

    static final String NEW_LINE = "\n";
    private static void order(Integer[] graph, int left, int right) {
        if (left >= right) {
            result.append(graph[right]).append(NEW_LINE);
            return;
        }

        int root = left++;
        int mid = left;
        for (; mid <= right; mid++) {
            if (graph[root] < graph[mid]) {
                break;
            }
        }

        if (left < mid) {
            order(graph, left, mid - 1);
        }
        if (mid <= right) {
            order(graph, mid, right);
        }

        result.append(graph[root]).append(NEW_LINE);
    }

}