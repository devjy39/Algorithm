package problem.baekjoon.divide_conquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No2571 {

    static final int MAX_SIZE = 100;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] papers = new int[MAX_SIZE + 1][MAX_SIZE + 1];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            draw(papers, x, y);
        }

        accumulatedSum(papers);
        int maxArea = 0;
        for (int[] paper : papers) {
            maxArea = Math.max(maxArea, getMaxArea(paper, 0, MAX_SIZE));
        }

        System.out.println(maxArea);
    }

    private static void accumulatedSum(int[][] papers) {
        for (int i = 1; i <= MAX_SIZE; i++) {
            int sum = 0;
            for (int j = 1; j <= MAX_SIZE; j++) {
                if (papers[j][i] > 0) {
                    papers[j][i] = ++sum;
                } else {
                    sum = 0;
                }
            }
        }
    }

    private static int getMaxArea(int[] paper, int left, int right) {
        if (left >= right) {
            return left == right ? paper[left] : 0;
        }

        int mid = (left + right) >> 1;
        int leftMaxArea = getMaxArea(paper, left, mid - 1);
        int rightMaxArea = getMaxArea(paper, mid + 1, right);

        return Math.max(centerMaxArea(paper, left, right), Math.max(leftMaxArea, rightMaxArea));
    }

    private static int centerMaxArea(int[] paper, int left, int right) {
        int mid = (left + right) >> 1;

        int min = mid - 1;
        int max = mid + 1;
        int count = 1;
        int h = paper[mid];
        int maxSum = count * h;

        while (min >= left && max <= right) {
            if (paper[min] > paper[max]) {
                h = Math.min(h, paper[min--]);
            } else {
                h = Math.min(h, paper[max++]);
            }

            maxSum = Math.max(maxSum, h * ++count);
        }

        while (min >= left) {
            h = Math.min(h, paper[min--]);
            maxSum = Math.max(maxSum, h * ++count);
        }

        while (max <= right) {
            h = Math.min(h, paper[max++]);
            maxSum = Math.max(maxSum, h * ++count);
        }
        return maxSum;
    }

    private static void draw(int[][] papers, int x, int y) {
        for (int row = 0; row < 10; row++) {
            for (int col = 0; col < 10; col++) {
                papers[x + row][y + col] = 1;
            }
        }
    }

}

