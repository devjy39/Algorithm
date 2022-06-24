package dataStructure.nonLinear.NonLinearDS_13_2.src;

import java.util.Comparator;
import java.util.PriorityQueue;

class Worker {
    int speed;
    int effi;

    public Worker(int speed, int effi) {
        this.speed = speed;
        this.effi = effi;
    }
}

/* 효율성과 스피드의 최적의 밸런스를 찾아야 하는데 효율성은 가장 낮은 값만 적용되니
*  효율성순으로 정렬 시 처음 픽한 값 중 어떤 값을 바꿔도 효율성은 새 값이 된다.
*  고로 효율성으로 정렬 후 파워가 낮은 값만 바꿔가며 n번만 돌면 된다.. 다 돌아야 함
* */
public class Practice4 {
    public static int solution(int n, int[] speed, int[] efficiency, int k) {
        PriorityQueue<Worker> pq = new PriorityQueue<>(
                (w1, w2) -> w2.effi - w1.effi);
        for (int i = 0; i < speed.length; i++) {
            pq.add(new Worker(speed[i], efficiency[i]));
        }

        PriorityQueue<Worker> speedQ = new PriorityQueue<>(k,
                Comparator.comparingInt(w -> w.speed));

        int sum = 0;
        int perform = 0;

        while (!pq.isEmpty()) {
            Worker worker = pq.poll();
            sum += worker.speed;
            speedQ.add(worker);

            if (speedQ.size() == k) {
                perform = Math.max(perform, sum * worker.effi);
                sum -= speedQ.poll().speed;
            }
        }

        return perform;
    }

    public static void main(String[] args) {
        // Test code
        int[] speed = {2, 10, 3, 1, 5, 8};
        int[] efficiency = {5, 4, 3, 9, 7, 2};
        System.out.println(solution(6, speed, efficiency, 2));
        System.out.println(solution(6, speed, efficiency, 3));
        System.out.println(solution(6, speed, efficiency, 4));
    }
}
