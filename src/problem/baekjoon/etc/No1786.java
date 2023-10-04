import java.io.*;
import java.util.*;

public class No1786 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] text = br.readLine().toCharArray();
        char[] pattern = br.readLine().toCharArray();

        int[] pi = new int[pattern.length];

        for (int i = 1, j = 0; i < pattern.length; i++) {
            while (j > 0 && pattern[i] != pattern[j]) {
                j = pi[j - 1];
            }

            if (pattern[i] == pattern[j]) {
                pi[i] = ++j;
            } else {
                pi[i] = 0;
            }
        }

        List<Integer> list = new ArrayList<>();

        // i : text , j : pattern
        for (int i = 0, j = 0; i < text.length; ++i) {
            while (j > 0 && text[i] != pattern[j]) {
                j = pi[j - 1];
            }

            if (text[i] == pattern[j]) { // 일치
                if (j == pattern.length - 1) { // 찾음
                    list.add(i - j + 1);
                    j = pi[j];
                } else {
                    j++;
                }
            }

        }

        StringBuilder result = new StringBuilder();
        result.append(list.size()).append('\n');
        for (int index : list) {
            result.append(index).append('\n');
        }
        System.out.println(result);
    }

}

