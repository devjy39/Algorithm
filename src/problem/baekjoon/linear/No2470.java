package problem.baekjoon.linear;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class No2470 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<Integer> list = new ArrayList<>(n);

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            list.add(Integer.parseInt(st.nextToken()));
        }

        System.out.println(getSolutions(list));
    }

    private static String getSolutions(List<Integer> list) {
        Collections.sort(list);
        int[] result = new int[2];
        int left = 0;
        int right = list.size() - 1;
        int max = Integer.MAX_VALUE;

        while (left < right) {
            int sum = list.get(left) + list.get(right);
            if (Math.abs(sum) < max) {
                max = Math.abs(sum);
                result[0] = left;
                result[1] = right;
            }

            if (sum > 0) {
                right--;
            } else if (sum < 0) {
                left++;
            } else {
                break;
            }
        }

        return list.get(result[0]) + " " + list.get(result[1]);
    }

}