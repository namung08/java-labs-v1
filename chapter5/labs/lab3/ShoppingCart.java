package chapter5.labs.lab3;

import java.util.ArrayList;
import java.util.List;

/**
 * Lab 3: 인터페이스 활용하기
 *
 * ShoppingCart 클래스를 정의하세요.
 * 이 클래스는 Buyable 인터페이스를 구현한 다양한 상품을 담는 장바구니 역할을 합니다.
 */
public class ShoppingCart {
  // TODO: 상품 목록을 저장할 리스트 선언
  List<Buyable> buyables;

  // TODO: 생성자 정의
  public ShoppingCart() {
    buyables = new ArrayList<>();
  }

  // TODO: 장바구니에 상품 추가하는 메소드 구현
  public void add(Buyable buyable) {
    buyables.add(buyable);
  }

  // TODO: 장바구니에서 상품 제거하는 메소드 구현
  public void remove(Buyable buyable) {
    buyables.remove(buyable);
  }

  // TODO: 장바구니의 총 금액을 계산하는 메소드 구현
  public void printTotalAmount() {
    int sum = 0;
    for (Buyable buyable : buyables) {
      sum += buyable.getPrice();
    }
    System.out.println("The sum of all buyables is " + sum);
  }

  public void printTotalAmountOfDiscountForDiscountedBook() {
    int sum = 0;
    for (Buyable buyable : buyables) {
      if (buyable instanceof DiscountedBook discountedBook) {
        sum += discountedBook.getDiscountPrice();
      }
    }
    System.out.println("The sum of all discount buyables is " + sum);
  }

  // TODO: 장바구니 상품 목록을 출력하는 메소드 구현
  public void print() {
    for (Buyable buyable : buyables) {
      buyable.print();
    }
  }
}
