/*
 * 배열 탐색
 * 선형 탐색의 원리와 구현 방법을 이해한다
 * 배열에서 최대값, 최솟값 찾는 알고리즘 구현한다
 * 특정 값의 인덱스 위치를 찾는 방법을 익힌다
 * 시간 복잡도 O(n)의 의미를 이해한다
 *
 * */


import java.util.Arrays;

public class ArraySearch {
    /*
     * 선형 탐색
     * 배열의 첫 번째 요소부터 마지막 요소까지 순서대로 하나씩 비교하는 방법
     * 정렬 여부과 관계없이 사용할 수 있다.
     * 시간 복잡도 : O(n) = 최악의 경우 n개를 모두 확인한다
     * 찾으면 해당 인덱스를 반환, 없으면 -1 반환
     * */
    static int linearSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i;
            }
        }
        return -1;
    }

    //    모든 위치 찾기 (중복 값 포함)
//    target이 여러 번 등장할 수 있으므로 모든 인덱스를 찾아 반환
    static int[] findAll(int[] arr, int target) {
//        먼저 몇 개 있는지
        int count = 0;
        for (int val : arr) {
            if (val == target) count++;
        }

//        결과를 담을 배열 생성
        int[] result = new int[count];
        int idx = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                result[idx++] = i;
            }
        }
        return result;
    }

    //    최대값 위치 반환
    static int findMaxIndex(int[] arr) {
        int maxIdx = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > arr[maxIdx]) {
                maxIdx = i;
            }
        }
        return maxIdx;
    }
//    최소값은 다 똑같은데 비교연산자 바꾸면 됩니다.

    //    이진 탐색 - 정렬된 배열에서만 사용 가능
//    배열 중간값과 비교해서 탐색 범위를 절반씩 줄여나가는 방법.
//    선형 탐색보다 훨씬 빠르다
//    시간 복잡도: O(log n) - 100만 개 데이터도 약 20번이면 찾는다!
//    전제 조건 : 배열이 정렬되어 있어야 한다!
    static int binarySearch(int[] arr, int target) {
        int left = 0; // 탐색 범위의 왼쪽 끝 인덱스
        int right = arr.length - 1; // 탐색 범위의 오른쪽 끝 인덱스
        while (left <= right) {
            int mid = (left + right) / 2; //중간 인덱스 계산

            if (arr[mid] == target) {
                return mid; //중간값이 목표값이면 반환
            } else if (arr[mid] < target) {
                // 목표값이 중간보다 크면 오른쪽 절반만 탐색
                left = mid + 1;
            } else {
                // 목표값이 중간보다 작으면 왼쪽 절반만 탐색
                right = mid - 1;
            }
        }
        return -1;
    }

    static void main(String[] args) {
//        1. 선형 탐색 테스트
        int[] arr = {4, 35, 123, 124, 35, 324,};
        int target = 124;
        int idx = linearSearch(arr, target);

        System.out.println(idx);

        //    2. 중복 값 모두 찾기
        int[] dupeArr = {1, 2, 3, 4, 5, 6, 6, 7, 8, 9, 6};
        int searchVal = 6;
        int[] positions = findAll(dupeArr, searchVal);
        System.out.println(Arrays.toString(positions));

//        3. 최대값 찾기
        int[] scores = {11, 22, 33, 44, 99, 66, 77, 88};
        int maxIdx = 0;
        System.out.println("최대값 인덱스 : " + findMaxIndex(scores));

//        4. 이진 탐색
        int[] sortedArr = {2, 5, 8, 12, 16, 23, 38, 72, 91};
        int tgt = 38;
        System.out.println(binarySearch(sortedArr, tgt));

        /*
         * 선형 탐색vs 이진 탐색
         * 선형 탐색의 경우에
         * 정렬이 불필요합니다. 시간 복잡도 O(n) - 데이터가 n개면 최대 n번 비교
         * 데이터가 적거나 정렬 안 된 경우 사용
         * 이진 탐색의 경우에
         * 반드시 정렬된 배열이어야 함
         * 시간 복잡도 O(log n) -100만 개도 약 20번이면 충분
         * 데이터가 많고 정렬된 경우 훨씬 빠름
         * */
        /*
         * TODO 실습문제
         *  1. 문자열 배열에서 특정 이름을 선형 탐색으로 찾는 메서드를 작성하세요.
         * 문자열 비교는 equals() 사용!
         * 2. 배열 {4,2,7,1,8,3,6,5}에서 두 번째로 작은 값을 찾으세요.
         * (정렬 없이 한번의 탐색으로 구해보세요)
         * 심화문제
         * 3. 이진 탐색을 응용해서, 정렬된 배열에 새 값을 삽입할 올바른 위치(인덱스)
         * 를 찾는 메서드를 작성하세요
         * */
//        TODO 풀이
//        1
        String[] names = {"김철수", "이영희", "박민준"};
//        선형 탐색으로 이름 찾기 (인덱스 반환, 없으면 -1)
        String searchName = "김철수";

        int nameIdx = -1;
        for (int i = 0; i < names.length; i++) {
            if (names[i].equals(searchName)) {
                nameIdx = i;
                break;
            }
        }
        if (nameIdx != -1) {
            System.out.println("김철수씨" + nameIdx + "번에서 찾음");
        } else {
            System.out.println("김철수 씨 없음.");
        }

//        2.
        int[] searchArr = {4, 2, 7, 1, 8, 3, 6, 5};
//        최소값과 두 번째 최소값을 동시에 추적
        int min1 = 100; // 가장 작은 값
        int min2 = 100; // 두번째로 작은 값
        for (int val : searchArr) {
            if (val < min1) {
                // 새로운 최소값을 발견
                min2 = min1;
                min1 = val;
            } else if (val < min2 && val != min1) {
                //최소값보다는 크지만 두 번째 최소값보다는 작은 경우
                min2 = val;
            }
        }
        System.out.println(min1 + " " + min2);
//        3. 위와 같은 이진탐색을 사용하면 되는데,
//        인덱스 찾는 것이니 (찾은위치+1)을 해주시면 됩니다
        int[] sortedForInsert = {1, 3, 5, 7, 9, 11, 13, 15};
        // 삽입 위치 탐색 : 이진 탐색으로 올바른 위치 찾기
        // target보다 크거나 같은 첫 번째 요소의 인덱스를 반환
        int insertTarget = 6;
        int insertLeft = 0;
        int insertRight = sortedForInsert.length - 1;
        int insertPos = sortedForInsert.length; //기본값 : 맨 끝에 삽입

        while (insertLeft <= insertRight) {
            int mid = (insertLeft + insertRight) / 2;
            if (sortedForInsert[mid] >= insertTarget) {
                insertPos = mid; // 현재 위치를 후보로 저장
                insertRight = mid - 1; // 더 왼쪽에 적합한 위치가 있는지 확인
            } else {
                insertLeft = mid + 1;
            }
        }
        System.out.println(insertPos);

    }
}
