package dataStructure.nonLinear.graph.practices;
// Practice3
// 주어진 그래프를 두 개의 그래프로 분리할 수 있는지 확인 하는 프로그램을 작성하세요.
// 분리 조건: 인접하지 않은 노드끼리 분리

// 모든 노드는 연결되어 있다.
// 분리 가능하면 true, 불가능하면 false 출력

// 예시 입력)
// 그래프: {{1, 3}, {0, 2}, {1, 3}, {0, 2}}
// 출력: true

// 그래프: {{1, 2, 3}, {0, 2}, {0, 1, 3}, {0, 2}}
// 출력: false

import java.util.Arrays;

public class Practice3 {
    public static void solution(int[][] graph) {
        //노드에 1 인접 노드에 -1을 세팅하는 아이디어
        int[] flags = new int[graph.length];
        flags[0] = 1;
        for (int i = 0; i < graph.length; i++) {
            for (int adjNode : graph[i]) {
                if (flags[adjNode] == 0) {
                    flags[adjNode] = flags[i] * -1;
                } else if (flags[adjNode] == flags[i]) {
                    System.out.println("false");
                    System.out.println(Arrays.toString(flags));
                    return;
                }
            }
        }
        System.out.println(Arrays.toString(flags));
        System.out.println("true");
    }

    public static void main(String[] args) {
        // Test code
        int[][] graph = {{1, 3}, {0, 2}, {1, 3}, {0, 2}};
        solution(graph);

        graph = new int[][]{{1, 2, 3}, {0, 2}, {0, 1, 3}, {0, 2}};
        solution(graph);
    }
}
