Practice
===

문제 설명
---

이 지역에는 과수원들이 많고 각 과수원마다 사과나무를 키우고 있다.  
사과나무 관리를 위해 주 관리사와 부 관리사가 사과나무의 상태를 관리 중이다.  

과수원 당 사과나무의 개수는 appleTrees 배열에 주어진다.  
각 과수원마다 주 관리사는 1명이 있고, 주 관리사가 관리 가능한 나무의 개수는 a 개이다.  
해당 과수원에 주 관리사 만으로 관리가 부족한 경우에는,  
부 관리사가 추가되며 부 관리사 1명 당 관리 가능한 나무의 개수는 b 개 이다.

각 과수원마다 모든 사과 나무를 관리하기 위한 감독관 수의 최소값을 구하는 프로그램을 작성하세요.


입력 형식
---

appleTrees 에 주어지는 과수원의 개수는 1 ~ 1,000,000 사이의 자연수이다.  
과수원 당 사과나무의 개수는 1 ~ 1,000,000 사이의 자연수이다.  
관리 가능한 나무의 개수 a, b 각각 1 ~ 1,000,000 사이의 자연수이다.


출력 형식
---
감독관의 수의 최소값을 반환한다.



입출력 예시
---

| appleTrees               | a   | b   | Result |
|--------------------------|-----|-----|--------|
| {1, 2, 3}                | 1   | 1   | 6      |
| {10, 10, 20, 20, 30, 30} | 5   | 3   | 38     |