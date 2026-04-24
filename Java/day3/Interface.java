/*
* 인터페이스와 추상 클래스
* 인터페이스의 역할과 사용 방법을 이해한다
* 추상클래스의 역할과 사용 방법을 이해한다
* 인터페이스와 추상 클래스의 차이점을 비교한다
* 다형성을 활용한 설게 방식을 이해한다
* */

public class Interface {
    static void main(String[] args) {
//        Interface - 기능 계약
//        인터페이스는 메서드 시그니처만 선언한다 (구현 없음)
//        implements 키워드로 클래스가 인터페이스를 구현한다
//        인터페이스 타입 변수에 구현체 객체를 담을 수 있다 (다형성)
        Flyable plane = new Airplane("보잉747");
        Flyable bird = new Sparrow("참새");
        plane.fly();
        bird.fly();
//        abstract class - 공통 틀 + 일부 구현
//        abstract 메서드 : 자식이 반드시 구현해야 한다.
//        일반 메서드 : 자식이 그대로 쓰거나 오버라이딩 할 수 있다.
//        interface와 달리 필드와 생성자를 가질 수 있다.
        AbstractShape[] shapes ={
                new IntfCircle(5.0,"빨강"),
                new IntfRect(4.0,6.0),
                new IntfTriangle(3.0,8.0)
        };
        for (AbstractShape s : shapes) {
            s.draw();
            System.out.printf(" 넓이: %.2f%n", s.area());
        }
    }

//    TODO
    /*
    * [기초]
    * printable 인터페이스
    * interface Printable {void print();}
    * Document 클래스가 Printable을 구현하게 하세요
    * print() 구현: "문서 출력 중: [제목]" 출력
    * Document 객체 2개를 만들어 print() 호출하세요
    * 힌트 class Document implements Printable {String title;...}
    * [심화]
    * 복수 인터페이스 구현
    * interface Printable {void print();}
    * interface Saveable {void save(String filename);)}
    * Document 클래스가 두 인터페이스를 모두 구현하게 하세요.
    * print() 콘솔 출력, save()는 "파일 저장: [파일명]"  출력
    * */


}

interface Flyable {
    void fly();
}

class Airplane implements Flyable {
    private String model;
    public Airplane(String model) {this.model = model;}
    @Override public void fly() {
        System.out.println(model + ": 엔진 추력으로 하늘을 납니다.");
    }
}
class Sparrow implements Flyable{
    private String name;
    public Sparrow(String name) {this.name =name;}
    @Override public void fly() {
        System.out.println(name + ": 날갯짓으로 날아오릅니다.");
    }
}

abstract class AbstractShape {
    protected String color;
    public AbstractShape(String color) {this.color = color;}
    public AbstractShape() {this.color = "검정";}

    abstract double area();

//    공통 구현 메서드 - 자식이 재사용
    void draw() {
        System.out.println(getClass().getSimpleName()+"색상"+ color);
    }
}

class IntfCircle extends AbstractShape {
    private double r;
    public IntfCircle(double r, String color) {super(color); this.r = r;}
    @Override public double area() {return Math.PI *r *r;}
}
class IntfRect extends AbstractShape {
    private double w,h;
    public IntfRect(double w, double h) { super();this.w = w; this.h=h;}
    @Override public double area() {return w*h;}
}
class IntfTriangle extends AbstractShape {
    private double base, height;
    public IntfTriangle(double base, double height) {super(); this.base = base; this.height = height;}
    @Override public double area() {return 0.5* base*height;}
}