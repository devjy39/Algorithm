package problem.baekjoon.binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 이진탐색2805 {
    static int n, m;
    static int INF = 2_000_000_000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int[] woods = new int[n];
        int right = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            woods[i] = Integer.parseInt(st.nextToken());
            right = Math.max(right, woods[i]);
        }
        br.close();

        System.out.println(binarySearch(woods, right > m ? right - m : 0, right));
    }

    static int binarySearch(int[] woods, int left, int right) {
        while (left <= right) {
            int mid = (left + right) >> 1;

            if (getWoodLength(woods, mid) < m) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return right;
    }

    static int getWoodLength(int[] woods, int h) {
        int length = 0;

        for (int i = 0; i < n; i++) {
            if (woods[i] > h) {
                length += woods[i] - h;
                if (length > m || length < 0) {
                    return INF;
                }
            }
        }

        return length;
    }
}