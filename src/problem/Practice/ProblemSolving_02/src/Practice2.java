package problem.Practice.ProblemSolving_02.src;

public class Practice2 {
    static int[][] maps;
    static int[][] dirs = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    public static int solution(int[][] map, int[] startPos) {
        maps = map;
        result = 0;
        dfs(startPos[0], startPos[1], startPos[2]);
        return result;
    }
    static int result;

    private static void dfs(int x, int y, int d) {
        if (maps[x][y] > 0) {
            return;
        }
        if (maps[x][y] == 0) {
            result++;
            maps[x][y] = -1;
        }

        for (int i = 0; i < 4; i++) {
            d = (d + 3) % 4; //좌회전

            int newX = x + dirs[d][0];
            int newY = y + dirs[d][1];

            if (maps[newX][newY] == 0) {
                dfs(newX, newY, d);
                return;
            }
        }

        maps[x][y] = 9; //후진체크

        d = (d + 2) % 4; // 후진
        x += dirs[d][0];
        y += dirs[d][1];
        dfs(x, y, d);
    }

    public static void main(String[] args) {
        // Test code
        int[][] map = {{1, 1, 1, 1, 1},
                       {1, 0, 0, 0, 1},
                       {1, 0, 0, 0, 1},
                       {1, 0, 0, 0, 1},
                       {1, 1, 1, 1, 1}};
        int[] startPos = {1, 1, 0};
        System.out.println(solution(map, startPos));

        map = new int[][]{  {1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                            {1, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                            {1, 0, 1, 0, 1, 1, 1, 1, 1, 1},
                            {1, 0, 1, 0, 1, 1, 1, 1, 1, 1},
                            {1, 0, 1, 0, 0, 0, 0, 0, 0, 1},
                            {1, 0, 1, 0, 0, 0, 0, 0, 0, 1},
                            {1, 0, 1, 0, 0, 0, 1, 1, 0, 1},
                            {1, 0, 1, 0, 0, 0, 1, 1, 0, 1},
                            {1, 0, 1, 0, 0, 0, 1, 1, 0, 1},
                            {1, 1, 1, 1, 1, 0, 0, 0, 0, 1},
                            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1}};
        startPos = new int[]{1, 1, 2};
        System.out.println(solution(map, startPos));

    }
}
