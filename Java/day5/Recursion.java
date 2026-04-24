/*
* 재귀
* 재귀가 무엇인지 어떤 원리로 동작하는지 이해한다
* 재귀의 두 가지 요소 (기저 조건, 재귀 호출)을 파악한다
* 팩토리얼, 피보나치 등등을 재귀로서 구현할 수 있다
* 하노이탑 문제를 재귀로 해결해보자
* 재귀와 반복문의 장단점을 비교해보자
* */


public class Recursion {

    static void main(String[] args) {
        /*
        * 재귀란?
        * 재귀란 '함수가 자기 자신을 호출하는 것'입니다
        *
        *예를 들어 일상에서 마트료시카
        * 인형을 열면 인형이 계속 나오는 형태
        * 재귀도 마찬가지입니다
        * 함수를 호출하면 자기 자신을 호출하는 것.
        * 언젠가는 멈추는 조건(기저 조건)에 도달합니다.
        *
        * 재귀의 두 가지 필수 요소
        * 1) 기저 조건(Base Case) : 재귀를 멈추는 조건 (조건이 잘못되거나 없으면 무한 루프)
        * 2) 재귀 호출(Recursive Call) : 자기 자신을 더 작은 문제로 호출
        * */

    }
//    팩토리얼 n! ex) 5! 5*4*3*2*1
//    팩토리얼의 기저 조건은 0! = 1
//    재귀 관계 n! = n * (n-1)! <- 재귀 호출
static long factorial(int n){
        // 기저 조건: n이 0이면 1을 반환 (0! = 1)
    if (n == 0){
        return 1;
    }
    // 재귀 호출 : n x (n-1)
    return n * factorial(n-1);
}

// 반복문으로 구현한 팩토리얼
    static long factorialLoop(int n){
        long result = 1;
        for (int i = 1; i <=n; i++){
            result *= i;
        }
        return result;
    }

//    피보나치 수열
//    피보나치 수열 : 1,1,2,3,5,8,13,21,34...
//    규칙 :앞의 두 수를 더하면 다음 수가 됩니다.
//    재귀적 정의:
//    fib(1) = 1 <-기저 조건
//    fib(2) = 1 <-기저 조건
//    fib(n) = fib(n-1) + fib(n-2) <- 재귀 관계
//    fib(5) = fib(4) + fib(3)
//    fib(4) = fib(3) + fib(2)      <- fib(3) 중복 계산
//    fib(3) = fib(2) + fib(1)      <- fib(2) 중복 계산
//    n이 커질수록 기하급수적으로 느려진다 O(n^2)
    static int fibRecursive(int n) {
        // 기저 조건
        if (n==1 || n==2){
            return 1;
        }
        // 재귀 호출
        return fibRecursive(n-1)+ fibRecursive(n-2);
    }
//    반복문으로 피보나치를 구현 O(n)
    static long fibLoop(int n) {
        if(n==1 || n==2) return 1;
        long prev2 = 1;
        long prev1 = 1;
        long curr = 0;
        for (int i = 3; i <= n; i++){
            curr = prev1 + prev2;
            prev2  = prev1;
            prev1 =curr;
        }
        return curr;
    }

//    하노이 탑
    /*
    * 문제 설명:
    * 기둥 A,B,C 가 있습니다.
    * A에 크기가 다른 원판이 n개 쌓여 있습니다.
    * 모든 원판을 C로 옮겨야 합니다
    * 규칙 1 : 한 번에 하나의 원판만 이동
    * 규칙 2 : 작은 원판 위에 큰 원판을 올릴 수 없음
    *
    * 재귀적 사고
    * 원판이 n개일 때
    * 1단계 : 위쪽(n-1)개를 A에서 B로 이동 (C를 임시 공간으로 활용)
    * 2단계 : 가장 큰 원판 1개를 A에서 B로 이동
    * 3단계 : B에 있는 (n-1)개를 B에서 C로 이동 (A를 임시 공간으로 활용)
    *
    * n=1일 때 A에서 C로 바로 이동 (기저 조건)
    *
    * 이동 횟수 : 2^n - 1번
    * n=3 이면 2^3 -1 = 7번
    * */

    static int hanoiCount = 0; //이동 횟수 카운터
    static void hanoi(int n , char from, char to , char via){
        // 기저 조건: 원판이 1개일 때 - 바로 이동
        if (n==1){
            System.out.println("원판"+n+"이동"+from+"->"+to);
            hanoiCount++;
            return;
        }
//        1단계 : 위의 (n-1)개를 from에서 via로 이동 (to를 임시 공간으로)
        hanoi(n-1, from,via,to);

//        2단계 : 가장 큰 원판(n번째)을 from에서 to 이동
        System.out.println("원판"+n+"이동"+from+"->"+to);
        hanoiCount++;

//        3단계 : via에 있는 (n-1)개를 via에서 to로 이동 (from을 임시 공간으로)
        hanoi(n-1,via,to,from);



    }

}
