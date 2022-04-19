설계의 품질 : 잘 설계되었는지 평가하는데 도움이 되는 설계 원칙

# SRP - 단일 책임의 원리 (Single Responsibility Principle)

하나의 클래스는 하나의 책임을 가져야 한다. 책임의 기본 단위는 객체

책임 : 해야하는 것, 할 수 있는 것, 해야하는 것을 잘할 수 있는 것

책임 == 변경의 이유

<img width="467" alt="image" src="https://user-images.githubusercontent.com/57888020/163995171-9735231e-58c4-4ff5-ba5e-132f0e5982c3.png">

<img width="439" alt="image" src="https://user-images.githubusercontent.com/57888020/163995263-c1d56d6a-cd36-4201-8eb0-ba5b72fe5f5b.png">

# OCP - 개방 폐쇄의 원리 (Open-Closed Principle)

SW의 요소는 확장에 열려있고 변경에 닫혀있어야 한다. 

쉽게 확장할 수 있어야 하고, 수정하는 경우에 다른 부분에는 영향을 미치지 않아야 한다. 

DIP와 다름 : OCP는 모듈 하나의 안에서 적용

# LSP - 리스코프 교체 원리 (Liskov Substitution Principle)

기본 클래스(Base class)를 사용한다. 파생 클래스에 대하여 알 필요 없이 사용하게 해야 한다.

서브 타입이 베이스 타입에 교체될 수 있어야 한다.

더 이상의 요구나 더 이하의 약속이 없어야 한다.

  슈퍼 클래스에서 받는 매개변수는 서브 클래스가 다 받아야 하고, - 더 이상의 요구
  
  슈퍼 클래스가 사용되었을 때 유효하면 서브 클래스가 사용되었을 떄도 유효하다 - 더 이하의 약속
 
인터페이스 상속에는 LSP가 적용되어야 하고

구현상속의 경우에는 Java에서는 컴포지션(위임)을 사용, C++에서는 private 베이스 클래스를 사용하는 것이 좋다.

ex ) Java에서 Queue를 구현할 때 List를 사용한다면 컴포지션을 사용하여야 한다. (상속을 해서는 안된다.)

<img width="526" alt="image" src="https://user-images.githubusercontent.com/57888020/163997273-1506a13e-8cdc-405b-bc54-a80f6a08f9e9.png">


# ISP - 인터페이스 격리 원리 (Interface Seperate Principle)

클라이언트는 자신이 사용하지 않는 메서드에 의존하면 안된다. 

다른 클라이언트를 위한 기능을 하나의 인터페이스나 클래스에 넣어 비대하게 만들면

- 클라이언트에 불필요한 결합이 생긴다.
- 한 클라이언트에 변경이 생기면 다른 클라이언트도 다시 컴파일해야 한다.

# DIP - 의존 관계 역전 원리 (Dependent Inversion Principle)

구체적인 것이 추상적인 것에 의존해야 한다.

높은 수준의 개념(인터페이스, 추상 클래스)이 낮은 수준의 구현보다 안정적이다. == 변경이 적다.

OCP와의 비교 : DIP는 두개 사이의 관계에서 적용

<img width="425" alt="image" src="https://user-images.githubusercontent.com/57888020/163997801-3cf1aad7-0b00-42c7-8158-e75c44ee8e83.png">


# LOD - 디메테르 법칙

주어진 프로그램에서 모듈 사이의 결합을 최소화 한다.

모듈 내부에서 변화의 영역이 멀리서 받아오는 것이 아니어야

영향의 범위를 예측할 수 있는 것은 다음과 같다.
- 클래스 안의 메소드
- 메소드에 전달된 파라미터 객체의 메서드 호출
- 자신이 만든 객체의 메서드
- 내부 객체의 메서드

디메테르 법칙을 위배하는 경우

<img width="487" alt="image" src="https://user-images.githubusercontent.com/57888020/163999139-f87d5c70-5123-4ca8-abf7-82669c7aff80.png">

# 추상 재사용

재사용 가능한 SW : 느슨한 결합, 강한 응집

컴포넌트의 지속적인 리팩토링

# 상속 vs 인터페이스

Java에서는 인터페이스의 다중 상속을 허용한다.

## 인터페이스의 구현은 behaves-like-a 관계 : 관련 없는 클래스의 그루핑

TaleMarketer와 HouseFly는 서로 관계가 없지만 짜증나게 하는 동작을 공유하고 싶음 -> annoying을 정의한 인터페이스 사용

짜증을 일으키는 방법은 다르니까 구현은 다름

느슨한 결합

## 슈퍼클래스의 상속은 is-a 관계 : 관련 클래스 사이의 자료/함수 재사용

