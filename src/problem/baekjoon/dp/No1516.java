package problem.baekjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class No1516 {
    static class Building {
        int totalTime;
        int buildTime;
        List<Building> requiredBuildings = new ArrayList<>();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Building[] buildings = new Building[n + 1];
        for (int i = 1; i <= n; i++) {
            buildings[i] = new Building();
        }

        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            buildings[i].buildTime = Integer.parseInt(st.nextToken());
            String read;
            while (!(read = st.nextToken()).equals("-1")) {
                buildings[i].requiredBuildings.add(buildings[Integer.parseInt(read)]);
            }
        }

        StringBuilder result = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            if (buildings[i].totalTime == 0) {
                dfs(buildings[i]);
            }
            result.append(buildings[i].totalTime).append("\n");
        }

        System.out.print(result);
    }

    private static int dfs(Building node) {
        if (node.totalTime > 0) {
            return node.totalTime;
        }
        int requiredTime = 0;

        for (Building building : node.requiredBuildings) {
            requiredTime = Math.max(requiredTime, dfs(building));
        }

        return node.totalTime = node.buildTime + requiredTime;
    }

}
