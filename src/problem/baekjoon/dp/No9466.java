package problem.baekjoon.dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No9466 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            int[] arr = new int[n + 1];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }

            result.append(composeTeam(arr, n)).append('\n');
        }

        System.out.print(result);
    }

    private static int composeTeam(int[] arr, int n) {
        int count = n;
        int[] visited = new int[arr.length];
        int[] connected = new int[arr.length];

        for (int i = 1; i < arr.length; i++) {
            if (visited[i] != 0) {
                continue;
            }
            int cur = i;
            int seq = 1;

            while (visited[cur] == 0) {
                connected[cur] = seq++;
                visited[cur] = i;
                cur = arr[cur];
            }
            if (visited[cur] == i) {
                count -= seq - connected[cur];
            }
        }

        return count;
    }

}