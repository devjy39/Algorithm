Practice
===

문제 설명
---

이메일 정보를 병합하는 프로그램을 구현하려고 한다.  
이메일 정보가 들어있는 2차원 문자열 배열 accounts 가 주어졌고,  
각각의 accounts[i] 에 대해 accounts[i][0] 에는 사람 이름을, 나머지는 이메일을 나타낸다.

<br/>

주어진 이메일 정보에는 한 사람이 여러 이메일을 소유하기도, 동명이인이 있기도 하다.
- 이름이 같고 이메일이 다르면 동명이인이다.
- 이름이 같고 이메일 중 같은 이메일이 있으면 동일 인이다.


주어진 이메일을 정보를 병합하고 출력하는 프로그램을 작성하세요. 


입출력 예시
---
|입력|결과|
|---|---|
|"John", "john@mail.com", "john_lab@mail.com" <br/> "John", "john@mail.com", "john02@mail.com" <br/> "Mary", "mary@mail.com" <br/> "John", "johnnybravo@mail.com"|"John, johnnybravo@mail.com" <br/> "John, john02@mail.com, john@mail.com, john_lab@mail.com" <br/> Mary, mary@mail.com|

