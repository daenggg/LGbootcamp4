/*
 * 2차원 배열
 * 2차원 배열(행과 열)의 구조를 이해한다.
 * 중첩 for문으로 2차원 배열을 순회하는 방법을 이긴다.
 * 지그재그 탐색 패턴을 이해하고 구현한다.
 * */

import java.util.Arrays;

public class Array2 {

    static void main(String[] args) {
        /*
         * 2차원 배열이란?
         * 배열의 배열 -  행(row)과 열(column)로 이루어진 표(테이블)형태의 구조
         * 좌표계처럼 arr[행][열]로 접근한다.
         *
         *       col0 col1 col2
         * row0  [ 1,   2,   3 ]
         * row1  [ 4,   5,   6 ]
         * row2  [ 7,   8,   9 ]
         * */

//        2차원 배열의 선언과 초기화
//        방법 1. 크기 지정 (3행 3열)
        int[][] grid1 = new int[3][3]; // 모든 요소 0으로 초기화

//        방법 2. 배열 리터럴로 초기화
        int[][] grid2 = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

//        방법 3. 불규칙한 크기 (가변 배열)
//        행마다 열의 수가 달라도 된다!
        int[][] jagged = new int[3][];
        jagged[0] = new int[]{1}; // 0번 행의 열 : 1개
        jagged[1] = new int[]{2, 3}; // 1번 행의 열 : 2개
        jagged[2] = new int[]{4, 5, 6}; // 2번 행의 열 : 3개
        for (int[] row : jagged) {
            System.out.println(Arrays.toString(row));
        }
//        2차원 배열 요소 접근
        int[][] mat = {
                {10, 20, 30},
                {40, 50, 60},
                {70, 80, 90}
        };
        System.out.println(mat[0][0]);
        System.out.println(mat[1][2]);
        System.out.println(mat[2][1]);

//        배열의 행 수 : 배열명.length
        System.out.println(mat.length);
//        배열을 열 수 : 배열명[0].length (0번 행의 길이)
        System.out.println(mat[0].length);

//        2차원 배열의 순회 (중첩 for문)
//        왼 -> 오, 위 -> 아래 방향으로 읽는 일반적인 순회
        int[][] m = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12}
        };

        int rows = m.length;
        int cols = m[0].length;

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                System.out.printf("%3d", m[r][c]); // 3을 넣음으로써 오른쪽 정렬로 출력
            }
            System.out.println(); // 행이 끝나면 줄바꿈
        }

//        향상된 for문으로 순회 (인덱스 불필요 시)
        for (int[] row : m) {
            for (int val : row) {
                System.out.printf("%3d", val);
            }
            System.out.println();
        }
//        열 우선 순회
        for (int c = 0; c < cols; c++) {
            for (int r = 0; r < rows; r++) {
                System.out.printf("%3d", m[r][c]);
            }
            System.out.println();
        }

//        지그재그 탐색
//        짝수 행은 왼쪽 -> 오른쪽, 홀수 행은 오른쪽 -> 왼쪽으로 탐색하는 방식
//        뱀처럼 이동하는 패턴이라 "스네이크 탐색"이라고도 부른다
        int[][] zigData = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        };

        for (int r = 0; r < zigData.length; r++) {
            if (r % 2 == 0) {
//                짝수 행 : 왼쪽에서 오른쪽으로
                for (int c = 0; c < zigData[r].length; c++) {
                    System.out.printf("%3d", zigData[r][c]);
                }
            } else {
//                홀수 행 : 오른쪽에서 왼쪽으로
                for (int c = zigData[r].length - 1; c >= 0; c--) {
                    System.out.printf("%3d", zigData[r][c]);
                }
            }
            System.out.println();
        }
//        대각선 탐색
        int[][] square = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

//        주 대각선 (좌상단 -> 우하단): r == c 인 위치
        for (int i = 0; i < square.length; i++) {
            System.out.print(square[i][i] + " ");
        }
        System.out.println();

//        부 대각선 (우상단 -> 좌하단): r + c == length - 1 인 위치
        int n = square.length;
        for (int i = 0; i < n; i++) {
            System.out.print(square[i][n - 1 - i] + " ");
        }
        System.out.println();

//        2차원 배열 전체 합계
        int totalSum = 0;
        for (int[] row : square) {
            for (int val : row) {
                totalSum += val;
            }
        }
        System.out.println("합계 : " + totalSum);

        /*
         * TODO 실습문제
         *  1. 3x3 행렬의 각 행의 합과 열의 합을 출력하세요
         *
         * 심화문제
         *  2. 4x4 크기의 행렬을 90도 회전시켜 출력하세요
         * (힌트 : 원본[r][c] -> 결과[c][c-1-r]
         *  3. 5x5 행렬에서 테두리(가장자리)에 있는 요소만 출력하세요
         * (힌트 : r == 0 || r == 4 || c == 0 || c == 4
         * */

//        1번 풀이
        int[][] array1 = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        for (int r = 0; r < array1.length; r++) {
            int total1 = 0;
            for (int c = 0; c < array1[r].length; c++) {
                total1 += array1[r][c];
            }
            System.out.println(r + "행의 합: " + total1);
        }
        for (int c = 0; c < array1.length; c++) {
            int total1 = 0;
            for (int r = 0; r < array1[c].length; r++) {
                total1 += array1[r][c];
            }
            System.out.println(c + "열의 합: " + total1);
        }
//        2번 풀이
        int[][] array2 = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        };
        int n2 = array2.length;
        for (int r = 0; r < array2.length; r++) {
            for (int c = 0; c < array2[r].length; c++) {
                System.out.printf("%4d", array2[c][n2 - 1 - r]);
            }
            System.out.println();
        }


//        3번 풀이
        int[][] array3 = {
                {1, 2, 3, 4, 5},
                {6, 7, 8, 9, 10},
                {11, 12, 13, 14, 15},
                {16, 17, 18, 19, 20},
                {21, 22, 23, 24, 25}
        };
        for (int i = 0; i < array3.length; i++) {
            for (int j = 0; j < array3[i].length; j++) {
                if (i == 0 || i == array3.length - 1 || j == 0 || j == array3[i].length - 1) {
                    System.out.print(array3[i][j] + " ");
                }
            }

        }
    }
}
