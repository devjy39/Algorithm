import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.List;

public class Main {
    static List<Point> virus;
    static int[][] map;
    static int n, virusCount, land, time = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        virusCount = Integer.parseInt(st.nextToken());

        map = new int[n][n];
        virus = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] != 1) {
                    land++;
                    if (map[i][j] == 2) {
                        virus.add(new Point(i, j));
                    }
                }
            }
        }

        land -= virusCount;

        dfs(new int[virusCount], 0, -1);
        System.out.println(time == Integer.MAX_VALUE ? -1 : time);
    }

    private static void dfs(int[] virusNumbers, int depth, int prev) {
        if (depth >= virusNumbers.length) {
            time = Math.min(time, bfs(virusNumbers));
            return;
        }

        for (int i = prev + 1; i < virus.size(); i++) {
            virusNumbers[depth] = i;
            dfs(virusNumbers, depth + 1, i);
        }
    }

    static int[][] dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    static int season;

    static Queue<Point> queue = new ArrayDeque<>();
    private static int bfs(int[] virusNumbers) {
        season--;
        int time = -1;
        for (int virusNumber : virusNumbers) {
            Point point = virus.get(virusNumber);
            queue.add(point);
            map[point.x][point.y] = season;
        }

        int infect = 0;

        while (!queue.isEmpty()) {
            Queue<Point> next = new LinkedList<>();
            time++;

            while (!queue.isEmpty()) {
                Point cur = queue.poll();

                for (int[] dir : dirs) {
                    int x = dir[0] + cur.x;
                    int y = dir[1] + cur.y;

                    if (x < 0 || y < 0 || x >= n || y >= n || map[x][y] == 1 || map[x][y] == season) {
                        continue;
                    }
                    map[x][y] = season;
                    next.add(new Point(x, y));
                }
            }

            queue = next;
            infect += queue.size();
        }

        return infect < land ? Integer.MAX_VALUE : time;
    }

}

