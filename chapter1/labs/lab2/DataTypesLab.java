package chapter1.labs.lab2;

/**
 * Lab 2: 자바 데이터 타입 실습
 *
 * 이 실습은 자바의 기본 데이터 타입을 이해하고 사용하는 것을 목표로 합니다.
 */
public class DataTypesLab {
    public static void main(String[] args) {
        // TODO: 다음 기본 데이터 타입의 변수를 선언하고 값을 할당하세요.
        // 1. 정수형(byte, short, int, long) 변수 선언 및 할당
        byte byteValue = 127;
        short shortValue = 12127;
        int intValue = 1271231511;
        long longValue = 1271231415123124L;


        // TODO: 2. 실수형(float, double) 변수 선언 및 할당
        float floatValue = 3.14f;
        double doubleValue = 3.141592;

        // TODO: 3. 문자형(char) 변수 선언 및 할당
        char charValue = 'a';

        // TODO: 4. 논리형(boolean) 변수 선언 및 할당
        boolean booleanValue = true;

        // TODO: 5. 모든 변수 값을 출력하세요.
        System.out.println("byteValue = " + byteValue);
        System.out.println("shortValue = " + shortValue);
        System.out.println("intValue = " + intValue);
        System.out.println("longValue = " + longValue);
        System.out.println("floatValue = " + floatValue);
        System.out.println("doubleValue = " + doubleValue);
        System.out.println("charValue = " + charValue);
        System.out.println("booleanValue = " + booleanValue);

        // TODO: 6. 자신의 키(cm)와 몸무게(kg)를 저장하는 변수를 선언하고
        // BMI 지수를 계산하여 출력하세요. (BMI = 몸무게(kg) / (키(m) * 키(m)))
        float bodyWeight = 70.1f;
        float height = 170.4f;

        double bmiResult = bodyWeight / height * height;
        System.out.println("bmiResult = " + bmiResult);

    }
}
