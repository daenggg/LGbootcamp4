/*
* 주제 : 조건문, 반복문
* 조건에 따라 다른 코드를 실행하는 조건문을 익힌다
* 코드를 반복 실행하는 반복문을 익힌다
* 반복문의 흐름을 제어하는 break와 continue를 이해한다.
* */

public class ControlFlow {
    static void main(String[] args){
//        1. if / else if / else
        int score = 78;
        if (score >= 90) {
            System.out.println("학점: A");
        } else if (score >= 80) {
            System.out.println("학점: B");
        } else if (score >= 70) {
            System.out.println("학점: C");
        } else {
            System.out.println("학점: F (재수강)");
        }




//        중첩 if
        int age = 18;
        boolean hasID = true;
        if(age >= 19) {
            if (hasID) {
                System.out.println("입장 가능!");
            } else  {
                System.out.println("신분증이 필요합니다.");
            }
        } else {
            System.out.println("미성년자는 입장 불가입니다.");
        }

//        2. switch 문
//        변수의 값에 따라 여러 경우 중 하나를 실행한다.
//        if else - 가 많아질 거 같을 때 쓰면 가독성이 좋아진다.
//        break 를 빠트리면 다음 case로 실행이 넘어가니 반드시 써줘야한다.
        int day = 6; // 1 - 월, 2 - 화, 3 - 수, 4 - 목, 5 - 금, 6 - 토, 7 - 일

        switch (day) {
            case 1:
                System.out.println("월요일");
                break; // break가 없으면 아래 케이스가 쭉 실행됨
            case 2:
                System.out.println("화요일");
                break; // break가 없으면 아래 케이스가 쭉 실행됨
            case 3:
                System.out.println("수요일");
                break; // break가 없으면 아래 케이스가 쭉 실행됨
            case 4:
                System.out.println("목요일");
                break; // break가 없으면 아래 케이스가 쭉 실행됨
            case 5:
                System.out.println("금요일");
                break; // break가 없으면 아래 케이스가 쭉 실행됨
            case 6:
                System.out.println("토요일");
                break; // break가 없으면 아래 케이스가 쭉 실행됨
            case 7:
                System.out.println("일요일");
                break; // break가 없으면 아래 케이스가 쭉 실행됨
            default:
                // 어떤 case에도 해당되지 않을 때 실행
                System.out.println("잘못된 요일 번호입니다.");
        }

//        switch에서 여러 case를 묶는 방법
        switch (day){
            case 6:
            case 7:
//                6 또는 7인 경우 모두 이 블록 실행
                System.out.println("주말입니다!");
                break;
            default:
                System.out.println("평일입니다!");
        }

//        3. for 문
//        반복 횟수가 정해진 경우에 주로 사용한다.
//        형식 : for (초기화; 조건; 증감) {반복할 코드}
//        1부터 5까지 출력
        for (int i = 1; i <= 5; i++) {
            System.out.print("i = " + i+ " ");
        }
//        1부터 10까지 합계 구하기
        int sum = 0;
        for (int i = 1; i <= 10; i++) {
            sum += i;
        }
        System.out.println("합계" + sum);

//        중첩 for문
        for (int dan = 2; dan <= 3; dan++){
            for(int i = 1; i <= 9; i++){
//                System.out.print(dan + "x" + i + "=" + (dan*i) + " ");
                System.out.printf("%d x %d = %2d%n", dan, i, dan*i);
            }
            System.out.println(" ");
        }

//        4. while 문
//        조건이 참인 동안 반복 실행된다.
//        반복 횟수를 미리 모를 때 주로 사용한다.
//        조건이 처음부터 false면 한 번도 실행되지 않는다.

        int n = 1;
        while (n <= 5) {
            System.out.println("n = " + n);
            n++; // while문 같은 경우에는 특히나 무한루프에 빠지기 쉬우므로
//            반드시 탈출 조건을 정확히 작성해 주어야 한다.
        }

//      while로 자릿수 계산하기
        int number = 12345;
        int digits = 0;
        int temp = number;
        while (temp > 0) {
            temp /= 10; // 10으로 나누면 자릿수가 하나식 줄어든다
            digits++;
        }
        System.out.println(number + "의 자릿수는 " + digits + "자리");

//    do-while 문
//    while문과 비슷하지만, 조건 검사를 나중에 합니다. → 최소 1번은 실행된다.
        int attempt = 1;
        do {
            System.out.println("시도 횟수" + attempt);
            attempt++;
        } while(attempt <= 3);

//        while 과의 차이 비교
        System.out.println("while과의 차이");
        int val = 10;
//        조건이 처음부터 false인 경우
        while (val < 5) {
            System.out.println("while: 실행됨");
        }
        do {
            System.out.println("do-while: 조건이 false여도 1번 실행됨");
        } while (val < 5);

//        6. break와 continue
//        break 반복문을 즉시 종료하고 빠져나온다
        for (int i = 1; i <= 10; i++) {
            if (i == 5) {
                System.out.println("5를 만났습니다. break!");
                break; // for문 탈출
            }
        }

//        continue 이번 반복만 건너 뛰고 다음 반복으로 넘어간다
        for (int i = 1; i <= 20; i++) {
            if (i % 2 == 0) {
                continue; // 짝수면 아래 출력 건너뛰고 다음 if
            }
            System.out.println(i + " "); // 홀수만 출력됨
        }

//        TODO 실습 문제
        /*
        * 1. for문으로 1~100사이의 홀수 합계를 구하시오
        * 2. 중첩 for문으로 구구단 전체(너무 많으면 일부만)를 출력하세요
        * 3. while문으로 2의 거듭제곱을 1000이 넘기 전까지 출력하세요
        * 4. switch 문으로 달(month)을 입력받아 해당 달의 계절을 출력하세요
        * 3~5월: 봄, 6~8월: 여름, 9~11월: 가을, 12~2월: 겨울
        * */

//        1번
        int answer = 0;
        for (int i = 1; i <= 100; i++) {
            if (i % 2 == 0) {
                continue;
            } else{
                answer += i;
            }
        }
        System.out.println("1~100사이의 홀수 합계 = " + answer);

//        2번
        for (int dan = 2; dan <= 4; dan++) {
            for (int i = 1; i <= 9; i++){
                System.out.print(dan + "x" + i + "=" + (dan*i) + " ");
            }
            System.out.println(" ");
        }
//        3번
        int q = 1;
        while (q < 1000){
            System.out.print(q + " ");
            q *= 2;
        }
        System.out.println(" ");
//        4번
        int month = 9;
        switch (month) {
            case 3, 4, 5 :
                System.out.println("봄");
                break;
            case 6, 7, 8 :
                System.out.println("여름");
                break;
            case 9, 10, 11 :
                System.out.println("가을");
                break;
            case 12, 1, 2 :
                System.out.println("겨울");
                break;
            default:
                System.out.println("잘못된 월 입력");

        }
    }

}
