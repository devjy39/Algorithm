package problem.baekjoon.binarySearch;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class No1300 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());

        System.out.println(binarySearch(n, k));
    }

    private static int binarySearch(int n, int k) {
        int left = 1;
        int right = k; // 무조건 n * n 보다 작음

        while (left < right) {
            int mid = (left + right) >> 1;
            int count = calCount(n, mid);

            if (count < k) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }

    private static int calCount(int n, int value) {
        int seqCount = 0;

        for (int i = n; i > 0; i--) {
            int div = value / i;
            if (n < div) { // 최적화
                seqCount += n * i;
                break;
            } else {
                seqCount += div;
            }
        }

        return seqCount;
    }

}