package problem.baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No2018 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        System.out.println(getCount(n));
    }

    private static int getCount(int n) {
        int sum = 1;
        int left = 1;
        int right = 1;
        int count = 0;

        while (left <= right) {
            if (sum < n) {
                sum += ++right;
            } else if (sum > n) {
                sum -= left++;
            } else {
                count++;
                sum += ++right;
            }
        }
        return count;
    }

}

