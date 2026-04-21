//
/*
* public class 클래스명 - 클래스 선언
* 중요 : 클래스명은 반드시 파일명(확장자 제와)과 동일해야 한다!
* 이 파일 이름이 Hello 이므로 실제 클래스명은 Hello로 지정한다.
* 특별한 변수(이벤트 or 해프닝 or 목적)이 없으면 파일 하나에 하나의 클래스만 작성한다.
* */


public class Hello {
    /*
    * main 메서드 : 프로그램의 시작점 (Entry Point)
    * JVM이 프로그램을 실행할 때 가장 먼저 이 메서드를 호출한다
    * public static void main(String[] args) - 이 형태는 외워야 한다.
    * - public : 어디서든 접근 가능
    * - static : 객체 생성 없이 바로 실행 가능
    * - void : 반환값 없음
    * - String[] args : 명령행 인수를 받는 배열 (지금은 신경 쓰지 않아도 됨)
    * */


    static void main(String[] args) {

//        화면 출력 메서드
//        System.out.println() : 출력 후 줄바꿈 (ln = line)
        System.out.println("Hello, Java");

//        System.out.print() : 출력 후 줄바꿈 없음

        System.out.println("안녕하세요, ");
        System.out.println("Java 세계에 ");
        System.out.println("오신 것을 환영합니다!");

//        System.out.printf() : C언어 스타일의 포맷 출력
//        %s = 문자열, %d = 정수, %f = 실수, %n = 줄바꿈
        System.out.printf("오늘 배우는 언어 : %s%n", "Java");
        System.out.printf("버전 : Java %d%n", 100);

//        주석 종류
//        한줄 주석 : //로 시작
        /*
        * 여러 줄 주석
        * /*로  시작해서 오른쪽 모양으로 끝이 난다 */ /*
        * */

        /*
        * Java 특징 요약
        * 1. 객체지향 프로그래밍 (OOP)
        * 2. 플랫폼 독립성 (JVM)
        * 3. 강타입 언어
        * 4. 자동 메모리 관리 (GC)
        * 5. 멀티 스레드 지원
        * */

//    TODO 실습문제
/*    1. 자신의 이름과 좋아하는 숫자를 화면에 출력해보세요
      2. printf를 사용해서 "이름 : 홍길동, 나이: 25세" 형식으로 출력해보세요
      3. 여러 줄 주석으로 Java 특징 중 하나를 설명하는 주석을 직접 작성해보세요
*/
        String name = "고유정";
        int age = 24;
        System.out.println("고유정");
        System.out.println("100");
        System.out.printf("이름 : %s, 나이: %d세%n", name, age);

        /*
        플랫폼 독립성이란?
        자바 소스코드를 컴파일하면 바이트코드가 생성된다.
        이 바이트코드는 JVM이 설치된 곳이라면
        윈도우, 맥, 리눅스 등 어떤 운영체제에서도 동일하게 실행된다.
        덕분에 개발자는 플랫폼마다 별도로 코드를 작성할 필요가 없다.
        */
    }

}
