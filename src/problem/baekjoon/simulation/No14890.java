package problem.baekjoon.simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class No14890 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());

        int[][] map = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(getCheckCount(map, l, n));
    }

    private static int getCheckCount(int[][] map, int l, int n) {
        int count = 0;
        for (int i = 0; i < n; i++) {
            count += verticalCheck(map[i], l) ? 1 : 0;
        }
        for (int i = 0; i < n; i++) {
            count += horizontalCheck(map, l , i) ? 1 : 0;
        }

        return count;
    }

    private static boolean horizontalCheck(int[][] map, int l, int h) {
        List<Integer> height = new ArrayList<>();
        List<Integer> count = new ArrayList<>();
        height.add(map[0][h]);

        int equalCount = 1;
        int prev = map[0][h];

        for (int i = 1; i < map.length; i++) {
            if (prev == map[i][h]) {
                equalCount++;
            } else {
                if (Math.abs(prev - map[i][h]) > 1) {
                    return false;
                }
                count.add(equalCount);
                height.add(map[i][h]);
                equalCount = 1;
                prev = map[i][h];
            }
        }
        count.add(equalCount);

        return isPossible(l, height, count);
    }

    private static boolean verticalCheck(int[] map, int l) {
        List<Integer> height = new ArrayList<>();
        List<Integer> count = new ArrayList<>();
        height.add(map[0]);

        int equalCount = 1;
        int prev = map[0];

        for (int i = 1; i < map.length; i++) {
            if (prev == map[i]) {
                equalCount++;
            } else {
                if (Math.abs(prev - map[i]) > 1) {
                    return false;
                }
                count.add(equalCount);
                height.add(map[i]);
                equalCount = 1;
                prev = map[i];
            }
        }
        count.add(equalCount);

        return isPossible(l, height, count);
    }

    private static boolean isPossible(int l, List<Integer> height, List<Integer> count) {
        boolean down = false;

        for (int i = 1; i < height.size(); i++) {
            if (height.get(i - 1) > height.get(i)) { // 내리막길
                if (count.get(i) < l) {
                    return false;
                }
                down = true;
            } else {
                if (down) {
                    if (count.get(i - 1) < 2 * l) {
                        return false;
                    }
                } else {
                    if (count.get(i - 1) < l) {
                        return false;
                    }
                }
                down = false;
            }
        }

        return true;
    }

}

