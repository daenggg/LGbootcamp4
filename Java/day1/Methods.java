/*
 * 메서드
 * 메서드를 왜 사용하는지 이해하고 (코드 재사용, 가독성)
 * 메서드를 정의하고 호출하는 방법을 익혀보자
 * 매개변수와 반환값의 개념을 이해해보자
 * 같은 이름으로 다른 매개변수를 받는 오버로딩을 이해한다.
 * */

public class Methods {
    //    메서드 정의 위치 : 클래스 안, main (메서드) 밖에 정의한다.
//    지금 이 주석이 있는 위치
    //    반환값 없음 (void), 매개변수 없음
//    void : 아무것도 반환하지 않는다는 의미
//    static : main 메서드에서 객체 생성 없이 바로 호출하기 위해 필요
    static void printGreeting() {
        System.out.println("안녕하세요! Java 메서드입니다.");
    }

    //    반환값 없음, 매개변수 있음
//    이름(name)을 받아서 인사말을 출력한다
    static void greet(String name) {
//        name : 메서드 외부에서 전달받은 값으로 담는 매개변수(Parameter)
        System.out.println("안녕하세요, " + name + "님!");
    }

    //    반환값 있음, 매개변수 있음
//    두 정수를 더해서 결과를 반환한다,
//    int add(...) => int 타입을 반환하겠다는 선언
    static int add(int a, int b) {
        int result = a + b;
        return result; // return 으로 값을 반환한다.
    }

    //    반환값 있음, 매개변수 있음
//    정수가 짝수인지 판별하여 true/false로 반환한다
    static boolean isEven(int number) {
        return (number % 2 == 0);
    } // 조건식 자체를 반환 가능

    //    반환값 double, 계산 메서드
//    원의 넓이를 계산하여 반환한다
    static double circleArea(double radius) {
        final double PI = 3.141592;
        return PI * radius * radius;
    }

//    메서드 오버로딩
//    같은 이름의 메서드를 매개변수 타입 또는 개수를 달리하여 여러 개 정의하는 것
//    컴파일러가 호출 시 전달되는 인수의 타입/개수를 보고 알맞은 메서드를 선택한다
//    반환 타입만 다른 건 오버로딩이 아님! -> 예전 CS면접에서 자주 나왔음

    //    add(int, int) - 정수 두 개 덧셈
    static int add(int a, int b, int c) {
        // 매개변수 3개 버전 (위의 add(int, int)와 이름이 같음)
        return a + b + c;
    }

    //    add(double, double) - 실수 두 개 덧셈
    static double add(double a, double b) {
        return a + b;
    }

    //    문자열 연결 버전
    static String add(String a, String b) {
        return a + b; // 문자열 합치기
    }

//    재귀 메서드
//    메서드가 자기 자신을 호출하는 방식
//    반드시 탈출 조건(base case)이 있어야 무한 호출을 막을 수 있다.

    //    n! (팩토리얼) 계산 : 5! : 5 x 4 x 3 x 2 x 1 = 120
    static int factorial(int n) {
        // 탈출 조건 : 0! = 1, 1! = 1
        if (n <= 1) {
            return 1;
        }
        // n! = n x (n-1) <- 자기 자신 호출
        return n * factorial(n - 1);
    }

    //    main 메서드 : 위에서 정의한 메서드들을 호출해서 테스트
    static void main(String[] args) {
//        메서드 호출
//        void, 매개변수 없음
        printGreeting();
//        void, 매개변수 있음
        greet("홍길동");
        greet("이순신");
//        반환값 있음 : 반환값을 변수에 담거나 바로 사용
        int sum = add(10, 20);
        System.out.println(sum);
//        반환값을 변수 없이 바로 출력에 사용
        System.out.println(add(5, 3));
//        boolean 반환
        System.out.println("4는 짝수? " + isEven(4));
        System.out.println("7는 짝수? " + isEven(7));
//        double 반환
        System.out.printf("반지름이 5인 원의 넓이: %.2f%n", circleArea(5));

//        오버로딩 확인
        System.out.println(add(1, 2));
        System.out.println(add(1, 2, 3));
        System.out.println(add(1.5, 5.6));
        System.out.println(add("Hello, ", "World"));

//        재귀 호출
        for (int i = 0; i <= 6; i++) {
            System.out.println(i + "! = " + factorial(i));
        }

//        <TODO실습 호출>
        System.out.println(max(3, 5)); // 1번 호출
        System.out.println(sumTo(4)); // 2번 호출
        System.out.println(strLength("asdf")); // 3번 호출(1)
        System.out.println(strLength("asdf", "a")); // 3번 호출(2)
        System.out.println(fib(7));

    }

    /*
     * 메서드 사용의 장점 정리
     * 1. 코드 재사용 : 같은 로직을 여러 번 복사하지 않아도 된다.
     * 2. 가독성 : 메서드 이름으로 무슨 일을 하는지 알 수 있다.
     * 3. 유지보수 : 로직 수정 시 메서드 한 곳만 바꾸면 된다.
     * 4. 테스트 : 개별 메서드를 단독으로 테스트하기 쉽다
     * */

//        TODO 실습 문제
    /*
     * 1. 두 정수를 받아 더 큰 값을 반환하는 max(int a, int b)메서드를 작성하세요.
     * 2. 정수를 받아 1부터 그 수까지의 합을 반환하는 sumTo(int n) 메서드를 작성하세요.
     * 3. 문자열을 받아 길이를 반환하는 메서드와 두 문자열을 받아 길이의 합을 반환하는
     * 메서드를 오버로딩으로 구현하세요. (메서드명: strLength)
     * 4. 피보나치 수열을 n번째 값을 재귀로 구하는 매서드를 작성하세요.
     * fib(0) = 0, fib(1) = 1, fib(n) = fib(n-1) + fib(n-2)
     * 참고로 잊지마세요. 메서드는 main 바깥에서 작성하시고 main에서 호출하세요.
     * main 밑에 함수를 작성하셔도 ok
     * */

    //    1번
    static int max(int a, int b) {
        if (a > b) {
            return a;
        } else {
            return b;
        }
    }

    //    2번
    static int sumTo(int n) {
        int answer = 0;
        for (int i = 1; i <= n; i++) {
            answer += i;
        }
        return answer;
    }

    //    3번
    static int strLength(String a) {
        return a.length();
    }

    static int strLength(String a, String b) {
        return a.length() + b.length();
    }

    //    4번
    static int fib(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        return fib(n - 1) + fib(n - 2);
    }
}
