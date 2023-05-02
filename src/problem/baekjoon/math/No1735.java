package problem.baekjoon.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No1735 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int m1 = Integer.parseInt(st.nextToken());
        int d1 = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int m2 = Integer.parseInt(st.nextToken());
        int d2 = Integer.parseInt(st.nextToken());

        System.out.println(abbreviation((m1 * d2) + (m2 * d1), d1 * d2));
    }

    private static String abbreviation(int molecule, int denominator) {
        int gcd = getGcd(molecule, denominator);
        return String.format("%d %d", molecule / gcd, denominator / gcd);
    }

    private static int getGcd(int molecule, int denominator) {
        int mod = molecule % denominator;
        return mod == 0 ? denominator : getGcd(denominator, mod);
    }

}

