package problem.baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class No1041 {
    static final int DICE_SIZE = 6;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] dice = new int[6];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 6; i++) {
            dice[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(getSumDiceNumber(dice, n));
    }

    private static long getSumDiceNumber(int[] dice, int n) {
        long sum = 0;
        if (n == 1) {
            int max = 0;
            for (int d : dice) {
                sum += d;
                max = Math.max(max, d);
            }
            return sum - max;
        }

        int[] dicePair = new int[3];
        for (int i = 0; i < 3; i++) {
            dicePair[i] = Math.min(dice[i], dice[DICE_SIZE - 1 - i]);
        }
        Arrays.sort(dicePair);
        dicePair[2] += dicePair[1] += dicePair[0];

        long threeCount = 4L;  // 3면
        long twoCount = 8L * n - 12; // 2면
        long oneCount = (n - 2) * (5L * n - 6); // 1면

        return oneCount * dicePair[0] + twoCount * dicePair[1] + threeCount * dicePair[2];
    }

}

