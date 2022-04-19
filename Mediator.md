이렇게 설계가 되어있다고 하자

<img width="376" alt="image" src="https://user-images.githubusercontent.com/57888020/164021461-7b605c50-d1ff-4ea7-bc15-229bb5b98fef.png">

이 경우에 Tugboat 대신에 다른 것을 적용한다던가, Tugboat를 따로 사용하기 어렵다.

Ship과 직접 연관이 되어있기 때문이다. 그래서 이 의존성을 피하도록 설계해야 한다.

중재자를 중간에 두어서 직접 연관시키지 말고 중재자를 통해서 연관이 되도록 하면 된다.

<img width="452" alt="image" src="https://user-images.githubusercontent.com/57888020/164021918-3c572f0c-1945-4a42-ab7f-9b2378e478d2.png">

# 중재자 패턴 (Mediator Pattern)

조정자 패턴.

어떻게 객체들의 집합이 상호작용하는지 함축해놓은 객체

행위 패턴의 일종 : 프로그램의 실행 행위를 변경할 수 있다.

객체 간 통신은 중재자 객체 안에 함축된다.

객체들은 더이상 다른 객체와 서로 직접 통신하지 않으며 대신 중재자를 통해 통신한다.

<img width="570" alt="image" src="https://user-images.githubusercontent.com/57888020/163965095-4d65be25-1860-40ed-a0f5-3d5fd6b116a2.png">

## 여러 중재자가 사용된 구조

<img width="565" alt="image" src="https://user-images.githubusercontent.com/57888020/164027950-25b4691d-8997-4d63-a712-2f11f7a7e5d8.png">

이때 화살표가 저 방향으로 되어 있어야 분리가 가능하다.
