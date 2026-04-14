/*
 (node가 설치되어 있어야 합니다)    
실행 방법 -> 터미널에 tsc 파일명.ts를 작성하시면 
컴파일 되어 -> 파일명.js 가 생성됩니다.
*/
// type alias : 카테고리 값 제한
type Category = "all" | "coffee" | "tea" | "dessert";

// interface: 메뉴 아이템 설계도
interface MenuItem {
  id: number;
  name: string;
  price: number;
  category: Exclude<Category, "all">; // 'all' 제외한 세 가지만
  emoji: string;
  soldOut?: boolean; // optional :있어도 되고 없어도 되지만 넣으거면 타입 맞춰!
  tags?: string[];
}

interface CartItem extends MenuItem {
  quantity: number;
}

// Union 타입으로 주문 상태 제한
type OrderStatus = "pending" | "preparing" | "done";

// 주문 인터페이스
interface Order {
  id: number;
  items: CartItem[];
  totalPrice: number;
  createdAt: Date;
  status: OrderStatus;
}

// 메뉴 아이템 더미 데이터
const menuData: MenuItem[] = [
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
  private items: CartItem[] = [];

  // public add : 메뉴 아이템 추가 (이미 있으면 수량 증가)
  public add(menu: MenuItem): void {
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
  public remove(id: number): void {
    this.items = this.items.filter((item) => item.id !== id);
  }

  // public clear : 장바구니 전체 비우기
  public clear(): void {
    this.items = [];
  }

  //public getItems : 복사본 반환 -> 외부에서 원본 배열을 직접 수정하지 못하게 방어
  public getItems(): CartItem[] {
    return [...this.items];
  }

  //public getTotalPrice 총 금액 계산
  public getTotalPrice(): number {
    return this.items.reduce(
      (sum, item) => sum + item.price * item.quantity,
      0,
    );
  }

  //public getTotalCount : 총 수량 계산
  public getTotalCount(): number {
    return this.items.reduce((sum, item) => sum + item.quantity, 0);
  }

  // public isEmpty : 장바구니가 비어있는지 여부
  public isEmpty(): boolean {
    return this.items.length === 0;
  }
}

// MenuManager : 메뉴 렌더링 + 카테고리 상태 전담 클래스
class MenuManager {
  private currentCategory: Category = "all";
  readonly grid: HTMLDivElement;

  constructor(grid: HTMLDivElement) {
    this.grid = grid;
  }

  public setCategory(cat: Category): void {
    this.currentCategory = cat;
  }

  public getCurrentCategory(): Category {
    return this.currentCategory;
  }

  public render(): void {
    const filtered: MenuItem[] =
      this.currentCategory === "all"
        ? menuData
        : menuData.filter((item) => item.category === this.currentCategory);

    const html: string = filtered
      .map((item) => {
        const tagsHtml: string = item.tags?.length
          ? item.tags.map((tag) => `<span class=tag>${tag}</span>`).join("")
          : "";
        const soldOutHtml: string = item.soldOut
          ? '<span class="tag sold">품절</span>'
          : "";

        return `
        <article class='menu-card ${item.soldOut ? "sold-out" : ""}' role=listitem>
            <div class="menu-card-emoji>${item.emoji}</div>
            <div class="menu-card-name>${item.name}</div>
            <div class="menu-card-tags>${tagsHtml}${soldOutHtml}</div>
            <div class="menu-card-price>${item.price.toLocaleString()}원</div>
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

const menuGrid = document.getElementById("menuGrid") as HTMLDivElement;
const cartSidebar = document.getElementById("cartSidebar") as HTMLElement;
const cartOverly = document.getElementById("cartOverlay") as HTMLDivElement;
const cartToggle = document.getElementById(
  "cartToggleBtn",
) as HTMLButtonElement;
const cartCloseBtn = document.getElementById(
  "cartCloseBtn",
) as HTMLButtonElement;
const cartItems = document.getElementById("cartItems") as HTMLDivElement;
const cartTotal = document.getElementById("cartTotal") as HTMLElement;
const cartCountBadge = document.getElementById("cartCount") as HTMLElement;
const orderBtn = document.getElementById("orderBtn") as HTMLButtonElement;
const subscribeForm = document.getElementById(
  "subscribeForm",
) as HTMLFormElement;
const emailInput = document.getElementById("emailInput") as HTMLInputElement;
const subscribeMsg = document.getElementById("subscribeMsg") as HTMLElement;

// menuGrid는 위 DOM 레퍼런스에서 이미 선언됨
const menuManager = new MenuManager(menuGrid);

// 장바구니 UI 렌더링
function renderCart(): void {
  if (cartManager.isEmpty()) {
    cartItems.innerHTML = "<p>담긴 상품이 없습니다.</p>";
    cartTotal.textContent = "0원";
    cartCountBadge.textContent = "0";
    orderBtn.disabled = true;
    return;
  }

  // getItems(): 복사본 배열 반환
  const html: string = cartManager
    .getItems()
    .map(
      (item) =>
        `
    <div class="cart-item-row>
        <span class="cart-item-name>${item.emoji} ${item.name}</span>
        <span class="cart-item-qty>${item.quantity}</span>
        <span class="cart-item-price>${(item.price * item.quantity).toLocaleString()}원</span>
        <button class="cart-item-remove" data-remove-id="${item.id}">X</button>
    </div>
    `,
    )
    .join("");

  cartItems.innerHTML = html;
  cartTotal.textContent = cartManager.getTotalCount().toLocaleString() + "원";
  cartCountBadge.textContent = String(cartManager.getTotalCount());
  orderBtn.disabled = false;
}

// 장바구니에 아이템 추가 (cartManager.add())
function addToCart(id: number): void {
  const menu: MenuItem | undefined = menuData.find((item) => item.id === id);
  if (!menu) return;

  // 데이터 처리는 CartManager에게 위임
  cartManager.add(menu);
  renderCart();
}

//  장바구니 아이템 제거 (carManager.remove())
function removeFromCart(id: number): void {
  cartManager.remove(id);
  renderCart();
}
