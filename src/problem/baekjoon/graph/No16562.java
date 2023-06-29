import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class No16562 {
    static class Friendship {
        int a;
        int b;

        public Friendship(int a, int b) {
            this.a = a;
            this.b = b;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int balance = Integer.parseInt(st.nextToken());

        int[] prices = new int[n + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            prices[i] = Integer.parseInt(st.nextToken());
        }
        Friendship[] friendships = new Friendship[m];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            friendships[i] = new Friendship(a, b);
        }

        System.out.println(calculateMinPrice(friendships, prices, n, balance));
    }

    private static String calculateMinPrice(Friendship[] friendships, int[] prices, int n, int balance) {
        int[] parents = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            parents[i] = i;
        }

        for (Friendship friendship : friendships) {
            if (find(parents, friendship.a) != find(parents, friendship.b)) {
                union(parents, friendship.a, friendship.b);
            }
        }

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            map.put(find(parents, i), Math.min(prices[i], map.getOrDefault(parents[i], 10000)));
        }

        int price = 0;
        for (Integer value : map.values()) {
            price += value;
        }

        return price <= balance ? String.valueOf(price) : "Oh no";
    }

    private static void union(int[] parents, int a, int b) {
        int aP = find(parents, a);
        int bP = find(parents, b);

        parents[aP] = bP;
    }

    private static int find(int[] parents, int a) {
        if (parents[a] == a) {
            return a;
        }

        return parents[a] = find(parents, parents[a]);
    }

}
