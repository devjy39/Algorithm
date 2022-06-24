package problem.baekjoon.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main2606 {
    static ArrayList<Integer>[] edges;
    static boolean[] visited;
    static int cnt;

    static void dfs(int key) {
        visited[key] = true;
        ArrayList<Integer> edge = edges[key];
        for (int e : edge) {
            if (!visited[e]) {
                visited[e] = true;
                cnt++;
                dfs(e);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        edges = new ArrayList[n + 1];
        visited = new boolean[n + 1];
        for (int i = 0; i <= n; i++) {
            edges[i] = new ArrayList<>();
        }
        int l = Integer.parseInt(br.readLine());

        for (int i = 0; i < l; i++) {
            String str = br.readLine();
            String[] arr = str.split(" ");
            int left = Integer.parseInt(arr[0]);
            int right = Integer.parseInt(arr[1]);
            edges[left].add(right);
            edges[right].add(left);
        }
        br.close();

        visited[1] = true;
        dfs(1);
        System.out.println(cnt);
    }
}