package chapter4.labs.lab2;

/**
 * Lab 2: 생성자 활용하기
 *
 * Book 클래스 정의하기
 */
public class Book {
  // TODO: 제목, 저자, 가격, 출판연도를 저장할 수 있는 필드를 정의하세요.
  private String title;
  private String author;
  private int price;
  private int year;

  // TODO: 기본 생성자를 정의하세요.
  public Book() {
  }

  // TODO: 제목만 인자로 받는 생성자를 정의하세요. (this() 사용)
  public Book(String title) {
    this.title = title;
  }

  // TODO: 제목과 저자를 인자로 받는 생성자를 정의하세요. (this() 사용)
  public Book(String title, String author) {
    this.title = title;
    this.author = author;
  }

  // TODO: 제목, 저자, 가격을 인자로 받는 생성자를 정의하세요. (this() 사용)
  public Book(String title, String author, int price) {
    this.title = title;
    this.author = author;
    this.price = price;
  }

  // TODO: 모든 필드를 인자로 받는 생성자를 정의하세요.
  public Book(String title, String author, int price, int year) {
    this.title = title;
    this.author = author;
    this.price = price;
    this.year = year;
  }

  // TODO: 책의 정보를 출력하는 메소드를 정의하세요.
  public void print() {
    System.out.println("Title: " + title + "\nAuthor: " + author + "\nPrice: " + price + "\nYear: " + year);
  }

  public void setTitle(String title) {
    this.title = title;
  }
}
