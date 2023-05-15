package problem.baekjoon.etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class No1043 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        boolean[] person = new boolean[n + 1];
        st = new StringTokenizer(br.readLine());
        int t = Integer.parseInt(st.nextToken());
        for (int i = 0; i < t; i++) {
            person[Integer.parseInt(st.nextToken())] = true;
        }

        int[] parents = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            parents[i] = i;
        }
        List<int[]> parties = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int l = Integer.parseInt(st.nextToken());
            int[] party = new int[l];
            for (int j = 0; j < l; j++) {
                party[j] = Integer.parseInt(st.nextToken());
            }
            parties.add(party);
            unionFind(parents, l, party);
        }

        findTruePersonParents(person, parents);
        System.out.println(getLieParty(person, parents, parties));
    }

    private static int getLieParty(boolean[] person, int[] parents, List<int[]> parties) {
        int count = 0;

        for (int[] party : parties) {
            for (int p : party) {
                if (person[find(parents, p)]) {
                    count--;
                    break;
                }
            }
            count++;
        }
        return count;
    }

    private static void findTruePersonParents(boolean[] person, int[] parents) {
        Set<Integer> trueParent = new HashSet<>();
        for (int i = 1; i < person.length; i++) {
            if (person[i]) {
                trueParent.add(find(parents, i));
            }
        }

        for (int i = 1; i < parents.length; i++) {
            if (trueParent.contains(parents[i])) {
                person[i] = true;
            }
        }
    }

    private static void unionFind(int[] parents, int l, int[] party) {
        for (int j = 1; j < l; j++) {
            int node = party[j];
            int prev = party[j - 1];

            if (find(parents, prev) != find(parents, node)) {
                union(parents, prev, node);
            }
        }
    }

    private static void union(int[] parents, int a, int b) {
        parents[find(parents, a)] = parents[find(parents, b)];
    }

    private static int find(int[] parents, int node) {
        return parents[node] == node ? node : (parents[node] = find(parents, parents[node]));
    }

}


