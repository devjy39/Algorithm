package problem.baekjoon.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No1016 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long min = Long.parseLong(st.nextToken());
        long max = Long.parseLong(st.nextToken());

        System.out.println(getSquareCount(min, max));
    }

    private static int getSquareCount(long min, long max) {
        boolean[] isSquares = new boolean[(int) (max - min + 1)];

        for (long i = 2; i * i <= max; i++) {
            long square = i * i;
            for (long div = min % square == 0 ? min / square : (min / square + 1); square * div <= max; div++) {
                isSquares[(int) (div * square - min)] = true;
            }
        }


        int count = 0;
        for (boolean isSquare : isSquares) {
            if (!isSquare) {
                count++;
            }
        }

        return count;
    }

}


