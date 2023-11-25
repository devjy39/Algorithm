package problem.baekjoon.simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No1138 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int[] sequence = new int[n];
        for (int i = 1; i <= n; i++) {
            int a = Integer.parseInt(st.nextToken());
            int count = 0;
            while (count <= a) {
                if (sequence[count++] != 0) {
                    a++;
                }
            }
            sequence[count - 1] = i;
        }

        StringBuilder result = new StringBuilder();
        for (int i : sequence) {
            result.append(i).append(" ");
        }
        System.out.println(result);
    }

}
