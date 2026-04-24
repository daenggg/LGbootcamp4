/*
* HashMap (해시맵, 키-값 저장)
* HashMap이 무엇인지 이해하고, key-value 구조를 파악한다
* put , get , containsKey , getOrDefault , remove 를 사용할 수 있다
* keySet , values , entrySet 으로 HashMap 을 순회할수 있다
* 빈도수 세기 패턴을 익힌다
* */


import java.util.HashMap;
import java.util.Map;

public class HashMaps {
    static void main(String[] args) {
//        HashMap이란?
        /*
        * 해시맵은 '키(key) - 값(value)' 쌍으로 데이터를 저장합니다.
        * 마치 사전 (Dictionary)과 같습니다
        * 단어 (key) -> 뜻(value)
        * "apple" -> "사과"
        * "banana" -> "바나나"
        *
        * 실생활 비유:
        *   학번 (key) -> 학생 이름(value)
        *   전화번호부 : 이름 -> 전화번호
        *   성적표: 과목명 -> 점수
        *
        * 특징:
        * Key는 중복 불가 (같은 Key로 put하면 값이 덮어씌워짐)
        * value 는 중복 허용
        * 순서 없음 (입력한 순서가 보장되지 않음)
        * key 로 value를 O(1) 시간에 빠르게 탐색
        *
        * 사용하려면 import java.util.HashMap; 이 필요합니다.
        * */

//        해시맵 생성 및 기본 조작
//        해시맵 생성 < 키 타입, 값 타입>
        HashMap<String, Integer> scores = new HashMap<>();

//        put  - 키, 값 저장
//        put(키, 값) : 키-값 쌍을 저장합니다.
//        이미 존재하는 키라면 값을 덮어씁니다. (기존 값 반환)
//        새 키라면 null 반환합니다.
        scores.put("짱구", 95);
        scores.put("맹구", 88);
        scores.put("철수", 72);
        scores.put("유리", 91);

        System.out.println(scores);

//        같은 키로 다시 put하면 값이 업데이트 됩니다
        Integer oldValue = scores.put("철수",100); // 기존 값 72점이 반환됨
        System.out.println(oldValue);
        System.out.println(scores);
        System.out.println(scores.size());

//        get() - 값 가져오기
        /*
        * get(키) : 해당 키의 값을 반환합니다.
        * 키가 없으면 null 반환합니다.
        * + null을 int변수에 담으려 하면 NullPointerException 발생!
        * 이를 방지하기 위해 getOrDefault()를 사용합니다.
        * */
        Integer kimScore = scores.get("철수");
        System.out.println(kimScore);

        Integer unknownScore = scores.get("훈이");
        System.out.println(unknownScore);

//        getOrDefault() - 없으면 기본값 반환
//        getOrDefault(키, 기본값) : 키가 있으면 해당 값, 없으면 기본값 반환
//        null 처리를 안전하게 할 수 있는 방법
        int score1 = scores.getOrDefault("짱구",0);
        int score2 = scores.getOrDefault("훈이",0);
        System.out.println(score1);
        System.out.println(score2);

//        containsKey() / containsValue() - 포함 여부 확인
//        containsKey(키) : 해당 키가 있으면 true
//        containsValue(값) : 해당 값이 있으면 true
        System.out.println(scores.containsKey("짱구"));
        System.out.println(scores.containsKey("훈이"));
        System.out.println(scores.containsValue(100));

//        remove() = 키-값 삭제
//        remove(키) : 해당 키의 키-값 쌍을 삭제하고 값을 반환합니다.
        Integer removedScore = scores.remove("맹구");
        System.out.println(removedScore);
        System.out.println(scores);

//        해시맵 순회 방법
        HashMap<String, String> capitals = new HashMap<>();
        capitals.put("한국", "서울");
        capitals.put("일본", "도쿄");
        capitals.put("중국", "베이징");
        capitals.put("미국", "워싱턴 D.C.");
        capitals.put("프랑스", "파리");

//      방법 1 : keySet() - 키 집합으로 순회
//        keySet() : 모든 키를 Set으로 반환합니다.
//        키로 값을 꺼내서 사용할 수 있습니다.
        for (String country : capitals.keySet()) {
            System.out.println(country + " -> "+ capitals.get(country));
        }

//        방법 2 : values() - 값 컬렉션으로 순회
//        values() : 모든 값을 Collection으로 반환합니다.
//        키가 필요 없고 값만 필요할 때 사용합니다
        for (String capital : capitals.values()) {
            System.out.println(capital);
        }

//        방법 3 : entrySet() -> 키-값 쌍으로 순회 (가장 효율적)
        /*
        * entry.getKey() : 키 가져오기
        * entry.getValue() : 값 가져오기
        * keySet() 보다 효율적입니다.
        * import java.util.Map 이 필요합니다.
        * */
        for (Map.Entry<String, String> entry : capitals.entrySet()){
            System.out.println(entry.getKey() + " 의 수도: "+entry.getValue());
        }
//        빈도수 세기 패턴

        /*
        * 빈도수 세기 - 해시맵의 가장 중요한 활용 패턴
        * 배열이나 문자열에서 각 요소/문자가 몇 번 등장하는지 셀 때 사용합니다.
        * 알고리즘 문제에서 자주 나오는 패턴입니다.
        *
        * 핵심 로직:
        * map.put(요소, map.getOrDefault(요소, 0) + 1)
        * -> 이미 있으면 현재 카운트 + 1
        * -> 처음 등장이면 0 + 1 = 1로 저장
        * */
//        예제 1: 단어 빈도수 세기
        String sentence = "apple banana apple cherry banana apple cherry cherry";
        String[] words = sentence.split(" ");

        HashMap<String, Integer> wordCount = new HashMap<>();
        for (String word : words){
            // getOrDefault (word, 0) : word가 없으면 0, 있으면 현재 카운트 반환
            wordCount.put(word, wordCount.getOrDefault(word, 0)+1);
        }
        for (Map.Entry<String, Integer> entry : wordCount.entrySet()) {
            System.out.println(" "+ entry.getKey()+ " : "+ entry.getValue()+"번");
        }

//        예제 2: 문자 빈도수 세기
            String str = "hello world";
        HashMap<Character, Integer> charCount = new HashMap<>();

        for (char c : str.toCharArray()){
            if (c == ' ') continue; //공백 제외
            charCount.put(c , charCount.getOrDefault(c, 0) +1);
        }

        for (Map.Entry<Character, Integer> entry : charCount.entrySet()) {
            System.out.println(entry.getKey()+": "+ entry.getValue()+"번");
        }

//        예제 3 : 숫자 배열에서 빈도수 세기
        int[] nums = {1,3,2,1,4,3,2,1,5,3};
        HashMap<Integer, Integer> numCount = new HashMap<>();

        for (int n : nums){
            numCount.put(n ,numCount.getOrDefault(n,0) +1);
        }
        for (int key : numCount.keySet()){
            System.out.println(key+": "+numCount.get(key)+"번");
        }

//        가장 많이 등장한 숫자 찾기
        int maxCount = 0;
        int mostFrequent = -1;
        for (Map.Entry<Integer, Integer> entry : numCount.entrySet()){
            if (entry.getValue() > maxCount){
                maxCount = entry.getValue();
                mostFrequent = entry.getKey();
            }
        }
        System.out.println("가장 많이 등장한 숫자: "+mostFrequent + " "+ maxCount+"번 등장");

//       종합 실습 예제 - 학생 성적 관리
//        학생별 여러 과목 성적 관리 : HashMap<String, HashMap(String, Integer)>>
        HashMap<String, HashMap<String, Integer>> studentScores = new HashMap<>();

//        학생 데이터 추가
        HashMap<String, Integer> kimGrades = new HashMap<>();
        kimGrades.put("수학", 90);
        kimGrades.put("영어", 85);
        kimGrades.put("국어", 78);
        studentScores.put("김철수", kimGrades);

        HashMap<String, Integer> leeGrades = new HashMap<>();
        leeGrades.put("수학", 76);
        leeGrades.put("영어", 92);
        leeGrades.put("국어", 88);
        studentScores.put("이영희", leeGrades);

        // 출력
        for (Map.Entry<String, HashMap<String, Integer>> student : studentScores.entrySet()){
            System.out.println("\n" + student.getKey());
            int total = 0;
            for (Map.Entry<String, Integer> subject : student.getValue().entrySet()){
                System.out.println(subject.getKey()+": "+ subject.getValue());
                total += subject.getValue();
            }
            System.out.println("평균 : "+ (total / student.getValue().size()));
        }


//        TODO 실습 문제
        /*
        * [기초]
        * 1.전화번호부 해시맵
        * 이름 -> 전화번호 형태의 HashMap<String , String>을 만드세요
        * 3명의 정보를 put() 으로 추가하시고 특정 이름을 조회하세요
        * 없는 이름을 조회할 때 "없는 연락처입니다" 출력하세요
        * 2. 단어 빈도수 세기
        * 위에 있던 문자열 "apple banana apple cherry banana apple cherry cherry"에서
        * 각 단어가 몇 번 등장하는지 HashMap  형태로 세어보세요.
        * 결과를 "단어: 횟수" 형태로 출력하세요
        * [심화]
        * 1. 에너그램 판별
        *두 문자열이 서로 에너그램인 판별하는 메서드를 만드세요
        * 애너그램 : 같은 문자들로 구성, 순서만 다름 예) listen, silent
        * HashMap으로 각 문자의 빈도를 세어 비교하세요
        * listen, silent / hello, world 로 테스트하세요
        *2. 두 수의 합 찾기
        * 배열 {2,7,11,15} 와 target = 9 가 주어질 때,
        * 합이 target이 되는 두 원소의 인덱스를 출력하세요
        * 이중 for문과 HashMap방법 두 가지로 구해보세요.
        * */
//        심화 2번 풀이
        int[] twoSumArr = {2,7,11,15};
        int target = 9;
        HashMap<Integer, Integer> seen = new HashMap<>(); // 값 -> 인덱스 저장
        System.out.println("목표 값: "+ target);
        for (int i = 0; i < twoSumArr.length; i++){
            int complement = target - twoSumArr[i]; //짝궁 값
            if (seen.containsKey(complement)) {
                // 짝궁 값이 이미 HashMap에 있으면 -> 쌍 발견
                System.out.println(complement+ ", "+ twoSumArr[i] + " -> 합계:" + target);
            }
            seen.put(twoSumArr[i],i); //현재 값을 HashMap에 저장
        }





    }
//    심화 1번 풀이 메서드 에너그램 판별 메서드
    static boolean isAnagram (String s1, String s2){
        // 길이가 다르면 에너그램 불가
        if (s1.length() != s2.length()) return false;

        HashMap<Character, Integer> freq1 = new HashMap<>();
        HashMap<Character, Integer> freq2 = new HashMap<>();

//        첫 번째 문자열의 문자 빈도수 계산
        for (char c : s1.toCharArray()) {
            freq1.put(c, freq1.getOrDefault(c ,0)+1);
        }
//        두 번째 문자열의 문자 빈도수 계산
        for (char c : s2.toCharArray()) {
            freq2.put(c, freq2.getOrDefault(c ,0)+1);
        }
//        두 HashMap이 동일하면 애너그램
        return freq1.equals(freq2);
    }











}
