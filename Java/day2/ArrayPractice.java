/*
 * 배열 뒤집기 알고리즘을 두 가지 방법으로 구현한다
 * 중복 요소를 제거하는 방법을 이해한다
 * 배열 회전 알고리즘을 구현한다
 * */

import java.util.Arrays;

public class ArrayPractice {
    // 두 변수의 값 교환 (Swap)
//    임시 변수 (temp)를 이용한 교환 - 배열 조작의 기본 패턴
//    int temp = a; a = b; b = temp;
//    (배열을 직접 수정하는 swap은 아래 메서드로 구현)
    static void swap(int[] arr, int i, int j) {
        int temp = arr[i]; //임시 저장
        arr[i] = arr[j]; // i 자리에j 값 덮어쓰기
        arr[j] = temp; // j 자리에 임시값(원래 i값)저장
    }

    //    배열 뒤집기 방법 1 : 새 배열 생성
//    원본 배열은 그대로 두고, 역순으로 담은 새 배열을 반환한다
    static int[] reverseNew(int[] arr) {
        int n = arr.length;
        int[] reversed = new int[n];
        for (int i = 0; i < n; i++) {
            reversed[i] = arr[n - 1 - i]; //뒤에서부터 복사
        }
        return reversed;
    }

    //    배열 뒤집기 방법 2 : 양 끝에서 가운데로 교환
//    추가 배열 없이 원본 배열 자체를 뒤짚는다. 메모리가 더 효율적으로 쓰임
//    왼쪽 포인터와 오른쪽 포인터가 만날 때까지 교환
    static void reverseInPlace(int[] arr) {
        int left = 0;
        int right = arr.length - 1;
        while (left < right) {
            swap(arr, left, right); // 양 끝 교환
            left++; //왼쪽 포인터 오른쪽으로
            right--; //오른쪽 포인터 왼쪽으로
        }
    }

    //    배열 왼쪽으로 k칸 회전
//    예: {1,2,3,4,5} 를 2칸 왼쪽 회전 -> {3,4,5,1,2}
//    방법 : 앞 k를 잘라서 뒤에 붙이는 방식
    static int[] rotateLeft(int[] arr, int k) {
        int n = arr.length;
        k = k % n; // k가 n보다 크면 실제 회전량은 k%n
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            // 원본의 (i+k) %n 번째 요소를 i번째로 가져온다
            result[i] = arr[(i + k) % n];
        }
        return result;
    }

    //    배열 오른쪽으로 k칸 회전
//    오른쪽 k칸 회전 = 왼쪽 (n-k)칸 회전과 동일!
    static int[] rotateRight(int[] arr, int k) {
        int n = arr.length;
        k = k % n;
        return rotateLeft(arr, n - k); //오른쪽 k칸 = 왼쪽 (n-k)칸
    }

    //    중복 제거
