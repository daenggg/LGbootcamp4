// 메뉴 아이템 더미 데이터
const menuData = [
    {
        id: 1,
        name: "아메리카노",
        price: 4500,
        category: "coffee",
        emoji: "☕",
        tags: ["인기", "추천"],
    },
    {
        id: 2,
        name: "카페라떼",
        price: 5000,
        category: "coffee",
        emoji: "🥛",
        tags: ["인기"],
    },
    {
        id: 3,
        name: "콜드브루",
        price: 5500,
        category: "coffee",
        emoji: "🧊",
        tags: ["신메뉴", "추천"],
    },
    {
        id: 4,
        name: "카푸치노",
        price: 5000,
        category: "coffee",
        emoji: "🍵",
    },
    {
        id: 5,
        name: "얼그레이",
        price: 4000,
        category: "tea",
        emoji: "🫖",
        tags: ["추천"],
    },
    {
        id: 6,
        name: "페퍼민트",
        price: 4000,
        category: "tea",
        emoji: "🌿",
        tags: ["디카페인"],
    },
    {
        id: 7,
        name: "티라미수",
        price: 6500,
        category: "dessert",
        emoji: "🍰",
        tags: ["인기"],
    },
    {
        id: 8,
        name: "치즈케이크",
        price: 7000,
        category: "dessert",
        emoji: "🧀",
        soldOut: true, // 품절
    },
    {
        id: 9,
        name: "마들렌",
        price: 3500,
        category: "dessert",
        emoji: "🧁",
        tags: ["신메뉴"],
    },
];
// 클래스 + 접근 제어자
// CartManager : 장바구니 데이터 전담 클래스
// - 외부에서 items 배열을 직접 건드리지 못하도록 private으로 보호
// - 데이터 조작은 반드시 public 메서드를 통해서만 수행
class CartManager {
    // private : 클래스 외부에서 읽기/수정 불가
    items = [];
    // public add : 메뉴 아이템 추가 (이미 있으면 수량 증가)
    add(menu) {
        if (menu.soldOut) return;
        const existing = this.items.find((item) => item.id === menu.id);
        if (existing) {
            existing.quantity += 1;
        } else {
            //스프레드로 MenuItem복사 + quantity 필드 추가
            this.items.push({ ...menu, quantity: 1 });
        }
    }
    // public remove : id에 해당하는 아이템 제거
    remove(id) {
        this.items = this.items.filter((item) => item.id !== id);
    }
    // public clear : 장바구니 전체 비우기
    clear() {
        this.items = [];
    }
    //public getItems : 복사본 반환 -> 외부에서 원본 배열을 직접 수정하지 못하게 방어
    getItems() {
        return [...this.items];
    }
    //public getTotalPrice 총 금액 계산
    getTotalPrice() {
        return this.items.reduce(
            (sum, item) => sum + item.price * item.quantity,
            0,
        );
    }
    //public getTotalCount : 총 수량 계산
    getTotalCount() {
        return this.items.reduce((sum, item) => sum + item.quantity, 0);
    }
    // public isEmpty : 장바구니가 비어있는지 여부
    isEmpty() {
        return this.items.length === 0;
    }
}
// MenuManager : 메뉴 렌더링 + 카테고리 상태 전담 클래스
class MenuManager {
    currentCategory = "all";
    grid;
    constructor(grid) {
        this.grid = grid;
    }
    setCategory(cat) {
        this.currentCategory = cat;
    }
    getCurrentCategory() {
        return this.currentCategory;
    }
    render() {
        const filtered =
            this.currentCategory === "all"
                ? menuData
                : menuData.filter(
                      (item) => item.category === this.currentCategory,
                  );
        const html = filtered
            .map((item) => {
                const tagsHtml = item.tags?.length
                    ? item.tags
                          .map((tag) => `<span class=tag>${tag}</span>`)
                          .join("")
                    : "";
                const soldOutHtml = item.soldOut
                    ? '<span class="tag sold">품절</span>'
                    : "";
                return `
        <article class='menu-card ${item.soldOut ? "sold-out" : ""}' role=listitem>
            <div class="menu-card-emoji">${item.emoji}</div>
            <div class="menu-card-name">${item.name}</div>
            <div class="menu-card-tags">${tagsHtml}${soldOutHtml}</div>
            <div class="menu-card-price">${item.price.toLocaleString()}원</div>
            ${
                !item.soldOut
                    ? `<button class="add-cart-btn" data-id="${item.id}">장바구니 담기</button>`
                    : `<button class="add-cart-btn" disabled>품절</button>`
            }
        </article>
        `;
            })
            .join("");
        this.grid.innerHTML = html || "<p>메뉴가 없습니다.</p>";
    }
}
// 인스턴스 생성 - 클래스를 new 키워드로 실체화
const cartManager = new CartManager(); // 장바구니 매니저
const menuGrid = document.getElementById("menuGrid");
const cartSidebar = document.getElementById("cartSidebar");
const cartOverlay = document.getElementById("cartOverlay");
const cartToggleBtn = document.getElementById("cartToggleBtn");
const cartCloseBtn = document.getElementById("cartCloseBtn");
const cartItems = document.getElementById("cartItems");
const cartTotal = document.getElementById("cartTotal");
const cartCountBadge = document.getElementById("cartCount");
const orderBtn = document.getElementById("orderBtn");
const subscribeForm = document.getElementById("subscribeForm");
const emailInput = document.getElementById("emailInput");
const subscribeMsg = document.getElementById("subscribeMsg");
// menuGrid는 위 DOM 레퍼런스에서 이미 선언됨
const menuManager = new MenuManager(menuGrid);
// 장바구니 UI 렌더링
function renderCart() {
    if (cartManager.isEmpty()) {
        cartItems.innerHTML = "<p>담긴 상품이 없습니다.</p>";
        cartTotal.textContent = "0원";
        cartCountBadge.textContent = "0";
        orderBtn.disabled = true;
        return;
    }
    // getItems(): 복사본 배열 반환
    const html = cartManager
        .getItems()
        .map(
            (item) => `
    <div class="cart-item-row">
        <span class="cart-item-name">${item.emoji} ${item.name}</span>
        <span class="cart-item-qty">${item.quantity}</span>
        <span class="cart-item-price">${(item.price * item.quantity).toLocaleString()}원</span>
        <button class="cart-item-remove" data-remove-id="${item.id}">X</button>
    </div>
    `,
        )
        .join("");
    cartItems.innerHTML = html;
    cartTotal.textContent = cartManager.getTotalPrice().toLocaleString() + "원";
    cartCountBadge.textContent = String(cartManager.getTotalCount());
    orderBtn.disabled = false;
}
// 장바구니에 아이템 추가 (cartManager.add())
function addToCart(id) {
    const menu = menuData.find((item) => item.id === id);
    if (!menu) return;
    // 데이터 처리는 CartManager에게 위임
    cartManager.add(menu);
    renderCart();
}
//  장바구니 아이템 제거 (carManager.remove())
function removeFromCart(id) {
    cartManager.remove(id);
    renderCart();
}
// CART open / close
function openCart() {
    cartSidebar.classList.add("open");
    cartOverlay.classList.add("active");
    cartSidebar.setAttribute("aria-hidden", "false");
}
function closeCart() {
    cartSidebar.classList.remove("open");
    cartOverlay.classList.remove("active");
    cartSidebar.setAttribute("aria-hidden", "true");
}
// 이벤트 처리
// 필터 탭 클릭 이벤트
const filterBtns = document.querySelectorAll(".filter-btn");
filterBtns.forEach((btn) => {
    btn.addEventListener("click", function () {
        filterBtns.forEach((b) => b.classList.remove("active"));
        this.classList.add("active");
        // menuManager.setCategory() : 필터 선택한 요소들만 나와야 함
        menuManager.setCategory(this.dataset.category || "all");
        // menuManger.render() : 변경된 카테고리로 렌더링 즉 메뉴 다시 그리기
        menuManager.render();
    });
});
// 메뉴 그리드 클릭
menuGrid.addEventListener("click", function (e) {
    // closest : 클릭된 요소에서 가장 가까운 해당 선택자 조상을 찾음
    const btn = e.target.closest(".add-cart-btn");
    if (!btn || btn.disabled) return;
    // dataset.id = data-id 속성 값
    const id = Number(btn.dataset.id);
    addToCart(id);
    // 버튼 피드백 애니메이션
    btn.textContent = "담겼습니다!";
    btn.style.background = "green";
    setTimeout(() => {
        btn.textContent = "장바구니 담기";
        btn.style.background = "";
    }, 800);
});
// 장바구니 아이템 삭제
cartItems.addEventListener("click", function (e) {
    const btn = e.target.closest(".cart-item-remove");
    if (!btn) return;
    const id = Number(btn.dataset.removeId);
    removeFromCart(id);
});
// 장바구니 열기/닫기
cartToggleBtn.addEventListener("click", openCart);
cartCloseBtn.addEventListener("click", closeCart);
cartOverlay.addEventListener("click", closeCart);
// ESC 키로 장바구니 닫기
document.addEventListener("keydown", function (e) {
    if (e.key === "Escape") closeCart();
});
// 주문 버튼
orderBtn.addEventListener("click", function () {
    if (cartManager.isEmpty()) return;
    // Order Interface로 타입 안전하게 주문 객체 생성
    const order = {
        id: Date.now(),
        items: cartManager.getItems(),
        totalPrice: cartManager.getTotalPrice(),
        createdAt: new Date(),
        status: "pending",
    };
    // 주문 완료 처리
    alert(
        `주문 완료! \n 주문번호: #${order.id} \n 금액: #${order.totalPrice.toLocaleString}원`,
    );
    console.log("주문 정보: ", order);
    // cartManager.clear() : 장바구니 초기화, 주문 완료 후에 이루어지는 초기화 과정
    cartManager.clear();
    renderCart();
    closeCart();
});
// 뉴스레터 구독 폼
// submit 이벤트 -> 디폴트 이벤트 방지가 필요함!
subscribeForm.addEventListener("submit", function (e) {
    e.preventDefault();
    const email = emailInput.value.trim();
    // 간단 이메일 유효성 검사
    if (!email || !email.includes("@")) {
        subscribeMsg.textContent = "올바른 이메일을 입력해주세요";
        subscribeMsg.style.color = "#ffe0c0";
        emailInput.value = "";
        return;
    }
    subscribeMsg.textContent = `${email} 구독 완료! 감사합니다.`;
    subscribeMsg.style.color = "green";
    emailInput.value = "";
    setTimeout(() => {
        subscribeMsg.textContent = "";
    }, 3000);
});
// 초기 렌더링
menuManager.render();
renderCart();
console.log("웹 초기화 완료!");
console.log(`메뉴 총 ${menuData.length}개 로드됨`);
// 메뉴 통계 출력
const categories = ["coffee", "tea", "dessert"];
categories.forEach((cat) => {
    const count = menuData.filter((item) => item.category === cat).length;
    console.log(`${cat} : ${count}개`);
});
// 평균 가격
const avgPrice =
    menuData.reduce((sum, item) => sum + item.price, 0) / menuData.length;
console.log(`평균 가격: ${avgPrice.toLocaleString()}원`);
// export {};
