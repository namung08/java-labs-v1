package chapter4.labs.lab3;

/**
 * Lab 3: static과 final 키워드 사용하기
 *
 * Calculator 클래스 정의하기
 */
public class Calculator {
  // TODO: PI 값을 나타내는 static final 상수를 정의하세요.
  private static final float PI = 3.141592653589793f;

  // TODO: 인스턴스 변수를 정의하세요. (계산기 모델명, 계산 횟수 등)
  private String model;
  private int counter;

  // TODO: 계산기 객체의 총 개수를 나타내는 static 변수를 정의하세요.
  private static int CALCULATOR_COUNT = 0;

  // TODO: 생성자를 정의하고, 객체가 생성될 때마다 계산기 개수를 증가시키세요.
  public Calculator(String model) {
    this(model, 0);

    CALCULATOR_COUNT++;
  }

  public Calculator(String model, int counter) {
    this.model = model;
    this.counter = counter;

    CALCULATOR_COUNT++;
  }


  // TODO: 원의 면적을 계산하는 static 메소드를 정의하세요.
  public static double areaOfACircle(double radius) {
    return PI * radius * radius;
  }

  // TODO: 원의 둘레를 계산하는 static 메소드를 정의하세요.
  public static double circumferenceOfACircle(double radius) {
    return 2 * PI * radius;
  }


  // TODO: 사각형의 면적을 계산하는 static 메소드를 정의하세요.
  public static double areaOfQuadratic(double width, double height) {
    return width * height;
  }


  // TODO: 인스턴스 메소드를 정의하고, 해당 메소드가 호출될 때마다 계산 횟수를 증가시키세요.
  public void addCount() {
    counter++;
  }

  // TODO: 계산기의 정보를 출력하는 메소드를 정의하세요.
  public void print() {
    System.out.println("model: " + model + " counter: " + counter);
  }

  // TODO: 현재까지 생성된 계산기의 총 개수를 반환하는 static 메소드를 정의하세요.
  public static void calculatorCountPrint() {
    System.out.println("count: " + CALCULATOR_COUNT);
  }

}

