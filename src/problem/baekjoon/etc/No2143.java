package problem.baekjoon.etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class No2143 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int target = Integer.parseInt(br.readLine());
        int[] arr1 = getInputArray(br);
        int[] arr2 = getInputArray(br);

        System.out.println(getTargetSumCount(target, arr1, arr2));
    }

    private static int[] getInputArray(BufferedReader br) throws IOException {
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        return arr;
    }

    private static long getTargetSumCount(int target, int[] arr1, int[] arr2) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr1.length; i++) {
            int sum = 0;
            for (int j = i; j < arr1.length; j++) {
                sum += arr1[j];
                map.put(sum, map.getOrDefault(sum, 0) + 1);
            }
        }

        long count = 0;
        for (int i = 0; i < arr2.length; i++) {
            int sum = 0;
            for (int j = i; j < arr2.length; j++) {
                sum += arr2[j];
                count += map.getOrDefault(target - sum, 0);
            }
        }
        return count;
    }

}

