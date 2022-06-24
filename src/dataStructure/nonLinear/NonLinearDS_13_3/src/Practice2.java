package dataStructure.nonLinear.NonLinearDS_13_3.src;

import java.awt.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Practice2 {
    static int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public static int solution(int n, int[][] switches) {
        boolean[][] visited = new boolean[n][n];
        boolean[][] light = new boolean[n][n];
        light[0][0] = true;
        int cnt = 0;

        ArrayList<Point>[][] graph = new ArrayList[n][n];
        for (int[] aSwitch : switches) {
            if (graph[aSwitch[0]-1][aSwitch[1]-1] == null) {
                graph[aSwitch[0]-1][aSwitch[1]-1] = new ArrayList<>();
            }
            graph[aSwitch[0]-1][aSwitch[1]-1].add(new Point(aSwitch[2]-1, aSwitch[3]-1));
        }
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(0, 0));

        boolean isGoing = true;// 갈 수 있는 곳인가? 1,1은 강제 true

        while (!queue.isEmpty()) {
            Point p = queue.poll();
            Queue<Point> next = new LinkedList<>(); //인접한 갈 수 있는 곳들

            for (int[] dir : dirs) {
                int i = p.x + dir[0];
                int j = p.y + dir[1];
                if (i >= 0 && j >= 0 && i < graph.length && j < graph[i].length) {
                    if (visited[i][j]) {
                        isGoing=true;
                    } else if (light[i][j]) {
                        next.add(new Point(i, j));
                    }
                }
            } // 주변에 방문한 방이 있는지 체크

            if (isGoing) {
                cnt++;
                queue.addAll(next);
                visited[p.x][p.y] = true;
                System.out.println(p.x+" "+p.y);
                if (graph[p.x][p.y] != null) {
                    for (Point point : graph[p.x][p.y]) { // 불키는 곳들
                        if(!visited[point.x][point.y])
                            queue.add(point);
                    }
                }
            }
            isGoing = false; // 초기화
        }

        return cnt;
    }


    public static void main(String[] args) {
        // Test code
        int[][] switches = {{1, 1, 1, 2}, {2, 1, 2, 3}, {1, 1, 1, 3},
                {2, 3, 3, 1}, {1, 3, 1, 2}, {1, 3, 2, 3}};
        System.out.println(solution(3, switches));  // 5
    }
}
