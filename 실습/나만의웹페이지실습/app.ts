type Category = "all" | "outer" | "top" | "bottom";

interface ClothingItem {
    id: number;
    name: string;
    price: number;
    category: Exclude<Category, "all">;
    image: string;
    description: string;
    reviewCount: number;
}

// 더미 데이터 (20개)
const clothingData: ClothingItem[] = [
    {
        id: 1,
        name: "[JUST BETTER] 헤이디 프릴 블라우스",
        price: 26800,
        category: "top", 
        image: "👕",
        description: "프렌치 감성의 프릴과 펀칭 레이스 디테일이 돋보이는 제작 블라우스입니다.",
        reviewCount: 15
    },
    {
        id: 2,
        name: "[JUST BETTER] 앨리스 플라워 끈블라우스",
        price: 27000,
        category: "top",
        image: "👚",
        description: "화사한 플라워 패턴으로 봄 무드를 가득 담은 러블리한 블라우스입니다.",
        reviewCount: 49
    },
    {
        id: 3,
        name: "베이직 라운드 반팔 티셔츠",
        price: 12900,
        category: "top",
        image: "👕",
        description: "매일 입기 좋은 탄탄한 코튼 소재의 기본 라운드 티셔츠입니다.",
        reviewCount: 120
    },
    {
        id: 4,
        name: "루즈핏 스트라이프 니트",
        price: 34000,
        category: "top",
        image: "🧶",
        description: "여유 있는 핏으로 체형 보정이 가능하며 데일리하게 즐기기 좋은 니트입니다.",
        reviewCount: 32
    },
    {
        id: 5,
        name: "옥스포드 버튼다운 셔츠",
        price: 29800,
        category: "top",
        image: "👔",
        description: "클래식한 디자인으로 슬랙스나 데님 어디에나 잘 어울리는 셔츠입니다.",
        reviewCount: 55
    },
    {
        id: 6,
        name: "데일리 오버핏 맨투맨",
        price: 24500,
        category: "top",
        image: "👚",
        description: "부드러운 양기모 안감으로 겨울철 따뜻하고 편안하게 착용 가능한 맨투맨입니다.",
        reviewCount: 210
    },

    // --- BOTTOM (하의) ---
    {
        id: 7,
        name: "실크같은 리오셀 스판부츠컷",
        price: 25900,
        category: "bottom",
        image: "👖",
        description: "부드러운 리오셀 소재와 쫀쫀한 스판이 만나 극강의 편안함을 선사합니다.",
        reviewCount: 83
    },
    {
        id: 8,
        name: "시그니처 배기 인밴딩 팬츠",
        price: 29500,
        category: "bottom",
        image: "👖",
        description: "허리 안쪽 밴딩 처리로 깔끔한 아웃핏과 편안한 착용감을 동시에 잡았습니다.",
        reviewCount: 12
    },
    {
        id: 9,
        name: "와이드 생지 데님 팬츠",
        price: 38000,
        category: "bottom",
        image: "👖",
        description: "트렌디한 와이드 핏에 생지 특유의 깊은 컬러감이 매력적인 데님입니다.",
        reviewCount: 41
    },
    {
        id: 10,
        name: "린넨 믹스 숏 팬츠",
        price: 19000,
        category: "bottom",
        image: "🩳",
        description: "여름철 시원하게 입을 수 있는 통기성 좋은 린넨 혼방 반바지입니다.",
        reviewCount: 28
    },
    {
        id: 11,
        name: "세미 슬림핏 슬랙스",
        price: 32000,
        category: "bottom",
        image: "👖",
        description: "다리가 길어 보이는 최적의 슬림 핏으로 제작된 오피스룩 추천 슬랙스입니다.",
        reviewCount: 94
    },
    {
        id: 12,
        name: "코듀로이 조거 팬츠",
        price: 27500,
        category: "bottom",
        image: "👖",
        description: "포근한 코듀로이 원단으로 제작되어 스트릿한 무드를 연출하기 좋습니다.",
        reviewCount: 37
    },
    {
        id: 13,
        name: "A라인 코튼 미니스커트",
        price: 22000,
        category: "bottom",
        image: "👗",
        description: "깔끔하게 떨어지는 A라인 핏으로 다리 라인을 예쁘게 살려주는 스커트입니다.",
        reviewCount: 62
    },

    // --- OUTER (아우터) ---
    {
        id: 14,
        name: "오버사이즈 트렌치 코트",
        price: 89000,
        category: "outer",
        image: "🧥",
        description: "봄, 가을 필수 아이템으로 멋스러운 실루엣을 연출해주는 코트입니다.",
        reviewCount: 18
    },
    {
        id: 15,
        name: "경량 퀼팅 점퍼",
        price: 45000,
        category: "outer",
        image: "🧥",
        description: "가볍고 따뜻하여 간절기에 단독으로나 이너로 활용하기 좋습니다.",
        reviewCount: 67
    },
    {
        id: 16,
        name: "베이직 데님 자켓",
        price: 52000,
        category: "outer",
        image: "🧥",
        description: "빈티지한 워싱이 가미되어 캐주얼한 무드를 더해주는 청자켓입니다.",
        reviewCount: 39
    },
    {
        id: 17,
        name: "싱글 체크 자켓",
        price: 74000,
        category: "outer",
        image: "🧥",
        description: "세련된 체크 패턴으로 격식 있는 자리에도 어울리는 싱글 자켓입니다.",
        reviewCount: 22
    },
    {
        id: 18,
        name: "윈드브레이커 후드 집업",
        price: 39000,
        category: "outer",
        image: "🧥",
        description: "가벼운 비바람을 막아주며 운동이나 야외 활동 시 유용한 바람막이입니다.",
        reviewCount: 45
    },
    {
        id: 19,
        name: "울 혼방 핸드메이드 코트",
        price: 158000,
        category: "outer",
        image: "🧥",
        description: "고급스러운 울 소재를 사용하여 가볍고 보온성이 뛰어난 핸드메이드 코트입니다.",
        reviewCount: 14
    },
    {
        id: 20,
        name: "에코 레더 라이더 자켓",
        price: 68000,
        category: "outer",
        image: "🧥",
        description: "시크한 분위기를 연출해주는 유연한 텍스처의 비건 레더 자켓입니다.",
        reviewCount: 51
    }
];

