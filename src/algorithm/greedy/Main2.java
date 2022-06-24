package algorithm.greedy;
// 거스름돈 문제

import java.util.Map;
import java.util.TreeMap;

public class Main2 {
    static final int[] coins = {500, 100, 50, 10, 5, 1};

    public static void getChangeCoins(int receivedMoney, int price) {
        Map<Integer, Integer> map = new TreeMap<>((k1, k2) -> k2 - k1);
        int change = receivedMoney - price;

        for (int coin : coins) {
            if (coin <= change) {
                map.put(coin, change / coin);
                change %= coin;
            }
        }
        System.out.println(map);
    }

    public static void main(String[] args) {
        // Test code
        getChangeCoins(1000, 100);
        getChangeCoins(1234, 500);
    }
}
