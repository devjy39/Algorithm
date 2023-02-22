package problem.baekjoon.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No2042 {
    static class SegmentTree {
        long[] tree;
        long[] arr;
        int root, n;

        public SegmentTree(int n, long[] arr) {
            int h = (int) Math.ceil(Math.log(n) / Math.log(2));
            this.tree = new long[1 << (h + 1)];
            this.arr = arr;
            this.n = n;
            this.root = 1;
        }

        public long init(int node, int start, int end) {
            if (start == end) {
                return tree[node] = arr[start];
            }

            return tree[node] = init(node * 2, start, (start + end) >> 1)
                    + init(node * 2 + 1, ((start + end) >> 1) + 1, end);
        }

        public void updateNode(int idx, long number) {
            update(root, root, n, idx, number - arr[idx]);
            arr[idx] = number;
        }
        private void update(int node, int start, int end, int target, long delta) {
            if (target < start || target > end) {
                return;
            }

            tree[node] += delta;
            if (start == end){
                return;
            }

            update(node * 2, start, (start + end) >> 1, target, delta);
            update(node * 2 + 1, ((start + end) >> 1) + 1, end, target, delta);
        }

        public long getSum(int left, int right) {
            return getSegmentSum(root, root, n, left, right);
        }

        private long getSegmentSum(int node, int start, int end, int left, int right) {
            if (right < start || left > end) {
                return 0;
            }

            if (start >= left && end <= right) { //완전히 포함
                return tree[node];
            }

            return getSegmentSum(node * 2, start, (start + end) >> 1, left, right) +
                    getSegmentSum(node * 2 + 1, ((start + end) >> 1) + 1, end, left, right);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        long[] arr = new long[N + 1];
        for (int i = 1; i <= N; i++) {
            arr[i] = Long.parseLong(br.readLine());
        }

        SegmentTree tree = new SegmentTree(N, arr);
        tree.init(1, 1, N);

        StringBuilder result = new StringBuilder();
        for (int i = M + K; i > 0; i--) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if (a == 1) { // 수 변경
                tree.updateNode(b, Long.parseLong(st.nextToken()));
            } else { // 범위 합
                result.append(tree.getSum(b, Integer.parseInt(st.nextToken()))).append("\n");
            }
        }

        System.out.print(result);
    }

}