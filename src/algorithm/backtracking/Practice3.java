package algorithm.backtracking;
// Practice3
// sols 배열에 5지 선다 문제의 정답들이 적혀있다.
// 3번 연속 해서 같은 정답이 있는 경우가 없다는 것을 알아낸 후,
// 문제를 찍어서 푼다고 할 때, 5점 이상을 받을 경우의 수를 출력하세요.

// 문제는 총 10문제이며 각 문제당 1점이다.

// 입출력 예시
// sols: {1, 2, 3, 4, 5, 1, 2, 3, 4, 5}
// 결과: 261622


public class Practice3 {
    final static int numOfProblems = 10;
    final static int SCORE = 5;
    static int cnt;

    public static void solution(int[] sols) {
        if (sols == null || sols.length != numOfProblems) {
            return;
        }

        backTracking(new int[numOfProblems], sols, 0, 0);
        System.out.println(cnt);
    }

    private static void backTracking(int[] problem, int[] sols, int correct, int depth) {
        if (depth == numOfProblems) { // 합격할 경우의 수니까 중간 합격이어도 뒤를 봐야하고
            if (correct >= SCORE) {
                cnt++;
            }
            return;
        } else if (numOfProblems - depth + correct < 5) { //남은거 다맞아도 탈락이므로 뒤를 볼 필요가 없음
            return;
        }

        int notCoorect = 0;
        if (depth > 1 && problem[depth - 1] == problem[depth - 2]) {
            notCoorect = problem[depth - 1];
        }

        for (int i = 1; i <= 5; i++) {
            if (i == notCoorect) {
                continue;
            }
            problem[depth] = i;
            if (sols[depth] == i) {
                backTracking(problem, sols, correct + 1, depth + 1);
            } else {
                backTracking(problem, sols, correct, depth + 1);
            }
        }
    }

    public static void main(String[] args) {
        // Test code
        int[] sols = {1, 2, 3, 4, 5, 1, 2, 3, 4, 5};
        solution(sols);

        sols = new int[] {1, 1, 2, 2, 3, 3, 4, 4, 5, 5};
        solution(sols);
    }
}
