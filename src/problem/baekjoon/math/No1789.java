package problem.baekjoon.math;

import java.io.*;

public class No1789 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long S = Long.parseLong(br.readLine());

        long sum = 0;
        int count;
        for (count = 1; sum < S; count++) {
            sum += count;
        }

        System.out.println(sum == S ? count - 1 : count - 2);
    }

}