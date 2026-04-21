/*
* [4일차] String 클래스 주요 메서드
* String이 불변 (immutable) 객체임을 이해한다
* 자주 사용하는 String 메서드의 사용법을 익힌다
* 실제 문제에서 String 메서드를 조합해 사용하는 방법을 익힌다
* */


public class StringMethods {

    public static void main(String[] args) {
//        String은 불변 객체다
//        메서드를 호출해도 원본은 바뀌지 않는다.
//        항상 반환값을 새 변수에 받아야 합니다.
        String original = "Hello. Java!";
        original.toUpperCase(); // 반환값을 받지 않으면 아무 효과 없음!
        System.out.println(original);

        String upper = original.toUpperCase(); // 반환값을 변수에 저장해야 함
        System.out.println(upper);

//        기본 정보 메서드 - length , isEmpty , contains , startsWith, endsWith
        String s ="Hello, World";
        System.out.println("길이: "+ s.length());
        System.out.println("비어있나?: "+ s.isEmpty());
        System.out.println("포함 여부: " + s.contains("World"));
        System.out.println("시작 확인: " + s.startsWith("Hello"));
        System.out.println("끝 확인 : " + s.endsWith("!"));

//        검색 메서드 - indexOf, lastIndexOf
//        찾으면 인덱스(0부터) 반환, 없으면 -1 반환
        String sentence = "Java is great. Java is fun.";
        System.out.println("indexOf: " + sentence.indexOf("Java"));
        System.out.println("lastIndexOf: " + sentence.lastIndexOf("Java"));
        System.out.println("없는 문자: "+ sentence.indexOf("Python"));

//        추출 메서드 - charAt , substring
//        charAt(i) : i번쨰 문자 한 글자 반환
//        substring(a) : a번째부터 끝 까지
//        substring(a, b) : a번째부터 b번째 직전까지
        String word = "Programming";
        System.out.println("chatAt(0): " + word.charAt(0));
        System.out.println("substring(3): " + word.substring(3));
        System.out.println("substring(3,7): " + word.substring(3,7));

//        변환 메서드 - toUpperCase, toLowerCase, trim , replace
        String messy = "  Hello World  ";
        System.out.println("trim(): " + messy.trim()); // 앞뒤 공백 제거
        System.out.println("toUpperCass: " + messy.trim().toUpperCase());
        System.out.println("toLowerCass: " + messy.trim().toLowerCase());

        String text = "banana";
        System.out.println("replace: "+ text.replace('a', 'o'));
        System.out.println("replaceAll: "+text.replaceAll("an", "AN"));

//        분리 / 결합 - split , String.join
//        spilt(구분자): 문자열을 쪼개 배열로 반환
//        String.join(구분자, 배열) : 배열을 하나의 문자열로 합치기
        String csv ="사과,바나나,체리,딸기";
        String[] fruits = csv.split(",");
        System.out.println(fruits.length);
        for (String fruit : fruits){
            System.out.println(fruit);
        }
        String joined = String.join(" / ", fruits);
        System.out.println(joined);

//        문자열 비교 - equals vs ==
//        == : 주소(차조)비교 -> 대부분  false (new로 만든 경우)
//        equals() : 내용 비교 -> 올바른 방법!
//        equalsIgnoreCase() : 대소문자 무시하교 비교
        String a = new String("hello");
        String b = new String("hello");
        System.out.println("== 비교: " + (a == b));
        System.out.println("equals 비교: " + a.equals(b));
        System.out.println("equalsIgnoreCase() 비교: " + a.equalsIgnoreCase("Hello"));

//        형 변환 String <-> int
//        String -> int : Integer.parseInt("123")
//        int -> String : String.valueOf(123) 또는 123 + ""
        String numStr = "123";
        int num = Integer.parseInt(numStr);
        System.out.println("parseInt: "+ (num+1));

        int val = 456;
        String valStr = String.valueOf(val);
        System.out.println("valueOf: " + (valStr+"7"));

//        TODO 문제
        /*
        * [기초]
        * 1. 특정 문자 개수 세기
        * 문자열 "Hello, World! Hello Java!"에서 "l"이 몇 번 등장하는지 세세요.
        * for 루프와 charAt() 또는 indexOf()를 활용하세요
        * 2. 팰린드롬 확인
        * 문자열이 팰린드롬(앞뒤가 같은 문자열)인지 확인하는 메서드를 만드세요.
        * - "racecar" , "hello" , "madam" 으로 테스트하세요.
        * 힌트 :str.equals(new StringBuilder(str).reverse().toString()) 꼭 써야하는건 아님
        * [심화]
        * 1.
        * 단어 첫 글자 대문자 변환
        * "hello world from java" -> "Hello World From Java"로 변환하세요
        * split(" ")으로 단어 분리 후 각 단어의 첫 글자를 대문자 처리후 합쳐보자
        * 2.
        * 가장 많이 등장하는 문자 찾기
        * "programming" 에서 가장 많이 등장하는 문자와 횟수를 출력하세요
        * 공백 제외, 대소문자 구분 없이 처리하세요
        * */


    }
//    TODO 문제 풀이
//    1.
    static int countChar(String str, char target){
        int count = 0;
        for (int i = 0; i < str.length(); i++){
            if (str.charAt(i) == target) count++;
        }
        return count;
    }
//    2. 풀이가 2개임
    static boolean isPalindrome(String str){
        String reversed = new StringBuilder(str).reverse().toString();
        return str.equals(reversed);
    }
//    2. 두번째 풀이
    static boolean isPalindrome2(String str){
//        1) 문자열의 절반만 돌면 됩니다 - 앞뒤를 짝지어 비교
        int len = str.length();

        for (int i = 0; i < len / 2; i++){
//            2) 앞쪽문자(i)와 대응하는 뒤쪽 문자(len - 1 - i)를 비교
            char front = str.charAt(i);
            char back = str.charAt(len-1-i);

            if (front != back) {
//                3)하나라도 다르면 바로 아니오 false
                return false;
            }

        }
//        4) 끝까지 무사히 통과했다면 회문 맞음
        return true;

    }

//    심화 1.
    static String toTitleCase(String sentence) {
        String[] words = sentence.split(" ");
        for (int i = 0; i < words.length; i++){
            if(words[i].length() > 0) {
//                첫 글자 대문자 + 나머지 그대로
                words[i] = words[i].substring(0,1).toUpperCase() + words[i].substring(1);
            }
        }
        return String.join(" ", words);
    }

//    2.
    static void findMostFrequentChar(String str) {
        str = str.toLowerCase().replace(" ",""); //공백 제외, 소문자 처리
        int[] freq = new int[128]; // 아스키 범위 배열
        for (int i = 0; i < str.length(); i++){
            freq[str.charAt(i)]++;
        }
//        밑에 작은따옴표로  char 지정해 준게 중요함.
        char maxChar = ' ';
        int maxCount = 0;

        for (int i = 0 ; i <freq.length; i++){
            if (freq[i] > maxCount) {
                maxCount = freq[i];
                maxChar = (char) i;
            }
        }
        System.out.println("가장 많이 나온 문자: "+ maxChar +" "+ maxCount);

    }










}
