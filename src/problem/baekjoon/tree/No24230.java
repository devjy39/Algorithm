package problem.baekjoon.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No24230 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] colors = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            colors[i] = Integer.parseInt(st.nextToken());
        }

        int colorCount = colors[1] != 0 ? 1 : 0;

        for (int i = 1; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if (colors[a] != colors[b]) {
                colorCount++;
            }
        }

        System.out.println(colorCount);
    }

}

