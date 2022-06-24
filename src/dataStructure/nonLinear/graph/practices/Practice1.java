package dataStructure.nonLinear.graph.practices;
// Practice1
// Center Node 찾기
// Undirected 그래프에서 center node 를 출력하세요.
// Center node 는 다른 모든 노드와 연결된 노드를 의미
// 다른 노드와 연결된 노드는 하나라고 가정

// 입력 그래프: {{1, 2}, {2, 3}, {4, 2}}
// 출력: 2

// 입력 그래프: {{1,2}, {5,1}, {1,3}, {1,4}}
// 출력: 1

class MyGraphMatrix {
    char vertices[];
    int[][] adjMat;
    int elemCnt;

    public  MyGraphMatrix() {}
    public MyGraphMatrix(int size) {
        this.vertices = new char[size];
        this.adjMat = new int[size][size];
        this.elemCnt = 0;
    }

    public boolean isFull() {
        return this.elemCnt == this.vertices.length;
    }

    public void addVertex(char data) {
        if (isFull()) {
            System.out.println("Graph is full!");
            return;
        }

        this.vertices[this.elemCnt++] = data;
    }

    public void addEdge(int x, int y) {
        this.adjMat[x][y] = 1;
        this.adjMat[y][x] = 1;
    }
}


public class Practice1 {
    public static int solution(int[][] e) {
        MyGraphMatrix graph = new MyGraphMatrix(e.length + 1);
        for (int[] ints : e) {
            graph.addEdge(ints[0] - 1, ints[1] - 1);
        }
        int result = 0;

        for (int i = 0; i < graph.adjMat.length; i++) {
            int cnt = 0;
            for (int id : graph.adjMat[i]) {
                if (id == 1) {
                    cnt++;
                }
            }
            if (cnt == e.length) {
                result = i+1;
                break;
            }
        }

        return result;
    }

    public static int solution2(int[][] e) {
        return 0;
    }

    public static void main(String[] args) {
        // Test code
        int[][] edges = {{1, 2}, {2, 3}, {4, 2}};
        System.out.println(solution(edges));
        System.out.println(solution2(edges));
        System.out.println();
        
        edges = new int[][]{{1,2}, {5,1}, {1,3}, {1,4}};
        System.out.println(solution(edges));
        System.out.println(solution2(edges));
    }
}
