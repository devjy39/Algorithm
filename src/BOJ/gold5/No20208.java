package BOJ.gold5;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class No20208 {
    static int H;
    static int[][] distance;
    static int MAX = 1_000_000_000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        List<Point> list = new ArrayList<>();
        list.add(new Point(0, 0));

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            for (int j = 0; j < N; j++) {
                int type = Integer.parseInt(st.nextToken());
                if (type == 1) {
                    list.get(0).setLocation(i, j);
                } else if (type == 2) {
                    list.add(new Point(i, j));
                }
            }
        }

        setDistance(list);
        System.out.println(getMaxCount(0, M, 0, 1));
    }

    private static void setDistance(List<Point> list) {
        distance = new int[list.size()][list.size()];

        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.size(); j++) {
                if (i == j) {
                    distance[i][j] = MAX;
                } else {
                    distance[i][j] = Math.abs(list.get(i).x - list.get(j).x) + Math.abs(list.get(i).y - list.get(j).y);
                }
            }
        }
    }

    private static int getMaxCount(int cur, int health, int count, int bit) {
        int maxCount = 0;

        for (int i = 1; i < distance.length; i++) {
            if (((1 << i) & bit) == 0 && distance[cur][i] <= health) { // 방문 x , 체력 가능
                maxCount = Math.max(maxCount, getMaxCount(i, health - distance[cur][i] + H, count + 1, bit | (1 << i)));
            }
        }

        return Math.max(maxCount, health >= distance[cur][0] ? count : 0);
    }
}
