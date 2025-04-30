package chapter4.labs.lab2;

/**
 * Lab 2: 생성자 활용하기
 *
 * Book 클래스를 테스트하는 메인 클래스
 */
public class BookTest {
    public static void main(String[] args) {
        System.out.println("Book 클래스 테스트를 시작합니다.");

        // TODO: 기본 생성자를 사용하여 Book 객체를 생성하고 정보를 출력하세요.
        Book book1 = new Book();
        book1.print();

        // TODO: 제목만 인자로 받는 생성자를 사용하여 Book 객체를 생성하고 정보를 출력하세요.
        Book book2 = new Book("title");
        book2.print();

        // TODO: 제목과 저자를 인자로 받는 생성자를 사용하여 Book 객체를 생성하고 정보를 출력하세요.
        Book book3 = new Book("title", "author");
        book3.print();

        // TODO: 제목, 저자, 가격을 인자로 받는 생성자를 사용하여 Book 객체를 생성하고 정보를 출력하세요.
        Book book4 = new Book("title", "author", 1);
        book4.print();

        // TODO: 모든 필드를 인자로 받는 생성자를 사용하여 Book 객체를 생성하고 정보를 출력하세요.
        Book book5 = new Book("title", "author", 1, 2025);
        book5.print();

        // TODO: 객체를 생성한 후 필드 값을 변경하고 정보를 출력하세요.
        Book book6 = new Book("title", "author", 2, 2025);
        book6.setTitle("title1");
        book6.print();
    }
}
