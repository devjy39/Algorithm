package dataStructure.math.practice1;

import java.util.ArrayList;

public class Practice1 {
    public static ArrayList<ArrayList<Integer>> solution(int numRows) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>(numRows); 

        for (int i = 0; i < numRows; i++) {
            ArrayList<Integer> list = new ArrayList<>();
            list.add(1);
            for (int j = 1; j < i; j++) {
                list.add(result.get(i-1).get(j-1)+result.get(i-1).get(j));
            }
            list.add(1);

            result.add(list);
        }
        return result;
    }

    public static void main(String[] args) {
        // Test code
        System.out.println(solution(1));
        System.out.println(solution(2));
        System.out.println(solution(3));
        System.out.println(solution(4));
        System.out.println(solution(5));
    }
}
