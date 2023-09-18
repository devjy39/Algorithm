package problem.baekjoon.divide_conquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No16974 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        long x = Long.parseLong(st.nextToken());

        long[] counts = new long[n + 1];
        long[] patties = new long[n + 1];
        counts[0] = patties[0] = 1;

        for (int i = 1; i <= n; i++) {
            counts[i] = counts[i - 1] * 2 + 3;
            patties[i] = patties[i - 1] * 2 + 1;
        }

        System.out.println(getPatties(counts, patties, n, x));
    }

    private static long getPatties(long[] counts, long[] patties, int idx, long x) {
        if (idx == 0) {
            return x < 1 ? 0 : 1;
        }

        long center = (counts[idx] >> 1) + 1;

        if (x > center) {
            return patties[idx - 1] +
                    getPatties(counts, patties, idx - 1, x - center) + 1;
        }

        return getPatties(counts, patties, idx - 1, x - 1) + (x == center ? 1 : 0);
    }

}

