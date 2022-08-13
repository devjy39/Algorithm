package problem.baekjoon.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class No1867 {
    static boolean[] visited;
    static boolean[] raw;
    static int[] col;
    static List<List<Integer>> graphs;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        raw = new boolean[n];
        col = new int[n];
        graphs = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graphs.add(new ArrayList<>());
            col[i] = -1;
        }

        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            graphs.get(Integer.parseInt(st.nextToken())-1).add(Integer.parseInt(st.nextToken())-1);
        }
        br.close();

        int answer = 0;
        for (int i = 0; i < n; i++) {
            visited = new boolean[i+1];
            if (dfs(i)) { // raw 당 col 하나씩 매칭한다.
                answer++;
            }
        }
        System.out.println(answer);
    }

    private static boolean dfs(int node) {
        if (visited[node]) {
            return false;
        }
        visited[node] = true;

        for (int idx : graphs.get(node)) {
            /*  이미 매칭된 col의 raw에서 다른 col로 변경 가능한지 탐색
            * */
            if (col[idx] == -1 || dfs(col[idx])) {
                col[idx] = node;
                return true;
            }
        }

        return false;
    }
}