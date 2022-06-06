# 책임 체인 패턴

도움말 시스템을 생각해보자

단일 도움말 시스템이 모든 도움말에 해당하는 것을 한번에 다 가지고 있지 않는다. 

사용자의 현재 위치와 상태에 따라 적절한 도움말을 제시해준다.

이때 상태 객체를 이용하여 상태에 따라 다르게 도움말을 보여주게 하여

활성화된 GUI 객체가 도움말을 보여줄 수 있다면 해당 객체에 도움말 기능을 맡김

만일 없으면 가장 최근 상태에 따라 도움말 제시하게 할 수 있다.

이렇게 하는 경우 도움말 관련 기능을 한군데로 모을 수 있고, 관리와 기능 확장이 용이하다.

하지만 클라이언트 코드의 각 부분에서 상태를 설정해주는 메소드가 있어야하고 새로운 상태와 도움말이 추가되면 상태 설정 함수도 추가되어야 한다.

이런 상황을 해결하고자 하는 것이 책임 체인 패턴

- 현재 GUI 객체가 도움말을 가지고 있다면 보여줌
- 없다면 자신을 포함하고 있는 상위 GUI 객체에게 도움말 처리 요청 (상위 GUI 객체와 연결이 되어 있어야)

-> 책임을 분산해서 결합력을 약하게 한다.

<img width="410" alt="image" src="https://user-images.githubusercontent.com/57888020/172096699-baa040a4-5e7f-4dab-b3dd-c50a44699a59.png">

<img width="430" alt="image" src="https://user-images.githubusercontent.com/57888020/172096745-d20b16d2-aecf-4633-afeb-cd0f4347fc59.png">

## 분석

특정 요청에 대해 이를 처리하는 객체를 고정하지 않는다.

요청을 보내는 객체(sender)와 요청을 처리하는 객체(receiver)를 분리한다.

객체들의 연결고리(chain)

- 요청에 대하여 각 객체는 자신이 처리할 수 있으면 자신이 처리
- 처리하지 못하면 연결된 다음 객체에 요청 넘김

## 일반적인 구조

<img width="390" alt="image" src="https://user-images.githubusercontent.com/57888020/172096939-a392f5ce-0e29-4662-9af3-5634e7442ee1.png">

보통 successor는 하나만 가지고 있다.

## 적용 결과

- 결합도를 줄인다.
  - sender는 어떤 receiver가 요청을 처리할 지 몰라도 됨
  - sender는 receiver들에 대한 reference를 모두 가질 필요 없음
  - 첫 번째 객체에게 요청을 보내면 다음부터는 연결고리에 있는 객체들이 자동 요청 전파
- 융통적인 책임 배정
  - 연결고리에 객체들 동적 삽입, 삭제
  - 동적인 객체들 간의 책임 분산
- 처리 확신 불가
  - 연결고리에 있는 객체 모두가 요청 처리 못하는 경우 -> sender는 요청 처리를 확신할 수 없음

## 후속 체인의 구현

방법 1. 기존 링크 이용 : 일반적으로 GUI 객체들은 child-parent 간의 연결 레퍼런스 있음 -> 이걸 그대로 사용 가능

방법 2. 링크 새로 정의 : handler 클래스에서 구현, 링크에 대한 관리와 호출을 구현해야 함

<img width="438" alt="image" src="https://user-images.githubusercontent.com/57888020/172097750-676498fc-8757-40c8-944c-628029d30bde.png">

## 요청이 여러 개인 경우??

각 요청에 대한 개별적인 메소드 마련

요청 객체 Request 만들어서 handleRequest로 넘김