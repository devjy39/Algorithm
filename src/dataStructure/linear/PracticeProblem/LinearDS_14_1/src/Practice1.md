Practice
===

문제 설명
---
과거에 하기의 modification 함수를 이용해 배열 내 데이터 순서를 변경했었다.

- 최근에 이 변경한 데이터들을 다시 원래의 배열 순서로 변경해야 하는 일이 생겼다.
- 아래의 modification 코드를 분석 후 되돌리는 코드를 작성하세요.


```java
public static int[] modification(int[] arr) {
        int[] arrNew = new int[arr.length];

        int idx = 0;
        int cnt = 0;
        int val = arr[idx];

        while (cnt < arr.length) {
            while (val == 0) {
                idx = (idx + 1) % arr.length;
                val = arr[idx];
            }
            arrNew[cnt++] = val;
            arr[idx] = 0;
            idx = (val + idx) % arr.length;
            val = arr[idx];
        }
        return arrNew;
    }
```

Modification 당시 입출력 샘플
---
|입력|출력|
|---|---|
|1 3 5 7 9|1 3 7 9 5|
|3 6 8 2|3 2 6 8|

되돌리기 입출력 예시
---
|입력|출력|
|---|---|
|1 3 7 9 5|1 3 5 7 9|
|3 2 6 8|3 6 8 2|


