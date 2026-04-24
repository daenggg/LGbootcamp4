/*
* ArrayList (동적 배열)
* ArrayList가 무엇인지, 일반 배열과의 차이를 이해한다
* add, remove, get ,size , contains , indexOf 메서드를 사용할 수 있다
* for-each 문과 Iterator로 ArraysList 순회할수 할수 있다.
*Collections.sort로 정렬할수있다
* 2차원 ArrayList를 만들어볼수 있다.
* */


import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class ArrayLists {
    static void main(String[] args) {
        /*
        * ArrayList란?
        * 일반 배열 int[] 은 크기를 처음에 고정해야 합니다
        * int[] arr = new int[5]; -> 딱 5칸, 늘리거나 줄일 수 없음
        *
        * ArrayList는 크기가 자동으로 늘어나는 '동적 배열'입니다
        * 요소를 추가하면 자동으로 공간이 늘어납니다
        * 요소를 삭제하면 자동으로 공간이 줄어듭니다
        * 내부적으로는 일반 배열로 구현되어 있지만, 크기 관리를 ArrayList가 대신 해줍니다
        *
        * 사용하려면 import java.util.ArrayList 가 필요합니다.
        * */

//        1. 생성 및 기본 조작
        ArrayList<String> fruits = new ArrayList<>();
        ArrayList<Integer> test = new ArrayList<>();

//        2. add() - 요소 추가
//        add(요소) : 맨 뒤에 요소를 추가합니다
//        add(인덱스, 요소) : 특정 위치에 요소를 추가합니다. (기존 요소는 뒤로 밀림)
        fruits.add("사과");
        fruits.add("바나나");
        fruits.add("딸기");
        fruits.add("오렌지");
        fruits.add("포도");

        test.add(1);
        test.add(2);
        test.add(0);
        test.add(1);

        System.out.println(test);
        test.remove((Integer) 0);
        System.out.println(test);

        System.out.println(fruits);

//        인덱스 1번 위치에 "망고" 삽입 -> 기존 요소들은 뒤로 밀림
        fruits.add(1,"망고");
        System.out.println(fruits);

//        3. size() - 요소 개수
//        현재 ArrayList에 들어있는 요소의 개수를 반환합니다.
//        일반 배열의 .length와 비슷하지만, 실제 담긴 요소 수를 돌려줍니다.
        System.out.println(fruits.size());

//        4. get() - 요소 가져오기
//        get(인덱스)  : 해당 위치의 요소를 반환합니다.
//        인덱스는 0부터 시작이죠! (0-based index)
        System.out.println(fruits.get(0));
        System.out.println(fruits.get(2));

//        5. contains() - 포함 엽 확인
//        contains(요소) : 해당 요소가 있으면 true, 없으면 false 반환
        System.out.println("바나나 포함 여부: " + fruits.contains("바나나"));
        System.out.println("수박 포함 여부: " + fruits.contains("수박"));

//        6. indexOf() - 위치(인덱스) 찾기
//        indexOf(요소) : 해당 요소가 처음 등장하는 인덱스를 반환합니다
//        없으면 -1을 반환합니다
        System.out.println("오렌지 위치: " + fruits.indexOf("오렌지"));
        System.out.println("수박 위치: " + fruits.indexOf("수박"));

//        7. remove() - 요소 삭제
//        remove(인덱스) : 해당 위치의 요소를 삭제하고, 삭제된 요소를 반환합니다.
//        remove(객체) : 해당 값을 가진 첫 번째 요소를 삭제합니다.
//        주의 : Integer 타입 ArrayList 에서 숫자를 삭제할 때 혼동 주의
        String removed = fruits.remove(0);
        System.out.println(removed);
        System.out.println(fruits);

        fruits.remove("포도");
        System.out.println(fruits);

//        8. set - 요소 수정
//        set(인덱스, 새값) : 해당 위치의 요소를 새 값으로 교체합니다.
        fruits.set(0,"키위");
        System.out.println(fruits);

        System.out.println();

//        ArrayList 순회 방법
        ArrayList<String> colors =new ArrayList<>();
        colors.add("빨강");
        colors.add("초록");
        colors.add("파랑");
        colors.add("노랑");

//        방법 1 : 일반 for문 (인덱스 사용)
//        인덱스가 필요할 때, 또는 역순 순회가 필요할 때 사용합니다.
        for (int i = 0 ;i <  colors.size(); i++){
            System.out.println(i + " 번 " + colors.get(i));
        }

//        방법 2 : for-each 문
//        인덱스가 필요 없을 때, 코드가 간결해집니다
//        colors 에서 하나씩 꺼내서 color라는 변수에 담아서 처리하겠다 라는 의미입니다.
        for (String color : colors){
            System.out.println(color);
        }

//        방법 3 : Iterator (반복자)
//        Iterator 는 컬렉션을 순차적으로 탐색하는 도구입니다.
//        순회 중에 요소를 안전하게 삭제할 때 특히 유용합니다.
//        hasNext() : 다음 요소가 있으면 true
//        next() : 다음 요소를 가져오고 커서를 이용
        Iterator<String> iter = colors.iterator();
        while (iter.hasNext()) {
            String c = iter.next();
            System.out.println(c);
        }
        System.out.println();

//        Collections.sort() - ArrayList 정렬
//        java.util.Collections 클래스의 정적 메서드입니다.
//        기본값 : 오름차순 (숫자 : 작은 것부터 문자 : 사전순)
        ArrayList<Integer> numbers = new ArrayList<>();
        numbers.add(5);
        numbers.add(2);
        numbers.add(8);
        numbers.add(1);
        numbers.add(9);
        numbers.add(3);
        System.out.println(numbers);

        Collections.sort(numbers);
        System.out.println(numbers);

//        내림차순 정렬 : Collections.reverseOrder() 를 두 번째 인자로 전달
        Collections.sort(numbers, Collections.reverseOrder());
        System.out.println(numbers);

//        Collections의 다른 유용한 메서드들
        System.out.println("최소값 : " + Collections.min(numbers));
        System.out.println("최대값 : " + Collections.max(numbers));
        Collections.shuffle(numbers); //무작위 섞기
        System.out.println(numbers);

//        2차원 ArrayList
        /*
        * ArrayList를 담는 ArrayList 구조입니다.
        * ArrayList<ArrayList<Integer>> 라고 읽으면 됩니다
        *
        * matrix.get(행).get(열) 로 접근합니다
        * */

//      2차원 ArrayList 생성
        ArrayList<ArrayList<Integer>> matrix = new ArrayList<>();
//      3행을 만들어서 추가합니다.
        for (int i = 0; i <=3; i++){
            ArrayList<Integer> row = new ArrayList<>(); // 각 행(row)를 만들고
            for (int j =0; j < 3; j++){
                row.add(i*3+j+1);// 1~9값 채우기
            }
            matrix.add(row); // matrix에 추가
        }

        //    2차원 ArrayList 출력
        for (int i = 0; i < matrix.size(); i++){
            for (int j = 0 ; j < matrix.get(i).size() ; j++){
                System.out.printf("%3d", matrix.get(i).get(j));
            }
            System.out.println();
        }

//        특정 요소 접근 : 2행 1열
        System.out.println(matrix.get(2).get(1));

//      추가 유용한 메서드들
        /*
        * isEmpty() : 비어있으면 true 아니면 false
        * clear() : 모든 요소 삭제
        * addAll() : 다른 컬렉션의 모든 요소를 한 번에 추가
        * subList() : 부분 리스트 (시작 인덱스 포함, 끝 인덱스 미포함)
        * toArray() : ArrayList 를 배열(Array)로변환
        * */

//        addAll()
        ArrayList<Integer> a = new ArrayList<>();
        a.add(1);a.add(2);a.add(3);
        ArrayList<Integer> b = new ArrayList<>();
        b.add(4);b.add(5);b.add(6);
        a.addAll(b); // b의 모든 요소를 a에 추가
        System.out.println(a);

//        TODO 실습문제
        /*
        * [기초]
        * String ArrayList에 학생 이름 5개 추가하세요
        * Collection.sort() 로 오름차순 정렬하세요
        * 첫 번째 이름 삭제하고 최종 리스트 출력하세여
        *
        * [심화] 중복 없는 합계
        * [3,1,4,1,5,9,2,6,5,3] 을 ArrayList에 추가하세요
        * 이미 들어있는 숫자는 건너뛰어 중복 제거 리스트를 만드세요
        * 중복 제거된 숫자들의 합계를 출력하세요
        * */





    }









}
