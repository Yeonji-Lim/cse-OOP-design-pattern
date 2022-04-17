어떤 클래스는 프로그램 내에서 한번만 생성되어서 하나의 객체를 나누어 사용해야 한다고 하자 ( 마치 회사에서 공용으로 사용하는 프린터기 처럼! )

외부에서 생성자를 호풀할 수 없게 private으로 선언하면 해결할 수 있다. 

그러면 어떻게 생성할까? 

getter를 만들어서 인스턴스가 이미 생성되어 있다면 인스턴스를 반환하고, 그렇지 않다면 인스턴스를 생성해주는 것이다.

~~~
public class Printer {
    private static Printer printer = null;
    private Printer() { } // 생성자를 외부에서 사용하지 못하게 한다.

    public static Printer getPrinter() {
        if (printer == null)            // 인스턴스가 생성되지 않은 상황이라면 인스턴스 생성
            printer = new Printer();    // 생성된 인스턴스는 정적 변수 printer에 의해 참조된다.
        
        return printer; // printer 변수에서 참조하는 인스턴스를 반환
    }

    ...
}
~~~

주의할 점은 getPrinter 메서드와 printer 변수가 static 타입이라는 것!

## 정적 메소드와 정적 변수

정적 메소드 & 정적 변수 : 구체적인 인스턴스에 속하는 영역이 아인고 클래스 자체에 속한다. 

그래서 클래스의 인스턴스를 통하지 않고서도 메소드를 실행하거나 변수를 참조할 수 있다.

단 하나의 객체만 생성해서 이를 어디에서든지 참조할 수 있게 하려는 것이 목적이므로 적절!

잘 모르겠다면 다음을 생각하자. 만약에 getPrinter가 정적메소드가 아니라면?

생성되지 않은 instance 객체로 다음과 같이 사용해야 한다.

~~~
instance.getPrinter();
~~~

그러면 printer 객체는 어떻게 만들것인가에 있어서 모순이다. 

정적 메소드로 만들어서 Instance 객체를 통하지 않아도 외부에서 호출할 수 있다.

~~~
printer.getPrinter();
~~~

또한 정적 변수 printer는 클래스의 인스턴스가 생성될 때마다 생성되는 것이 아니라,

딱 한번만 생성되며 클래스의 인스턴스가 생성되기 전에 초기화된다.

정적 변수는 클래스에서 생성된 모든 인스턴스들에게 공유된다.

## 새로운 문제점

이제 이렇게 해두면, 해당 인스턴스를 하나만 만들고 여러 곳에서 동일한 인스턴스를 사용할 수 있다.

그런데 다중 스레드에서는 이 인스턴스가 1개 이상 생성될 수도 있다.

프린터의 경우, 다음 상황을 생각해보자

1. Printer 인스턴스가 생성되지 않은 상태에서 스레드 1이 getPrinter 메서드의 if 문을 실행했다. 현재 printer 변수는 null

2. 이 스레드 1이 생성자를 호출하기 전에 스레드 2도 getPrinter의 if문을 통해 printer 변수가 null인 것을 확인했다.

3. 결국 두 스레드 모두 생성자를 호출하게 되고, Printer 인스턴스가 두 개 생성된다.

이러한 상황을 경합 조건이라고 한다.

메모리와 같은 동일한 자원을 2개이상의 스레드가 이용하려고 경합하는 현상을 말한다.

이런 상황에서 Printer 클래스가 상태를 유지해야 하는 경우에 문제가 생긴다.

## 해결책

2가지 해결책이 있다.

1. 정적 변수에 인스턴스를 만들어서 바로 초기화 한다.

2. 인스턴스를 만드는 메서드에 동기화한다.

### 1번 방법

~~~
public class Printer {
    private static Printer printer = new Printer(); // 클래스가 로딩될 때 만들어져 초기화가 한번만 실행된다. 
    private int counter = 0;
    private Printer() { }

    public static Printer getPrinter() {
        return printer;
    }

    public void print(String str) {
        counter++;
        Systemn.out.println(str);
    }
}
~~~

이 정적 변수는 프로그램이 실행될 때 부터 종료될 때까지 없어지지 않고 메모리에 계속 상주하며 클래스에서 생성된 모든 객체에서 참조할 수 있다. 

이를 통해서 문제를 일으켰었던 if문을 사용하지 않아도 되게 된다!

### 2번 방법

getPrinter 메서드를 동기화한다.

~~~
public class Printer {
    private static Printer printer = null;
    private Printer() { }

    public synchronized static Printer getPrinter() {
        if(printer == null) {
            printer = new Printer();
        }
        return printer;
    }

    public void print(String str) {
        System.out.println(str);
    }
}
~~~

이렇게 해서 다중 스레드 환경에서 동시에 여러 스레드가 getPrinter 메서드르 ㄹ소유하는 객체에 접근하는 것을 방지한다. 

그런데 이때 만약 printer의 상태를 의미하는 counter라는 변수를 추가했다고 하자

~~~
public class Printer {
    private static Printer printer = null;
    private int counter = 0;
    private Printer() { }

    public synchronized static Printer getPrinter() {
        if(printer == null) {
            printer = new Printer();
        }
        return printer;
    }

    public void print(String str) {
        synchronized(this) { // 오직 하나의 스레듬나 접근을 허용한다.
            counter++;
            ystem.out.println(str+counter);
        }
    }
}
~~~

이 경우  counter 변수의 값은 여전히 이상하게 출력되는데, 여러개의 스레드가 counter 변수 값에 동시에 접근해 생기기 떄문

# Singletom Pattern

인스턴스가 오직 하나만 생성되는 것을 보장하고, 어디에서든 이 인스턴스에 접근할 수 있도록 하는 디자인 패턴

Singleton 요소 하나 밖에 없다.

하나의 인스턴스만을 생성하는 책임이 있다.

getInstance 메서드를 통해 모든 클라이언트에게 동일한 인스턴스를 반환하는 작업을 수행

## 정적 클래스

싱글턴 패턴을 사용하지 않고 정적 크래스를 사용해서 구현할 수도 있다.

~~~
public class Printer {
    private static int counter = 0;
    public synchronized static void print(String str) { // 메소드 동기화
        counter++;
        System.out.println(str+counter);
    }
}
public class UserThread extends Thread {
    public UserThread(String name) { // 스레드 생성 
        super(name);
    }

    public void run() {
        Printer.print(Thread.currentThread().getName() + " print using " + "." );
    }
}

public class Main {
    private static final int THREAD_NUM = 5;
    public static void main(String[] args) {
        UserThread[] user = new UserThread[THREAD_NUM];
        for(int i = 0; i < THREAD_NUM; i++) {
            user[i] = new UserThread((i + 1) + "-thread");
            user[i].start(); // 스레드 실행
        }
    }
}
~~~

싱글턴 패턴을 이용하는 방법과 가장 차이가 나는 점은 객체를 전혀 생성하지 않고 메서드를 사용한다는 점

정적 메서드를 사용하기 때문에 일반적으로 실행할 때 바인딩되는 인스턴스 메서드를 사용하는 것보다 성능면에서 우수하다.

그러나 인터페이스를 구현해야 하는 경우에는 정적메소드를 사용할 수 없다.

