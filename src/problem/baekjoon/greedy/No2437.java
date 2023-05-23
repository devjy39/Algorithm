package problem.baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class No2437 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] weights = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            weights[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(getUnmeasurableWeight(weights));
    }

    private static int getUnmeasurableWeight(int[] weights) {
        Arrays.sort(weights);
        int maxNumber = 0;

        for (int weight : weights) {
            if (maxNumber < weight - 1) {
                return maxNumber + 1;
            }
            maxNumber += weight;
        }

        return maxNumber + 1;
    }

}
