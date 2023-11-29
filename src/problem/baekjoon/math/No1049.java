package problem.baekjoon.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No1049 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int setPrice = Integer.MAX_VALUE;
        int onePrice = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            setPrice = Math.min(setPrice, Integer.parseInt(st.nextToken()));
            onePrice = Math.min(onePrice, Integer.parseInt(st.nextToken()));
        }

        System.out.println(getMinPrice(m, setPrice, onePrice));
    }

    private static int getMinPrice(int m, int setPrice, int onePrice) {
        if (onePrice * 6 <= setPrice) {
            return onePrice * m;
        }
        if (setPrice <= (m % 6) * onePrice) {
            return (m / 6 + 1) * setPrice;
        }
        return (m / 6) * setPrice + (onePrice * (m % 6));
    }

}

