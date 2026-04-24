/*
* 배열 핸들링 - 빈도수 카운팅, 구간합, 누적합
* 배열을 이용해 빈도수(카운팅) 을 계산할 수 있다
* 구간합(Range Sum)의 개념을 이해한다
* 누적합(Prefix Sum) 배열을 만들고 활용할수 있다
* 카운팅 개념 응용으로 카운팅 정렬을 할 수 있다
* */


public class ArrayHandling {
    static void main(String[] args) {
        /*
        * 빈도수 카운팅이란?
        * 배열에서 각 값이 몇 번 등장하는지 세는 기법입니다.
        * 값의 범위가 정해져 있을 때 (0~9 , 1~100) 매우 효율적입니다.
        *
        * 핵심 아이디어:
        * count [값] = 해당 값의 등장 횟수
        * 예 : 배열 [3,1,4,1,5,9,2,6,5,3]
        *   count[1] = 2 count[2] = 1 count[3] = 2
        *   count[1] = 2 count[2] = 2 count[6] = 1
        * */
        int[] data = {3,1,4,1,5,9,2,6,5,3,5};
        // 최댓값 찾기 (count 배열 크기를 결정하기 위해)
        int maxVal = data[0];
        for (int n : data){
            if(n > maxVal) maxVal = n;
        }
//        카운팅 배열 생성 : 인덱스 = 값, 값 = 등장 횟수
//        count[i] = 숫자 i 가 몇 번 나왔는지
        int[] count = new int[maxVal + 1]; // 0 ~ maxVal 인덱스 공간

//        카운팅
        for (int n : data){
            count[n]++;
        }

        System.out.println("빈도수 카운팅 결과");
        for (int i = 0; i <=maxVal; i++ ){
            if (count[i] >0){
                System.out.println(" 숫자" + i+": "+ count[i]+"번 등장");
            }
        }
        // 가장 많이 등장한 숫자 (최빈값)
        int modeVal = 0,  modeCount = 0;
        for (int i =0; i <=maxVal; i++){
            if (count[i] > modeCount){
                modeCount = count[i];
                modeVal=i;
            }
        }
        System.out.println(modeVal+ " "+modeCount+"번 등장");

//        응용 : 카운팅 정렬
//        카운팅 배열을 이용하면 배열을 O(n)에 정렬할 수 있습니다.
//        단, 값의 범위가 작을 때만 효율적
        System.out.println("카운팅 정렬");
        System.out.println("정렬 전: ");
        for (int n : data) System.out.print(n + " ");
        System.out.println();

        System.out.println("정렬 후: ");
        for (int i = 0; i<=maxVal; i++){
            for (int j = 0; j < count[i]; j++){
                System.out.print(i+" "); // count[i]번만큼 i 를 출력
            }
        }
        System.out.println();

//        구간합이란?
        /*
        * 배열에서 특정 구간 [l, r]의 합을 구하는 것입니다.
        * 예 : arr = [1,2,3,4,5]
        *   arr[1]~arr[3] 의 합 = 2+3+4 = 9
        *
        * 간단한 방법: 매 질의마다 반복문으로 더함
        * -> 질의 1번에 O(n) 시간 소요
        * -> 질의 q번이면 O(n*q) 시간
        * -> 배열이 크고 질의 많으면 매우 느림!
        * */
        int[] arr = {1,2,3,4,5,6,7,8,9,10};

        System.out.println("배열:");
        for (int n : arr) System.out.print(n + " ");
        // 구간 합 질의 목록 : [시작, 끝] (0번 인덱스부터 시작)
        int[][] queries = {{0,4},{2,6},{3,9},{0,9}};

        System.out.println("간단한 방법");
        for (int[] q : queries){
            int l = q[0], r= q[1];
            int sum = 0;
            for (int i = l; i <= r; i++){ //매번 l~r을 더함
                sum += arr[i];
            }
            System.out.println(l+" "+r+" "+sum);
        }

//        누적합(Prefix Sum)이란?
        /*
        * prefix[i] = arr[0] + arr[1] + ... + arr[i] (0번부터 i번까지의 합)
        *
        * 예 : arr = [1,2,3,4,5,6,7,8,9,10]
        *   prefix[0] = 1
        *   prefix[1] = 1 + 2 = 3
        *   prefix[2] = 1 + 2 + 3 = 6
        *   prefix[3] = 1 + 2 + 3 + 4 = 10
        *
        * 구간 [l , r ]의 합 공식 :
        *  sum(l, r) = prefix[r] - prefix[l-1]
        *  (단, l == 0 이면 prefix[r] 그대로)
        *
        * 이렇게 하면:
        * - 전처리 : 한 번만 O(n) 으로 prefix 배열 생성
        * - 이후 각 질의 O(1) 에 답 계산
        * - 질의가 q 번이면 O(n + q)시간 <- 훨씬 빠름!
        * */

//        누적합 배열 생성 (1-indexed로 만들면 편함)
        int n = arr.length;
        int[] prefix = new int[n+1]; // 크기를 i+1로 (0번 인덱스는 0으로 남김)
        prefix[0] = 0 ; //더미값

        System.out.println("배열: ");
        for (int num : arr) System.out.print(num+ " ");

//        누적합 배열 채우기
        for (int i =1 ;i <= n; i++){
            prefix[i] = prefix[i-1] + arr[i-1];
        }

        System.out.println("누적합 배열: ");
        for (int i = 0; i <=n; i++){
            System.out.print(prefix[i] + " ");
        }

//        누적합 활용 구간합 계산
//        1-based 인덱스로 질의 변환 (arr[0] ~ arr[4]  -> l = 1, r = 5)
        for (int[] q : queries){
            int l = q[0] +1;
            int r = q[1] +1; // 1-based로 변환
            // sum(l, r) = prefix[r] - prefix[l-1]
            int rangeSum= prefix[r] - prefix[l-1];
            System.out.println(q[0]+" "+q[1] + " "+ rangeSum);
        }

//        2차원 누적합
//        2차원 배열에서 직사각형 영역의 합을 빠르게 구할 수 있습니다.
//        prefix2D[i][j] = (0,0) ~ (i,j) 직사각형의 합

//        아이디어:
//        prefix2D[i][j] = prefix2D[i-1][j] + prefix2D[i][j-1]
//                           - prefix2D[i-1][j-1] + arr[i][j]
//        (위쪽 + 왼쪽 - 중복 계산된 왼쪽위 + 현재)

int[][] grid = {
        {1,2,3},
        {4,5,6},
        {7,8,9},
};
        int rows = grid.length;
        int cols = grid[0].length;
        int[][] prefix2D = new int[rows+1][cols+1];

        // 2차원 누적합 계산
        for (int i  = 1; i <= rows; i++){
            for (int j = 1; j <= cols; j++){
                prefix2D[i][j] = prefix2D[i-1][j] + prefix2D[i][j-1]
                                    - prefix2D[i-1][j-1] + grid[i-1][j-1];
            }
        }

        System.out.println("원본 2차원 배열: ");
        for (int[] row: grid){
            for (int val : row) System.out.printf("%3d", val);
            System.out.println();
        }

//        전체 합
        System.out.println("전체 합: " + prefix2D[rows][cols]);

//        (0,0) ~ (1,1) 부분 영역의 합 (1+2+4+5 = 12)
//        1-based : r1=1 , c1=1 r2=2 ,c2 =2
        int r1 = 1, c1 = 1, r2=2 ,c2=2;
        int subSum = prefix2D[r2][c2] - prefix2D[r1-1][c2]
                    - prefix2D[r2][c1-1] + prefix2D[r1-1][c1-1];
        System.out.println(subSum);

        /*
        * TODO 실습
        * 1 . 성적 분포 카운팅
        * 0~100 점수 배열이 주어질 때, 0~9점, 10~19점 ... 90~100점 구간별 학생 수를 카운팅하세요
        * 예 :점수 배열 [75,82,90,61,55,78,95,43,88,71]
        * 출력 : "40점대: 1명" , "50점대:1명"
        * 힌트 count[score / 10]++ 로 구간을 나눌 수 있습니다.
        * 2. 구간 최솟값 /최댓값
        * 배열 [3,1,4,1,5,9,2,6,5,3,3] 에서 임의의 구간
        * [l,r] 의 최소값과 최대값을 구하는 함수를 만드세요
        * 구간 [2,7] 까지 최소값 최대값을 출력하세요
        * [심화]
        * 3. 누적합으로 조건 구간 찾기
        * 배열 [1 , -1 ,2 ,3, -2,4,-3,2,1,]에서
        * 누적합 배열을 구성하세요
        * 합이 5이상인 구간 [l,r]을 모두 찾아 출력하세요
        * 힌트 (이중 반복문으로 모든 구간 조합을 시도하고,)
        * prefix[r] - prefix[l-1] >= 5인지 확인
        * */

        // =========================================================
        // TODO 풀이
        // =========================================================
        System.out.println("\n===== TODO 풀이 =====");

        // TODO 1 풀이 — 성적 분포 카운팅
        System.out.println("\n[TODO 1] 성적 분포 카운팅");
        int[] scores = {75, 82, 90, 61, 55, 78, 95, 43, 88, 71};
        // 구간을 10으로 나누어 카운팅 배열에 저장 (0대~10대까지 11칸)
        int[] gradeCount = new int[11];  // 인덱스 0=0대, 4=40대, 10=100점
        for (int score : scores) {
            int bucket = score / 10;  // 75 → 7 (70대)
            gradeCount[bucket]++;
        }
        System.out.print("점수 배열: ");
        for (int s : scores) System.out.print(s + " ");
        System.out.println();
        for (int i = 0; i <= 10; i++) {
            if (gradeCount[i] > 0) {
                // 인덱스 10은 100점, 나머지는 i*10대
                String label = (i == 10) ? "100점" : (i * 10) + "대";
                System.out.println("  " + label + ": " + gradeCount[i] + "명");
            }
        }

        // TODO 2 풀이 — 구간 최솟값/최댓값
        System.out.println("\n[TODO 2] 구간 최솟값/최댓값");
        int[] rangeArr = {3, 1, 4, 1, 5, 9, 2, 6, 5, 3, 5};
        int ql = 2, qr = 7;  // 구간 [2, 7]
        int rangeMin = rangeArr[ql];
        int rangeMax = rangeArr[ql];
        for (int i = ql + 1; i <= qr; i++) {
            if (rangeArr[i] < rangeMin) rangeMin = rangeArr[i];
            if (rangeArr[i] > rangeMax) rangeMax = rangeArr[i];
        }
        System.out.print("배열: ");
        for (int v : rangeArr) System.out.print(v + " ");
        System.out.println();
        System.out.println("구간 [" + ql + ", " + qr + "] 최솟값: " + rangeMin);
        System.out.println("구간 [" + ql + ", " + qr + "] 최댓값: " + rangeMax);

        // TODO 3 풀이 — 누적합으로 조건 구간 찾기
        System.out.println("\n[TODO 3] 누적합으로 합이 5 이상인 구간 찾기");
        int[] condArr = {1, -1, 2, 3, -2, 4, -3, 2, 1};
        int condN = condArr.length;
        // 1-indexed 누적합 배열 구성
        int[] condPrefix = new int[condN + 1];
        condPrefix[0] = 0;
        for (int i = 1; i <= condN; i++) {
            condPrefix[i] = condPrefix[i - 1] + condArr[i - 1];
        }
        System.out.print("배열: ");
        for (int v : condArr) System.out.print(v + " ");
        System.out.println();
        System.out.println("합이 5 이상인 구간 [l, r] (0-based 인덱스):");
        // 이중 반복문으로 모든 구간 조합 시도
        for (int l = 1; l <= condN; l++) {
            for (int r = l; r <= condN; r++) {
                int rangeSum2 = condPrefix[r] - condPrefix[l - 1];
                if (rangeSum2 >= 5) {
                    System.out.println("  구간 [" + (l-1) + ", " + (r-1) + "]  합=" + rangeSum2);
                }
            }
        }








    }











}
