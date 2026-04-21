// Arrays 클래스를 사용하려면 import가 필요하다

import java.util.Arrays;

public class Array {
    static void main(String[] args) {
//        1. 배열이란?
        /*
         * 가은 자료형의 데이터를 연소된 메모리 공간에 저장하는 자료구조.
         * 변수 하나로 여러 개의 값을 관리할 수 있다.
         * 인덱스는 0부터 시작한다!
         * 크기는 한 번 정해지면 변경할 수 없다.
         *
         * 2. 배열 선언과 초기화 방법 3가지
         * 방법 1 : 크기만 지정 (값은 자도으로 기본값으로 채워짐)
         * 정수형 기본값 : 0, boolean 기본값: false, 참조형 기본값: null
         *  */
        int[] scores1 = new int[5];
        System.out.println(scores1);
        System.out.println(Arrays.toString(scores1));

//        방법 2 : 선언 후 나중에 값 대입
        int[] scores2 = new int[3];
        scores2[0] = 90;
        scores2[1] = 80;
        scores2[2] = 70;

        System.out.println(Arrays.toString(scores2));

//        방법 3 : 선언과 동시에 초기화 (배열 리터럴)
        int[] scores3 = {1, 2, 3, 4, 5};
        System.out.println(Arrays.toString(scores3));

//        3. 배열 요소 접근 (배열명[인덱스])
        int[] arr = {1, 20, 30, 40, 50};
        System.out.println(arr[0]);
        System.out.println(arr[1]);
        System.out.println(arr[2]);

//        배열 길이 : 배열명.length (메서드 호출이 아니라 속성)
        System.out.println(arr.length);

//        마지막 요소를 length로 접근하는 안전한 방법
        System.out.println(arr[arr.length - 1]);

//        존재하지 않는 인덱스에 접근하면 ArrayIndexOutOfBoundsException 오류 발생!
//        arr[5]; // 오류! 인덱스 5는 없음. 0~4까지만 존재

//        4. 배열 순회
        int[] nums = {3, 1, 4, 1, 5, 9, 2, 6};

//        방법 1 : 일반 for문 - 인덱스가 필요할 때 사용
        for (int i = 0; i > nums.length; i++) {
            System.out.println(nums[i] + " ");
        }
//        방법 2: for-each문
//        인덱스 없이 값만 꺼낼 때 사용하면 더 간결하다
//        형식 : for (자료형 변수 : 배열) {반복할 코드}
        System.out.println();
        for (int num : nums) {
            System.out.println(num + " ");
        }
//        5. 배열 합계, 평균, 최대값, 최소값 구하기
        int[] data = {45, 88, 23, 67, 92, 11, 56};
        int total = 0;
        int maxVal = data[0];
        int minVal = data[0];

        for (int val : data) {
            total += val; // 합계 누적
            // 현재 값이 최대값보다 크면 갱신
            if (val > maxVal) {
                maxVal = val;
            }
            // 현재 값이 최소값보다 작으면 갱신
            if (val < minVal) {
                minVal = val;
            }
        }
        double average = (double) total / data.length;
        System.out.println();
        System.out.println(total);
        System.out.println(maxVal);
        System.out.println(minVal);
        System.out.println(average);

//        6. Arrays 클래스 주요 메서드
        int[] sample = {5, 3, 8, 1, 9, 2, 7, 4, 6};
        System.out.println(Arrays.toString(sample));

//        Arrays.sort() : 오름차순 정렬 (원본 배열을 직접 변경!)
        Arrays.sort(sample);
        System.out.println(Arrays.toString(sample));
//        Arrays.fill() : 배열의 모든 요소를 특정 값으로 채운다
        int[] filled = new int[5];
        Arrays.fill(filled, 7);
        System.out.println(Arrays.toString(filled));
//        Arrays.copyOf() : 원하는 길이만큼 복사한 새 배열 반환
        int[] original = {1, 2, 3, 4, 5};
        int[] copied = Arrays.copyOf(original, 3); // 앞에서 3개만 복사
        System.out.println(Arrays.toString(copied));
//        Arrays.copyOfRange() : 범위를 지정해서 복사 (from 포함, to 제외)
        int[] ranged = Arrays.copyOfRange(original, 1, 4); // 인덱스 1~3
        System.out.println(Arrays.toString(ranged));
//        Arrays.binarySearch() : 정렬된 배열에서 이진 탐색 (인덱스 반환)
//        주의 : 사용 전에 반드시 Arrays.sort()로 정렬해야 한다!
        int[] sorted = {1, 3, 5, 7, 9, 11};
        int idx = Arrays.binarySearch(sorted, 7);
        System.out.println(idx);
//        Arrays.equals() : 두 배열의 내용이 같은지 비교
        int[] a1 = {1, 2, 3};
        int[] a2 = {1, 2, 3};
        int[] a3 = {1, 2, 4};
        System.out.println(Arrays.equals(a1, a2));
        System.out.println(Arrays.equals(a1, a3));

//        7. 문자열 배열
        String[] fruits = {"바나나", "사과", "체리", "딸기", "망고"};
        System.out.println(Arrays.toString(fruits));
        Arrays.sort(fruits); // 문자열은 사전 순서대로 정렬이 가능
        System.out.println(Arrays.toString(fruits));

//        특정 과일 찾기
        for (String fruit : fruits) {
            if (fruit.equals("사과")) {
                System.out.println("사과 있음!");
                break;
            }
        }

//        TODO 실습 문제
        /*
         * 1. 10개의 정수 배열을 선언하고 1~10을 저장한 후, 짝수만 출력하세요
         * 2. 정수 배열 {3, 1, 4, 1, 5, 9, 2, 6}에서 가장 자주 등장하는 값을 찾는
         * 코드를 작성해보세요 (힌트 : 반복 카운트, 이중 for문)
         * 3. 조금 어려움 주의. 배열을 오름차순 정렬 sort 없이 직접 오름차순 정렬을
         * 구현해보세요. (인접한 두 값을 비교해서 교환하는 방식 -> 버블 정렬)
         *  */

//        1번
        int[] arr1 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        for (int i : arr1) {
            if (i % 2 == 0) {
                System.out.print(i + " ");
            }
        }
        System.out.println();
//        2번
        int[] arr2 = {3, 1, 4, 1, 5, 9, 2, 6};
        int V = 0;
        int max2 = 0;
        for (int i : arr2) {
            int count2 = 0;
            for (int j : arr2) {
                if (i == j) {
                    count2++;
                }
            }
            if (count2 > max2) {
                max2 = arr2[i];
            }
        }
        System.out.println(max2);
//        3번
        int[] bubbleArr = {5, 3, 8, 1, 9, 2, 7, 4, 6};
        System.out.println(Arrays.toString(bubbleArr));

//        버블 정렬 : 인접한 두 값을 비교해서 큰 값을 오른쪽으로 밀어낸다
//        한 번의 패스마다 가장 큰 값이 맨 뒤로 이동 -> n-1번 반복
        int bubbleN = bubbleArr.length;
        for (int pass = 0; pass < bubbleN - 1; pass++) {
//            이미 정렬된 마지막 (pass)개는 비교가 필요하지 않다
            for (int i = 0; i < bubbleN - 1 - pass; i++) {
                if (bubbleArr[i] > bubbleArr[i + 1]) {
//                인접한 두 값 교환
                    int temp = bubbleArr[i];
                    bubbleArr[i] = bubbleArr[i + 1];
                    bubbleArr[i + 1] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(bubbleArr));
    }
}
