package problem.baekjoon.backTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class No25195 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        List<List<Integer>> graph = new ArrayList<>(n + 1);
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph.get(a).add(b);
        }

        int s = Integer.parseInt(br.readLine());
        boolean[] fan = new boolean[n + 1];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < s; i++) {
            fan[Integer.parseInt(st.nextToken())] = true;
        }

        System.out.println(findPath(graph, fan) ? "yes" : "Yes");
    }

    private static boolean findPath(List<List<Integer>> graph, boolean[] fan) {
        Queue<Integer> queue = new LinkedList<>();
        if (!fan[1]) {
            queue.add(1);
        }

        while (!queue.isEmpty()) {
            int cur = queue.poll();

            if (graph.get(cur).isEmpty()) {
                return true;
            }

            for (Integer next : graph.get(cur)) {
                if (!fan[next]) {
                    queue.add(next);
                }
            }
        }

        return false;
    }

}
