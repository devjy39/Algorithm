Practice
===

문제 설명
---

문자열 배열 queries 와 문자열 pattern 이 주어졌을 떄,  
queries 중 pattern 과 매칭되는 문자열은 true 아닌 경우 false 로 배열을 구성하여 반환하세요. 

pattern 과의 매칭 여부는,  
patter 각 문자의 전후로 소문자 알파벳을 추가했을 때 만들 수 있는 문자열을 기준으로 한다.

예를 들어,  
"FooBar" 은 패턴 "FB" 를 이용하여 "F" + "oo" + "B" + "oo" 로 만들 수 있다.   
반면, "FooCar" 은 "FB" 를 이용하여 만들 수 없다.

입출력 예시
---
|queries|pattern|결과|
|---|---|---|
|"FooBar", "FooBarTest", "FootBall", "FrameBuffer", "ForceFeedBack"|"FB"|[true, false, true, true, false]|
|"FooBar", "FooBarTest", "FootBall", "FrameBuffer", "ForceFeedBack"|"FoBa"|[true, false, true, false, false]|
|"FooBar", "FooBarTest", "FootBall", "FrameBuffer", "ForceFeedBack"|"FoBaT"|[false, true, false, false, false]|

