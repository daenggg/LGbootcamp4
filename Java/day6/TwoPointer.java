/*
* 투포인터
* 투포인터 기법이 무엇인지, 왜 사용하는지 이해한다
* 정렬된 배열에서 두 수의 합 문제를 O(n)으로 풀 수 있다
* 세수 의 합 문제를 O(n^2)으로 풀 수 있다.
* 연속 부분 배열의 합 문제에 투포인터를 적용해볼수있다
* */


import java.util.Arrays;

public class TwoPointer {
    static void main(String[] args) {
        /*
        * 투포인터란?
        * 배열에 두 개의 포인터(인덱스)를 두고, 조건에 따라 움직이면서
        * 문제를 해결하는 기법입니다.
        *
        * 언제 사용하나?
        * 정렬된 배열에서 특정 합/조건을 만족하는 쌍을 찾을 때
        * 연속 부분 배열을 탐색할 때
        *
        * 장점
        * 이중 포문 O(n^2) -> 투포인터 O(n)  으로 개선 가능
        *
        * 두 가지 형태
        * 1) 양끝에서 시작해 중간으로 좁히는 방식
        * 2) 같은 방향으로 시작해 한 포인터 앞서가는 방식
        * */

//        두 수의 합
        /*
        * 정렬된 배열에서 합이 target이 되는 두 수의 인덱스를 찾아라
        *
        * 간단한 반복문 방법
        * 모든 쌍을 다 확인
        *  for i: for j: if arr[i]+arr[j] = target
        *
        * 투 포인터 방법
        * left = 배열의 왼쪽 끝 (0번 인덱스)
        * right = 배열의 오른쪽 끝 (마지막 인덱스)
        * 종료 조건 : left >= right
        * */

        int[] arr = {1,2,3,4,5,6,7,8};
        int target = 7;

        System.out.println("배열: "+ Arrays.toString(arr));

        int left = 0;
        int right = arr.length - 1;

        while (left< right) {
            int sum =arr[left] + arr[right];
            System.out.print(arr[left] + " " + arr[right]+" "+ sum);

            if (sum == target){
                System.out.println("-> 정답");
                left++;
                right--;
            } else if (sum < target) {
                System.out.println("-> 합이 더 작음, left++");
                left++;
            } else {
                System.out.println("-> 합이 더 큼, right--");
                right--;
            }
        }
//            처음 하나만 찾는 버전
            System.out.println("합이 딱 한 쌍인 경우");
            int[] arr2 = {1,3,5,7,9,11,15};
            int target2 = 500;

            left = 0;
            right = arr2.length -1;
            boolean found = false;

            while (left < right) {
                int sum = arr2[left] + arr2[right];
                if (sum == target2){
                    System.out.println("찾음!" + arr2[left]+" "+ arr2[right]);
                    found = true;
                    break;
                } else if ( sum < target2) {
                    left++;
                } else {
                    right--;
                }
            }
            if (!found) System.out.println("없음");

//        세 수의 합
        /*
        * 배열에서 합이 target이 되는 세 수의 조합을 모두 찾아라
        *
        * [방법]
        * 1. 배열 정렬 (O(n log n))
        * 2. 첫 번째 수를 for 루프로 고정 (O(n))
        * 3. 나머지 두 수는 투포인터로 탐색 (O(n))
        * 전체 : O(n^2)
        *
        * 이 방법 없다면? 이중 for + 검색 = O(n^3)
        * */

        int [] arr3 = {-1,0,1,2,-1,-4,3,-2};
        int target3 = 0;

        Arrays.sort(arr3); // 정렬 필수

        for (int i =0; i < arr3.length - 2; i++) {
            // 중복 건너뛰기 : 같은 값이 연속이면 패스
            if (i > 0 && arr3[i] == arr3[i-1]) continue;

            int l = i + 1;
            int r = arr3.length - 1;

            while (l < r){
                int sum = arr3[i] + arr3[l] + arr3[r];
                if (sum == target3){
                    System.out.println(arr3[i]+" "+arr3[l]+" "+arr3[r]+ " "+sum);
                    // 중복 건너뛰기
                    while (l<r && arr3[l] == arr3[l-1]) l++;
                    while (l<r && arr3[r] == arr3[r-1]) r++;
                    l++;
                    r--;
                } else if (sum<target3){
                    l++;
                } else {
                    r--;
                }
            }

        }

//        연속 부분 배열의 합
        /*
        * 배열에서 연속된 부분 배열의 합이 target이 되는 경우를 모두 찾아라
        * (양수만 있는 정렬된 배열)
        * 예 : arr = [1,2,3,4,5] target = 9
        *   -> [2,3,4] (인덱스 1~3) [4,5] (인덱스 3~4)
        *
        * [투포인터 방법]
        * start , end 두 포인터가 모두 왼쪽에서 시작
        * currentSum = arr[start] ~ arr[end]의 합
        *
        * 양수 배열에서만 성립하는 방법
        * (음수가 있으면 합이 단조증가/감소하지 않아 이 방법 사용 불가)
        * */
        int[] arr4 = {1,2,3,4,5,6,7};
        int target4 = 9;

        int start = 0;
        int end = 0;
        int currentSum = arr4[0];

        while (end < arr4.length){
            if (currentSum == target4) {
                // 정답 구간 출력
                for (int i = start; i <=end; i++) {
                    System.out.print(arr4[i]+" ");
                    if (i < end) System.out.print(", ");
                }
                System.out.println(start+"~"+end);
//                다음 탐색 : end 를 앞으로 이동
                currentSum -= arr4[start];
                start++;
            } else if (currentSum< target4) {
                end++;
                if (end < arr4.length) currentSum +=arr4[end];
            } else{
                currentSum -= arr4[start];
                start++;
            }
        }

//        응용 - 팰린드롬 판별
//        팰린드롬 - 앞에서 읽으나 뒤에서 읽으나 같은 문자열
//        토마토, 기러기, 역삼역

//        투 포인터로 양 끝에서 중앙으로 이동하며 비교합니다.

        String[] testWords = {"racecar","hello","level","java","madam"};

        for (String word : testWords){
            System.out.println(isPalindrome(word)? "회문": "회문 아님");
        }

//        TODO 실습문제
        /*
        * 1. 가장 긴 연속 부분 배열
        * 배열 [1,2,3,1,1,1,4] 에서 합이 6이하인 가장 긴 연속 부분 배열의 길이를 구하시오
        * 투포인터를 활용하세요
        * 2. 네 수의 합
        * 배열 [1,0,-1,0,-2,2] 에서 합이 0인
        * 네수 의 모든 조합을 출력하세요
        *
        * 3. 가장 넓은 물통 [심화]
        * 배열 [1,8,6,2,5,4,8,3,7] 은 각 위치의 벽 높이입니다.
        * 두 벽 사이에 담을 수 있는 물의 양 = (벽 간격) x min(왼쪽 높이, 오른쪽 높이)
        * 담을 수 있는 최대 물의 양을 투포인터로 구하세요
        * 힌트 : 더 낮은 쪽의 포인터를 이동시킵니다.
        *
        * */

        // TODO 1 풀이 — 가장 긴 연속 부분 배열 (합이 6 이하)
        System.out.println("\n[TODO 1] 합이 6 이하인 가장 긴 연속 부분 배열");
        int[] todo1Arr = {1, 2, 3, 1, 1, 1, 4};
        int todo1Target = 6;
        int todo1MaxLen = 0;
        int todo1Start = 0;
        int todo1Sum = 0;
        int todo1BestStart = 0;

        System.out.println("배열: " + Arrays.toString(todo1Arr) + ", 합 <= " + todo1Target);
        // 투포인터(슬라이딩 윈도우): 합이 target 초과이면 start를 줄임
        for (int end1 = 0; end1 < todo1Arr.length; end1++) {
            todo1Sum += todo1Arr[end1];
            // 합이 초과하면 왼쪽을 축소
            while (todo1Sum > todo1Target) {
                todo1Sum -= todo1Arr[todo1Start];
                todo1Start++;
            }
            // 현재 윈도우 길이
            int len = end1 - todo1Start + 1;
            if (len > todo1MaxLen) {
                todo1MaxLen = len;
                todo1BestStart = todo1Start;
            }
        }
        System.out.println("가장 긴 연속 부분 배열 길이: " + todo1MaxLen);
        System.out.println("해당 구간: " + Arrays.toString(Arrays.copyOfRange(todo1Arr, todo1BestStart, todo1BestStart + todo1MaxLen)));

        // TODO 2 풀이 — 네 수의 합이 0인 조합
        System.out.println("\n[TODO 2] 합이 0인 네 수의 조합");
        int[] todo2Arr = {1, 0, -1, 0, -2, 2};
        int todo2Target = 0;
        Arrays.sort(todo2Arr);
        System.out.println("배열 (정렬 후): " + Arrays.toString(todo2Arr));
        // 이중 for + 투포인터 = O(n³)
        for (int i = 0; i < todo2Arr.length - 3; i++) {
            if (i > 0 && todo2Arr[i] == todo2Arr[i - 1]) continue;  // 중복 건너뜀
            for (int j = i + 1; j < todo2Arr.length - 2; j++) {
                if (j > i + 1 && todo2Arr[j] == todo2Arr[j - 1]) continue;  // 중복 건너뜀
                int lo = j + 1, hi = todo2Arr.length - 1;
                while (lo < hi) {
                    int s = todo2Arr[i] + todo2Arr[j] + todo2Arr[lo] + todo2Arr[hi];
                    if (s == todo2Target) {
                        System.out.println("  [" + todo2Arr[i] + ", " + todo2Arr[j]
                                + ", " + todo2Arr[lo] + ", " + todo2Arr[hi] + "]");
                        while (lo < hi && todo2Arr[lo] == todo2Arr[lo + 1]) lo++;
                        while (lo < hi && todo2Arr[hi] == todo2Arr[hi - 1]) hi--;
                        lo++;
                        hi--;
                    } else if (s < todo2Target) {
                        lo++;
                    } else {
                        hi--;
                    }
                }
            }
        }

//        TODO 풀이 3 -가장 넓은 물통
        int[] heights = {1,8,6,2,5,4,8,3,7};
        System.out.println(Arrays.toString(heights));
        int todo3Left = 0 , todo3Right = heights.length -1;
        int maxWater = 0;
        // 낮은 쪽 포인터를 이동시키는 전략
        while (todo3Left < todo3Right){
            int width = todo3Right - todo3Left;
            int minHeight = Math.min(heights[todo3Left], heights[todo3Right]);
            int water = width * minHeight;
            if (water > maxWater) maxWater = water;
//            더 낮은 쪽을 이동 (높은 쪽을 이동하면 물이 줄어들 수만 있으므로)
            if (heights[todo3Left]< heights[todo3Right]){
                todo3Left++;
            } else{
                todo3Right--;
            }
        }
        System.out.println("담을 수 있는 최대 물의 양: "+ maxWater);






    }
    static boolean isPalindrome(String s){
        int left = 0;
        int right = s.length()-1;

        while (left < right) {
            if (s.charAt(left) != s.charAt(right)){
                return false; //다른 문자 발견 > 회문 아님
            }
            left++;
            right--;
        }
        return true; // 모두 같으면 회문
    }








}
