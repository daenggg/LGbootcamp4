/*
* 접근 제어자
* 접근 제어자의 종류와 접근 범위를 이해한다
* 왜 필드를 private으로 감추는지 캡슐화 이해한다
* getter/setter 패턴으로 안전하게 필드를 다루는 방법을 익힌다
* static 필드와 static 메서드의 개념을 이해한다
*
* */


public class Modifier {
    static void main(String[] args) {
        /*
        * 접근 제어자
        * public : 어디서든 접근 가능
        * private : 같은 클래스 안에서만 접근 가능
        * protected : 같은 패키지 + 자식 클래스에서 접근 가능
        * (default) : 같은 패키지 안에서만 접근 가능
        * 아래 Counter  클래스로 private + static 동작을 확인해보자.
        * */
        Counter c1 = new Counter("카운터1");
        Counter c2 = new Counter("카운터2");
        Counter c3 = new Counter("카운터3");
        System.out.println("생성된 Counter 수 : " + Counter.getCount());

//        캡슐화 - getter / setter
//        필드를 private으로 숨기고, 공개된 메서드로만 값에 접근한다
//        setter에서 유효성 검사를 수행해 잘못된 값이 들어오는 것을 막는다
    ModPerson person = new ModPerson("홍길동", 30);
        System.out.println(person.getName()+ " "+ person.getAge());
        person.setAge(35);
        person.setAge(-1);
        System.out.println("변경 후 나이: "+person.getAge());
        //    static 필드 / static 메서드
//    static 필드 : 객체가 아닌 클래스 자체에 속한다 (모든 객체가 공유)
//    static 메서드 : 객체 없이 클래스명.메서드()로 호출 가능
        System.out.println("원주율(상수) : "+ MathUtils.PI);
        System.out.println("최대값: "+ MathUtils.max(17,42));
        System.out.println("원 넓이(r = 5): "+MathUtils.circleArea(5.0));
    }
    /*
    * [기초] Counter 클래스 (static 활용)
    * static int count 필드로 객체 생성 횟수를 세는 Counter 클래스를 만드세요.
    * 생성자에서 count++, static getCount() 메서드로 조회
    * Counter 3개를 생성한 후 Counter.getCount()를 출력하세요
    * [심화]
    * Temperature 클래스
    * double celsius (섭씨 , private)
    * static final double ABSOLUTE_ZERO = -273.15 (절대영도 상수)
    * toFahrenheit():화씨 반환 (공식 C * 9/5 +32)
    * toKelvin() : 켈빈 반환 (공식  C +273.15)
    * setCelsius(double c) : 절대영도 미만이면 예외 출력
    * 0℃, 100℃ ,-40℃으로 테스트 해보세요
    * */


}
// private , static
class Counter{
    private static int count = 0; // 모든 객체가 공유하는 카운터
    private String label;

    public Counter(String label){
        this.label = label;
        count++;
    }

    public static int getCount() { return count;}
    public String getLabel() {return  label;}
}
// getter , setter
class ModPerson {
    private String name;
    private int age;

    public ModPerson(String name, int age){
        this.name = name;
        this.age = age;
    }

    public String getName() { return name;}
    public int getAge() { return age;}

    public void setAge(int age){
        if (age < 0 ) {
            System.out.println("나이는 0살 이상이어야 합니다."); return;
        }
        this.age = age;
    }
}

// static
class MathUtils {
    public static final double PI = 3.14159265358979; // static final 상수
    private MathUtils() {} // 인스턴스 생성 방지
    public static int max(int a, int b) { return  (a > b) ? a : b;}
    public static double circleArea(double r) {return PI * r * r;}
}


//심화 TODO
class Temperature {
//    파이널 상수
    public static final double ABSOLUTE_ZERO = -273.15;
//    섭씨 캡슐화
    private double celsius;
//    섭씨 초기화
    public Temperature() {
        this.celsius = 0;
    }
//    절대영도 유효성 검사를 한 섭씨 setter
    public void setCelsius(double c){
        if (c< ABSOLUTE_ZERO){
            System.out.println("절대영도 보다 낮을 수 없습니다.");
            return;
        }
        this.celsius = c;
    }
//    섭씨 getter
    public double getCelsius() {
        return celsius;
    }
//    화씨 반환
    public double toFahrenheit() {
        return celsius * 9.0 / 5.0 +32;
    }
//    켈빈 반환
    public double toKelvin(){
        return celsius - ABSOLUTE_ZERO;
    }

}