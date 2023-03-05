package problem.baekjoon.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No6588 {
    static final int MAX_SIZE = 1_000_000;
    static final String FAIL_MESSAGE = "Goldbach's conjecture is wrong.\n";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder result = new StringBuilder();

        boolean[] prime = getPrimes();

        String read;
        while (!(read = br.readLine()).equals("0")) {
            if (!isGoldbachNumber(prime, Integer.parseInt(read), result)) {
                result.append(FAIL_MESSAGE);
            }
        }

        System.out.print(result);
    }

    private static boolean isGoldbachNumber(boolean[] isNotPrime, int number, StringBuilder result) {
        int range = number / 2;
        for (int i = 3; i <= range; i += 2) {
            if (!isNotPrime[i] && !isNotPrime[number - i]) {
                result.append(number).append(" = ").append(i).append(" + ").append(number - i).append("\n");
                return true;
            }
        }

        return false;
    }

    public static boolean[] getPrimes() {
        boolean[] prime = new boolean[MAX_SIZE + 1];
        prime[0] = prime[1] = true;

        for (int i = 2; i < 1000; i++) {
            if (!prime[i]) {
                for (int j = i * i; j <= MAX_SIZE; j += i) {
                    prime[j] = true;
                }
            }
        }

        return prime;
    }
}

