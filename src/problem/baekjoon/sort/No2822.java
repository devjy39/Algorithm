package problem.baekjoon.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class No2822 {
    static class Score {
        int index;
        int score;

        public Score(int index, int score) {
            this.index = index;
            this.score = score;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int amount = 8;
        Score[] scores = new Score[amount];
        for (int i = 0; i < amount; i++) {
            scores[i] = new Score(i + 1, Integer.parseInt(br.readLine()));
        }

        Arrays.sort(scores, (s1, s2) -> Integer.compare(s2.score, s1.score));
        Arrays.sort(scores, 0, 5, Comparator.comparingInt(s -> s.index));

        int sum = 0;
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < 5; i++) {
            sum += scores[i].score;
            result.append(scores[i].index).append(" ");
        }

        System.out.println(sum + "\n" + result);
    }

}

