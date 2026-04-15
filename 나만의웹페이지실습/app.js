// 2. 데이터 (15개)
const clothingData = [
    { id: 1, name: "오버핏 셔츠", price: 29000, category: "top", image: "👕" },
    {
        id: 2,
        name: "루즈핏 맨투맨",
        price: 24500,
        category: "top",
        image: "👚",
    },
    { id: 3, name: "베이직 반팔", price: 12900, category: "top", image: "👕" },
    {
        id: 4,
        name: "스트라이프 니트",
        price: 38000,
        category: "top",
        image: "🧶",
    },
    { id: 5, name: "린넨 셔츠", price: 32000, category: "top", image: "👔" },
    {
        id: 6,
        name: "와이드 슬랙스",
        price: 35000,
        category: "bottom",
        image: "👖",
    },
    { id: 7, name: "중청 데님", price: 42000, category: "bottom", image: "👖" },
    {
        id: 8,
        name: "카고 조거 팬츠",
        price: 39000,
        category: "bottom",
        image: "🩳",
    },
    {
        id: 9,
        name: "나일론 팬츠",
        price: 28000,
        category: "bottom",
        image: "👖",
    },
    {
        id: 10,
        name: "치노 면바지",
        price: 33000,
        category: "bottom",
        image: "👖",
    },
    {
        id: 11,
        name: "윈드브레이커",
        price: 59000,
        category: "outer",
        image: "🧥",
    },
    { id: 12, name: "블레이저", price: 89000, category: "outer", image: "🧥" },
    { id: 13, name: "경량 조끼", price: 45000, category: "outer", image: "🧥" },
    { id: 14, name: "데님 자켓", price: 55000, category: "outer", image: "🧥" },
    { id: 15, name: "후드 집업", price: 37000, category: "outer", image: "🧥" },
];
// 3. 실행 로직
window.addEventListener("DOMContentLoaded", () => {
    const clothesGrid = document.querySelector(".clothes-grid");
    const filterBtns = document.querySelectorAll(".filter-btn");
    if (!clothesGrid) {
        console.error("클래스명이 .clothes-grid인 요소를 찾을 수 없습니다.");
        return;
    }
    const render = (category) => {
        const filtered =
            category === "all"
                ? clothingData
                : clothingData.filter((item) => item.category === category);
        const displayData = [...filtered, ...filtered];
        // --- 속도 최적화 로직 추가 ---
        // 아이템 1개당 2초 정도 걸리도록 계산 (예: 15개면 30초, 5개면 10초)
        const duration = filtered.length * 2;
        clothesGrid.style.animationDuration = `${duration}s`;
        // ----------------------------
        clothesGrid.innerHTML = displayData
            .map(
                (item) => `
        <article class="clothes-card">
            </article>
    `,
            )
            .join("");
    };
    // 버튼 이벤트 연결
    filterBtns.forEach((btn) => {
        btn.addEventListener("click", () => {
            filterBtns.forEach((b) => b.classList.remove("active"));
            btn.classList.add("active");
            const selectedCategory = btn.dataset.category || "all";
            render(selectedCategory);
        });
    });
    // 마우스 이벤트 (애니메이션 제어)
    clothesGrid.addEventListener("mouseover", () => {
        clothesGrid.classList.add("paused");
    });
    clothesGrid.addEventListener("mouseout", () => {
        clothesGrid.classList.remove("paused");
    });
    // 최초 실행
    render("all");
});
// export {};
