package problem.baekjoon.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No4803 {

    public static void main(String[] args) throws IOException {
        //System.setIn(new FileInputStream("src/data.txt"));

        StringBuilder result = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        String read;
        int t = 1;

        while (!"0 0".equals(read = br.readLine())) {
            st = new StringTokenizer(read);
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            boolean[] visited = new boolean[n + 1];
            boolean[] isCycle = new boolean[n + 1];
            int[] parents = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                parents[i] = i;
            }

            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int s = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());

                if (visited[s] && visited[e] && find(parents, s) == find(parents, e)) { // 같은 트리에 속한 경우
                    isCycle[parents[s]] = true;
                } else {
                    visited[s] = visited[e] = true;
                }

                if (find(parents, s) != find((parents), e)) {
                    if (isCycle[parents[s]] | isCycle[parents[e]]) { // 이미 싸이클인 트리로 전입할 때
                        isCycle[parents[s]] = isCycle[parents[e]] = true;
                    }
                    union(parents, s, e);
                }
            }

            appendTreeCount(result, t++, n, isCycle, parents);
        }

        System.out.print(result);
    }

    private static void appendTreeCount(StringBuilder result, int t, int n, boolean[] isCycle, int[] parents) {
        int count = 0;
        for (int i = 1; i <= n; i++) {
            if (!isCycle[find(parents, i)]) {
                count++;
                isCycle[parents[i]] = true;
            }
        }

        if (count == 0) {
            result.append("Case ").append(t).append(": No trees.\n");
        } else if (count == 1) {
            result.append("Case ").append(t).append(": There is one tree.\n");
        } else {
            result.append("Case ").append(t).append(": A forest of ").append(count).append(" trees.\n");
        }
    }

    private static void union(int[] parents, int s, int e) {
        s = find(parents, s);
        e = find(parents, e);

        if (s < e) {
            parents[e] = s;
        } else {
            parents[s] = e;
        }
    }

    private static int find(int[] parents, int n) {
        if (n == parents[n]) {
            return n;
        }

        return parents[n] = find(parents, parents[n]);
    }

}