package problem.baekjoon.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class No3665 {

    static class Team {
        int rank;
        List<Integer> list = new ArrayList<>();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder result = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());
            Team[] teams = new Team[N + 1];
            for (int i = 1; i <= N; i++) {
                teams[i] = new Team();
            }
            int[] scores = new int[N + 1];
            int[] ranks = new int[N + 1];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                int num = Integer.parseInt(st.nextToken());
                ranks[i + 1] = num;
                scores[num] = i;
                teams[num].rank = i;
            }

            int m = Integer.parseInt(br.readLine());
            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                if (scores[a] < scores[b]) { // a가 원래 등수 더 높은 경우
                    teams[b].rank--;
                    teams[b].list.add(a); // 순위 바꾸고 b 뒷 순서로 체크
                    teams[a].rank++;
                } else {
                    teams[a].rank--;
                    teams[a].list.add(b);
                    teams[b].rank++;
                }
            }

            topologySort(result, N, teams, scores, ranks);
        }

        System.out.print(result);
    }

    private static void topologySort(StringBuilder result, int N, Team[] teams, int[] scores, int[] ranks) {
        int nextTeam = 0;
        for (int i = 1; i <= N; i++) {
            if (teams[i].rank == 0) {
                nextTeam = i;
                break;
            }
        }

        StringBuilder sb = new StringBuilder();
        int count = 0;
        while (nextTeam > 0) {
            sb.append(nextTeam).append(" ");
            count++;

            int curTeam = nextTeam;
            nextTeam = 0;

            for (int node : teams[curTeam].list) {
                if (--teams[node].rank == 0) {
                    nextTeam = node;
                }
            }
            for (int i = scores[curTeam] + 1; i <= N; i++) {
                if (--teams[ranks[i]].rank == 0) {
                    nextTeam = ranks[i];
                }
            }
        }

        if (count == N) {
            result.append(sb).append("\n");
        } else {
            result.append("IMPOSSIBLE\n");
        }
    }

}