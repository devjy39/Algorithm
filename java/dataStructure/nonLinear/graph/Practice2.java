package dataStructure.nonLinear.graph;
// Practice2
// 인접 행렬 그래프의 DFS, BFS

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class MyGraphMatrix2 extends MyGraphMatrix {

    public MyGraphMatrix2(int size) {
        super(size);
    }

    public void dfs(int id) {
        boolean[] visited = new boolean[this.eleCnt];
        Stack<Integer> stack = new Stack();
        stack.push(id);
        visited[id] = true;

        while (!stack.isEmpty()) {
            int idx = stack.pop();
            System.out.print(this.vertices[idx]+" ");
            for (int i = 0; i < this.eleCnt; i++) { // 방문 갈림길 순서 설정
                if (this.map[idx][i] == 1 && visited[i] == false) {
                    visited[i] = true;
                    stack.push(i);
                }
            }
        }
        System.out.println();
    }

    public void bfs(int id) {
        boolean[] visited = new boolean[this.eleCnt];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(id);
        visited[id] = true;

        while (!queue.isEmpty()) {
            int idx = queue.poll();
            System.out.print(this.vertices[idx] + " ");
            for (int i = 0; i < this.eleCnt; i++) {
                if (this.map[idx][i] == 1 && visited[i] == false) {
                    visited[i] = true;
                    queue.add(i);
                }
            }
        }
        System.out.println();
    }
}

public class Practice2 {
    public static void main(String[] args) {
        // Test code
        MyGraphMatrix2 graph = new MyGraphMatrix2(7);
        graph.addVertex('A');   // 0
        graph.addVertex('B');   // 1
        graph.addVertex('C');   // 2
        graph.addVertex('D');   // 3
        graph.addVertex('E');   // 4
        graph.addVertex('F');   // 5
        graph.addVertex('G');   // 6

        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(0, 3);
        graph.addEdge(1, 4);
        graph.addEdge(2, 5);
        graph.addEdge(3, 4);
        graph.addEdge(3, 5);
        graph.addEdge(4, 6);
        graph.addEdge(5, 6);

        graph.dfs(0);
        graph.bfs(0);
    }
}
