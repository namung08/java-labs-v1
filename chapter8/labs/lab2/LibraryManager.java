package chapter8.labs.lab2;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Lab 2: 컬렉션 프레임워크 활용하기
 *
 * 도서 관리 시스템의 주요 기능을 구현한 클래스입니다.
 */
public class LibraryManager {
    // 도서 목록 (ArrayList 활용)
    private List<Book> books;

    // 사용자별 대여 현황 (HashMap 활용)
    private Map<String, List<Book>> userBorrowMap;

    // 도서 카테고리 (HashSet 활용)
    private Set<String> categories;

    /**
     * 생성자
     */
    public LibraryManager() {
        // TODO: 필드를 초기화하세요.
        this.books = new LinkedList<>();
        this.userBorrowMap = new LinkedHashMap<>();
        this.categories = new LinkedHashSet<>();
    }

    /**
     * 도서 추가 메소드
     */
    public void addBook(Book book) {
        // TODO: 도서를 추가하고, 카테고리도 Set에 추가하세요.
        this.books.add(book);
        this.categories.add(book.getCategory());
        System.out.println("added book: " + book);
    }

    /**
     * 도서 검색 메소드 (제목으로 검색)
     */
    public List<Book> searchBooksByTitle(String title) {
        // TODO: 제목에 검색어가 포함된 도서를 검색하세요.
        List<Book> filteredBooks = new LinkedList<>();
        for (Book book : this.books) {
            if (book.getTitle().toLowerCase().contains(title.toLowerCase())) {
                filteredBooks.add(book);
            }
        }
        return filteredBooks;
    }

    /**
     * 도서 검색 메소드 (저자로 검색)
     */
    public List<Book> searchBooksByAuthor(String author) {
        // TODO: 저자명으로 도서를 검색하세요.
        List<Book> filteredBooks = new LinkedList<>();
        for (Book book : this.books) {
            if (book.getAuthor().toLowerCase().contains(author.toLowerCase())) {
                filteredBooks.add(book);
            }
        }
        return filteredBooks;
    }

    /**
     * 도서 대여 메소드
     */
    public boolean borrowBook(String userId, String isbn) {
        // TODO: 도서를 대여하고, 사용자별 대여 현황을 업데이트하세요.
        // 사용자가 대여 현황에 등록이 되어 있는지 확인
        // 없을 경우 빈 대여 목록을 등록
        if (!this.userBorrowMap.containsKey(userId)) {
            this.userBorrowMap.put(userId, new LinkedList<>());
        }
        List<Book> borrowedBooks = this.userBorrowMap.get(userId);
        // 책의 정보를 조회
        for (Book book : this.books) {
            // 대소문자 구분없이 찾기
            if (book.getIsbn().equalsIgnoreCase(isbn)) {
                // 이미 대여한 책들 중 찾은 책이 없을 경우
                if (!borrowedBooks.contains(book)) {
                    borrowedBooks.add(book);
                    return true;
                } else {
                    System.out.println("Book already borrowed: " + book);
                    return false;
                }
            }
        }

        // 도서를 찾기 못한경우
        System.out.println("Not found book list");
        return false;
    }

    /**
     * 도서 반납 메소드
     */
    public boolean returnBook(String userId, String isbn) {
        // TODO: 도서를 반납하고, 사용자별 대여 현황을 업데이트하세요.
        if (this.userBorrowMap.containsKey(userId)) {
            // 해당 사용자의 대여 리스트를 가지고옴
            List<Book> borrowedBooks = this.userBorrowMap.get(userId);
            for (Book book : borrowedBooks) {
                // 대여 목록 중 isbn 이 포한된 경우
                if (book.getIsbn().equalsIgnoreCase(isbn)) {
                    // 대여 목록에서 해당 책 객체를 제거
                    borrowedBooks.remove(book);
                    return true;
                }
            }
        }
        // 도서 대여 현황에 사용자가 없는 경우
        return false;
    }

    /**
     * 사용자의 대여 도서 목록 조회 메소드
     */
    public List<Book> getBorrowedBooks(String userId) {
        // TODO: 사용자가 대여한 도서 목록을 반환하세요.
        return this.userBorrowMap.get(userId);
    }

    /**
     * 도서 정렬 메소드 (제목 기준)
     */
    public List<Book> getSortedBooksByTitle() {
        // TODO: 제목 기준으로 정렬된 도서 목록을 반환하세요.
        return this.books.stream().sorted(Comparator.comparing(Book::getTitle)).collect(Collectors.toList());
    }

    /**
     * 도서 정렬 메소드 (출판년도 기준)
     */
    public List<Book> getSortedBooksByYear() {
        // TODO: 출판년도 기준으로 정렬된 도서 목록을 반환하세요.
        return this.books.stream().sorted(Comparator.comparing(Book::getPublicationYear)).collect(Collectors.toList());
    }

    /**
     * 도서 정렬 메소드 (가격 기준)
     */
    public List<Book> getSortedBooksByPrice() {
        // TODO: 가격 기준으로 정렬된 도서 목록을 반환하세요.
        return this.books.stream().sorted(Comparator.comparing(Book::getPrice)).collect(Collectors.toList());
    }

    /**
     * 카테고리 목록 조회 메소드
     */
    public Set<String> getCategories() {
        // TODO: 모든 카테고리를 반환하세요.
        return this.categories;
    }

    /**
     * 카테고리별 도서 목록 조회 메소드
     */
    public List<Book> getBooksByCategory(String category) {
        // TODO: 특정 카테고리에 속한 도서 목록을 반환하세요.
        return this.books.stream().filter(book -> book.getCategory().equalsIgnoreCase(category)).collect(Collectors.toList());
    }

    /**
     * 전체 도서 목록 조회 메소드
     */
    public List<Book> getAllBooks() {
        // TODO: 전체 도서 목록을 반환하세요.
        return this.books;
    }
}
