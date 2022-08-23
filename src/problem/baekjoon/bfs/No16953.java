package problem.baekjoon.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class No16953 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        br.close();

        System.out.println(bfs(n, m));
    }

    // 1 <= x <= 1,000,000,000
    static final int MAX_ARRANGE = 100_000_000;
    private static int bfs(int num, int target) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(num);

        for (int count = 1; !queue.isEmpty(); count++) {
            Queue<Integer> next = new LinkedList<>();

            while (!queue.isEmpty()) {
                int cur = queue.poll();

                if (cur == target) {
                    return count;
                }

                int case1 = cur * 2;
                if (case1 <= target) {
                    next.add(case1);
                }

                int case2 = cur * 10 + 1; //overflow
                if (cur < MAX_ARRANGE && case2 <= target) {
                    next.add(case2);
                }
            }
            queue = next;

        }

        return -1;
    }
}