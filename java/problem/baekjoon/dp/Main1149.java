package problem.baekjoon.dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

/* 모든 비용을 저장하는 dp방식
* */
public class Main1149 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arrs = new int[n+1][3];

        for (int i = 1; i <= n; i++) {
            String[] arr = br.readLine().split(" ");
            arrs[i][0] = Integer.parseInt(arr[0])+Integer.min(arrs[i-1][1],arrs[i-1][2]);
            arrs[i][1] = Integer.parseInt(arr[1])+Integer.min(arrs[i-1][0],arrs[i-1][2]);
            arrs[i][2] = Integer.parseInt(arr[2])+Integer.min(arrs[i-1][0],arrs[i-1][1]);
        }
        System.out.println(Arrays.stream(arrs[n]).min().getAsInt());
        br.close();
    }
}