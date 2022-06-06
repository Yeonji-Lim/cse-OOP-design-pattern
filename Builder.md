# 빌더 패턴

객체 생성 로직을 클래스 밖으로 옮길 필요가 있다.

-> 서로 연관된 복잡한 생성자를 가지고 있는 경우

역할을 분담하고 단일 책임을 가지게 하기 위해서

"점차적인 데이터" : 모든 데이터가 한꺼번에 제공되지 못한다.

<img width="277" alt="image" src="https://user-images.githubusercontent.com/57888020/172164177-1af577f1-c34f-4b24-9946-0e80d4b548c9.png">

파서가 발견한 속성을 저장한다.

Reservation 객체를 구축한다.

생성자는 protected로

## 빌더를 사용하는 이유

Reservation을 단순화 -> 다른 작업에 집중

Scanner를 사용하여 점진적으로 생성한다.

예외 생성

## 의도

객체 생성 로직을 클래스 밖으로 옮김

## 동기

생성자의 복잡성

비즈니스 룰의 복잡성

한번에 모든 생성 데이터가 없을 때

## 단계적 생성

파서, UI를 통하여 객체의 파라미터를 수집하는 경우