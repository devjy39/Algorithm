package problem.baekjoon.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No2436 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        // a * b * 최대공약수 = 최소공배수
        int mul = b / a;

        for (int i = (int) Math.sqrt(mul); i >= 0; i--) {
            if (mul % i != 0) {
                continue;
            }

            if (gcd(i, mul / i) == 1) {
                System.out.println(i * a + " " + mul / i * a);
                break;
            }
        }
    }

    private static int gcd(int a, int b) {
        return a % b == 0 ? b : gcd(b, a % b);
    }


}

