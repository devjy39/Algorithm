package problem.baekjoon.backTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No1062 {
    static final char[] defaultWords = {'a', 'n', 't', 'i', 'c'};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        boolean[] needAlpha = new boolean[26];
        for (char defaultWord : defaultWords) {
            needAlpha[defaultWord - 'a'] = true;
        }

        String[] words = new String[n];
        for (int i = 0; i < n; i++) {
            words[i] = br.readLine();
            for (int j = 4; j < words[i].length() - 4; j++) {
                needAlpha[words[i].charAt(j) - 'a'] = true;
            }
        }

        int needCount = 0;
        for (boolean isNeed : needAlpha) {
            if (isNeed) {
                needCount++;
            }
        }

        if (m < defaultWords.length) { // 기본알파벳 개수보다 부족한 경우
            System.out.println(0);
        } else if (needCount <= m) { // 필요한 알파벳 개수보다 많은 경우 (다 가능)
            System.out.println(n);
        } else {
            boolean[] visited = new boolean[needAlpha.length];
            for (char defaultWord : defaultWords) {
                visited[defaultWord - 'a'] = true;
            }
            System.out.println(getMaxWord(words, needAlpha, visited, m - defaultWords.length, 0, 0));
        }
    }

    private static int getMaxWord(String[] words, boolean[] needAlpha, boolean[] visited, int m, int prev, int depth) {
        if (depth >= m) {
            return getWordCount(words, visited);
        }

        int result = 0;
        for (int i = prev; i < needAlpha.length; i++) {
            if (needAlpha[i] && !visited[i]) {
                visited[i] = true;
                result = Math.max(result, getMaxWord(words, needAlpha, visited, m, i + 1, depth + 1));
                visited[i] = false;
            }
        }

        return result;
    }

    private static int getWordCount(String[] words, boolean[] visited) {
        int result = 0;

        for (String word : words) {
            boolean check = true;
            for (int i = 4; i < word.length() - 4; i++) {
                if (!visited[word.charAt(i) - 'a']) {
                    check = false;
                    break;
                }
            }

            if (check) {
                result++;
            }
        }

        return result;
    }

}

