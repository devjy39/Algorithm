package problem.baekjoon.linear;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class No1644 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        System.out.print(n == 1 ? 0 : twoPointer(getPrime(n), n));
    }

    private static List<Integer> getPrime(int n) {
        boolean[] prime = new boolean[n + 1];
        List<Integer> list = new ArrayList<>(n);

        for (int i = 2; i <= n; i++) {
            if (prime[i]) {
                continue;
            }
            list.add(i);
            for (int j = i * 2; j <= n; j += i) {
                prime[j] = true;
            }
        }

        return list;
    }

    private static int twoPointer(List<Integer> prime, int n) {
        int left = 0;
        int right = 1;
        int sum = 2;
        int count = 0;

        while (right < prime.size()) {
            if (sum < n) {
                sum += prime.get(right++);
            } else if (sum > n) {
                sum -= prime.get(left++);
            } else {
                sum += prime.get(right++) - prime.get(left++);
                count++;
            }
        }

        while (left < right) {
            if (sum > n) {
                sum -= prime.get(left++);
                continue;
            } else if (sum == n) {
                count++;
            }
            break;
        }

        return count;
    }

}