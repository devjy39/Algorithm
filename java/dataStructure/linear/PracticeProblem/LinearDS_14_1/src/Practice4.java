package dataStructure.linear.PracticeProblem.LinearDS_14_1.src;

import java.util.HashMap;
import java.util.Stack;

public class Practice4 {
    public static void solution(String str) {
        Stack<Character> stack = new Stack<>();
        HashMap<Character, Character> map = new HashMap<>();
        map.put('[', ']');
        map.put('{', '}');
        map.put('(', ')');

        for (char c : str.toCharArray()) {
            if (map.containsKey(c)) {
                stack.push(c);
            } else if (map.containsValue(c)) {
                if (stack.isEmpty() || map.get(stack.pop()) != c) {
                    System.out.println("Fail");
                    return;
                }
            }
        }

        if(stack.isEmpty())
            System.out.println("Pass");
        else
            System.out.println("Fail");
    }

    public static void main(String[] args) {
        // Test code
        solution("[yyyy]-[mm]-[dd]");               // Pass
        solution("System.out.println(arr[0][1))");  // FAIL
        solution("Support [Java or Python(3.x)]");  // PASS
        solution("([[{}])");                        // FAIL
    }
}
