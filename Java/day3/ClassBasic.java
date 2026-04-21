/*
 * 클래스 기초
 * 클래스를 직접 정의하고 객체를 생성하는 방법을 익힌다.
 * 필드(속성)와 메서드(기능) 클래스 안에 작성한다.
 * 생성자의 역할을 이해한다.
 * this 키워드가 무엇을 가르키는지 이해한다.
 * */


public class ClassBasic {
    static void main(String[] args) {
//        1. 클래스 정의와 객체 생성
//        클래스는 '설계도', 객체는 그 설계도로 만든 '실제 물건'이다.
//        new 키워드로 객체(인스턴스)를 생성한다.
        Book book1 = new Book("자바의 정석", "남궁성", 35000);
        Book book2 = new Book("JS의 정석", "남궁민", 20000);
        book1.printInfo();
        book2.printInfo();
//        2. 생성자 (Constructor)
//        객체가 만들어질 때 자동으로 한 번 호출된다
//        필드 초기화 역할을 담당한다
//        생성자를 여러 개 만들 수 있다 (오버로딩)
        Book bookDefault = new Book("제목 미정");
        bookDefault.printInfo();
//        3. this 키워드
//        this.필드 : 매개변수와 필드 이름이 같을 때 필드를 가리킨다
//        this() : 같은 클래스의 다른 생성자를 호출한다
//        Book 생성자 내부에서 this.title, this.author, this.price로 구분
//        bookDefault는 this("미상", 0)으로 다른 생성자를 위임 호출함
        System.out.println("할인가(20%): " + book1.discountPrice(20) + "원");
        Calculator calc = new Calculator();

        int sum = calc.add(5, 10);
        System.out.println("a + B = " + sum);


    }
}

// TODO 실습 문제
/*
 * [기초]
 * 1. calculator 클래스
 * - add (int a, int b), subtract, multiply, divide 메서드 구현
 * - divide는 b가 0이면 "0으로 나눌 수 없습니다" 출력 후 0 반환
 * - Calculator 객체 생성 후 각 연산 결과를 출력하세요. 연산은 아무거나
 * - 힌트 : class Calculator {int add(int a, int b) {return a + b;}...
 *
 * [심화]
 * 1. CBBankAccount 이체 기능
 * - CBBankAccount 의 transfer(CBBankAccount to, long amount) 메서드 확인
 * - 계좌 A (잔액 5000) -> 계좌 B (잔액 20000)로 30000원 이체 후 각 잔액 출력
 * - 잔액 초과 시 이체 시도를 거부하는 메시지를 띄워보자
 * */

// 1번 풀이
class Calculator {
    int add(int a, int b) {
        return a + b;
    }

    int subtract(int a, int b) {
        return a - b;
    }

    int multiply(int a, int b) {
        return a * b;
    }

    int divide(int a, int b) {
        if (b == 0) {
            System.out.println("0으로 나눌 수 없습니다.");
            return 0;
        } else {
            return a / b;
        }

    }
}

// 2번 풀이
class CBBankAccount {
    private String owner;
    private long balance;

    public CBBankAccount(String owner, long balance) {
        this.owner = owner;
        this.balance = balance;
    }

    public long getBalance() {
        return balance;
    }

    public void deposit(long amount) {
        if (amount <= 0) {
            System.out.println("입금액은 양수여야 합니다.");
            return;
        }
        balance += amount;
    }

    public void withdraw(long amount) {
        if (amount > balance) {
            System.out.println(owner + " 잔액 부족! (잔액: " + balance + ")");
            return;
        }
        balance -= amount;
    }

    public void transfer(CBBankAccount to, long amount) {
        if (amount > this.balance) {
            System.out.println("잔액 부족");
            return;
        }
        this.balance -= amount;
        to.balance += amount;
        System.out.println(owner + " → " + to.owner + " " + amount + "원 이체 완료");
    }

    @Override
    public String toString() {
        return owner + " 잔액: " + balance + "원";
    }
}


class Book {
    String title;
    String author;
    int price;

    //        생성자 오버로딩 1 - 제목만 입력 (나머지 기본값)
    public Book(String title) {
        this(title, "미상", 0);
    } // this()로 아래 생성자 위임 호출

    //        생성자 오버로딩 2 - 모든 필드 초기화
    public Book(String title, String author, int price) {
        this.title = title; // this.title : 필드, title : 매개변수
        this.author = author;
        this.price = price;
    }

    public void printInfo() {
        System.out.println(title + " " + author + " " + price);
    }

    //    할인율(%)을 적용한 가격 반환
    public int discountPrice(int discountPercent) {
        return price * (100 - discountPercent) / 100;
    }
}