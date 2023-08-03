import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.List;

public class No17142 {
    static List<Point> virusList;
    static Set<Point> virusSet;
    static int[][] map;
    static int n, virusCount, land, time = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        virusCount = Integer.parseInt(st.nextToken());

        map = new int[n][n];
        virusList = new ArrayList<>();
        virusSet = new HashSet<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 0) {
                    land++;
                } else if (map[i][j] == 2) {
                    Point point = new Point(i, j);
                    virusList.add(point);
                    virusSet.add(point);
                }
            }
        }

        dfs(new int[virusCount], 0, -1);
        System.out.println(time == Integer.MAX_VALUE ? -1 : time);
    }

    private static void dfs(int[] virusNumbers, int depth, int prev) {
        if (depth >= virusNumbers.length) {
            time = Math.min(time, bfs(virusNumbers));
            return;
        }

        for (int i = prev + 1; i < virusList.size(); i++) {
            virusNumbers[depth] = i;
            dfs(virusNumbers, depth + 1, i);
        }
    }

    static int[][] dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    static int season;

    static Queue<Point> queue = new ArrayDeque<>();
    private static int bfs(int[] virusNumbers) {
        season--;
        int time = 0;
        for (int virusNumber : virusNumbers) {
            Point point = virusList.get(virusNumber);
            queue.add(point);
            map[point.x][point.y] = season;
        }

        int infect = land;

        while (!queue.isEmpty()) {
            if (infect == 0) {
                break;
            }
            Queue<Point> next = new LinkedList<>();

            while (!queue.isEmpty()) {
                Point cur = queue.poll();

                for (int[] dir : dirs) {
                    int x = dir[0] + cur.x;
                    int y = dir[1] + cur.y;

                    if (x < 0 || y < 0 || x >= n || y >= n || map[x][y] == 1 || map[x][y] == season) {
                        continue;
                    }
                    Point point = new Point(x, y);
                    if (!virusSet.contains(point)) {
                        infect--;
                    }
                    map[x][y] = season;
                    next.add(point);
                }
            }

            queue = next;
            time++;
        }

        queue.clear();
        return infect > 0 ? Integer.MAX_VALUE : time;
    }

}

