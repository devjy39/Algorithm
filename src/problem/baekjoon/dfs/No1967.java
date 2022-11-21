package problem.baekjoon.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class No1967 {

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

        for (int i = 1; i < v; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            if (!graphs.containsKey(s)) {
                graphs.put(s, new ArrayList<>());
            }
            int d = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            graphs.get(s).add(new Node(d, w));
        }
        br.close();

        System.out.println(Math.max(dfs(1, 0), result));
    }

    private static int dfs(int root, int w) {
        if (!graphs.containsKey(root)) {
            return w;
        }

        List<Node> child = graphs.get(root);
        int maxChild = 0;

        if (child.size() > 1) {
            int secondMaxChild = 0;
            for (Node node : child) {
                int childWeight = dfs(node.d, node.w);
                if (childWeight > maxChild) {
                    secondMaxChild = maxChild;
                    maxChild = childWeight;
                } else {
                    secondMaxChild = Math.max(secondMaxChild, childWeight);
                }
            }

            result = Math.max(result, maxChild + secondMaxChild);
        } else {
            maxChild = dfs(child.get(0).d, child.get(0).w);
        }

        return maxChild + w;
    }

}