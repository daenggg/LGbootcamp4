/*
* 객체지향 프로그래밍
* 주제 4대 특성 - 캡슐화 , 상속, 다형성, 추상화
* 객체지향 프로그래밍의 핵심 개념 4가지를 이해한다
* 클래스와 객체의 관계를 설명할 수 있다
* 현실 세계의 예시로 OOP개념을 연결할 수 있다
* */

public class OOP {
    static void main(String[] args) {
//        1. 캡슐화
//        필드를 private로 숨기고, getter / setter 로만 접근한다
//        setter에서 잘못된 값이 들어오는 것을 막을 수 있다.
        Person p = new Person("김자바",20);
        System.out.println("이름: "+p.getName()+ ", 나이: "+p.getAge());
        p.setAge(25);
        p.setAge(-5);
        System.out.println("변경 후 나이: "+p.getAge());

//        2. 상속
//        자식 클래스가 부모 클래스의 필드/메서드를 물려받는다.
//        super()로 부모 생성자 호출, @Override 로 메서드 재정의
        OopDog dog = new OopDog("바둑이");
        OopCat cat = new OopCat("나비");
        dog.makeSound();
        cat.makeSound();
        System.out.println(dog.introduce());
        System.out.println(cat.introduce());
//        3. 다형성
//        부모 타입 변수에 따라 자식 객체를 담을 수 있다
//        같은 메서드 호출이지만 객채에 따라 다르게 동작한다.
        OopAnimal[] animals = {dog,cat,new OopDog("흰둥이"), new OopCat("고양이")};
        for (OopAnimal a : animals){
            a.makeSound(); //실제 타입에 맞는 소리 출력
        }

//        4. 추상화
//        -> abstract 클래스로 공통 틀 정의, 구현은 자식에게 맡긴다
//        사용자는 내부 구현을 몰라도 area()만 호출하면 된다.
        Figure[] figures = {new FigureCircle(5.0), new FigureRect(4.0,3.0)};
        for (Figure f : figures){
            System.out.printf("넓이 : %2f%n", f.area());
        }
    }
//    TODO 실습 문제
//    [기초]
/*
* Car 클래스 만들기
* - 속성 : brand(제조사), model(모델명),speed(속도)
* - 메서드 : accelerate(int amount) -속도 증가
*           break(int amount) - 속도 감소 (0미만이면0)
*           getInfo() - "제조사 모델명, 속도 출력"
* Car 객체 2개를 만들어 엑셀레이트 브레이크 후 겟인포 출력하시오
* 힌트 : class Car {String brand; int speed; ...}
* */



 /*
 * [심화]
 * 은행 계좌 시스템 설계
 * BankAccount 클래스 : balance( 잔액, private), owner(예금주)
 * deposit(long amount): 입금 (음수면 무시)
 * withdraw(long amount): 출금 (잔액 부족 시 "잔액 부족" 출력)
 * transfer(BankAccount to, long amount) : 이체 송금
 * 계좌 2개를 만들어 입금 -> 이체 -> 잔액 출력까지 구현하세요.
 * */

}
//Person 클래스
class Person {
    private String name;
    private int age;

    public Person(String name, int age){
        this.name = name;
        this.age = (age>=0) ? age : 0;
    }

    public String getName() {return name;}
    public int getAge() {return  age;}

    public void setAge(int age) {
        if (age <0) {
            System.out.println("나이는 0살 이상이어야 합니다.");
            return;
        }
        this.age = age;
    }
}

// 상속 Animal -> Dog, Cat
class OopAnimal{
    protected String name;

    public OopAnimal(String name) { this.name = name;}
    public void makeSound() {
        System.out.println(name + ": (소리 없음)");
    }
    public String introduce() {return "나는 동물 "+ name + "입니다.";}

}

class OopDog extends OopAnimal {
    public OopDog(String name) { super(name);}

    @Override
    public void makeSound() {
        System.out.println(name + ": 멍멍!");
    }

    @Override
    public String introduce() {return "나는 강아지 "+name+"입니다.";}
}
class OopCat extends OopAnimal {
    public OopCat(String name) { super(name);}

    @Override
    public void makeSound() {
        System.out.println(name + ": 야옹~");
    }

    @Override
    public String introduce() {return "나는 고양이 "+name+"입니다.";}
}

abstract class Figure {
    abstract double area();
}

class FigureCircle extends Figure {
    private double r;
    public FigureCircle(double r) {this.r = r;}
    @Override public  double area() { return Math.PI *r *r;}
}
class FigureRect extends Figure {
    private double w, h;
    public FigureRect(double w, double h) {this.w= w; this.h=h;}
    @Override public double area() {return w * h ;}
}

//TODO Car class
class Car {
    String brand;
    String model;
    int    speed;

    public Car(String brand, String model) {
        this.brand = brand;
        this.model = model;
        this.speed = 0;
    }

    public void accelerate(int amount) {
        speed += amount;
        System.out.println(brand + " " + model + " 가속 +" + amount + "km/h → " + speed + "km/h");
    }

    public void brake(int amount) {
        speed -= amount;
        if (speed < 0) speed = 0;
        System.out.println(brand + " " + model + " 감속 -" + amount + "km/h → " + speed + "km/h");
    }

    public void getInfo() {
        System.out.println("→ " + brand + " " + model + ", 속도: " + speed + "km/h");
    }
}

//TODO OopBankAccount class
class OopBankAccount {
    private String owner;
    private long   balance;

    public OopBankAccount(String owner, long balance) {
        this.owner   = owner;
        this.balance = balance;
    }

    public long getBalance() { return balance; }

    public void deposit(long amount) {
        if (amount <= 0) { System.out.println("입금액은 양수여야 합니다."); return; }
        balance += amount;
    }

    public void withdraw(long amount) {
        if (amount > balance) {
            System.out.println(owner + " 잔액 부족! (잔액: " + balance + ")");
            return;
        }
        balance -= amount;
    }

    public void transfer(OopBankAccount to, long amount) {
        if (amount > this.balance) {
            System.out.println(owner + " → " + to.owner + " 이체 실패: 잔액 부족");
            return;
        }
        this.balance -= amount;
        to.balance   += amount;
        System.out.println(owner + " → " + to.owner + " " + amount + "원 이체 완료");
    }

    @Override
    public String toString() { return owner + " 잔액: " + balance + "원"; }
}