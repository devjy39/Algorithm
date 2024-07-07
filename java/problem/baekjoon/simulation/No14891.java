package problem.baekjoon.simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class No14891 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<List<Boolean>> gears = new ArrayList<>();

        for (int i = 0; i < 4; i++) {
            gears.add(new ArrayList<>());
            String str = br.readLine();
            for (int j = 0; j < str.length(); j++) {
                gears.get(i).add(str.charAt(j) == '1');
            }
        }

        int k = Integer.parseInt(br.readLine());

        for (int i = 0; i < k; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int no = Integer.parseInt(st.nextToken());
            int dir = Integer.parseInt(st.nextToken());

            rotateGear(gears, no - 1, dir);
        }

        System.out.println(getScore(gears));
    }

    private static int getScore(List<List<Boolean>> gears) {
        int sum = 0;

        for (int i = 0; i < gears.size(); i++) {
            if (gears.get(i).get(0)) {
                sum += 1 << i;
            }
        }

        return sum;
    }


    static final int LEFT_COG = 6, RIGHT_COG = 2;
    /*  dir : 1 시계, 0 반시계
        no : 톱니바퀴 번호
    * */
    private static void rotateGear(List<List<Boolean>> gears, int no, int dir) {
        int leftGear = no - 1;
        int rightGear = no + 1;

        int curDir = dir * -1;
        boolean curLeftCog = gears.get(no).get(LEFT_COG);
        while (leftGear >= 0) {
            if (curLeftCog ^ gears.get(leftGear).get(RIGHT_COG)) { // 극이 다르면
                curLeftCog = gears.get(leftGear).get(LEFT_COG);
                Collections.rotate(gears.get(leftGear), curDir);
                curDir *= -1;
                leftGear--;
            } else {
                break;
            }
        }

        boolean curRightCog = gears.get(no).get(RIGHT_COG);
        curDir = dir * -1;
        while (rightGear < gears.size()) {
            if (curRightCog ^ gears.get(rightGear).get(LEFT_COG)) { // 극이 다르면
                curRightCog = gears.get(rightGear).get(RIGHT_COG);
                Collections.rotate(gears.get(rightGear), curDir);
                curDir *= -1;
                rightGear++;
            } else {
                break;
            }
        }

        Collections.rotate(gears.get(no), dir);
    }

}
