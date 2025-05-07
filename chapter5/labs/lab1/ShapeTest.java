package chapter5.labs.lab1;


import java.awt.*;
import java.util.LinkedList;
import java.util.List;

/**
 * Lab 1: 상속과 메소드 오버라이딩
 *
 * 여러 도형 객체를 생성하고, 각 도형의 면적을 계산하고 출력하는 테스트 클래스입니다.
 */
public class ShapeTest {
    public static void main(String[] args) {
        System.out.println("Lab 1: 상속과 메소드 오버라이딩 실습");

        // TODO: Rectangle 객체 생성
        Rectangle rectangle = new Rectangle(90, 100, "사각형", Color.BLUE);

        // TODO: Circle 객체 생성
        Circle circle = new Circle(100, "원", Color.RED);

        // TODO: 각 도형의 정보 출력 및 면적 계산
        rectangle.print();
        System.out.println("Area of Rectangle: " + rectangle.getArea());

        circle.print();
        System.out.println("Area of Circle: " + circle.getArea());

        // TODO: 배열을 사용하여 여러 Shape 객체 관리하기
        List<Circle> circles = new LinkedList<>();
        circles.add(circle);
        circles.add(new Circle(200, "circle", Color.RED));
        // TODO: 모든 도형의 면적 합계 계산하기
        double sum = 0;
        for (Circle c : circles) {
            sum += c.getArea();
        }
        System.out.println("Sum of Circles area: " + sum);
    }
}
