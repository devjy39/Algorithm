package dataStructure.linear.PracticeProblem.LinearDS_14_1.src;

import java.util.ArrayList;
import java.util.LinkedList;

public class Practice3 {
    public static void solution(int[] data) {
        ArrayList<Integer> result = new ArrayList<>(data.length);
        int idx = 0;
        int sign = 1;
        for (int i = 0; i < data.length; i++) {
            while (data[idx] == 0) {
                idx = (idx + sign + data.length) % data.length;
            }
            result.add(idx + 1);

            int val = data[idx];
            data[idx] = 0;
            sign = val > 0 ? 1 : -1;
            idx = (idx + val + data.length) % data.length;
        }

        System.out.println(result);
    }

    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<>();

        int[] balloon = {3, 2, 1, -3, -1};
        solution(balloon);

        System.out.println();
        balloon = new int[]{3, 2, -1, -2};
        solution(balloon);
    }
}
