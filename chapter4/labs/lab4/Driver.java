package chapter4.labs.lab4;

/**
 * Lab 4: 접근 제한자와 객체 간 관계 구현하기
 *
 * Driver 클래스 정의하기 (Car를 사용하는 관계)
 */
public class Driver {
  // TODO: 적절한 접근 제한자를 사용하여 필드를 정의하세요.
  // (이름, 운전 경력 등)
  private String name;
  private int age;
  private int driveAge;

  // TODO: 생성자를 정의하세요.
  public Driver(String name) {
    this(name, 0);
  }

  public Driver(String name, int driveAge) {
    this(name, 20, driveAge);
  }

  public Driver(String name, int age, int driveAge) {
    this.name = name;
    this.age = age;
    this.driveAge = driveAge;
  }

  // TODO: 자동차를 운전하는 메소드를 정의하세요.
  // (Car 객체를 매개변수로 받아 사용 관계 구현)
  public void driveCar(Car car) {
    System.out.println(name + " drives " + car.getModel() + ".");
    car.start();
    car.increaseSpeed(30);
    System.out.println("Safe driving...");
    car.increaseSpeed(20);
    car.print();
    car.decreaseSpeed(15);
    car.decreaseSpeed(35);
    car.stop();
  }

  // TODO: 자동차를 점검하는 메소드를 정의하세요.
  // (Car 객체를 매개변수로 받아 사용 관계 구현)
  public void vehicleInspection(Car car) {
    System.out.println(name + " inspections " + car.getModel() + ".");
    car.print();
  }

  // TODO: 운전자의 정보를 출력하는 메소드를 정의하세요.
  public void print() {
    System.out.println("Name: " + name + " Age: " + age + " DriveAge: " + driveAge);
  }

}
