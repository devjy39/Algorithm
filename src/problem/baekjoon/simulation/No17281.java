package problem.baekjoon.simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No17281 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[][] scoreByPlayer = new int[n][9];
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < 9; j++) {
                scoreByPlayer[i][j] = str.charAt(j << 1) - '0';
            }
        }

        int[] players = new int[9];
        boolean[] visited = new boolean[9];
        visited[0] = true;
        dfs(scoreByPlayer, players, visited, 0);
        System.out.println(maxScore);
    }

    static int maxScore;

    private static void dfs(int[][] scoreByPlayer, int[] players, boolean[] visited, int depth) {
        if (depth >= players.length) {
            maxScore = Math.max(maxScore, getScore(players, scoreByPlayer));
            return;
        }

        for (int i = 1; i < players.length; i++) {
            if (!visited[i]) {
                players[depth] = i;
                visited[i] = true;
                dfs(scoreByPlayer, players, visited, depth != 2 ? depth + 1 : 4);
                visited[i] = false;
            }
        }
    }

    private static int getScore(int[] players, int[][] scoreByPlayer) {
        int sequence = 0;
        int score = 0;

        for (int[] scores : scoreByPlayer) { // 이닝
            int out = 0;
            int bit = 0;

            while (out < 3) {
                int type = scores[players[sequence]];
                if (type == 0) { // out
                    out++;
                } else {
                    bit = bit << 1;
                    bit++;
                    bit = bit << --type;

                    for (int j = 8; bit >= 8; j <<= 1) {
                        if ((bit & j) > 0) {
                            score++;
                            bit -= j;
                        }
                    }
                }

                if (++sequence == 9) {
                    sequence = 0;
                }
            }

        }

        return score;
    }

}
