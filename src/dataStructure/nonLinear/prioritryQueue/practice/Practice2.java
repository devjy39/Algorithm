package dataStructure.nonLinear.prioritryQueue.practice;
// Practice2
// 돌의 무게 데이터로 이루어진 정수형 stones 배열이 주어졌을 때 다음의 내용에 따라 프로그램을 작성하세요.
// 해당 배열로부터 가장 무게가 많이 나가는 돌 두개를 꺼내세요.
// 두 개의 돌을 충돌시키는데, 무게가 같으면 둘다 소멸,
// 무게가 다르면 남은 무게만큼의 돌은 다시 추가합니다.
// 이 과정을 반복하며 가장 마지막의 돌의 무게를 출력하세요.

// 입출력 예시
// 입력: 2, 7, 4, 1, 8, 1
// 출력: 1

// 입력: 5, 3, 5, 3, 4
// 출력: 2

// 힙을 사용하기 좋은 문제 -> 추가할 원소도 계속 삽입정렬되고, 최소나 최대값을 계속 추출해야 할 때,

import java.util.PriorityQueue;

public class Practice2 {
    public static void solution(int[] stones) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((x, y) -> y - x);

        for (int stone : stones) {
            priorityQueue.add(stone);
        }

        while (priorityQueue.size() != 1) {
            int diff = Math.abs(priorityQueue.poll() - priorityQueue.poll());
            if(diff!=0)
                priorityQueue.offer(diff);
        }

        System.out.println(priorityQueue.peek());
    }

    public static void main(String[] args) {
        // Test code
        int[] stones = {2, 7, 4, 1, 8, 1};
        solution(stones);

        stones = new int[]{5, 3, 5, 3, 4};
        solution(stones);
    }
}
