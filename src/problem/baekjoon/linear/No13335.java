package problem.baekjoon.linear;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class No13335 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] trucks = new int[n];
        for (int i = 0; i < n; i++) {
            trucks[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(getTransitTime(trucks, w, l));
    }

    private static int getTransitTime(int[] trucks, int w, int l) {
        Queue<Integer> queue = new LinkedList<>();
        int weight = 0;
        int time = 0;

        for (int i = 1; i < w; i++) {
            queue.add(0);
        }

        for (int truck : trucks) {
            boolean pass = false;
            while (weight + truck > l || queue.size() >= w) {
                weight -= queue.poll();
                time++;
                pass = true;
            }

            while (queue.size() < w - 1) {
                queue.add(0);
            }

            queue.add(truck);
            weight += truck;
            if (!pass) {
                time++;
            }
        }

        return time + queue.size();
    }

}

