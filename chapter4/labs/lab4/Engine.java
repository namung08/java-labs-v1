package chapter4.labs.lab4;

/**
 * Lab 4: 접근 제한자와 객체 간 관계 구현하기
 *
 * Engine 클래스 정의하기
 */
public class Engine {
  // TODO: 적절한 접근 제한자를 사용하여 필드를 정의하세요.
  // (엔진 타입, 마력, 작동 상태 등)
  private String engineType;
  private int horsePower;
  private int cylinders;
  private int temperature;
  private boolean isRunning;

  // TODO: 생성자를 정의하세요.
  public Engine(String engineType, int horsePower, int cylinders) {
    setEngineType(engineType);
    setHorsePower(horsePower);
    setCylinders(cylinders);
    this.temperature = 0;
    this.isRunning = false;
  }

  // TODO: 엔진을 시작하는 메소드를 정의하세요.
  public void start() {
    if (!this.isRunning) {
      this.isRunning = true;
      this.temperature = 100;
      System.out.println(this.engineType + " is running.");
    }
  }

  // TODO: 엔진을 정지하는 메소드를 정의하세요.
  public void stop() {
    if (this.isRunning) {
      this.isRunning = false;
      this.temperature = 0;
      System.out.println(this.engineType + " is stopped.");
    }
  }

  // TODO: 엔진의 상태를 확인하는 메소드를 정의하세요.
  public void nowStatus() {
    if (this.isRunning) {
      System.out.println(this.engineType + " is now running.");
    } else {
      System.out.println(this.engineType + " is stopped.");
    }
    System.out.println(this.temperature + " Temperature");
  }

  // TODO: 엔진의 정보를 출력하는 메소드를 정의하세요.
  public void print() {
    System.out.println("Engine Type: " + this.engineType + "HorsePower: " + this.horsePower + "Cylinders: " + this.cylinders);
    System.out.println(" Temperature: " + this.temperature + "Running: " + this.isRunning);
  }

  // TODO: 필요한 getter/setter 메소드를 정의하세요.

  public String getEngineType() {
    return engineType;
  }

  public void setEngineType(String engineType) {
    if (engineType != null && !engineType.isEmpty()) {
      this.engineType = engineType;
    }
  }

  public int getHorsePower() {
    return horsePower;
  }

  public void setHorsePower(int horsePower) {
    if (horsePower > 0) {
      this.horsePower = horsePower;
    }
  }

  public int getCylinders() {
    return cylinders;
  }

  public void setCylinders(int cylinders) {
    if (cylinders > 1) {
      this.cylinders = cylinders;
    }
  }

  public int getTemperature() {
    return temperature;
  }

  public void setTemperature(int temperature) {
    if (temperature >= 0) {
      this.temperature = temperature;
    }
  }

  public boolean isRunning() {
    return isRunning;
  }

  public void setRunning(boolean running) {
    isRunning = running;
  }
}
