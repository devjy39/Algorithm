package problem.baekjoon.linear;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No15961 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int coupon = Integer.parseInt(st.nextToken());

        int[] arr = new int[n + k - 1];
        for (int i = k - 1; i < arr.length; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        for (int i = 0; i < k - 1; i++) {
            arr[i] = arr[n + i];
        }

        System.out.println(getMaxTypeCount(arr, d, coupon, k));
    }

    private static int getMaxTypeCount(int[] arr, int d, int coupon, int k) {
        int[] count = new int[d + 1];
        count[coupon]++;

        int maxTypeCount = 0;
        int typeCount = 1;
        for (int i = 0; i < k; i++) {
            if (count[arr[i]]++ == 0) {
                typeCount++;
            }
        }
        maxTypeCount = Math.max(maxTypeCount, typeCount);

        for (int i = k; i < arr.length; i++) {
            if (--count[arr[i - k]] == 0) { // 하나 있던거면
                typeCount--;
            }

            if (count[arr[i]]++ == 0 && arr[i] != coupon) { // 쿠폰 아니고, 없던거면
                maxTypeCount = Math.max(maxTypeCount, ++typeCount);
            }
        }
        return maxTypeCount;
    }


}
