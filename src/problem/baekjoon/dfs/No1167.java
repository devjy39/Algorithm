package problem.baekjoon.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class No1167 {

    static class Node {
        int d;
        int w;

        public Node(int d, int w) {
            this.d = d;
            this.w = w;
        }
    }

    static int result;
    static Map<Integer, List<Node>> graphs;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int v = Integer.parseInt(st.nextToken());
        graphs = new HashMap<>();
        visited = new boolean[v + 1];

        for (int i = 0; i < v; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            if (!graphs.containsKey(s)) {
                graphs.put(s, new ArrayList<>());
            }
            int d;
            while ((d = Integer.parseInt(st.nextToken())) != -1) {
                int w = Integer.parseInt(st.nextToken());
                graphs.get(s).add(new Node(d, w));
            }
        }
        br.close();

        System.out.println(Math.max(dfs(1, 0), result));
    }

    static boolean[] visited;

    private static int dfs(int root, int w) {
        visited[root] = true;

        List<Node> child = graphs.get(root);
        int maxChild = 0;
        int secondMaxChild = 0;

        for (Node node : child) {
            if (visited[node.d]) {
                continue;
            }

            int childWeight = dfs(node.d, node.w);
            if (childWeight > maxChild) {
                secondMaxChild = maxChild;
                maxChild = childWeight;
            } else {
                secondMaxChild = Math.max(secondMaxChild, childWeight);
            }
        }

        result = Math.max(result, maxChild + secondMaxChild); // 연결된 노드 중 가장 긴 노드 2개의 길이 합
        return maxChild + w; // 연결된 노드 중 가장 긴 노드 반환
    }

}