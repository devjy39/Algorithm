package problem.Practice.ProblemSolving_02.src;

import java.util.LinkedList;
import java.util.Queue;

public class Practice4 {
    public static int solution(int cacheSize, String[] searches) {
        Queue<String> cache = new LinkedList<>();
        int size = 0;
        int time = 0;

        for (String search : searches) {
            search = search.toLowerCase();
            if (cache.contains(search)) {
                time += 1;
                cache.remove(search);
                cache.add(search);
            } else {
                time += 5;
                if (size < cacheSize) {
                    size++;
                    cache.add(search);
                } else { // 교체
                    cache.remove();
                    cache.add(search);
                }
            }
        }

        return time;
    }

    public static void main(String[] args) {
        // Test code 5 1 5 5 5 5 1
        String[] searches = {"Google", "Google", "Microsoft", "Apple", "Qualcomm", "Google", "Qualcomm"};
        System.out.println(solution(3, searches));
    }
}
