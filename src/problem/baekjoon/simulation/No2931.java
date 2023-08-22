package problem.baekjoon.simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No2931 {
    //좌표를 저장할 Point
    static class Point {

        // x y 좌표 변수
        int x, y;

        // 생성자 x y를 입력으로 받아서 멤버변수에 할당
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        map = new char[r][c];
        Point start = null;

        for (int i = 0; i < r; i++) {
            String str = br.readLine();
            for (int j = 0; j < c; j++) {
                // 맵 요소
                map[i][j] = str.charAt(j);

                if (map[i][j] == 'M') {
                    start = new Point(i, j);
                }
            }
        }

        Point emptyBlock = getEmptyBlock(start, r, c);
        findBlock(emptyBlock);
    }

    static String[] blocks = {
            "+-12",     // 좌
            "-34+",     // 우
            "|14+",     // 상
            "|23+"      // 하
    };

    // 0 : 좌, 1: 우, 2: 상, 3: 하
    static final int[][] dirs = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
    static char[][] map; // 맵

    private static void findBlock(Point emptyBlock) {
        boolean[] road = new boolean[4];

        for (int i = 0; i < dirs.length; i++) {
            int x = emptyBlock.x + dirs[i][0];
            int y = emptyBlock.y + dirs[i][1];

            if (x < 0 || y < 0 || x >= map.length || y >= map[0].length) {
                continue;
            }

            road[i] = blocks[i].contains(map[x][y] + "");
        }

        System.out.println(++emptyBlock.x + " " + ++emptyBlock.y + " " + getType(road));
    }

    private static char getType(boolean[] road) {
        if (road[0] && road[1] && !road[2] && !road[3]) {
            return '-';
        } else if (!road[0] && !road[1] && road[2] && road[3]) {
            return '|';
        } else if (!road[0] && road[1] && !road[2] && road[3]) {
            return '1';
        } else if (!road[0] && road[1] && road[2] && !road[3]) {
            return '2';
        } else if (road[0] && !road[1] && road[2] && !road[3]) {
            return '3';
        } else if (road[0] && !road[1] && !road[2] && road[3]) {
            return '4';
        }

        return '+';
    }

    private static Point getEmptyBlock(Point point, int r, int c) {
        // 시작점부터 4방향 탐색
        for (int i = 0; i < dirs.length; i++) {
            int x = dirs[i][0] + point.x;
            int y = dirs[i][1] + point.y;

            if (x < 0 || y < 0 || x >= r || y >= c || map[x][y] == '.') {
                continue;
            }

            // i번 방향입니다. 도로이고
            if (blocks[i].contains(map[x][y] + "")) { // 갈 수 있다.
                return dfs(x, y, i);
            }
        }

        return null;
    }

    private static Point dfs(int x, int y, int prevDir) {
        int nextDir = nextDir(prevDir, map[x][y]);

        x += dirs[nextDir][0];
        y += dirs[nextDir][1];

        return map[x][y] == '.' ? new Point(x, y) : dfs(x, y, nextDir);
    }

    // prev 이전 방향과, block 현재 블록
    private static int nextDir(int prev, char block) {
        // 0 좌, 1 우, 2 상, 3하

        switch (block) {
            case '+':
            case '|':
            case '-':
                return prev;
            case '1': // 2 -> 1, 0 -> 3
            case '3': // 1 -> 2, 3 -> 0
                return 3 - prev;
            case '2': // 3 -> 1 , 0 -> 2
            case '4': // 1 -> 3, 2 -> 0
                return (prev + 2) % 4;
        }

        return -1;
    }

}