//    정렬 후 인접한 중복 제거
//    정렬하면 같은 값이 붙어 있으므로 이전 값과 비교해서 다를 때만 추가한다
    static int[] removeDuplicates(int[] arr) {
        if (arr.length == 0) return arr;
//        먼저 정렬 (복사본 사용하여 원본 보존)
        int[] sorted = Arrays.copyOf(arr, arr.length);
        Arrays.sort(sorted);

//        중복 없는 요소 개수 세기
        int uniqueCount = 1; // 첫 번째 요소는 항상 유일
        for (int i = 1; i < sorted.length; i++) {
            if (sorted[i] != sorted[i - 1]) { //이전 값과 다르면 유일
                uniqueCount++;
            }
        }
        //            유일한 요소만 담은 배열 생성
        int[] result = new int[uniqueCount];
        result[0] = sorted[0];
        int ri = 1;
        for (int i = 1; i < sorted.length; i++) {
            if (sorted[i] != sorted[i - 1]) {
                result[ri++] = sorted[i];
            }
        }
        return result;
    }

    static void main(String[] args) {
//        두 변수의 값 교환 부터 중복 제거까지 배열을 만들어서 스스로 출력해보세요~~

//        종합 실전 예제
        int[] studentScores = {88, 72, 95, 65, 88, 79, 92, 65, 100, 72};

//        오름차순 정렬 후 출력
        int[] sorted = Arrays.copyOf(studentScores, studentScores.length);
        Arrays.sort(sorted);
        System.out.println(Arrays.toString(sorted));

//        내림차순 : 정렬 후 뒤집기
        int[] descSorted = Arrays.copyOf(sorted, sorted.length);
        reverseInPlace(descSorted);
        System.out.println(Arrays.toString(descSorted));

//        상위 3명 점수 출력
        for (int i = 0; i < 3; i++) {
            System.out.print(descSorted[i] + " ");
        }
        System.out.println();

//        중복 없는 점수 출력
        int[] uniqueScores = removeDuplicates(studentScores);
        System.out.println(Arrays.toString(uniqueScores));

//        평균 점수
        int total = 0;
        for (int s : studentScores) total += s;
        System.out.println((double) total / studentScores.length);

//        TODO 실습 문제
        /*
         * 1. 배열 {1,2,3,4,5,6,7,8}을 3칸씩 오른쪽으로 회전(미뤄서)하여 출력하세요
         *
         * 심화문제
         * 2. 두 배열을 합쳐 중복을 제거한 새 배열을 만드는 메서드를 작성하세요
         * {1,2,3,4} { 3,4,5,6}
         * 3. 배열에서 가장 많이 등장하는 최빈값을 찾는 메서드를 작성하세요.
         * {1,1,1,1,1,3,4,5,6}
         * */

//        TODO 풀이
//        1.
        int[] todo2Base = {1, 2, 3, 4, 5, 6, 7, 8};
        int rotK = 3;
        int[] todo2Arr = Arrays.copyOf(todo2Base, todo2Base.length);
//        단계별 출력
        for (int step = 1; step <= rotK; step++) {
//            1칸씩 오른쪽으로 이동 : 마지막 요소를 앞으로 가져온다
            int last = todo2Arr[todo2Arr.length - 1]; // 마지막 값 임시 저장
            for (int i = todo2Arr.length - 1; i > 0; i--) {
                todo2Arr[i] = todo2Arr[i - 1]; // 한 칸씩 오른쪽으로 밀기
            }
            todo2Arr[0] = last; //저장해둔 마지막 값을 맨 앞에 배치
            System.out.println(step + "칸 회전" + Arrays.toString(todo2Arr));
        }
//        2.
        int[] arrA = {1, 2, 3, 4};
        int[] arrB = {3, 4, 5, 6};
//        두 배열을 합친 임시 배열 생성
        int[] merged = new int[arrA.length + arrB.length];
        for (int i = 0; i < arrA.length; i++) merged[i] = arrA[i];
        for (int i = 0; i < arrB.length; i++) merged[arrA.length + i] = arrB[i];

//        중복 제거 : 정렬 후 인정합 중복 값 제거
        Arrays.sort(merged);
        int uniqueCnt = 1;
        for (int i = 1; i < merged.length; i++) {
            if (merged[i] != merged[i - 1]) uniqueCnt++;
        }
        int[] mergedUnique = new int[uniqueCnt];
        mergedUnique[0] = merged[0];
        int ui = 1;
        for (int i = 1; i < merged.length; i++) {
            if (merged[i] != merged[i - 1]) mergedUnique[ui++] = merged[i];
        }
        System.out.println(Arrays.toString(mergedUnique));
//3.
        int[] modeArr = {1, 1, 1, 1, 1, 3, 4, 5, 6};
        int modeVal = modeArr[0]; // 최빈값 (초기화)
        int maxFreq = 0; //최빈값의 등장 횟수

        for (int i = 0; i < modeArr.length; i++) {
            int freq = 0;
            for (int j = 0; j < modeArr.length; j++) {
                if (modeArr[j] == modeArr[i]) freq++;
            }
            if (freq > maxFreq) {
                maxFreq = freq;
                modeVal = modeArr[i];
            }
        }
        System.out.println(modeVal + "이 숫자 등장 이만큼 : " + maxFreq);

    }


}
