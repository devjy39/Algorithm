package algorithm.binarySearch.binSearchProblem;// Practice4
// 정수형 배열 weights 와 정수 days 가 주어졌다.
// weights 에는 각 상품의 무게들의 정보가 들어있고, days 는 운송 납기일이다.
// 상품들은 weights 에 적혀있는 순서대로 실어서 운송해야 하는데,
// days 이내에 운송을 하기 위한 차량의 최소한의 적재량을 계산하는 프로그램을 작성하세요.

// 입출력 예시
// weights: 1, 2, 3, 4, 5, 6, 7, 8, 9, 10
// days: 5
// 출력: 15

// weights: 3, 2, 2, 4, 1, 4
// days: 3
// 출력: 6

import java.util.Arrays;

// 난이도 *****
public class Practice4 {
    public static int solution(int[] weights, int days) {
        int left = weights[weights.length - 1];
        int right = Arrays.stream(weights).sum();

        while (left <= right) {
            int mid = (left + right) >> 1;
            int getDay = getDays(weights, mid);

            if (getDay < days) {
                right = mid - 1;
            } else if (getDay > days) {
                left = mid + 1;
            } else {
                if (getDay != getDays(weights, mid - 1)) {
                    return mid;
                }
                right = mid;
            }
        }

        return -1;
    }

    private static int getDays(int[] weights, int total) {
        int days = 1;
        int sum = 0;
        for (int weight : weights) {
            if (sum + weight > total) {
                days++;
                sum = 0;
            }
            sum += weight;
        }

        return days;
    }

    public static void main(String[] args) {
        // Test code
        int[] weights = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        System.out.println("??"+getDays(weights,10));
        System.out.println(solution(weights, 5));   // 15

        weights = new int[]{3, 2, 2, 4, 1, 4};
        System.out.println(solution(weights, 3));   // 6
    }
}
