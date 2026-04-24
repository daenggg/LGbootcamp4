/*
* 슬라이딩 윈도우
* 슬라이딩 윈도우의 기법을 이해한다
* 고정 크기 윈도우로 최대합/최소합을 구할수있다
* 가변 크기 윈도우로 조건을 만족하는 부분 배열을 탐색할 수 있다
* 투포인터와 슬라이딩 윈도우 관계를 알아볼수있다.
* */

import java.util.HashMap;

public class SlidingWindow {

    static void main(String[] args) {
        /*
        * 슬라이딩 윈도우란?
        * 창문이 배열 위를 미끄러지듯 움직이며
        * 연속된 부분 배열을 탐색하는 기법입니다.
        *
        * 핵심 아이디어
        * 새 요소를 윈도우에 추가하고, 오래된 요소를 제거하면서
        * 매번 전체를 다시 계산하지 말고 O(1)에 갱신합니다.
        *
        * 비유
        * 기차 창문으로 바깥을 볼 때, 창문 크기는 고정이고
        * 기차가 달리면서 보이는 풍경이 바뀌는 것과 같다
        *
        * 종류
        * 1) 고정 크기 윈도우 : 윈도우 크기가 k로 항상 같음
        * 2) 가변 크기 윈도우 : 조건에 따라 윈도우 크기가 변함
        * 슬라이딩 윈도우는 결국 투 포인터 한 기법이라고 볼 수 있다.
        * */

//        고정 크기 윈도우 - 최대합
//        크기 k인 연속 부분 배열의 최대 합을 구하라
//        반복문의 경우 매번 k를 더해줘야 합니다.
//        슬라이딩 윈도우의 경우
//        1. 첫 번째 윈도우 크기 k의 합을 계산
//        2. 윈도우를 오른쪽으로 한 칸씩 이동할 때:
//        새 합 = 이전 합 - 맨 왼쪽 요소 + 새로 추가된 요소
        int[] arr = {1,3,-1,-3,5,3,6,7};
        int k = 3;

//        1단계 첫 번째 윈도우 합 계산
        int windowSum = 0;
        for (int i = 0; i < k; i++){
            windowSum += arr[i];
        }
        int maxSum = windowSum;
        int maxStart = 0;
        System.out.println("초기 윈도우의 합: "+windowSum);

//        2단계 윈도우 이동
        for (int i = k; i < arr.length; i++){
//            새 합 = 이전 합 - 빠진 왼쪽 요소 + 새로 추가된 오른쪽 요소
            windowSum = windowSum - arr[i - k] + arr[i];

            System.out.printf(" 윈도우 [%d~%d]: 빠짐(%d), 추가(%d), 합= %d%n",
                    i - k +1, i , arr[i-k],arr[i],windowSum);

            if (windowSum> maxSum){
                maxSum = windowSum;
                maxStart = i - k +1;
            }
        }
        System.out.println(maxSum+" "+ maxStart);

//        고정 크기 윈도우 - 최고,최저 / 평균
        int[] scores = {70,85,60,90,75,80,95,65};
        int windowSize = 3;

//        첫 윈도우 합 계산
        int sum = 0;
        for (int i = 0; i <windowSize; i++) sum +=scores[i];

        double maxAvg = (double) sum / windowSize;
        double minAvg = maxAvg;
        int maxAvgStart = 0, minAvgStart = 0;

        for (int i = windowSize; i < scores.length; i++){
            sum = sum - scores[i - windowSize] + scores[i];
            double avg = (double) sum / windowSize;

            if (avg > maxAvg) {maxAvg = avg; maxAvgStart = i - windowSize+1;}
            if (avg < minAvg) {minAvg = avg; minAvgStart = i - windowSize+1;}

        }
        System.out.println("최고 평균: "+maxAvg+" "+maxAvgStart);
        System.out.println("최저 평균: "+minAvg+" "+minAvgStart);

//        가변 크기 윈도우 - 합이 target 이상인 최소 길이
        /*
        * 합이 target 이상인 연속 부분 배열의 최소 길이를 구하라
        *
        * [가변 크기 슬라이딩 윈도우]
        * start , end 두 포인터 사용
        * end를 늘리면서 합을 키우고,
        * 합이 target이상이 되면 start를 줄이면서 최소 길이 갱신
        * */
        int[] arr2 = {2,3,1,2,4,3};
        int target = 7;

        int minLength = Integer.MAX_VALUE;
        int windowSum2 = 0;
        int startIdx = 0;

        for (int end = 0; end < arr2.length; end++){
            windowSum2 += arr2[end]; //윈도우 오른쪽 확장

            // 합이 target 이상이 되면 왼쪽을 줄이면서 최소 길이 갱신
            while (windowSum2 >= target){
                int length = end - startIdx + 1;
                minLength = Math.min(minLength, length);
                windowSum2 -= arr2[startIdx]; // 왼쪽 축소
                startIdx++;
            }
        }
        if (minLength == Integer.MAX_VALUE) {
            System.out.println("조건을 만족하는 부분 배열 없음");
        } else {
            System.out.println("최소 길이: "+ minLength);
        }

//        가변 크기 윈도우 - 중복 없는 최장 부분 문자열
        /*
        * 중복 문자 없는 가장 긴 부분 문자열의 길이를 구하라
        * ex) abcabcbb => abc 길이3
        *
        * [가변 크기 슬라딩 윈도우 + HashMap]
        * HashMap에 각 문자의 마지막 등장 위치를 기록
        * 중복 문자가 나오면 start를 해당 문자 다음 위치로 이동
        * */

    String[] testStrings = {"abcabcbb", "pwwkwe", "bbbbb","dvdf"};
    for (String s : testStrings){
        int maxLen = longSubstring(s);
        System.out.println("최장 길이: "+maxLen);
    }
    /*
    * 슬라이딩 윈도우 vs 투포인터
    * 슬라이딩 윈도우
    * - 연속된 부분 배열/문자열을 탐색
    * - 윈도우를 유지하면서 이전 계산 결과를 재사용
    * - 고정/가변 크기 모두 가능
    * - 대표문제 : 최대합, 최장 부분 문자열, 최소 길이
    *
    * 투포인터
    * - 슬라이딩 윈도우 상위 개념
    * - 두 포인터가 독립적으로 이동 가능
    * - 정렬된 배열에서 두/세 수의 합 등에 활용
    * - 반드시 연속 구간이 아닌 경우에도 사용
    * */




    }
//    중복 문자 없는 최장 부분 문자열 길이 메서드
    static int longSubstring(String s){
        // 각 문자가 마지막으로 등장한 인덱스를 저장
        HashMap<Character, Integer> lastIndex = new HashMap<>();
        int maxLen = 0;
        int start = 0; //윈도우 왼쪽 경계

        for (int end = 0; end < s.length(); end++){
            char c = s.charAt(end);
            // 현재 문자가 윈도우 안에 있으면 (lastIndex[c] >= start)
            // start를 그 문자 다음으로 이동
            if (lastIndex.containsKey(c) && lastIndex.get(c) >= start){
                start = lastIndex.get(c) + 1;
            }
            lastIndex.put(c, end); // 현재 문자의 위치 갱신 (덮어 씌운다)
            maxLen = Math.max(maxLen, end - start+1);


        }
        return maxLen;
    }










}
