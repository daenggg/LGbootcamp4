// typescript 클래스 실습입니다. 작성 완료 후 컴파일하신 후 연결해주세요.
// 클래스는 '은행 계좌'라는 실체를 만들기 위한 '설계도'입니다.
class BankAccount {
    owner;
    // 접근 제어자: private -> 클래스 외부에서 '직접' 수정&조회 금지!
    // 은행 금고 안의 돈처럼, 오직 클래스 내부의 입/출금 함수를 통해서만 바뀔 수 있습니다.
    balance;
    // 접근 제어자 : readonly -> 클래스 외부에서 조회는 가능하나 수정 금지
    // 은행 이름은 바뀌지 않아야 하므로 '읽기 전용'으로 보호합니다.
    backName;
    history = [];
    // 생성자 : 'new BankAccount(...)'를 호출할 때 딱 한번 실행되는 초기 세팅 함수입니다.
    constructor(
        // 단축 문법 : 앞에 public을 붙이면, 자동으로 'this.owner' 프로퍼티가 생성되고 값이 대입됩니다.
        owner,
        balance,
        bankName,
    ) {
        this.owner = owner;
        // 생성자에서 받은 초기값들을 실제 클래스 내부 변수(this)에 연결해 줍니다.
        this.balance = balance;
        this.backName = bankName;
    }
    // 입금 메서드 : 돈을 넣는 '정식 절차'입니다.
    // 단순히 변수를 바꾸는 게 아니라, "0원 이하는 안 됨" 같은 규칙(validation)을 체크합니다.
    deposit(amount) {
        if (amount <= 0) return false; // 0과 마이너스 입금은 불가능 하므로 false 반환
        this.balance += amount;
        // 장부에 내력을 기록합니다.
        this.history.push({ type: "입금", amount, balance: this.balance });
        return true;
    }
    // 출금 메서드 : 돈을 빼는 '정식 절차' 입니다.
    // 잔액보다 많이 밸 수 없다라는 볻안 규칙이 있습니다.
    withdraw(amount) {
        if (amount <= 0 || amount > this.balance) return false;
        this.balance -= amount;
        // 장부에 내역을 기록합니다.
        this.history.push({ type: "출금", amount, balance: this.balance });
        return true;
    }
    // 잔액 조회 : 밖에서 'acc.currentBalance'라고 쓰면 이 함수가 실행됩니다.
    // 실제 금고(balance)를 보여주되, 밖에서 직접 값을 덮어쓰지는 못하게 '보기 전용 창문'을 만드는 겁니다.
    get currentBalance() {
        return this.balance;
    }
    // 내역 조회 : 원본 데이터(history)를 보호하면서 데이터를 전ㄷㄹ합니다.
    get log() {
        // [...배열]을 사용해 복사본을 전달합니다.
        // 그래야 밖에서 내역을 지워도 원본 장부는 안전합니다.
        return [...this.history].reverse();
    }
}
// 계좌 생성
const acc = new BankAccount("홍길동", 500000, "우리은행");
// UI 업데이트 함수
function updateUI() {
    const elOwner = document.getElementById("owner");
    const elBank = document.getElementById("bank");
    const elBalance = document.getElementById("balance");
    const elHistory = document.getElementById("history");
    elOwner.textContent = acc.owner + "님";
    elBank.textContent = acc.backName;
    elBalance.textContent = acc.currentBalance.toLocaleString() + "원";
    elHistory.innerHTML =
        acc.log
            .map(
                (t) => `<li>
    <span>${t.type}</span>
    <span class="${t.type === "입금" ? "plus" : "minus"}>${t.type}
    ${t.type === "입금" ? "+" : "-"}${t.amount.toLocaleString()}원
    </span>
    <span class="bal">${t.balance.toLocaleString()}원</span>
    
    </li>`,
            )
            .join("") || `<li>내역 없음</li>`;
}
// 버튼 이벤트
function doDeposit() {
    const input = document.getElementById("amount");
    const msg = document.getElementById("msg");
    const amount = Number(input.value);
    if (!acc.deposit(amount)) {
        msg.textContent = "입금액엔 1원 이상이어야 합니다.";
        return;
    }
    msg.textContent = "";
    input.value = "";
    updateUI();
}
function doWithdraw() {
    const input = document.getElementById("amount");
    const msg = document.getElementById("msg");
    const amount = Number(input.value);
    if (!acc.withdraw(amount)) {
        msg.textContent = "잔액이 부족하거나 금액이 잘못되었습니다.";
        return;
    }
    msg.textContent = "";
    input.value = "";
    updateUI();
}
// 버튼에 이벤트 연결
document.getElementById("btnDeposit").addEventListener("click", doDeposit);
document.getElementById("btnWithdraw").addEventListener("click", doWithdraw);
// 초기 렌더링
updateUI();
// export {};
