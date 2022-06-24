package dataStructure.linear.PracticeProblem.LinearDS_14_2;

import java.util.*;
import java.util.stream.Collectors;

public class Practice5 {
    public static ArrayList<Integer> solution(String[] gems) {
        HashMap<String, Integer> map = new HashMap<>();
        int sum = Arrays.stream(gems).collect(Collectors.toSet()).size();
        int start = 0;
        int min = gems.length;
        int[] result = null;

        for (int end = 0; end < gems.length; end++) {
            if (map.containsKey(gems[end]))
                map.put(gems[end], map.get(gems[end]) + 1);
            else
                map.put(gems[end], 1);

            while (map.size() == sum) {// 다 모음
                if (end - start < min) {
                    result = new int[]{start + 1, end + 1};
                    min = end - start;
                }
                int cnt = map.get(gems[start]) - 1;
                if (cnt == 0) {
                    map.remove(gems[start]);
                } else {
                    map.put(gems[start], cnt);
                }
                start++;
            }
        }
        return (ArrayList<Integer>) Arrays.stream(result).boxed().collect(Collectors.toList());
    }

    public static void main(String[] args) {
        // Test code
        String[] gems = {"DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA"};
        System.out.println(solution(gems));

        gems = new String[]{"AA", "AB", "AC", "AA", "AC"};
        System.out.println(solution(gems));

        gems = new String[]{"XYZ", "XYZ", "XYZ"};
        System.out.println(solution(gems));

        gems = new String[]{"ZZZ", "YYY", "NNNN", "YYY", "BBB"};
        System.out.println(solution(gems));
    }
}
