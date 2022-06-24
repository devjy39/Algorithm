Practice
===

문제 설명
---

row x col 행렬 형태의 board 와 word 문자열이 주어졌을 때,  
해당 행렬에서 word 문자열이 인접하게 연결되어 있는지를 확인하는 프로그램을 작성하세요.

아래와 같은 행렬에서 word 로 "ABCCED" 가 주어진 경우 다음과 같이 인접해 있음을 확인할 수 있다.

인접하게 구성이되면 true 를 반환하고 그렇지 않으면 false 를 반환하시오.

![img_1.png](../imgs/img_1.png)

입출력 예시
---
|board|word|결과|
|---|---|---|
|{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}|"ABCCED"|true|
|{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}|"SEE"|true|
|{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}|"ABCB"|false|

