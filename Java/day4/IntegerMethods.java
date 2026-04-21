/*
 * Integer 클래스
 * 기본 자료형 int와 참조 자료형 Integer의 차이를 이해한다
 * 래퍼 클래스(Wrapper class)의 역할을 이해한다
 * Integer 클래스의 주요 상수와 메서드를 익힌다
 * 오토박싱 / 언박싱 개념을 이해한다
 * */


public class IntegerMethods {
    static void main(String[] args) {
        /*
         * 기본형 int vs 래퍼 클래스 Integer
         * int : 기본 자료형, 값 자체를 저장, null 불가
         * Integer : 객체(클래스), null 가능, 메서드와 상수를 제공
         * 래퍼 클래스가 필요한 이유 : 컬렉션(ArrayList 등)은 객체만 저장 가능
         * */
        int primitive = 42; // 기본형
        Integer boxed = 42; // 래퍼 클래스 (오토박싱 : int -> Integer 자동 변환)
        int unboxed = boxed; // 언방식 : Integer -> int 자동 변환

        Integer nullableInt = null; // Integer는 null 가능 (int는 불가)
        System.out.println(nullableInt);

//        Integer의 주요 상수 - MAX_VALUE, MIN_VALUE
//        int가 표현할 수 있는 최대/최소값
//        초과하면 오버플로우 발생!
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);

//        오버플로우 : 최댓값 +1 하면 최솟값으로 순환된다
        System.out.println(Integer.MAX_VALUE + 1); // 오버플로우
        System.out.println((long) Integer.MAX_VALUE + 1);


//        형 변환
//        String -> int : Integer.parseInt("123")
//        String -> Integer : Integer.ValueOf("123")
//        int -> String : Integer.toString(123) or String.valueOf(123)

//        String -> int
        String numStr = "12345";
        int num = Integer.parseInt(numStr);

//        int -> String
        int val = 99;
        String valStr = Integer.toString(val);

        try {
            int bad = Integer.parseInt("abc"); // 숫자가 아닌 문자 -> 예외!
        } catch (NumberFormatException e) {
            System.out.println("예외 발생!" + e.getMessage());
        }

//        진수 변환
//        -> 2진수(Binary), 8진수(Octal), 16진수(Hexadecimal)
        int n = 255;
        System.out.println(n + "의 2진수: " + Integer.toBinaryString(n));
        System.out.println(n + "의 8진수: " + Integer.toOctalString(n));
        System.out.println(n + "의 16진수: " + Integer.toHexString(n));

//        반대로 2진수 문자열 -> 10진수 변환 (parseInt의 두 번째 파라미터 : 진수)
        System.out.println("\"11111111\" -> 10진수: " + Integer.parseInt("11111111", 2));

//        비교 - Integer.compare(a, b)
//        반환값이 음수면: a < b / 0이면: a == b / 양수면: a > b
//        단순히 a - b를 반환하면 오버플로우 위험이 있어 compare 사용 권장
        System.out.println("compare(10, 20): " + Integer.compare(10, 20));
        System.out.println("compare(20, 20): " + Integer.compare(20, 20));
        System.out.println("compare(30, 20): " + Integer.compare(30, 20));

//        TODO
        /*
         * [기초]
         * 1.
         * 문자열 배열 {"10", "20", "30", "40", "50"}을
         * Integer.parseIint()로 int 배열로 변환하세요
         * 변환한 배열의 합계와 평균을 출력하세요
         * 힌트 : int[] nums = new int[5]; nums[i] = Integer.parserInt(strs[i]);
         * 2.
         * Integer.MAX_VALUE와 Integer.MIN_VALUE를 출력하세요
         * 두 값을 더했을 때 오버플로우가 발생하는지 확인하세요
         * Long 타입으로 같은 연산을 하면 결과가 달라지는지 비교하세요
         *
         * [심화]
         * 1. 진법 변환 출력
         * 정수 255를 2진수, 8진수, 16진수로 변환해서 출력하세요
         * 추가로 직접 while 루프로 2진수 변환도 구현하세요
         * 2. 문자열 숫자 배열 통계
         * {"23", "45", "12", "67", "89", "34"}를 int 배열로 변환 후
         * 합계 평균 최댓값 최솟값을 모두 출력하세요
         * Integer.compare(a, b)로 두 수를 비교하는 방법도 활용해보세요
         * */

//        1번 풀이
        String[] strs = {"10", "20", "30", "40", "50"};
        int[] nums = new int[5];
        int sum = 0;

        for (int i = 0; i < nums.length; i++) {
            nums[i] = Integer.parseInt(strs[i]);
            sum += nums[i];
        }
        System.out.println("합계: " + sum);
        System.out.println("평균: " + sum / nums.length);

//        2번 풀이
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);
        System.out.println(Integer.MAX_VALUE + Integer.MIN_VALUE);
        System.out.println((long) Integer.MAX_VALUE + (long) Integer.MIN_VALUE);

//        [심화] 1번 풀이
        int num1 = 255;
        System.out.println(Integer.toBinaryString(num1));
        System.out.println(Integer.toOctalString(num1));
        System.out.println(Integer.toHexString(num1));

        while (num1 >= 0) {
            System.out.print(num1 % 10);
        }

    }
}
