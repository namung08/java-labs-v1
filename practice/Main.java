package practice;

import practice.model.Person;
import practice.util.PersonUtil;

import java.util.List;

public class Main {
  public static void main(String[] args) {

    // 객체 리스트 생성
    List<Person> people = PersonUtil.createPersonList();

    // Set 실습
    PersonUtil.demonstrateSet();

    // Map 실습
    PersonUtil.demonstrateMap();

    // 람다 실습
    PersonUtil.demonstrateLambda();

    // 스트림 실습
    PersonUtil.demonstrateStream(people);
  }
}

