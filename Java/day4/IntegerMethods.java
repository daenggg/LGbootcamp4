/*
* Integer 클래스
* 기본 자료형 int와 참조 자료형 Integer의 차이를 이해한다
* 래퍼 클래스(Wrapper class)의 역할을 이해한다
* Integer 클래스의 주요 상수와 메서드를 익힌다
* 오토박싱/ 언방식 개념을 이해한다
* */


public class IntegerMethods {
    static void main(String[] args) {
        /*
        * 기본형 int vs 래퍼 클래스 Integer
        * int : 기본 자료형, 값 자체를 저장, null 불가
        * Integer : 객체(클래스), null 가능, 메서드와 상수를 제공
        * 래퍼 클래스가 필요한 이유 : 컬렉션(ArrayList 등)은 객체만 저장 가능
        * */
        int primitive = 42; //기본형
        Integer boxed = 42; // 래퍼 클래스 (오토박싱 : int -> Integer 자동 변환)
        int unboxed = boxed; // 언방식 : Integer -> int 자동 변환

        Integer nullableInt = null; //Integer는 null 가능 (int는 불가)
        System.out.println(nullableInt);

//        Integer의 주요 상수 - MAX_VALUE, MIN_VALUE
//        int 가 표현할 수 있는 최대/최소값
//        초과하면 오버플로우 발생!
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);

//        오버플로우 : 최대값  +1 하면 최솟값으로 순환된다
        System.out.println(Integer.MAX_VALUE+1); // 오버플로우
        System.out.println((long) Integer.MAX_VALUE+1);


//        형 변환
//        String -> int : Integer.parseInt("123")
//        String -> Integer : Integer.valueOf("123")
//        int -> String : Integer.toString(123) or String.valueOf(123)
//        String -> int
        String numStr = "12345";
        int num = Integer.parseInt(numStr);

//        int -> String
        int val = 99;
        String valStr = Integer.toString(val);

        try {
            int bad = Integer.parseInt("abc"); //숫자가 아닌 문자 -> 예외!
        } catch (NumberFormatException e){
            System.out.println("예외 발생!" + e.getMessage());
        }

//        진수 변환
//        -> 2진수(Binary) , 8진수(Octal) , 16진수(Hexadecimal)
        int n = 255;
        System.out.println(n + "의 2진수: "+Integer.toBinaryString(n));
        System.out.println(n + "의 8진수: "+Integer.toOctalString(n));
        System.out.println(n + "의 16진수: "+Integer.toHexString(n));

//        반대로 2진수 문자열 -> 10진수 변환 (parseInt의 두 번째 파라미터: 진수)
        System.out.println("\"11111111\" ->10진수: "+ Integer.parseInt("11111111",2));

//         비교 - Integer.compare(a, b)
//        반환값이 음수: a < b / 0 : a == b / 양수 : a > b
//        단순히 a - b 를 반환하면 오버플로우 위험이 있어 compare 사용 권장
        System.out.println("compare(10,20): "+ Integer.compare(10,20));
        System.out.println("compare(20,20): "+ Integer.compare(20,20));
        System.out.println("compare(30,20): "+ Integer.compare(30,20));

//        TODO
        /*
        * [기초]
        * 1.
        * 문자열 배열 {"10","20","30","40","50"} 을
        * Integer.pareseInt()로 int 배열로 변환하세요
        * 변환한 배열의 합계와 평균을 출력하세요
        * 힌트 : int[] nums = new int[5]; nums[i] = Integer.parseInt(strs[i]);
        * 2.
        * Integer.MAX_VALUE와 Integer.MIN_VALUE를 출력하세요
        * 두 값을 더했을 때 오버플로우가 발생하는지 확인하세요
        * Long 타입으로 같은 연산을 하면 결과가 달라지는 비교하세요
        *
        * [심화]
        * 1. 진법 변환 출력
        * 정수 255를 2진수,8진수,16진수로 변환해서 출력하세요
        * 추가로 직접 while 루프로 2진수 변환도 구현하세요
        * 2. 문자열 숫자 배열 통계
        * {"23","45","12","67","89","34"}를 int 배열로 변환 후
        * 합계 평균 최대값 최솟값을 모두 출력하세요
        * Integer.compare(a,b)로 두 수를 비교하는 방법도 활용해보세요
        *
        * */

        // [기초 1] 문자열을 정수로 변환 및 통계
        System.out.println("[기초 1] 문자열 배열 -> int 합계와 평균");
        String[] strs = {"10", "20", "30", "40", "50"};
        int[] nums = new int[strs.length];
        int sum = 0;

        for (int i = 0; i < strs.length; i++) {
            nums[i] = Integer.parseInt(strs[i]); // 문자열을 정수로!
            sum += nums[i];
        }
        double avg = (double) sum / nums.length;
        System.out.println("합계: " + sum + ", 평균: " + avg);

        // [기초 2] 정수 최대/최솟값 및 오버플로우
        System.out.println("\n[기초 2] 최대/최솟값과 오버플로우");
        System.out.println("Integer 최대값: " + Integer.MAX_VALUE);
        System.out.println("Integer 최소값: " + Integer.MIN_VALUE);

        // 오버플로우 테스트
        int overflow = Integer.MAX_VALUE + 1;
        System.out.println("최대값 + 1 = " + overflow + " (오버플로우 발생!)");

        // Long으로 연산 (오버플로우 방지)
        long safeSum = (long) Integer.MAX_VALUE + 1;
        System.out.println("Long으로 계산한 최대값 + 1 = " + safeSum + " (안전)");

        // [심화 1] 진법 변환
        System.out.println("[심화 1] 255의 진법 변환");
        int target = 255;
        System.out.println("2진수: " + Integer.toBinaryString(target));
        System.out.println("8진수: " + Integer.toOctalString(target));
        System.out.println("16진수: " + Integer.toHexString(target).toUpperCase());


        // [심화 2] 문자열 숫자 배열 상세 통계
        System.out.println("\n\n[심화 2] 문자열 숫자 배열 통계");
        String[] advancedStrs = {"23", "45", "12", "67", "89", "34"};
        printStatistics(advancedStrs);

    }

    // [심화 1 추가] while 루프로 2진수 직접 변환
    static void printBinaryManual(int n) {
        if (n == 0) { System.out.print(0); return; }
        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            sb.insert(0, n % 2); // 나머지를 앞에 붙임
            n /= 2;
        }
        System.out.print(sb.toString());
    }

    // [심화 2 추가] 합계, 평균, 최대, 최소 출력
    static void printStatistics(String[] strs) {
        int sum = 0;
        int max = Integer.MIN_VALUE; // 아주 작은 값으로 초기화
        int min = Integer.MAX_VALUE; // 아주 큰 값으로 초기화

        for (String s : strs) {
            int val = Integer.parseInt(s);
            sum += val;

            // Integer.compare(a, b) 활용 예시
            if (Integer.compare(val, max) > 0) max = val;
            if (Integer.compare(val, min) < 0) min = val;
        }

        System.out.println("합계: " + sum);
        System.out.println("평균: " + ((double)sum / strs.length));
        System.out.println("최대: " + max);
        System.out.println("최소: " + min);
    }
}
