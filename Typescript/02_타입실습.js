// Typescript 실습. 기본 타입 union interface
// 컴파일 하게 된다면 지금의 동일한 파일명에 확장자만 js로 바뀌게 됩니다.
// ex. 02_타입실습.ts -> (컴파일) -> 02_타입실습.js
// 데이터 : Student Interface를 따를 배열
const students = [
    { id: 1, name: "홍길동", score: 92, subject: "웹개발" },
    { id: 2, name: "홍길이", score: 82, subject: "웹개발" },
    { id: 3, name: "홍길삼", score: 72, subject: "Typescript" },
    { id: 4, name: "홍길사", score: 62, subject: "웹개발" },
    { id: 5, name: "홍길오", score: 92, subject: "웹개발" },
    { id: 6, name: "홍길육", score: 92, subject: "웹개발" },
    { id: 7, name: "홍길칠", score: 92, subject: "웹개발" },
    { id: 8, name: "홍길팔", score: 92, subject: "웹개발" },
];
// 함수 타입 : 매개벼수와 반환값에 타입 명시
function getGrade(score) {
    if (score >= 90) return "A";
    if (score >= 80) return "B";
    if (score >= 70) return "C";
    return "F";
}
// 카드 렌더링 - 반환값 없으면 void
function renderCards(list) {
    const container = document.getElementById("cards");
    container.innerHTML = list
        .map((s) => {
            const grade = getGrade(s.score);
            return `
            <div class =  'card'>
            <div>${s.name}</div>
            <div>${s.subject ?? "미지정"} . ${s.score}</div>
            <span>${grade}등급</span>
            </div>
        `;
        })
        .join("");
}
// 필터 버튼 렌더링
function renderFilters(subjects) {
    const wrap = document.getElementById("filters");
    const all = ["전체", ...subjects];
    wrap.innerHTML = all
        .map(
            (s) => `<button class=filter-btn data-subject="${s}">
            ${s}
            </button>`,
        )
        .join("");
    document.querySelectorAll(".filter-btn").forEach((btn) =>
        btn.addEventListener("click", function () {
            const subject = this.dataset.subject;
            const filtered = subject === "전체" ? students : students.filter((s) => s.subject === subject);
            renderCards(filtered);
        }),
    );
}
// 실행
const subjects = [...new Set(students.map((s) => s.subject))];
renderFilters(subjects);
renderCards(students);
