package BOJ.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class No20920 {
    static class Word implements Comparable<Word>{
        int count;
        String word;

        public Word(int count, String word) {
            this.count = count;
            this.word = word;
        }

        @Override
        public int compareTo(Word o) {
            if (this.count != o.count) {
                return Integer.compare(o.count, this.count);
            } else if (this.word.length() != o.word.length()) {
                return Integer.compare(o.word.length(), this.word.length());
            }

            return this.word.compareTo(o.word);
        }

        @Override
        public String toString() {
            return word;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String word = br.readLine();
            if (word.length() >= m) {
                map.put(word, map.getOrDefault(word, 0) + 1);
            }
        }

        List<Word> words = new ArrayList<>(map.size());
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            words.add(new Word(entry.getValue(), entry.getKey()));
        }

        Collections.sort(words);
        StringBuilder result = new StringBuilder();
        for (Word word : words) {
            result.append(word).append("\n");
        }
        System.out.print(result);
    }

}

