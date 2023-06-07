package problem.baekjoon.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class No1092 {
    static class Crane {
        int weight;
        int count;

        public Crane(int weight) {
            this.weight = weight;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Crane[] cranes = new Crane[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            cranes[i] = new Crane(Integer.parseInt(st.nextToken()));
        }

        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int[] boxes = new int[m];
        for (int i = 0; i < m; i++) {
            boxes[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(getMinTime(cranes, boxes, n - 1, m - 1));
    }

    private static int getMinTime(Crane[] cranes, int[] boxes, int n, int m) {
        Arrays.sort(cranes, Comparator.comparingInt(c -> c.weight));
        Arrays.sort(boxes);
        if (boxes[m] > cranes[n].weight) {
            return -1;
        }

        PriorityQueue<Crane> pq = new PriorityQueue<>(Comparator.comparingInt(c -> c.count));

        for (int i = m; i >= 0; i--) {
            while (n >= 0 && boxes[i] <= cranes[n].weight) {
                pq.add(cranes[n--]);
            }

            Crane crane = pq.poll();
            crane.count++;
            pq.add(crane);
        }

        int maxTime = 0;
        for (Crane crane : pq) {
            maxTime = Math.max(maxTime, crane.count);
        }

        return maxTime;
    }

}

