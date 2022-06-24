package dataStructure.linear.PracticeProblem.LinearDS_14_1.src;

import java.util.*;

public class Practice5 {
    public static Integer solution(int n, int k, int l, ArrayList<ArrayList> apples, Queue<ArrayList> moves) {
        int[][] map = new int[n][n];
        map[0][0] = 1;
        int[][] direct = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        for (ArrayList apple : apples) {
            map[(int) apple.get(0) -1][(int) apple.get(1)-1] = 2;
        }

        int time = 0;
        int dir = 0;
        int x = 0, y = 0;
        ArrayList move = moves.poll();
        Queue<int[]> snake = new LinkedList<>(List.of(new int[]{0,0}));

        while (true) {
            x += direct[dir][0];
            y += direct[dir][1];
            if (x < 0 || y < 0 || x >= n || y >= n || map[x][y] == 1) {
                break;
            }

            if (map[x][y] != 2) { // no apple
                int[] poll = snake.poll();
                map[poll[0]][poll[1]] = 0;
            }
            map[x][y] = 1;
            snake.add(new int[]{x, y});

            time++;
            if (move != null && move.get(0).equals(time)) {
                if (move.get(1).equals('D')) {
                    dir = (dir + 1) % direct.length;
                } else {
                    dir = (dir - 1 + direct.length) % direct.length;
                }
                move = moves.poll();
            }
        }

        return time+1;
    }

    private static void printMap(int[][] map) {
        for (int[] ints : map) {
            for (int anInt : ints) {
                System.out.print(anInt+" ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Test code
        int n = 6;
        int k = 3;
        int l = 3;
        ArrayList<ArrayList> apples = new ArrayList();
        apples.add(new ArrayList<>(Arrays.asList(3, 4)));
        apples.add(new ArrayList<>(Arrays.asList(2, 5)));
        apples.add(new ArrayList<>(Arrays.asList(5, 3)));

        Queue<ArrayList> moves = new LinkedList();
        moves.add(new ArrayList(Arrays.asList(3, 'D')));
        moves.add(new ArrayList(Arrays.asList(15, 'L')));
        moves.add(new ArrayList(Arrays.asList(17, 'D')));
        System.out.println((solution(n, k, l, apples, moves)));

        n = 10;
        k = 4;
        l = 4;
        apples.clear();
        apples.add(new ArrayList<>(Arrays.asList(1, 2)));
        apples.add(new ArrayList<>(Arrays.asList(1, 3)));
        apples.add(new ArrayList<>(Arrays.asList(1, 4)));
        apples.add(new ArrayList<>(Arrays.asList(1, 5)));

        moves.clear();
        moves.add(new ArrayList(Arrays.asList(8, 'D')));
        moves.add(new ArrayList(Arrays.asList(10, 'D')));
        moves.add(new ArrayList(Arrays.asList(11, 'D')));
        moves.add(new ArrayList(Arrays.asList(13, 'L')));
        System.out.println((solution(n, k, l, apples, moves)));

        n = 10;
        k = 5;
        l = 4;
        apples.clear();
        apples.add(new ArrayList<>(Arrays.asList(1, 5)));
        apples.add(new ArrayList<>(Arrays.asList(1, 3)));
        apples.add(new ArrayList<>(Arrays.asList(1, 2)));
        apples.add(new ArrayList<>(Arrays.asList(1, 6)));
        apples.add(new ArrayList<>(Arrays.asList(1, 7)));

        moves.clear();
        moves.add(new ArrayList(Arrays.asList(8, 'D')));
        moves.add(new ArrayList(Arrays.asList(10, 'D')));
        moves.add(new ArrayList(Arrays.asList(11, 'D')));
        moves.add(new ArrayList(Arrays.asList(13, 'L')));
        System.out.println((solution(n, k, l, apples, moves)));
    }
}