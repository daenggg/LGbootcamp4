/*
* String vs StringBuilder 성능 비교, append/insert/delete/reverse
* String이 불변이어서 반복적으로 연결할 때 성능이 나쁜 이유를 이해한다
* 스트링빌더가 성능 문제를 어떻게 해결하는지 이해한다
* 스트링빌더의 주요 메서드를 익힌다
* */


public class StringBuilders {
    static void main(String[] args) {
//        String 반복 연결의 문제점
//        String은 불변이라 + 할 때마다 새 객체가 생성된다
//        반복 횟수가 많아질수록 메모리 낭비가 심해진다

//        아래 주석 해제하여 확인 10만은 오래걸림.
//        느린 방식 : String + 연산 반복 (객체가 반복마다 새로 생성됨)
//        String result = "";
//        for (int i =0; i <100000; i++){
//            result += i; // 매번 새 String 객체 생성!
//        }
//        System.out.println(result);

//        빠른 방식: StringBuilder 사용 (내부 버퍼에 이어 붙임)

//        StringBuilder sb = new StringBuilder();
//        for (int i = 0; i < 100000; i++){
//            sb.append(i); // 같은 객체에 계속 추가!
//        }
//        System.out.println(sb.toString());

//  StringBuilder 주요 메서드
        /*
        * append() : 끝에 추가
        * insert() : 특정 위치에 삽입
        * delete() : 특정 범위 삭제
        * deleteCharAt() : 특정 위치 문자 하나 삭제
        * replace() : 특정 범위를 다른 문자열로 교체
        * reverse() : 전체 문자열 뒤집기
        * toString() : String으로 변환
        * */
        StringBuilder sb2 = new StringBuilder("Hello");

        sb2.append(", World");
        System.out.println(sb2);

        sb2.insert(5,"!!!");
        System.out.println(sb2);

        sb2.delete(5,8);
        System.out.println(sb2);

        sb2.replace(7,12, "Java");
        System.out.println(sb2);

        sb2.reverse();
        System.out.println(sb2);

//        StringBuilder로 문자열 조립하기
//        반복문 안에서 문자열을 만들 때는 항상 StringBuilder를 사용해보자
//        패턴1 : 구분자를 사이에 넣어 연결 (마지막엔 구분자 없음)
        String[] items = {"사과","바나나","체리"};
        StringBuilder sb3 = new StringBuilder();
        for (int i = 0; i < items.length; i++) {
            sb3.append(items[i]);
            if (i < items.length-1) sb3.append(", ");
        }
        System.out.println("연결 결과: "+ sb3);

//        패턴 2 : append 체이닝 = 메서드를 연속으로 이어 쓰기
        String table = new StringBuilder()
                .append("이름 : 홍길동").append("\n")
                .append("나이: 30").append("\n")
                .append("직업:개발자")
                .toString();
        System.out.println(table);


//        TODO 문제
        /*
        * [기초]
        * 1
        * 스트링빌더를 사용해 1부터 10까지 숫자를 ", "로 연결한 문자열을 만드세요
        * 힌트 : sb.append(i); if(i <10) sb append(", ")
        * 2
        * reverse를 써서 문자열을 거꾸로 출력해보세요
        * 시간이 된다면 for문으로 구현해보세요
        * [심화]
        * StringBuilder 로 구구단 전체 출력
        * 스트링빌더 하나에 2단~9단 전체 구구단을 저장하고 한번에 출력하세요
        * */




    }

    //    기초1번
    static String listNumbers() {
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <=10; i++){
            sb.append(i);
            if (i < 10 )sb.append(", ");
        }
        return sb.toString();
    }

//    심화
    static  String buildMultiplecationTable() {
        StringBuilder sb = new StringBuilder();
        for (int dan = 2; dan <=9; dan++){
            sb.append("--- ").append(dan).append("단 ---\n");
            for (int i = 1; i <=9 ; i++) {
                sb.append(dan).append(" x ").append(i)
                        .append(" = ").append(dan*i).append("\n");

            }
            sb.append("\n");
        }
        return sb.toString();
    }




}
