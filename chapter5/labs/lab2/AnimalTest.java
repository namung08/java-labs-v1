package chapter5.labs.lab2;

import java.util.ArrayList;
import java.util.List;

/**
 * Lab 2: 추상 클래스 활용하기
 *
 * 여러 동물 객체를 생성하고, 각 동물의 정보와 소리를 출력하는 테스트 클래스입니다.
 */
public class AnimalTest {
    public static void main(String[] args) {
        System.out.println("Lab 2: 추상 클래스 활용하기 실습");

        // TODO: Dog 객체 생성
        Animal dog = new Dog("corgi", true, "gogi", 1);

        // TODO: Cat 객체 생성
        Animal cat = new Cat("korean short hair", "pig", 2);

        // TODO: Bird 객체 생성
        Animal bird = new Bird(10, "parrot", "cherry", 3);

        // TODO: 각 동물의 정보와 소리 출력
        dog.print();
        dog.sound();

        cat.print();
        cat.sound();

        bird.print();
        bird.sound();

        // TODO: 배열을 사용하여 여러 Animal 객체 관리하기
        List<Animal> animals = new ArrayList<>();
        animals.add(cat);
        animals.add(bird);
        animals.add(dog);

        // TODO: 모든 동물에 대해 반복하여 정보와 소리 출력하기
        for (Animal animal : animals) {
            animal.print();
            animal.sound();
        }
    }
}
