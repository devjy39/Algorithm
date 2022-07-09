package problem.Practice;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Tetris {
    // 테트리스의 블록별 기본형과 변형 형태는 코드로 주어집니다.
    static int[][][][] TETRIS_BLOCK = new int[8][][][];

    static {
        int[][][] BLOCK;
        BLOCK = new int[][][]{
                {{0, 0, 0, 0},
                        {0, 1, 1, 1},
                        {0, 0, 0, 1}},
                {{0, 0, 1},
                        {0, 0, 1},
                        {0, 1, 1}},
                {{0, 0, 0, 0},
                        {0, 1, 0, 0},
                        {0, 1, 1, 1}},
                {{0, 1, 1},
                        {0, 1, 0},
                        {0, 1, 0}}};
        TETRIS_BLOCK[1] = BLOCK;

        BLOCK = new int[][][]{
                {{0, 0, 0, 0},
                        {0, 1, 1, 1},
                        {0, 1, 0, 0}},
                {{0, 1, 1},
                        {0, 0, 1},
                        {0, 0, 1}},
                {{0, 0, 0, 0},
                        {0, 0, 0, 1},
                        {0, 1, 1, 1}},
                {{0, 1, 0},
                        {0, 1, 0},
                        {0, 1, 1}}};
        TETRIS_BLOCK[2] = BLOCK;

        BLOCK = new int[][][]{
                {{0, 0, 1, 0},
                        {0, 1, 1, 1}},
                {{0, 0, 1, 0},
                        {0, 0, 1, 1},
                        {0, 0, 1, 0}},
                {{0, 0, 0, 0},
                        {0, 1, 1, 1},
                        {0, 0, 1, 0}},
                {{0, 0, 1},
                        {0, 1, 1},
                        {0, 0, 1}}};
        TETRIS_BLOCK[3] = BLOCK;

        BLOCK = new int[][][]{{{0, 0, 1},
                {0, 1, 1},
                {0, 1, 0}},
                {{0, 0, 0},
                        {1, 1, 0},
                        {0, 1, 1}}};
        TETRIS_BLOCK[4] = BLOCK;

        BLOCK = new int[][][]{{{0, 1, 0},
                {0, 1, 1},
                {0, 0, 1}},
                {{0, 0, 0},
                        {0, 1, 1},
                        {1, 1, 0}}};
        TETRIS_BLOCK[5] = BLOCK;

        BLOCK = new int[][][]{{{0, 0, 1},
                {0, 0, 1},
                {0, 0, 1},
                {0, 0, 1}},
                {{0, 0, 0, 0},
                        {1, 1, 1, 1}}};
        TETRIS_BLOCK[6] = BLOCK;

        BLOCK = new int[][][]{{{0, 1, 1},
                {0, 1, 1}}};
        TETRIS_BLOCK[7] = BLOCK;

    }

    static class MyBlock {
        int blockNum;
        int blockIdx;
        java.util.List<Point> curBlocks;
        Point standard;

        public MyBlock(int blockNum, int idx, java.util.List<Point> curBlocks) {
            this.blockNum = blockNum;
            this.blockIdx = idx;
            this.curBlocks = curBlocks;
            this.standard = new Point(0, 0);
        }
    }

    static int[][] map;
    static final int H = 15,W = 10;

    public int solution(int[] blocks, String commands) {
        int score = 0;
        map = new int[H][W];
        int idx = 0;

        for (int block : blocks) { //play
            MyBlock my = new MyBlock(block, 0, addBlock(block));
            printMap("add block");

            while (idx<commands.length()) {
                char command = commands.charAt(idx++);

                if (command == 'l') {
                    leftOrRightMove(my, 0, -1);
                } else if (command == 'r') {
                    leftOrRightMove(my, W - 1, 1);
                } else if (command == 'u') { //회전
                    rotateBlock(my);
                } else { // d
                    if (isDuplicate(my)) {
                        return score;
                    }
                    downMove(my);
                    printMap("block down!");

                    score += checkScore(H - 1, H - 1);
                    printMap("check score : " + score);
                    break;
                }
                printMap("command :"+command);
            }
        }

        return score;
    }

    void printMap(String str) {
        System.out.println(str);
        for (int[] m : map) {
            for (int i : m) {
                if (i == 0) {
                    System.out.print("□ ");
                } else {
                    System.out.print("■ ");
                }
            }
            System.out.println();
        }
        System.out.println("--------------------");
    }

    private int checkScore(int curFloor, int ground) {
        if (curFloor < 0) {
            return 0;
        }
        boolean remove = true;
        for (int i = 0; i < W; i++) {
            if (map[curFloor][i] == 0) {
                remove = false;
                break;
            }
        }

        if (remove) {
            return 1 + checkScore(curFloor - 1, ground);
        }

        boolean checkLast = false;
        for (int i = 0; i < W; i++) {
            if (map[ground][i] == 1) {
                checkLast = true;
            }
            map[ground][i] = map[curFloor][i];
        }
        if (!checkLast) {
            return 0;
        }

        return checkScore(curFloor - 1, ground - 1);
    }

    private void downMove(MyBlock my) {
        int distance = getDistance(my.curBlocks);

        java.util.List<Point> newCurBlocks = new ArrayList<>();
        for (Point curBlock : my.curBlocks) {
            map[curBlock.x + distance][curBlock.y]++;
            newCurBlocks.add(new Point(curBlock.x - distance, curBlock.y));
        }

        removeCurBlocks(my.curBlocks);
        my.curBlocks = newCurBlocks;
    }

    private void removeCurBlocks(java.util.List<Point> curBlocks) {
        for (Point curBlock : curBlocks) {
            map[curBlock.x][curBlock.y]--;
        }
    }

    private int getDistance(java.util.List<Point> curBlocks) {
        int distance = Integer.MAX_VALUE;
        for (Point curBlock : curBlocks) {
            int curDist = 0;
            int x = curBlock.x;
            while (++x < H) {
                if (map[x][curBlock.y] == 0) {
                    curDist++;
                } else {
                    break;
                }
            }
            if (curDist != 0) {
                distance = Math.min(distance, curDist);
            }
        }

        return distance;
    }


    private boolean isDuplicate(MyBlock my) {
        java.util.List<Point> curBlocks = my.curBlocks;

        for (Point curBlock : curBlocks) {
            if (map[curBlock.x][curBlock.y] > 1) {
                return true;
            }
        }
        return false;
    }

    private void rotateBlock(MyBlock my) {
        if (my.blockNum == 7) {
            return;
        }
        removeCurBlocks(my.curBlocks);

        my.blockIdx = (my.blockIdx + 1) % TETRIS_BLOCK[my.blockNum].length;
        int[][] newBlocks = TETRIS_BLOCK[my.blockNum][my.blockIdx];
        my.curBlocks.clear();
        my.standard.y += checkWall(my, newBlocks);

        for (int i = 0; i < newBlocks.length; i++) {
            for (int j = 0; j < newBlocks[i].length; j++) {
                if (newBlocks[i][j] == 1) {
                    map[i][j + my.standard.y]++;
                    my.curBlocks.add(new Point(i, j + my.standard.y));
                }
            }
        }
    }

    private int checkWall(MyBlock myBlock, int[][] newBlocks) {
        int adjustY = 0;
        boolean isLeft = false;

        for (int[] newBlock : newBlocks) {
            for (int j = 0; j < newBlock.length; j++) {
                if (newBlock[j] == 1) {
                    int y = j + myBlock.standard.y;
                    if (y < 0) {
                        adjustY = Math.max(adjustY, -myBlock.standard.y);
                        isLeft = true;
                    } else if (y >= W) {
                        adjustY = Math.max(adjustY, y - W + 1);
                    }
                }
            }
        }

        return isLeft ? adjustY : -adjustY;
    }

    private void leftOrRightMove(MyBlock my, int boundary, int dir) {
        if (checkCantMove(boundary)) {
            return;
        }
        my.standard.y += dir;
        java.util.List<Point> newCurBlocks = new ArrayList<>();

        for (Point curBlock : my.curBlocks) {
            map[curBlock.x][curBlock.y]--;

            int x = curBlock.x;
            int y = curBlock.y + dir;
            newCurBlocks.add(new Point(x, y));
            map[x][y]++;
        }

        my.curBlocks = newCurBlocks;
    }

    private boolean checkCantMove(int y) {
        if (y > 0 && y < W - 5) {
            return false;
        }
        for (int i = 0; i < 5; i++) {
            if (map[i][y] == 1) {
                return true;
            }
        }
        return false;
    }

    private java.util.List<Point> addBlock(int block) {
        int[][] curBlock = TETRIS_BLOCK[block][0];
        List<Point> cur = new ArrayList<>();

        for (int i = 0; i < curBlock.length; i++) {
            for (int j = 0; j < curBlock[i].length; j++) {
                if (curBlock[i][j] == 1) {
                    map[i][j]++;
                    cur.add(new Point(i, j));
                }
            }
        }
        return cur;
    }

    public static void main(String[] args) {
        Tetris solution = new Tetris();
        int[] blockTypes = {1, 3, 6, 2, 4, 7, 4, 5, 3};
        String commands = "uulduuuldurrrrrdrrurrrrrduulldrrrldrdrlrrruudurrrrd";

        System.out.println("game score : " + solution.solution(blockTypes, commands));
    }
}