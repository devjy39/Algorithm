package problem.baekjoon.binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class No11037 {
    static List<Integer> list = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        getList(new boolean[10], 0, 0);
        Collections.sort(list);

        StringBuilder result = new StringBuilder();
        String read;
        while ((read = br.readLine()) != null) {
            int number = Integer.parseInt(read);
            if (number == 0) {
                result.append(1).append('\n');
                continue;
            }
            int index = Collections.binarySearch(list, number);
            index = index >= 0 ? index + 1 : -index - 1;
            result.append(index >= list.size() ? 0 : list.get(index)).append('\n');
        }

        System.out.println(result);
    }

    private static void getList(boolean[] visited, int depth, int number) {
        if (depth >= 10) {
            return;
        }

        list.add(number);
        number *= 10;
        for (int i = 1; i < 10; i++) {
            if (!visited[i]) {
                visited[i] = true;
                getList(visited, depth + 1, number + i);
                visited[i] = false;
            }
        }
    }

}

