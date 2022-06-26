package algorithm.practice.practice2.src;

import java.util.Arrays;

/*
*   일단 최소 단위인 1이 있어야 함. 아니면 답이 무조건 1이 됨, 1은 만들 수 없기 때문
*   정렬을 먼저 하면 greedy 방식으로 풀 수 있다
*   최소 단위 수 부터 어디까지 만들 수 있는 수 인가를 구할 수 있음
*   예를들어 5까지 만들 수 있고 다음 수가 10이라면 10~15(앞서 확정된 5)가 확정된다.
*   이런 방식으로 최대 만들 수 있는 수가 다음 수보다 크지 않다면, 수를 끊기지 않고 만들 수 있는 것.
*   1 -> 1까지 만들 수 있음
*   1 -> 2까지 만들 수 있음
*   2 -> 4
*   3 -> 7
*   6 -> 13
*   7 -> 20
*   30 -> 30 ~ 50을 확보 했으나 30은 20보다 크기 때문에 21 ~ 29는 만들 수 없음.
* */
public class Practice3 {
    public static int solution(int[] weights) {
        Arrays.sort(weights);

        int prevSum = 1; //1이 없으면 1이 무조건 답이므로

        for (int weight : weights) {
            System.out.println(prevSum+" "+weight);
            if (weight <= prevSum) {
                prevSum += weight;
            } else {
                break;
            }
        }

        return prevSum;
    }

    public static void main(String[] args) {
        // Test code
        int[] weights = {6, 1, 2, 3, 1, 7, 30};
        System.out.println(solution(weights));
    }
}
