package practice.model;

import java.util.Objects;

public class Person implements Comparable<Person> {
  private String name;
  private int age;

  // TODO: 생성자를 구현해보세요

  public Person() {
    this("테스트", 15);
  }

  public Person(String name) {
    this(name, 50);
  }

  public Person(int age) {
    this("test", age);
  }

  public Person(String name, int age) {
    this.name = name;
    this.age = age;
  }
// TODO: Getter, Setter를 구현해보세요

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }


  // TODO: toString() 오버라이딩
  // 예: "Person{name='Alex', age=20}"
  @Override
  public String toString() {
    return "Person [name=" + name + ", age=" + age + "]";
  }

  // TODO: equals()와 hashCode() 오버라이딩
  // 이름과 나이를 기준으로 같다고 판단
  // Comparable 인터페이스 구현 (나이 오름차순 정렬 기준)

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof Person person)) return false;
    return getAge() == person.getAge() && Objects.equals(getName(), person.getName());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getName(), getAge());
  }

  @Override
  public int compareTo(Person other) {
    // TODO: 비교 기준 작성
    return String.CASE_INSENSITIVE_ORDER.compare(getName(), other.getName());
  }
}

