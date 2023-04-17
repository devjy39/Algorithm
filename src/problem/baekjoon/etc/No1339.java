package problem.baekjoon.etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class No1339 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String str = br.readLine();

            for (int j = 0; j < str.length(); j++) {
                char c = str.charAt(j);
                map.put(c, map.getOrDefault(c, 0) + (int) (Math.pow(10, str.length() - 1 - j)));
            }

        }

        System.out.println(getMaxResultNumber(map));
    }

    private static int getMaxResultNumber(Map<Character, Integer> map) {
        List<Integer> list = new ArrayList<>(map.values());
        list.sort(Collections.reverseOrder());

        int result = 0;
        int number = 9;
        for (int wordNumber : list) {
            result += wordNumber * number;
            number--;
        }

        return result;
    }

}
