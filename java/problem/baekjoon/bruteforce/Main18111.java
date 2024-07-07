package problem.baekjoon.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main18111 {
    static int n, m;
    static int minTime;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        Map<Integer, Integer> map = new HashMap<>();
        int min = Integer.MAX_VALUE, max = 0;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                int cur = Integer.parseInt(st.nextToken());
                map.put(cur, map.getOrDefault(cur, 0) + 1);
                min = Math.min(min, cur);
                max = Math.max(max, cur);
            }
        }
        br.close();

        minTime = Integer.MAX_VALUE;
        int height = 0;

        for (int h = min; h <= max; h++) {
            int time = evenGround(map, h, b);
            if (time <= minTime) {
                minTime = time;
                height = h;
            }
        }

        System.out.println(minTime + " " + height);
    }

    static int evenGround(Map<Integer, Integer> map, int targetH, int blocks) {
        int time = 0;

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int height = entry.getKey();
            if (targetH < height) {
                int cnt = (height - targetH) * entry.getValue();
                time += cnt * 2;
                blocks += cnt;
            } else if (targetH > height) {
                int cnt = (targetH - height) * entry.getValue();
                time += cnt;
                blocks -= cnt;
            }

            if (time > minTime) {
                return Integer.MAX_VALUE;
            }
        }

        return blocks < 0 ? Integer.MAX_VALUE : time;
    }
}