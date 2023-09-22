package problem.baekjoon.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class No10825 {
    static class Score {
        String name;
        int language;
        int english;
        int math;

        public Score(String name, int language, int english, int math) {
            this.name = name;
            this.language = language;
            this.english = english;
            this.math = math;
        }

        public String getName() {
            return name;
        }

        public int getLanguage() {
            return language;
        }

        public int getEnglish() {
            return english;
        }

        public int getMath() {
            return math;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Score[] scores = new Score[n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            String name = st.nextToken();
            int language = Integer.parseInt(st.nextToken());
            int english = Integer.parseInt(st.nextToken());
            int math = Integer.parseInt(st.nextToken());

            scores[i] = new Score(name, language, english, math);
        }

        Arrays.sort(scores, Comparator.comparingInt(Score::getLanguage).reversed()
                .thenComparingInt(Score::getEnglish)
                .thenComparing(Comparator.comparingInt(Score::getMath).reversed())
                .thenComparing(Score::getName));

        StringBuilder result = new StringBuilder();
        for (Score score : scores) {
            result.append(score.name).append('\n');
        }
        System.out.println(result);
    }

}

