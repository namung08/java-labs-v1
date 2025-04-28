package chapter1.labs.lab4;

/**
 * Lab 4: 자바 연산자 실습
 *
 * 이 실습은 자바의 다양한 연산자를 이해하고 활용하는 것을 목표로 합니다.
 */
public class OperatorsLab {
    public static void main(String[] args) {
        // TODO: 1. 산술 연산자 사용하기
        // 두 개의 정수형 변수를 선언하고 덧셈, 뺄셈, 곱셈, 나눗셈, 나머지 연산을 수행하세요.
        int a = 10;
        int b = 20;
        int c = a + b;
        int d = a - b;
        int e = a * b;
        int f = a / b;
        int g = a % b;

        System.out.println("------ 1. 산술 연산자 사용 ------");
        System.out.println(a + "+" + b + "=" + c);
        System.out.println(a + "-" + b + "=" + d);
        System.out.println(a + "*" + b + "=" + e);
        System.out.println(a + "/" + b + "=" + f);
        System.out.println(a + "%" + b + "=" + g);

        // TODO: 2. 증감 연산자 사용하기
        // 변수를 선언하고 전위 증가, 후위 증가, 전위 감소, 후위 감소 연산을 수행하세요.
        // 각 단계별로 변수의 값을 출력하여 변화를 확인하세요.
        System.out.println("------ 2. 증감 연산자 사용------");
        System.out.println("++a: " + ++a);
        System.out.println("a++: " + a++);
        System.out.println("--a: " + --a);
        System.out.println("a--: " + a--);

        // TODO: 3. 비교 연산자 사용하기
        // 두 변수를 비교하여 결과를 출력하세요 (==, !=, >, <, >=, <=).
        System.out.println("------ 3. 비교 연산자 사용하기------");
        System.out.println("a==b: " + (a==b));
        System.out.println("a!=b: " + (a!=b));
        System.out.println("a<b: " + (a<b));
        System.out.println("a<=b: " + (a<=b));
        System.out.println("a>b: " + (a>b));
        System.out.println("a<=b: " + (a<=b));


        // TODO: 4. 논리 연산자 사용하기
        // boolean 변수를 사용하여 AND(&&), OR(||), NOT(!) 연산을 수행하세요.
        boolean x = true;
        boolean y = false;
        System.out.println("------ 4. 논리 연산자 사용하기 ------");
        System.out.println("x && y: " + (x && y));
        System.out.println("x || y: " + (x || y));
        System.out.println("!x: " + (!x));

        // TODO: 5. 대입 연산자 사용하기
        // 변수를 선언하고 복합 대입 연산자(+=, -=, *=, /=, %=)를 사용하여 값을 변경하세요.
        System.out.println("------ 5. 대입 연산자 사용 ------");
        System.out.println("a += 5: " + (a += 5));
        System.out.println("a -= 5: " + (a -= 5));
        System.out.println("a *= 5: " + (a *= 5));
        System.out.println("a /= 5: " + (a /= 5));
        System.out.println("a %= 5: " + (a %= 5));


        // TODO: 6. 삼항 연산자 사용하기
        // 조건에 따라 다른 값을 할당하는 예제를 작성하세요.
        int result = a > b ? a : b;
    }
}
