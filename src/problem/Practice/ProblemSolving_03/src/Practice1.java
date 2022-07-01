package problem.Practice.ProblemSolving_03.src;

import java.util.HashMap;
import java.util.Map;

public class Practice1 {
    public static int solution(String str) {
        Map<String, Integer> map = new HashMap<>(
                Map.of("one", 1, "two", 2, "three", 3, "four", 4, "five", 5,
                        "six", 6, "seven", 7, "eight", 8, "nine", 9, "zero", 0));
        StringBuilder sb = new StringBuilder();

        String temp = "";
        for (char c : str.toCharArray()) {
            if (Character.isDigit(c)) {
                sb.append(c);
            } else {
                temp += c;
            }
            if (temp.length() >= 3) {
                if (map.containsKey(temp)) {
                    sb.append(map.get(temp));
                    temp = "";
                }
            }
        }

        return Integer.parseInt(sb.toString());
    }

    public static void main(String[] args) {
        // Test code
        System.out.println(solution("onetwothreefour"));
        System.out.println(solution("twozerothreezero"));
        System.out.println(solution("three21zero"));
    }
}
