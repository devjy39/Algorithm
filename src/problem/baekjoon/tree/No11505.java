package problem.baekjoon.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No11505 {
    static class SegmentTree {
        long[] tree;
        int[] arr;
        int root, n;
        final int MOD = 1_000_000_007;

        public SegmentTree(int n, int[] arr) {
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
                    * init(node * 2 + 1, ((start + end) >> 1) + 1, end) % MOD;
        }

        public void updateNode(int idx, int number) {
            update(root, root, n, idx, number);
        }

        private long update(int node, int start, int end, int target, long newNumber) {
            if (target < start || target > end) {
                return tree[node];
            } else if (start == end) {
                return tree[node] = newNumber;
            }

            return tree[node] = update(node * 2, start, (start + end) >> 1, target, newNumber) *
                    update(node * 2 + 1, ((start + end) >> 1) + 1, end, target, newNumber) % MOD;
        }

        public long getProduct(int left, int right) {
            return getSegmentProduct(root, root, n, left, right);
        }

        private long getSegmentProduct(int node, int start, int end, int left, int right) {
            if (right < start || left > end) {
                return 1;
            } else if (start >= left && end <= right) { //완전히 포함
                return tree[node];
            }

            return getSegmentProduct(node * 2, start, (start + end) >> 1, left, right) *
                    getSegmentProduct(node * 2 + 1, ((start + end) >> 1) + 1, end, left, right) % MOD;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] arr = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        SegmentTree tree = new SegmentTree(N, arr);
        tree.init(1, 1, N);

        StringBuilder result = new StringBuilder();
        for (int i = M + K; i > 0; i--) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if (a == 1) { // 수 변경
                tree.updateNode(b, Integer.parseInt(st.nextToken()));
            } else { // 범위 합
                result.append(tree.getProduct(b, Integer.parseInt(st.nextToken()))).append("\n");
            }
        }

        System.out.print(result);
    }

}