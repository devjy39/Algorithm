package problem.baekjoon.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No16987 {
    static class Egg {
        int durability;
        int weight;

        public Egg(int durability, int weight) {
            this.durability = durability;
            this.weight = weight;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Egg[] eggs = new Egg[n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            eggs[i] = new Egg(s, w);
        }

        System.out.println(dfs(eggs, 0));
    }

    private static int dfs(Egg[] eggs, int depth) {
        while (depth < eggs.length && eggs[depth].durability <= 0) {
            depth++;
        }
        if (depth >= eggs.length) {
            return 0;
        }

        int maxDestroyed = 0;
        Egg egg = eggs[depth];

        for (int i = 0; i < eggs.length; i++) {
            if (eggs[i].durability > 0 && i != depth) {
                int count = ((egg.durability -= eggs[i].weight) <= 0 ? 1 : 0) +
                        ((eggs[i].durability -= egg.weight) <= 0 ? 1 : 0);

                maxDestroyed = Math.max(maxDestroyed, count + dfs(eggs, depth + 1));
                egg.durability += eggs[i].weight;
                eggs[i].durability += egg.weight;
            }
        }

        return maxDestroyed;
    }

}

