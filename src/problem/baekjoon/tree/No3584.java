package problem.baekjoon.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No3584 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder result = new StringBuilder();

        for (int t = 0; t < T; t++) {
            int n = Integer.parseInt(br.readLine());

            int[] parents = new int[n + 1];
            for (int i = 1; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                int parent = Integer.parseInt(st.nextToken());
                int child = Integer.parseInt(st.nextToken());
                parents[child] = parent;
            }

            st = new StringTokenizer(br.readLine());
            int leftNode = Integer.parseInt(st.nextToken());
            int rightNode = Integer.parseInt(st.nextToken());

            result.append(findLowestCommonAnscestor(parents, leftNode, rightNode)).append("\n");
        }

        System.out.print(result);
    }

    private static int findLowestCommonAnscestor(int[] parents, int leftNode, int rightNode) {
        while (leftNode > 0) {
            int p = parents[leftNode];
            parents[leftNode] = -1;
            leftNode = p;
        }

        while (rightNode > 0) {
            if (parents[rightNode] == -1) {
                return rightNode;
            }
            rightNode = parents[rightNode];
        }

        return -1;
    }

}