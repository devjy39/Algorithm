package problem.baekjoon.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No2263 {

    static StringBuilder result;
    static int[] postOrder, postIndex, inIndex, inOrder;
    static int n;

    public static void main(String[] args) throws IOException {
        result = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer in = new StringTokenizer(br.readLine());
        StringTokenizer post = new StringTokenizer(br.readLine());
        inOrder = new int[n];
        inIndex = new int[n + 1];
        postOrder = new int[n];
        postIndex = new int[n + 1];

        for (int i = 0; i < n; i++) {
            inIndex[inOrder[i] = Integer.parseInt(in.nextToken())] = i;
            postIndex[postOrder[i] = Integer.parseInt(post.nextToken())] = i;
        }

        findPreOrder(postOrder[n - 1], 0, n - 1);

        System.out.println(result);
    }

    // 기본적으로 inOrder 기반 left,right 인덱스와 root 값
    private static void findPreOrder(int root, int left, int right) {
        if (left > right) {
            return;
        }
        result.append(root).append(" ");

        if (inIndex[root] - left > 0) { // 왼 자식 있으면
            int leftRoot = postOrder[postIndex[root] - (right - inIndex[root] + 1)]; // post 루트에서 r 자식 개수만큼 좌측
            findPreOrder(leftRoot, left, inIndex[root] - 1);
        }

        if (right - inIndex[root] > 0) { // 우 자식 있으면
            int rightRoot = postOrder[postIndex[root] - 1]; // post root 좌측
            findPreOrder(rightRoot, inIndex[root] + 1, right);
        }
    }
}