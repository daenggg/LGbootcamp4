/*
 * 변수와 자료형
 * 기본 자료형(Primitive Type), 참조 자료형(Reference Type), 형변환
 * 자바의 기본 자료형 8가지, 변수를 선언하고 값을 대입하는 방법
 * 자동 형변환(묵시적)과 강제 형변환(명시적)을 해보자
 * */

public class Variables {
    static void main(String[] args) {
//        변수란?
//        데이터를 저장하는 메모리 공간에 붙인 이름(라벨)
//        선언 방법 : 자료형 변수명 = 초기값;
//        정수형 (Integer Type)
//        byte : 1바이트, -128 ~ 127
        byte myByte = 100;
//        short : 2바이트, -32,768 ~ 32,767
        short myShort = 30000;
//        int : 4바이트, 약 -21억 ~ 21억 <- 가장 많이 사용
        int age = 25;
        int score = -50;
//        long: 8바이트, 매우 큰 정수 저장 가능
//        long 타입 리터럴 끝에는 L 또는 l을 붙인다.
        long population = 8000000000L;

        System.out.println("정수형 출력");
        System.out.println("byte: " + myByte);
        System.out.println("short: " + myShort);
        System.out.println("int: " + age);
        System.out.println("long: " + population);

//        실수형 (Floating-Point Type)
//        float : 4바이트, 소수점 약 7자리까지 정밀도
//        float 리터럴 끝에는 F 또는 f 를 붙인다
        float height = 175.5f;

//        double : 8바이트, 소수점 약 15자리까지 정밀도 <- 실수는 보통 double 사용
        double pi = 3.14159265358979;
        double temperature = -5.7;

//        문자형 (Character Type)
//        char : 2바이트, 문자 하나를 저장 (유니코드 기반)
//        반드시 작은 따옴표(' ')로 감싼다
        char grade = 'A';
        char letter = '자';
        char number = '5'; // 숫자처럼 생겼지만 문자!

        System.out.println("'A'의 유니코드 정수값: " + (int) grade);// 65

//        논리형 (Boolean Type)
//        boolean :참 또는 거짓 두 가지 값만 가짐
        boolean isJavaFum = true;
        boolean isPassed = false;

//        문자열 (String) - 기본 자료형이 아닌 참조 자료형!
//        String : 문자들의 연속 (시퀀스), 큰따옴표(" ")로 감싼다.
//        참조 자료형이지만 워낙 자주 쓰여서 기본형처럼 사용한다.
        String name = "홍길동";
        String greeting = "안녕하세요!";
        String empty = ""; // 빈 문자열 (null과 다름)

//        문자열 연결 : + 연산자 사용
        System.out.println("연결: " + name + "님, " + greeting);

//        상수 (Constant) - final 키워드
//        final을 붙이면 값을 한 번 대입한 후 변경할 수 없다.
//        관례상 상수명은 대문자와 언더스코어(_)로 작성한다.
        final double TAX_RATE = 0.1; // 세율 10%
        final int MAX_SCORE = 100; // 최대 점수
//        TAX_RATE = 0.2; // 에러! final 변수는 값 변경 불가

//        형변환 (Type Casting)
//        자동 형변환 (묵시적 형변환, Widening Conversion)
//        작은 자료형 → 큰 자료형 : 자동으로 변환된다. 데이터 손실 없음
//        byte → short → int → long → float → double
        int intValue = 100;
        long longValue = intValue; // int → long 자동 변환
        double doubleValue = intValue; // int → double 자동 변환

//        강제 형변환 (명시적 형변환, Narrowing Conversion)
//        큰 자료형 → 작은 자료형 : 직접 (자료형)을 앞에 붙여줘야 한다.
//        데이터 손실이 발생할 수 있으니 주의!
        double bigDouble = 9.99;
        int castedInt = (int) bigDouble; // 소수점 이하 버림(반올림 아님!!)
        long bigLong = 1234567890123L;
        int castedFromLong = (int) bigLong; // 번위 초과 시 값이 잘릴 수 있음
        System.out.println(bigDouble + " → " + castedInt);
        System.out.println(bigLong + " → " + castedFromLong);

//        문자열 <-> 숫자 변환
//        문자열을 정수로 변환
        String strNum = "123";
        int parsedInt = Integer.parseInt(strNum);

//        정수를 문자열로 변환
        int num = 456;
        String numToStr = String.valueOf(num);
        String numToStr2 = num + ""; // 빈 문자열과 더하면 문자열로 변환

        System.out.println("\"123\" → int : " + parsedInt + 1); // 괄호가 없어서 1231로 출력
        System.out.println("실제 더하기 " + (parsedInt + 1)); // 124
        System.out.println("456 → String" + numToStr2);

//        TODO 실습 문제
        /*
        * 1. 자신의 이름(String), 좋아하는 숫자(int),
        * 세자리 이상 숫자(double), 혈액형(char)을
        * 변수를 선언하고 출력하세요
        *
        * 2. 원의 반지름을 10으로 설정하고 넓이(pi x r2)를 계산해보세요
        * pi는 final 상수로 선언하세요
        *
        * 3. 문자열 "3.14"를 double 타입으로 변환해보세요
        * 힌트 : Double.parseDouble()
        * */

//        TODO 풀이
//        1.
        String myName = "고유정";
        int myIntNum = 100;
        double myDoubleNum = 123;
        char bloodType = 'A';

//        2.
        final double PI = 3.141592;
        int radius = 10;
        double area = PI * radius * radius;

//        3
        String strPi = "3.14";
        double parsePi = Double.parseDouble(strPi);

    }
}
