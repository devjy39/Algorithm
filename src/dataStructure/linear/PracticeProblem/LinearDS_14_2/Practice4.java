package dataStructure.linear.PracticeProblem.LinearDS_14_2;

import java.util.HashMap;

public class Practice4 {
    public static String solution(String[] participant, String[] completion) {
        HashMap<String, Integer> map = new HashMap<>();
        map.put(participant[completion.length], 1);

        for (int i = 0; i < completion.length; i++) {
            String[] arr = {participant[i], completion[i]};
            for (int j = 0; j < 2; j++) {
                if (!map.containsKey(arr[j])) {
                    map.put(arr[j], -2 * j + 1);
                } else {
                    int cnt = map.get(arr[j]) + -2 * j + 1;
                    if (cnt == 0) {
                        map.remove(arr[j]);
                    } else {
                        map.put(arr[j], cnt);
                    }
                }
            }
        }

        return map.keySet().stream().findFirst().get();
    }

    public static void main(String[] args) {
        // Test code
        String[] participant = {"leo", "kiki", "eden"};
        String[] completion = {"eden", "kiki"};
        System.out.println(solution(participant, completion));

        participant = new String[]{"marina", "josipa", "nikola", "vinko", "filipa"};
        completion = new String[]{"josipa", "filipa", "marina", "nikola"};
        System.out.println(solution(participant, completion));

        participant = new String[]{"mislav", "stanko", "mislav", "ana"};
        completion = new String[]{"stanko", "ana", "mislav"};
        System.out.println(solution(participant, completion));
    }
}