class WishlistManager {
    private items: ClothingItem[] = [];

    // 찜 목록에 추가
    public add(item: ClothingItem): void {
        const existing = this.items.find((i) => i.id === item.id);
        if (!existing) {
            this.items.push(item);
        } else {
            // 이미 있으면 제거
            this.remove(item.id);
        }
    }

    public remove(id: number): void {
        this.items = this.items.filter((item) => item.id !== id);
    }

    public getItems(): ClothingItem[] {
        return [...this.items];
    }

    public getCount(): number {
        return this.items.length;
    }

    public hasItem(id: number): boolean {
        return this.items.some((item) => item.id === id);
    }
}

const wishlistManager = new WishlistManager();

// 실행 로직
window.addEventListener("DOMContentLoaded", () => {
    const clothesGrid = document.querySelector(
        ".clothes-grid",
    ) as HTMLDivElement;
    const filterBtns =
        document.querySelectorAll<HTMLButtonElement>(".filter-btn");

    if (!clothesGrid) {
        console.error("클래스명이 .clothes-grid인 요소를 찾을 수 없습니다.");
        return;
    }

    const wishlistToggleBtn = document.getElementById("wishlistToggleBtn") as HTMLButtonElement;
    const wishlistSidebar = document.getElementById("wishlistSidebar") as HTMLElement;
    const wishlistOverlay = document.getElementById("wishlistOverlay") as HTMLDivElement;
    const wishlistCloseBtn = document.getElementById("wishlistCloseBtn") as HTMLButtonElement;
    const wishlistItemsContainer = document.getElementById("wishlistItems") as HTMLDivElement;
    const wishlistCountBadge = document.getElementById("wishlistCount") as HTMLElement;

    // 찜 목록 함수
    const renderWishlist = () => {
        const items = wishlistManager.getItems();
        wishlistCountBadge.textContent = String(wishlistManager.getCount());

        if (items.length === 0) {
            wishlistItemsContainer.innerHTML = "<p>찜한 상품이 없습니다.</p>";
            return;
        }

        wishlistItemsContainer.innerHTML = items
            .map(
                (item) => `
            <div class="wishlist-item-row">
                <span class="wishlist-item-name">${item.image} ${item.name}</span>
                <span class="wishlist-item-price">${item.price.toLocaleString()}원</span>
                <button class="wishlist-item-remove" data-remove-id="${item.id}">X</button>
            </div>
        `,
            )
            .join("");
    };

    // 렌더링 함수
    const render = (category: Category) => {
        // 필터링된 데이터 가져오기
        const filtered =
            category === "all"
                ? clothingData
                : clothingData.filter((item) => item.category === category);

        // 무한 루프 효과를 위해 필터링된 데이터를 2배로 복제
        const displayData = [...filtered, ...filtered];

        // --- 애니메이션 속도 동적 계산 (항상 일정한 속도 유지) ---
        // 카드 1개당 차지하는 너비: 280px(카드 너비) + 20px(gap 여백) = 300px
        // 화면이 -50% 이동할 때 실제 이동하는 거리는 '원본 데이터 개수 * 300px'
        const moveDistance = filtered.length * 300;
        const speedPxPerSec = 50; // 초당 50px 이동 (좀 더 천천히)
        const duration = displayData.length === 0 ? 0 : (moveDistance / speedPxPerSec);

        // 애니메이션 초기화 후 재적용
        clothesGrid.style.animation = 'none';
        void clothesGrid.offsetWidth; // 브라우저 리플로우 강제 발생 (애니메이션 재시작 위함)
        if (displayData.length > 0) {
            clothesGrid.style.animation = `scroll ${duration}s linear infinite`;
        }
        // ----------------------------------------------------

        clothesGrid.innerHTML = displayData
            .map(
                (item) => {
                    // 항목이 찜 목록에 있는지 확인
                    const isWishlisted = wishlistManager.hasItem(item.id);
                    return `
            <article class="clothes-card">
                <div class="clothes-img" style="font-size: 80px; text-align: center; padding: 30px 20px;">
                    ${item.image}
                </div>
                <div class="clothes-info" style="padding: 10px; border-top: 1px solid #eee;">
                    <h3 style="font-size: 15px; margin: 5px 0; white-space: nowrap; overflow: hidden; text-overflow: ellipsis;">${item.name}</h3>
                    <p style="font-size: 12px; color: #777; margin-bottom: 8px; line-height: 1.4; display: -webkit-box; -webkit-line-clamp: 2; -webkit-box-orient: vertical; overflow: hidden;">${item.description}</p>
                    <div style="display: flex; justify-content: space-between; align-items: flex-end;">
                        <span style="font-weight: bold; color: #ff4d7d;">${item.price.toLocaleString()}원</span>
                        <span style="font-size: 11px; color: #999;">리뷰 <span style="color: #666; font-weight: 500;">${item.reviewCount}</span></span>
                    </div>
                </div>
                <button class="add-wishlist-btn" data-id="${item.id}">
                    ${isWishlisted ? "❤️" : "🤍"}
                </button>
            </article>
        `})
            .join("");
    };

    // 버튼 이벤트 연결
    filterBtns.forEach((btn) => {
        btn.addEventListener("click", () => {
            filterBtns.forEach((b) => b.classList.remove("active"));
            btn.classList.add("active");

            const selectedCategory =
                (btn.dataset.category as Category) || "all";
            render(selectedCategory);
        });
    });

    // 마우스 이벤트
    clothesGrid.addEventListener("mouseover", () => {
        clothesGrid.classList.add("paused");
    });

    clothesGrid.addEventListener("mouseout", () => {
        clothesGrid.classList.remove("paused");
    });

    // 찜하기 버튼 클릭 이벤트
    clothesGrid.addEventListener("click", (e: MouseEvent) => {
        const btn = (e.target as HTMLElement).closest<HTMLButtonElement>(".add-wishlist-btn");
        if (!btn) return;

        const id = Number(btn.dataset.id);
        const item = clothingData.find((i) => i.id === id);
        if (item) {
            wishlistManager.add(item);
            renderWishlist();

            const activeCategoryBtn = document.querySelector('.filter-btn.active') as HTMLButtonElement;
            const category = (activeCategoryBtn?.dataset.category as Category) || "all";
            render(category);
        }
    });

    // 찜 목록 항목 삭제 이벤트
    wishlistItemsContainer.addEventListener("click", (e: MouseEvent) => {
        const btn = (e.target as HTMLElement).closest<HTMLButtonElement>(".wishlist-item-remove");
        if (!btn) return;

        const id = Number(btn.dataset.removeId);
        wishlistManager.remove(id);
        renderWishlist();

        const activeCategoryBtn = document.querySelector('.filter-btn.active') as HTMLButtonElement;
        const category = (activeCategoryBtn?.dataset.category as Category) || "all";
        render(category);
    });

    // 사이드바 여닫기
    const openWishlist = () => {
        wishlistSidebar.classList.add("open");
        wishlistOverlay.classList.add("active");
        wishlistSidebar.setAttribute("aria-hidden", "false");
    };

    const closeWishlist = () => {
        wishlistSidebar.classList.remove("open");
        wishlistOverlay.classList.remove("active");
        wishlistSidebar.setAttribute("aria-hidden", "true");
    };

    wishlistToggleBtn.addEventListener("click", openWishlist);
    wishlistCloseBtn.addEventListener("click", closeWishlist);
    wishlistOverlay.addEventListener("click", closeWishlist);

    document.addEventListener("keydown", (e: KeyboardEvent) => {
        if (e.key === "Escape") closeWishlist();
    });

    renderWishlist();
    render("all");
});
