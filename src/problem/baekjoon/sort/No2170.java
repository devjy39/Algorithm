package problem.baekjoon.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class No2170 {
    static class Line {
        int start;
        int end;

        public Line(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<Line> lines = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            lines.add(new Line(s, e));
        }

        System.out.println(getResult(lines));
    }

    private static int getResult(List<Line> lines) {
        lines.sort(Comparator.comparingInt(l -> l.start));
        int result = 0;
        int start = Integer.MIN_VALUE;
        int end = Integer.MIN_VALUE;

        for (Line line : lines) {
            if (line.start <= end) {
                end = Math.max(end, line.end);
            } else {
                result += end - start;
                start = line.start;
                end = line.end;
            }
        }

        return result + end - start;
    }

}

