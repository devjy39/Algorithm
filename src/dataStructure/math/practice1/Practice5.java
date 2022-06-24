package dataStructure.math.practice1;

public class Practice5 {
    public static int solution(int[][] grid) {
        int sum = 0;
        int[][] dir = {
                {-1, 0},
                {1, 0},
                {0, -1},
                {0, 1}
        };

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    for (int[] d : dir) {
                        int x = i + d[0];
                        int y = j + d[1];
                        if (x < 0 || y < 0 || x == grid.length || y == grid.length) {
                            sum++;
                        } else if (grid[x][y] == 0) {
                            sum++;
                        }
                    }
                }
            }
        }

        return sum;
    }

    // 재귀 풀이
    public static int solution2(int[][] grid) {
        int sum = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    sum = recursion(grid, i, j);
                }
            }
        }
        return sum;
    }

    // 방향타 변수 꿀팁
    static int[][] dir = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};

    public static int recursion(int[][] grid, int i, int j) {
        grid[i][j] = -1;
        int cnt = 0;
        for (int[] d : dir) {
            int x = i + d[0];
            int y = j + d[1];
            if (x < 0 || y < 0 || x >= grid.length || y >= grid.length || grid[x][y] == 0) {
                cnt++;
            } else {
                if(grid[x][y]!=-1)
                    cnt += recursion(grid, x, y);
            }
        }

        return cnt;
    }

    public static void main(String[] args) {
        // Test code
        int[][] grid = {{1}};
        System.out.println(solution(grid));
        System.out.println(solution2(grid));
        System.out.println();

        grid = new int[][]{{0, 1, 0, 0}, {1, 1, 1, 0}, {0, 1, 0, 0}, {1, 1, 0, 0}};
        System.out.println(solution(grid));
        System.out.println(solution2(grid));
    }
}
