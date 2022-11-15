package problem.baekjoon.simulation;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class No15686 {

    static int[][] map;
    static List<Point> chickens, houses;
    static int result = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        map = new int[n][n];
        chickens = new ArrayList<>();
        houses = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 2) {
                    chickens.add(new Point(i, j));
                } else if (map[i][j] == 1) {
                    houses.add(new Point(i, j));
                }
            }
        }
        br.close();

        combination(new boolean[chickens.size()], m, 0, 0);

        System.out.println(result);
    }

    private static void combination(boolean[] available, int m, int count, int prev) {
        if (count == m) {
            result = Math.min(result, calculateDistance(available));
            return;
        }

        for (int i = prev; i < available.length; i++) {
            available[i] = true;
            combination(available, m, count + 1, i + 1);
            available[i] = false;
        }
    }

    private static int calculateDistance(boolean[] available) {
        int sum = 0;

        for (Point house : houses) {
            sum += getMinDistance(house, available);
            if (sum >= result) {
                return result;
            }
        }

        return sum;
    }

    private static int getMinDistance(Point house, boolean[] available) {
        int distance = Integer.MAX_VALUE;

        for (int i = 0; i < available.length; i++) {
            if (available[i]) {
                distance = Math.min(distance, Math.abs(house.x - chickens.get(i).x) + Math.abs(house.y - chickens.get(i).y));
            }
        }

        return distance;
    }

}