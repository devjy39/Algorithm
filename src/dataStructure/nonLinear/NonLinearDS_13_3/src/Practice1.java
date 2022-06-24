package dataStructure.nonLinear.NonLinearDS_13_3.src;

import java.util.PriorityQueue;

public class Practice1 {
    static PriorityQueue<int[]> queue;
    static int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public static void solution(char[][] picture) {
        boolean[][] visited = new boolean[picture.length][picture.length];
        queue = new PriorityQueue<>((q1, q2) -> q2[2] - q1[2]); //알파벳 내림차순 B는 최하위
        queue.add(new int[]{0, 0, picture[0][0]});

        char prev = 'B';
        int blindCnt = 0;
        int generalCnt = 0;
        while (!queue.isEmpty()) {
            int[] point = queue.poll();
            char cur = picture[point[0]][point[1]];
            if (visited[point[0]][point[1]]) {
                continue;
            } else {
                if (prev == 'B' || cur == 'B') {
                    blindCnt++;
                }
                generalCnt++;
            }
            prev = cur;
            dfs(picture, visited, point[0], point[1]);
        }

        System.out.println("blindCnt = " + blindCnt);
        System.out.println("generalCnt = " + generalCnt);
    }

    public static void dfs(char[][] picture, boolean[][] visited, int x, int y) {
        visited[x][y] = true;

        for (int[] dir : dirs) {
            int i = x + dir[0];
            int j = y + dir[1];
            if (i >= 0 && j >= 0 && i < picture.length && j < picture[i].length) {
                if (!visited[i][j]) {
                    if (picture[i][j] == picture[x][y]) {
                        dfs(picture, visited, i, j);
                    } else {
                        queue.add(new int[]{i, j, picture[i][j]});
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        // Test code
        char[][] pictures = {
                {'R', 'R', 'R', 'R', 'R'},
                {'G', 'B', 'G', 'B', 'G'},
                {'B', 'B', 'G', 'B', 'B'},
                {'B', 'B', 'R', 'R', 'R'},
                {'R', 'R', 'R', 'R', 'R'}
        };
        solution(pictures); // 4 3
    }
}
