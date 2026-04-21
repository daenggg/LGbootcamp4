/*
Java vs JAvascript 핵심 차이점 - js 입장
 - 변수 선언: int i = 0, let i = 0 (타입 명시 불필요)
 - 출력 System.out.println() -> console.log()
 - switch문 구조는 동일하지만, JS는 switch(true) 패턴도 자주 사용
 - JS에도 do-while이 있지만, 거의 쓰이지 않는다.

 JS 실행 방법
 터미널에서 node 파일명.js 입력하면 터미널에서 실행결과를 확인할 수 있음
 */

console.log("자바스크립트 콘솔로그입니다.");

let score = 78; // java일 때는 타입을 지정해줬어야 함

if (score >= 90) {
    console.log("학점: A");
} else if (score >= 80) {
    console.log("학점: B");
} else {
    console.log("불합격");
}

let grade = score >= 60 ? "합격" : "불합격";
console.log(grade);

let day = 3;
switch (day) {
    case 1:
        console.log("월");
        break;
    case 2:
        console.log("화");
        break;
    case 3:
        console.log("수");
        break;
    case 4:
        console.log("목");
        break;
    case 5:
        console.log("금");
        break;
    case 6:
        console.log("토");
        break;
    case 7:
        console.log("일");
        break;
    default:
        console.log("잘못된 요일 번호입니다. 1~7까지 입력하세요");
}

// Javascript 최신 문법 : 스위치 없이 객체 맵으로 대체
const dayNames = {
    1: "월욜",
    2: "화욜",
    3: "수욜",
    4: "목욜",
    5: "금욜",
    6: "토욜",
    7: "일욜",
};

console.log("객체 맵 방식: ", dayNames[day] || "잘못된 번호");

// for문 자바랑 구조 동일
for (let i = 1; i <= 5; i++) {
    console.log("i = ", i);
}

// javascript 배열 전용 반복문 : for...of
const fruits = ["사과", "바나나", "딸기"];
for (const fruit of fruits) {
    console.log("과일: ", fruit);
}

// 이 밑으로 문법이 유사하고 출력방식에서만
// js의 경우 템플릿 리터럴(` `)을 쓸 수 있다.
// TODO 실습 문제를 JS로 풀어봅시다 1~4번까지
// 4번만 한 번 풀어보겠습니다.
const month = 7;
switch (month) {
    case 3:
    case 4:
    case 5:
        console.log("봄");
        break;
    case 6:
    case 7:
    case 8:
        console.log("여름");
        break;
    case 9:
    case 10:
    case 11:
        console.log("가을");
        break;
    case 12:
    case 1:
    case 2:
        console.log("겨울");
        break;
    default:
        console.log("잘못된 월 입력");
}
