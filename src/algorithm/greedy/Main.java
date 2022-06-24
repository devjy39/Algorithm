package algorithm.greedy;
/* 알고리즘 - 그리디 알고리즘
*   빠르지만, 최적해를 보장하지 못한다.
*   적용 가능한 경우.:
*   1. 탐욕적 선택 특성 : 지금 선택이 다음 선택에 영향이 없어야 한다. -> 워딩 그대로 해석하지 말고
*   - ex)500,100,50,10 원의 경우 -> 500원을 100원으로 구성이 가능하여 대체(sub problem)가 되지만, 영향이 없는 것
*   - ex)500,400,100,50,0 일 경우 -> 400원을 500원으로 만들 수 없으므로 대체제가 아니다. 영향이 있음
*   - 순서나 나열 기준을 바꿔서 탐욕이 가능하게 만들 수도 있다.
*   2. 최적 부분 구조 : 전체 문제의 최적해는 부분 문제의 최적해가 되어야한다.
* */
// Activity Selection Problem

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class Activity {
    String name;
    int start;
    int end;

    public Activity(String name, int start, int end) {
        this.name = name;
        this.start = start;
        this.end = end;
    }
}

public class Main {
    public static void selectActivity(ArrayList<Activity> list) {
        // 종료시간 기준 오름차순 정렬
        Collections.sort(list, Comparator.comparingInt(a -> a.end));
        int endTime = 0;
        for (Activity activity : list) {
            if (endTime <= activity.start) {
                System.out.print(activity.name+" ");
                endTime = activity.end;
            }
        }

    }

    public static void main(String[] args) {
        // Test code
        ArrayList<Activity> list = new ArrayList<>();
        list.add(new Activity("A", 1, 5));
        list.add(new Activity("B", 4, 5));
        list.add(new Activity("C", 2, 3));
        list.add(new Activity("D", 4, 7));
        list.add(new Activity("E", 6, 10));
        selectActivity(list);
    }
}
