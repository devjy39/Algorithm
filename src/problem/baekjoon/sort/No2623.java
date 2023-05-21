package problem.baekjoon.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class No2623 {
    static class Singer {
        int number;
        List<Singer> nextSingers = new ArrayList<>();
        int waitCount;

        public Singer(int number) {
            this.number = number;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Singer[] singers = new Singer[n + 1];
        for (int i = 1; i <= n; i++) {
            singers[i] = new Singer(i);
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());

            int prev = Integer.parseInt(st.nextToken());
            for (int j = 1; j < k; j++) {
                int cur = Integer.parseInt(st.nextToken());
                singers[prev].nextSingers.add(singers[cur]);
                singers[cur].waitCount++;
                prev = cur;
            }
        }

        System.out.println(topologicalSort(n, singers));
    }

    private static String topologicalSort(int n, Singer[] singers) {
        Queue<Singer> queue = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            if (singers[i].waitCount == 0) {
                queue.add(singers[i]);
            }
        }

        StringBuilder result = new StringBuilder();
        int count = 0;

        while (!queue.isEmpty()) {
            Singer singer = queue.poll();
            count++;
            result.append(singer.number).append("\n");

            for (Singer nextSinger : singer.nextSingers) {
                if (--nextSinger.waitCount <= 0) {
                    queue.add(nextSinger);
                }
            }
        }

        return count < n ? "0" : result.toString();
    }

}
