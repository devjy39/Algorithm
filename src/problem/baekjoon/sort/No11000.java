package problem.baekjoon.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class No11000 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        int[][] lectures = new int[n][2];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            lectures[i][0] = s;
            lectures[i][1] = t;
        }

        System.out.println(getLectureCount(lectures));
    }

    private static int getLectureCount(int[][] lectures) {
        Arrays.sort(lectures, (l1, l2) -> l1[0] - l2[0]);
        PriorityQueue<int[]> pq = new PriorityQueue<>((l1, l2) -> l1[1] - l2[1]);

        for (int[] lecture : lectures) {
            if (pq.isEmpty() || pq.peek()[1] > lecture[0]) {
                pq.add(lecture);
                continue;
            }
            pq.poll();
            pq.add(lecture);
        }

        return pq.size();
    }

}

