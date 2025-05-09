package chapter8.labs.lab1;

import chapter4.labs.lab2.Book;

import static chapter8.labs.lab1.PairUtils.*;

/**
 * Lab 1: 제네릭 클래스 구현 테스트
 *
 * Pair 클래스와 PairUtils 클래스의 기능을 테스트합니다.
 */
public class PairTest {
    public static void main(String[] args) {
        System.out.println("=== Pair 클래스 테스트 ===");

        // TODO: Pair 클래스의 다양한 타입 매개변수를 사용하여 객체를 생성하고 테스트하세요.
        // Integer와 String 타입의 Pair
        Pair<Integer, String> integerStringPair = new Pair<>();
        Pair<Integer, String> integerStringPair2 = new Pair<>();
        // Double과 Double 타입의 Pair
        Pair<Double, Double> twoDoublePair = new Pair<>();
        // 사용자 정의 클래스를 사용한 Pair
        Pair<Long, Book> longBookPair = new Pair<>();
        System.out.println("\n=== PairUtils 클래스 테스트 ===");

        // TODO: PairUtils 클래스의 메소드를 테스트하세요.
        // of 메소드 테스트
        Pair pair = of(integerStringPair, twoDoublePair);
        System.out.println(pair);
        // swap 메소드 테스트
        Pair<String, Integer> stringIntegerPair = swap(integerStringPair);
        System.out.println(stringIntegerPair);
        // 숫자 타입의 sum 메소드 테스트
        Pair<Integer, Integer> twoIntegerPair = of(1, 2);
        System.out.println("sum: " + sum(twoIntegerPair));
        // pair 비교
        System.out.println("compare1: " + compare(integerStringPair, integerStringPair));
        System.out.println("compare2: " + compare(integerStringPair, integerStringPair2));
        System.out.println("compare3: " + compare(integerStringPair, twoDoublePair));

        // 타입 제한 테스트 (Number 하위 클래스만 가능)

        // 와일드카드 메소드 테스트
    }
}
