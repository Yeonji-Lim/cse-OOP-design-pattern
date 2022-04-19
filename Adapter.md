# Adapter Pattern

클래스의 인터페이스를 클라이언트가 예상하는 형태로 변환하고자 할 때

Adapter를 사용하여 호환되지 않는 인터페이스를 바꾸어 같이 협력하도록 만들어 준다.

재사용을 위하여 Open-Closed 원리를 적용한다.

<img width="385" alt="image" src="https://user-images.githubusercontent.com/57888020/164039441-cdcdf2c7-0b9f-4d53-8139-8e59282ab420.png">

## 바꾸기(Change) 보다는 적응(Adapt)시키는 것.

<img width="636" alt="image" src="https://user-images.githubusercontent.com/57888020/164039971-af4bfb4f-c0d4-4e5d-b554-c1c806def08d.png">

어뎁터 클래스는 마치 래핑해주는 거임

## 두가지 방법

1. 클래스 어뎁터 : 상속

<img width="438" alt="image" src="https://user-images.githubusercontent.com/57888020/164040400-6d07f5bb-47f6-47d2-917a-5815adfa1227.png">

2. 객체 어뎁터 : 위임

<img width="410" alt="image" src="https://user-images.githubusercontent.com/57888020/164040521-1b408d9a-12be-41c8-8c1d-31078c254bf8.png">

위임이 더 좋음
- 어뎁티가 여러 개인 경우 추가가 용이함
- 어뎁티를 동적으로 바꿀 수 있음
