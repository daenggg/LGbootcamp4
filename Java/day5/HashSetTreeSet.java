/*
* HashSet & TreeSet (집합 자료구조)
* Set이 무엇인지, List와의 차이를 이해한다
* HashSet의 특징(중복 없음, 순서 없음) 을 이해한다
* TreeSet의 특징(중복 없음, 자동 정렬) 을 이해한다
* add , contains , remove 메서드를 사용할 수 있다.
* 합집합, 교집합, 차집합 연산을 구현할 수 있다.
* */


import java.util.HashSet;
import java.util.TreeMap;
import java.util.TreeSet;

public class HashSetTreeSet {
    static void main(String[] args) {
        /*
        * Set이란?
        * Set은 '집합'을 표현하는 자료도구입니다.
        * List 와의 핵심 차이:
        * list - 순서 있음, 중복 허용
        * Set - 중복 없음 -> 중복이 자동으로 제거됨
        * Set의 종류 :
        * HastSet : 순서 없음, 속도 빠름 (검색/추가/삭제 평균 O(1))
        * TreeSet : 자동 정렬(오름차순) , 속도는 해쉬셋보단 약간 느림 (O(log n))
        * + LinkedHashSet : 입력한 순서 유지 , HashSet보다 약간 느림
        *
        * HashSet - 중복 없음, 순서 보장 없음
        * TreeSet - 중복 없음 , 자동 오름차순 정렬
        * */

        HashSet<String> set = new HashSet<>();
        set.add("자바"); set.add("파이썬"); set.add("자바"); // 중복 -> 무시
        System.out.println(set);
        System.out.println(set.contains("자바"));
        set.remove("파이썬");
        System.out.println(set);

//        중복 제거 활용 패턴
        int[] arr = {3,1,4,1,5,9,2,6,5,3};
        HashSet<Integer> unique = new HashSet<>();
        for (int n : arr) unique.add(n);
        System.out.println(unique);

//        TreeSet
//        HashSet과 같지만, 요소가 항상 오름차순으로 정렬되어 있습니다.
//        내부적으로 "이진 탐색 트리" 구조를 사용합니다.
//        숫자 작은것부터 문자는 사전순대로 정렬
//        TreeSet - 자동 정렬
        TreeSet<Integer> tree = new TreeSet<>();
        tree.add(5);
        tree.add(1);
        tree.add(3);
        tree.add(2);
        tree.add(4);
        System.out.println(tree);

//        TreeSet 만의 특별한 메소드
        System.out.println("첫 번째 (최소값)" + tree.first());
        System.out.println("마지막 (최대값)" + tree.last());

        System.out.println("5 미만의 수: "+ tree.headSet(5));
        System.out.println("5 이상의 수: "+ tree.tailSet(5));

        System.out.println("2이상 5미만 : "+ tree.subSet(2,5));
//        내림차순 정렬 : descenddingSet()
        System.out.println(tree.descendingSet());

    /*
    * 집합 연산
    * 수학의 집한 연산과 개념이 동일합니다
    * 합집합  : A U B = A 또는 B 에 있는 모든 요소
    * 교집합  : A N B = A 와 B 에 있는 공통 요소
    * 차집합  : A - B = A 에는 있지만 B에는 없는 요소
    * Java에서는 HashSet의 메서드로 집합 연산을 수행합니다.
    * addAll() -> 합집합
    * retainAll() -> 교집합
    * removeAll() -> 차집합
    *
    * 주의 : 이 메서드들은 원본을 수정합니다! 원본이 필요하시면 복사본에서 사용하세요.
    * */

        HashSet<Integer> setA =new HashSet<>();
        setA.add(1);
        setA.add(2);
        setA.add(3);
        setA.add(4);
        setA.add(5);

        HashSet<Integer> setB =new HashSet<>();
        setB.add(3);
        setB.add(4);
        setB.add(5);
        setB.add(6);
        setB.add(7);

        System.out.println(setA);
        System.out.println(setB);

//        합집합
//         addAll() 은 다른 컬렉션의 모든 요소를 추가합니다. 복사에서 써보겠음
        HashSet<Integer> union = new HashSet<>(setA); //setA의 복사본 생성
        union.addAll(setB);
        System.out.println(union);

//        교집합
//         retainAll()은 다른 컬렉션에도 있는 요소만 남기고 나머지는 삭제합니다.
        HashSet<Integer> intersection = new HashSet<>(setA); //setA의 복사본 생성
        intersection.retainAll(setB);
        System.out.println(intersection);

//        차집합 setA - setB
//         removeAll()은 다른 컬렉션에 있는 모든 요소들을 삭제합니다.
        HashSet<Integer> differenceA = new HashSet<>(setA); //setA의 복사본 생성
        differenceA.removeAll(setB);
        System.out.println(differenceA);

//        차집합 setB - setA
        HashSet<Integer> differenceB = new HashSet<>(setB); //setA의 복사본 생성
        differenceB.removeAll(setA);
        System.out.println(differenceB);

//        실용 예제 : 출석 명단과 결석 체크
//        전체 수강생 명단 (TreeSet - 이름 정렬 유지)
        TreeSet<String> allStudents = new TreeSet<>();
        allStudents.add("짱구");
        allStudents.add("철수");
        allStudents.add("맹구");
        allStudents.add("훈이");
        allStudents.add("유리");

//        오늘 출석한 학생 (HashSet - 빠른 검색용)
        HashSet<String> attended = new HashSet<>();
        attended.add("철수");
        attended.add("맹구");
        attended.add("훈이");

        System.out.println("전체 수강생: "+ allStudents);
        System.out.println("출석 학생: "+ attended);

//        결석 학생 = 전체 - 출석 (차집합)
        TreeSet<String> absent = new TreeSet<>(allStudents);
        absent.removeAll(attended);
        System.out.println("결석 학생: " + absent);

//        특정 학생 출석 여뷰 확인
        String checkName = "짱구";
        if (attended.contains(checkName)){
            System.out.println(checkName+"님은 출석 했습니다.");
        } else {
            System.out.println(checkName+"님은 결석 했습니다.");
        }

        /*
        * TODO 실습문제
        *  [기초]
        * 1
        * 정수 배열 { 1,2,3,4,5,3,2,1} 을 해쉬셋에 모두 넣으세요
        * 출력 후 크기(중복 제거된 원소 수)를 출력하세요
        * 2
        * 문자열 {"바나나","사과","체리","딸기"} 를 트리셋에 넣으세요
        * 정렬된 첫 요소와 마지막 요소를 출력하세요
        * [심화]
        * 로또 번호 생성기
        * 1~45 범위에서 중복 없이 6개의 숫자를 뽑아 오름차순으로 출력하세요
        * HashSet + Random 또는 TreeSet + Random으로 구현하세요
        * 3회 반복 출력하세요
        * 힌트 : while (set.size() < 6) set.add(random.nextInt(45)+1;)
        * */

    }








}
