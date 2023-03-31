package problem.baekjoon.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No2644 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(br.readLine());

        int[] parents = new int[n + 1];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int parent = Integer.parseInt(st.nextToken());
            int child = Integer.parseInt(st.nextToken());
            parents[child] = parent;
        }

        System.out.println(getRelationDistance(parents, x, y));
    }

    private static int getRelationDistance(int[] parents, int x, int y) {
        int[] parentCount = new int[parents.length];
        int count = 1;
        while (x > 0) {
            parentCount[x] = count++;
            x = parents[x];
        }

        count = 0;
        while (y != 0) {
            if (parentCount[y] > 0) { // x의 공통 조상
                return count + parentCount[y] - 1;
            }
            count++;
            y = parents[y];
        }

        return -1;
    }
}

