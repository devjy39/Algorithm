package problem.baekjoon.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No2357 {
    static class SegmentTree {
        int[] maxTree;
        int[] minTree;
        int[] arr;
        int root, n;

        public SegmentTree(int n, int[] arr) {
            int h = (int) Math.ceil(Math.log(n) / Math.log(2));
            this.maxTree = new int[1 << (h + 1)];
            this.minTree = new int[1 << (h + 1)];
            this.arr = arr;
            this.n = n;
            this.root = 1;
        }

        public void init(int node, int start, int end) {
            minTreeInit(node, start, end);
            maxTreeInit(node, start, end);
        }

        private int minTreeInit(int node, int start, int end) {
            if (start == end) {
                return minTree[node] = arr[start];
            }

            return minTree[node] = Math.min(minTreeInit(node * 2, start, (start + end) >> 1),
                    minTreeInit(node * 2 + 1, ((start + end) >> 1) + 1, end));
        }

        private int maxTreeInit(int node, int start, int end) {
            if (start == end) {
                return maxTree[node] = arr[start];
            }

            return maxTree[node] = Math.max(maxTreeInit(node * 2, start, (start + end) >> 1),
                    maxTreeInit(node * 2 + 1, ((start + end) >> 1) + 1, end));
        }

        public int getMinValue(int left, int right) {
            return getMinValue(root, root, n, left, right);
        }

        private int getMinValue(int node, int start, int end, int left, int right) {
            if (right < start || left > end) {
                return Integer.MAX_VALUE;
            } else if (start >= left && end <= right) { //완전히 포함
                return minTree[node];
            }

            return Math.min(getMinValue(node * 2, start, (start + end) >> 1, left, right),
                    getMinValue(node * 2 + 1, ((start + end) >> 1) + 1, end, left, right));
        }

        public int getMaxValue(int left, int right) {
            return getMaxValue(root, root, n, left, right);
        }

        private int getMaxValue(int node, int start, int end, int left, int right) {
            if (right < start || left > end) {
                return 0;
            } else if (start >= left && end <= right) { //완전히 포함
                return maxTree[node];
            }

            return Math.max(getMaxValue(node * 2, start, (start + end) >> 1, left, right),
                    getMaxValue(node * 2 + 1, ((start + end) >> 1) + 1, end, left, right));
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] arr = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        SegmentTree tree = new SegmentTree(N, arr);
        tree.init(1, 1, N);

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int left = Integer.parseInt(st.nextToken());
            int right = Integer.parseInt(st.nextToken());

            result.append(tree.getMinValue(left, right)).append(" ").append(tree.getMaxValue(left, right)).append("\n");
        }

        System.out.print(result);
    }

}