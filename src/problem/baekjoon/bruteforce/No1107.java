package problem.baekjoon.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class No1107 {
    static int result;
    static int target;
    static Set<Integer> buttons;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String strTarget = br.readLine();
        target = Integer.parseInt(strTarget);
        int m = Integer.parseInt(br.readLine());

        buttons = new HashSet<>(Set.of(0, 1, 2, 3, 4, 5, 6, 7, 8, 9));
        if (m != 0) {
            for (String butt : br.readLine().split(" ")) {
                buttons.remove(Integer.valueOf(butt));
            }
        }
        br.close();
        minLength = Math.max(1, strTarget.length() - 1);

        result = Integer.MAX_VALUE;
        int moveCount = Math.abs(target - 100);
        if (buttons.contains(0)) {
            moveCount = Math.min(moveCount, target + 1);
        }

        if (moveCount > strTarget.length()) {
            for (Integer button : buttons) {
                if (button != 0) {
                    dfs(button, 1);
                }
            }
        }

        System.out.println(Math.min(moveCount, result));
    }

    static int minLength;

    private static void dfs(int num, int length) {
        if (length >= minLength) {
            result = Math.min(result, Math.abs(target - num) + length);
        }
        if (num > target) {
            return;
        }

        int num10 = num * 10;
        for (int button : buttons) {
            dfs(num10 + button, length + 1);
        }
    }
}