package chapter5.labs.lab3;

/**
 * Lab 3: 인터페이스 활용하기
 *
 * 인터페이스 구현과 다형성을 테스트하는 클래스입니다.
 */
public class ShopTest {
    public static void main(String[] args) {
        System.out.println("Lab 3: 인터페이스 활용하기 실습");

        // TODO: Book 객체 생성
        Buyable book = new Book("The Giving Tree", "Shel Silverstein", 12600);

        // TODO: Electronics 객체 생성
        Buyable electronics = new Electronics("GIGABYTE AORUS Geforce RTX 5090", 5148000, "GIGABYTE");

        // TODO: DiscountedBook 객체 생성
        Buyable discountedBook = new DiscountedBook("The Giving Tree", "Shel Silverstein", 12600, 50);

        // TODO: ShoppingCart 객체 생성
        ShoppingCart cart = new ShoppingCart();

        // TODO: 장바구니에 상품 추가하기
        cart.add(book);
        cart.add(electronics);
        cart.add(discountedBook);

        // TODO: 장바구니 내용과 총액 출력하기
        System.out.println("---장바구니 내용 출력하기---");
        cart.print();
        System.out.println("---장바구니 총액 출력하기---");
        cart.printTotalAmount();

        // TODO: 인터페이스를 활용한 다형성 테스트
        //       - Buyable 타입 배열에 다양한 상품 담기
        //       - 모든 상품의 정보 출력하기
        cart.print();

        // TODO: Discountable 인터페이스를 구현한 객체만 별도로 처리하기
        cart.printTotalAmountOfDiscountForDiscountedBook();
    }
}
