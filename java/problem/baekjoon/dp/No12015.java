package problem.baekjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No12015 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] lis = new int[n];
        int top = -1;
        StringTokenizer st = new StringTokenizer(br.readLine());
        br.close();

        lis[++top] = Integer.parseInt(st.nextToken());

        for (int i = 1; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());

            if (lis[top] < num) {
                lis[++top] = num;
            } else {
                lis[binSearch(lis, top, num)] = num;
            }
        }

        System.out.println(top + 1);
    }

    private static int binSearch(int[] lis, int top, int num) {
        int low = 0;
        int high = top;

        while (low <= high) {
            int mid = (low + high) >> 1;

            if (num < lis[mid]) {
                high = mid - 1;
            } else if (num > lis[mid]) {
                low = mid + 1;
            } else {
                return mid;
            }
        }

        return low;
    }
}