package chapter4.labs.lab1;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Lab 1: 클래스와 객체 만들기
 *
 * Person 클래스 정의하기
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Person {
    // TODO: 이름, 나이, 성별을 저장할 수 있는 필드를 정의하세요.
    private String name;
    private int age;
    private String gender;


    // TODO: 객체 정보를 출력하는 메소드를 작성하세요.
    public void print() {
        System.out.println(this.name + " " + this.age + " " + this.gender);
    }


    // TODO: 생일이 지났을 때 나이를 한 살 증가시키는 메소드를 작성하세요.
    public void yearOlder() {
        this.age++;
    }
}
