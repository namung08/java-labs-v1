package practice.util;


import practice.model.Person;

import java.util.*;
import java.util.stream.Collectors;

public class PersonUtil {

  // TODO: 컬렉션(List, Set, Map) 실습

  public static List<Person> createPersonList() {
    List<Person> people = new ArrayList<>();
    // TODO: Person 인스턴스를 추가해보세요
    people.addAll(List.of(new Person("tester", 30), new Person(40), new Person("asd"), new Person()));
    return people;
  }

  public static void demonstrateSet() {
    Set<String> fruits = new HashSet<>();
    // TODO: 중복된 문자열을 넣고 Set의 특성을 관찰하세요
    fruits.add("apple");
    fruits.add("banana");
    fruits.add("orange");
    fruits.add("grape");
    fruits.add("pear");
    System.out.println(fruits);
    fruits.add("apple");
    System.out.println(fruits);
  }

  public static void demonstrateMap() {
    Map<String, Integer> scores = new HashMap<>();
    // TODO: 키-값 쌍을 넣고 Map의 동작을 확인해보세요
    scores.put("math", 90);
    scores.put("eng", 80);
    scores.put("kor", 100);
    System.out.println(scores);
  }

  // TODO: 람다와 함수형 인터페이스 실습
  public static void calculate(int x, int y, Calculable calc) {
    calc.calculate(x, y);
  }

  public static void demonstrateLambda() {
    // TODO: 람다 표현식으로 덧셈 구현
    calculate(10, 5, (x, y) -> {
      System.out.println(x + " + " + y + " = " + (x + y));
    }); // 여기에 람다식을 넣어보세요
  }

  // TODO: 스트림 API 실습

  public static void demonstrateStream(List<Person> people) {
    // 필터링: 20세 이상만 출력
    List<Person> filtered = people.stream()
        .filter(p -> p.getAge() >= 20)
        .collect(Collectors.toList());

    // TODO: map 연산으로 이름만 추출하고 출력
    filtered.stream().map(Person::getName).forEach(System.out::println);
    // TODO: 정렬 - 나이 내림차순
    filtered.stream().sorted(Comparator.comparing(Person::getAge)).forEach(System.out::println);
    // 최종 연산: forEach
  }

  // 사용자 정의 함수형 인터페이스
  @FunctionalInterface
  public interface Calculable {
    void calculate(int x, int y);
  }
}

