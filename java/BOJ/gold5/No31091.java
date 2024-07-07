package BOJ.gold5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No31091 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] up = new int[N + 1];
        int[] down = new int[N + 1];

        for (int i = 0; i < N; i++) {
            int number = Integer.parseInt(st.nextToken());

            if (number > 0) {
                up[number]++;
            } else {
                down[-number]++;
            }
        }

        printAnswer(getCheck(N, down, up));
    }

    private static boolean[] getCheck(int N, int[] down, int[] up) {
        for (int i = 1; i <= N; i++) {
            up[i] += up[i - 1];
        }

        for (int i = N - 1; i >= 0; i--) {
            down[i] += down[i + 1];
        }


        boolean[] check = new boolean[N + 1];

        for (int i = 0; i <= N; i++) {
            int lies = 0;

            lies += i == 0 ? 0 : (down[0] - down[i]);
            lies += i == N ? 0 : (up[N] - up[i]);
            if (lies != i) {
                continue;
            }

            check[lies] = true;
        }

        return check;
    }

    private static void printAnswer(boolean[] check) {
        int amount = 0;
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < check.length; i++) {
            if (check[i]) {
                amount++;
                result.append(i).append(" ");
            }
        }

        System.out.println(amount + "\n" + result);
    }

}
