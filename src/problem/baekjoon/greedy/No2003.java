package problem.baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No2003 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] sum = new int[n + 1];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 1; i <= n; i++) {
            sum[i] = Integer.parseInt(st.nextToken()) + sum[i - 1];
        }

        System.out.println(getEqualSumCount(m, sum));
    }

    private static int getEqualSumCount(int m, int[] sum) {
        int left = 0;
        int right = 1;

        int count = 0;
        while (right < sum.length) {
            if (sum[right] - sum[left] < m) {
                right++;
            } else if (sum[right] - sum[left] > m) {
                left++;
                if (left == right) {
                    right++;
                }
            } else {
                count++;
                left++;
                right++;
            }
        }
        return count;
    }

}

