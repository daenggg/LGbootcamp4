/*
* 연산자
* 주제 : 산술 / 비교 / 논리 / 증감 / 삼항 연산자
* 다양한 연산자의 종류와 사용법, 연산자 우선순위, 삼항 연산자 조건에 따라 값을 선택하는 방법을 익혀봅시다.
* */

public class Operators {
    static void main(String[] args) {
//        1. 산술 연산자
        int a = 10;
        int b = 3;
        System.out.println(a+b); // 덧셈
        System.out.println(a-b); // 뺄셈
        System.out.println(a*b); // 곱셈
        System.out.println(a/b); // 나눗셈 몫
        System.out.println(a%b); // 나눗셈 나머지

//        주의 : 정수 나눗셈에서 소수점 결과를 원할 때는 형변환 필요
        System.out.println((double) a / b);

//        나머지 연산의 활용 예시
//        짝수/홀수 판별 : n % 2 == 0 이면 짝수
//        배열 순환 인덱스 : index % length -> 나중에 할 거임

//        2. 대입 연산자
        int x = 10;
        System.out.println(x);
        x += 5;
        System.out.println(x);
        x -= 5;
        System.out.println(x);
        x *= 5;
        System.out.println(x);
        x /= 5;
        System.out.println(x);
        x %= 5;
        System.out.println(x);

//        3. 증감 연산자
        int count = 5;
//        전위(prefix) : 먼저 증가/감소 후 사용
        System.out.println(++count);
        System.out.println(--count);

//        후위(postfix) :먼저 사용 후 증가/감소
        System.out.println(count++);
        System.out.println(count--);
        System.out.println(count);

//        4. 비교 연산자
//        결과는 항상 boolean (true / false)
        int p = 10, q = 20;
        System.out.println(p == q);
        System.out.println(p != q);
        System.out.println(p > q);
        System.out.println(p < q);
        System.out.println(p >= q);
        System.out.println(p <= q);

//        주의 : 문자열 (String) 비교는 == 대신 equals() 사용!
        String s1 = new String("hello");
        String s2 = new String("hello");

        System.out.println(s1 == s2); // false 주소값 비교
        System.out.println(s1.equals(s2)); // true 내용 비교

//        5. 논리 연산자
//        boolean 값들을 조합할 때 사용
        boolean t = true;
        boolean f = false;
//        && (AND) : 둘 다 true여야 true
        System.out.println(t && f);
//        || (OR) : 하나라도 true면 true
        System.out.println(t || f);
//        ! (NOT) : 반전
        System.out.println(!t);
        System.out.println(!f);

//        6. 삼항 연산자
//        형식 : (조건식) ? 참일 때 값 : 거짓일 때 값
        int myScore = 85;
        String result = (myScore >= 60) ? "합격" : "불합격";
        System.out.println(result);

//        +) 절대값 구하기
        int num = -42;
        int abs = (num >= 0) ? num : -num;

//        7. 연산자 우선순위
//        높은 순서 : () → 단항(++, --, !) → 산술(*, /, %) → 산술(+, -) → 비교 → 논리 → 삼항 → 대입
//        헷갈릴 때는 괄호()를 쓰면 명확합니다.

//        TODO 실습문제
//        1. 두 정수를 입력받아 합, 차, 곱, 목, 나머지를 출력하세요
//        2. 어떤 수가 3의 배수인지 확인하는 코드를 작성하세요 (힌트 - %연산자)
//        3. 삼항 연산자를 이용해 두 수 중 작은 값을 출력하세요
//        4. 나이가 19세 이상이고 신분증이 있으면(boolean) 입장 가능하다는
//        조건을 논리 연산자로 표현하세요

        int i = 20;
        int j = 3;
        boolean idCard = true;
        System.out.println(i+j);
        System.out.println(i-j);
        System.out.println(i*j);
        System.out.println(i/j);
        System.out.println(i%j);

        System.out.println((j%3 == 0) ? true : false);
        System.out.println(i < j ? i : j);
        System.out.println((i>=19) && (idCard = true) ? "입장 가능" : "입장 불가능");

    }
}
