package problem.baekjoon.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class No10825 {
    static class Score implements Comparable<Score> {
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

        @Override
        public int compareTo(Score o) {
            if (this.language != o.language) {
                return Integer.compare(o.language, this.language);
            }
            if (this.english != o.english) {
                return Integer.compare(this.english, o.english);
            }
            if (this.math != o.math) {
                return Integer.compare(o.math, this.math);
            }

            return name.compareTo(o.name);
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

        Arrays.sort(scores);
        StringBuilder result = new StringBuilder();
        for (Score score : scores) {
            result.append(score.name).append('\n');
        }
        System.out.println(result);
    }

}

