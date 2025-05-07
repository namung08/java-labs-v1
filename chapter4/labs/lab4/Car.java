package chapter4.labs.lab4;

import java.awt.*;

/**
 * Lab 4: 접근 제한자와 객체 간 관계 구현하기
 *
 * Car 클래스 정의하기 (Engine을 포함하는 관계)
 */
public class Car {
  private static final int year = 2025;
  // TODO: 적절한 접근 제한자를 사용하여 필드를 정의하세요.
  // (모델명, 색상, 속도, Engine 타입의 필드 등)
  private Engine engine;
  private String maker;
  private String model;
  private Color color;
  private int speed;


  // TODO: 생성자를 정의하세요.
  // (Engine 객체를 생성하여 포함관계 구현)
  public Car(String engineType, int horsePower, int cylinders, String maker, String model, Color color) {
    this.maker = maker;
    this.model = model;
    this.color = color;
    this.speed = 0;
    engine = new Engine(engineType, horsePower, cylinders);
  }

  // TODO: 자동차를 시동하는 메소드를 정의하세요.
  // (내부적으로 Engine 객체의 메소드 호출)
  public void start() {
    engine.start();
  }

  // TODO: 자동차를 정지하는 메소드를 정의하세요.
  // (내부적으로 Engine 객체의 메소드 호출)
  public void stop() {
    if (speed > 0) {
      System.out.println("The vehicle is still moving.");
      return;
    }
    engine.stop();
  }

  // TODO: 자동차의 속도를 증가시키는 메소드를 정의하세요.
  public void increaseSpeed(int amount) {
    if (engine.isRunning()) {
      speed += amount;
      System.out.println("The current speed: " + speed);
    } else {
      System.out.println("Please start the vehicle first.");
    }
  }

  // TODO: 자동차의 속도를 감소시키는 메소드를 정의하세요.
  public void decreaseSpeed(int amount) {
    if (engine.isRunning()) {
      speed -= amount;
      System.out.println("The current speed: " + speed);
    } else {
      System.out.println("Please start the vehicle first.");
    }
  }


  // TODO: 자동차의 정보를 출력하는 메소드를 정의하세요.
  // (내부적으로 Engine 객체의 정보도 출력)
  public void print() {
    System.out.println("maker: " + maker + " model: " + model + " color: " + color + " speed: " + speed);
    engine.print();
  }

  // TODO: 필요한 getter/setter 메소드를 정의하세요.

  public Engine getEngine() {
    return engine;
  }

  public void setEngine(Engine engine) {
    if (engine != null) {
      this.engine = engine;
    }
  }

  public String getMaker() {
    return maker;
  }

  public void setMaker(String maker) {
    if (maker != null && !maker.isEmpty()) {
      this.maker = maker;
    }
  }

  public String getModel() {
    return model;
  }

  public void setModel(String model) {
    if (model != null && !model.isEmpty()) {
      this.model = model;
    }
  }

  public Color getColor() {
    return color;
  }

  public void setColor(Color color) {
    if (color != null) {
      this.color = color;
    }
  }

  public int getSpeed() {
    return speed;
  }

  public void setSpeed(int speed) {
    if (speed >= 0) {
      this.speed = speed;
    } else {
      System.out.println("The speed of the vehicle cannot be negative.");
    }
  }
}
