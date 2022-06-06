# 상태 패턴

## 상태

객체가 시스템에 존재하는 동안

객체의 라이프 타임 동안 객체가 가질 수 있는 어떤 조건이나 상황

## 상태 진입

객체가 한 상태에서 다른 상태로 이동

보통 특정 이벤트가 발생한 후 명세된 조건을 만족한 경우에 이루어짐

## 상태 패턴을 적용하지 않는 경우

스위치 문 같은 것으로 상태를 확인하고 상태에 따라 다른 프로세스를 따르게 하는 경우

- 복잡한 조건문 -> 현재 시스템의 상태 변화 파악이 어려움
- 새로운 상태의 추가 -> 관련된 모든 메서드 코드 수정

-> 변하는 부분을 객체로 만들자(캡슐화)

## 상태 패턴

가능한 상태 개수만큼 상태 클래스 

-> 상태에 따라 행위가 달라지는 함수들을 포함한다.-> if, switch 문이 줄어든다.

상태 변수 대신 상태 객체를 가지고, 조건문 대신 각각에 해당하는 메소드를 가진다.

<img width="425" alt="image" src="https://user-images.githubusercontent.com/57888020/172178541-09988150-462f-4d5b-9726-2f37ff85148d.png">

<img width="411" alt="image" src="https://user-images.githubusercontent.com/57888020/172178623-c9d358b2-e206-4589-8695-b81a1762859d.png">

<img width="469" alt="image" src="https://user-images.githubusercontent.com/57888020/172178852-5f547d46-d94b-431d-900e-2217451b3fa0.png">

<img width="411" alt="image" src="https://user-images.githubusercontent.com/57888020/172179369-daf47ace-9e02-4638-a833-cb743a51be1a.png">

## 싱글톤 적용

State 객체가 독자적인 정보를 가지는 게 아니라면 여러개 가질 필요는 없다.

State 객체는 특정 객체의 행위들을 각 상태에 따라 모아둔 것 -> 단순 함수 집합 -> 싱글톤 패턴 활용

<img width="294" alt="image" src="https://user-images.githubusercontent.com/57888020/172179771-5b95f1f5-9693-46ab-b6ef-b37ad0a82595.png">

## 의도

객체의 내부 상태가 변경되었을 때 그에 따라 객체의 행위도 변경되게 한다. 마치 다른 클래스의 객체가 된 것처럼!

## 적용 범위

- 객체의 행위가 해당 객체의 상태에 따라 달라지는 경우
- 객체의 함수 코드가 객체의 상태에 따라 큰 부분의 조건 문장으로 구성되어 있을 때(if, switch)

## 구조

<img width="333" alt="image" src="https://user-images.githubusercontent.com/57888020/172181506-ba691315-1653-4088-b712-0d296ceaea7f.png">

- Context : 현재 상태를 나타내는 ConcreteState 객체의 reference를 가짐
- State : Context 객체의 현재 상태에 따라 다른 행위를 하는 함수들의 interface 정의
- ConcreteState : 각 Class는 Context 객체의 특정 상태에 따라 수행되는 행위들을 구현

## 협동

- Context 객체
  - 상태 의존적인 요청에 대해서는 ConcreteState 객체에 요청 위임 -> Context 는 상태와 무관해야 함 상태 교체에도 영향이 없음
  - ConcreteClass 객체 함수를 호출할 때 자신의 reference를 인자로 넘길 수 있음
  - 이 객체의 상태변화는 Context나 ConcreteState 객체의 작업 수행 중에 일어남
- 일반적으로 클라이언트는 Context 객체를 초기화하는 것 이외에 상태 변환에 직접 개입 x

## 결과

- 상태 고유의 동작을 국부화, 동작을 각 상태에 분할
  - 특정 상태에 연관된 행위 -> State 객체로
  - 새로운 상태 추가 구현 쉬움 : 모든 상태 의존 코드가 상태 서브클래스에 있음
  - 조건문 줄여버림
- 상태 변환을 외부에 노출
  - 상태 변환 == 참조 객체 변환
- 상태 객체의 공유
  - 하나의 State를 여러 Context에서 사용가능 : 개별적인 내부 정보를 가지지 않는 경우 싱글톤 적용

## 구현

- 상태 전환 정의
  - ConcreteState가 가지고 있는 것이 좋다. 보통 다음 상태로 가는 것이 분명함
  - Context도 가질 수 있는데 if문이 들어가야 함
- 테이블 기반
  - 상태 전환 표 : 상태 전환이 복잡한 경우 상태에서 입력에 따라 전환되는 상태 기록
  - 표 검색 -> 속도 느림, 이해 어렵
  - 전환 도중에 행동 수행 구현이 어려움
- 상태 객체의 생성과 소멸
  - 각 State 필요시 생성, 소멸
  - 싱글톤 : 보통 이게 더 좋음 

## 관련 패턴

- 싱글톤
- 플라이웨이트 : 여러 종류의 State 객체들을 공유해야 하는 경우 플라이웨이트 활용 가능
- 커맨드 패턴과 비슷하다.

