package problem.baekjoon.simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class No27958 {

    static int[][] dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    static int maxScore;
    static int[][] map, originMap, getScore;
    static int[] attacks;
    static int n, k;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        k = Integer.parseInt(br.readLine());

        map = new int[n][n];
        originMap = new int[n][n];
        getScore = new int[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                getScore[i][j] = originMap[i][j] = map[i][j];
            }
        }
        attacks = new int[k];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < k; i++) {
            attacks[i] = Integer.parseInt(st.nextToken());
        }

        updateMaxScore(0, 0);
        System.out.println(maxScore);
    }

    private static void updateMaxScore(int idx,int score) {
        if (idx >= k) {
            maxScore = Math.max(maxScore, score);
            return;
        }

        for (int i = 0; i < n; i++) {
            int attack = attacks[idx];

            for (int j = 0; j < n; j++) {
                if (map[i][j] > 0) {
                    int h = map[i][j];
                    if (h >= 10) {
                        map[i][j] = 0;
                        getScore[i][j] = 0;
                        updateMaxScore(idx + 1, score + h);
                        getScore[i][j] = h;
                        map[i][j] = h;
                    } else if (attack >= h) {
                        map[i][j] = 0;
                        List<Integer> target = new ArrayList<>();
                        List<Integer> originScores = new ArrayList<>();

                        generate(i, j, target, originScores);
                        updateMaxScore(idx + 1, score + getScore[i][j]);
                        remove(i, j, target, originScores);

                        map[i][j] = h;
                    } else {
                        map[i][j] -= attack;
                        updateMaxScore(idx + 1, score);
                        map[i][j] += attack;
                    }
                    break;
                }
            }


        }
    }

    private static void remove(int i, int j, List<Integer> target, List<Integer> scores) {
        for (int l = 0; l < target.size(); l++) {
            int[] dir = dirs[target.get(l)];
            int x = i + dir[0];
            int y = j + dir[1];

            if (x < 0 || y < 0 || x >= n || y >= n) {
                continue;
            }

            getScore[x][y] = scores.get(l);
            map[x][y] = 0;
        }
    }

    private static void generate(int i, int j, List<Integer> target, List<Integer> scores) {
        int h = originMap[i][j] / 4;
        for (int l = 0; l < 4; l++) {
            int[] dir = dirs[l];
            int x = i + dir[0];
            int y = j + dir[1];

            if (x < 0 || y < 0 || x >= n || y >= n || map[x][y] > 0) {
                continue;
            }

            target.add(l);

            scores.add(getScore[x][y]);
            getScore[x][y] = h;

            map[x][y] = h;
        }
    }

}

