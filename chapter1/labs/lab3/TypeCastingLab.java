package chapter1.labs.lab3;

/**
 * Lab 3: 자바 타입 변환(Type Casting) 실습
 *
 * 이 실습은 자바의 타입 변환에 대해 이해하고 실습하는 것을 목표로 합니다.
 */
public class TypeCastingLab {
    public static void main(String[] args) {
        // TODO: 1. 자동 형변환(Implicit Casting) 예제
        // byte -> int, int -> long, long -> float, float -> double 순으로
        // 변수를 선언하고 자동 형변환을 수행한 뒤 결과 출력하기
        byte byteValue = 127;
        int intValue = byteValue;
        long longValue = intValue;
        float floatValue = longValue;
        double doubleValue = floatValue;

        System.out.println("------ 1. 자동 형변환 ------");
        System.out.println("byteValue = " + byteValue);
        System.out.println("intValue = " + intValue);
        System.out.println("longValue = " + longValue);
        System.out.println("floatValue = " + floatValue);
        System.out.println("doubleValue = " + doubleValue);


        // TODO: 2. 명시적 형변환(Explicit Casting) 예제
        // double -> float -> long -> int -> char -> short -> byte 순으로
        // 변수를 선언하고 명시적 형변환을 수행한 뒤 결과 출력하기
        double doubleValue2 = 3.141592;
        float floatValue2 = (float) doubleValue2;
        long longValue2 = (long) floatValue2;
        int intValue2 = (int) longValue2;
        char charValue2 = (char) intValue2;
        short shortValue2 = (short) charValue2;
        byte byteValue2 = (byte) shortValue2;

        System.out.println("------ 2. 명시적 형변환 ------");
        System.out.println("doubleValue = " + doubleValue2);
        System.out.println("floatValue = " + floatValue2);
        System.out.println("longValue = " + longValue2);
        System.out.println("intValue2 = " + intValue2);
        System.out.println("charValue2 = " + charValue2);
        System.out.println("shortValue2 = " + shortValue2);
        System.out.println("byteValue2 = " + byteValue2);

        // TODO: 3. 데이터 손실 확인하기
        // int 값을 byte로 변환하여 데이터 손실이 발생하는 예제 작성하기
        int intValue3 = 5555;
        byte byteValue3 = (byte) intValue3;

        System.out.println("------ 3. 데이터 손실 확인 ------");
        System.out.println("intValue3 = " + intValue3);
        System.out.println("byteValue3 = " + byteValue3);


        // TODO: 4. 문자열과 숫자 간 변환하기
        // 문자열 "123"을 정수로, "3.14"를 실수로 변환하기
        String stringValue = "123";
        int intValue4 = Integer.parseInt(stringValue);

        String stringValue2 = "3.14";
        float floatValue4 = Float.parseFloat(stringValue2);

        System.out.println("------ 4. 문자열과 숫자 간 변환하기 ------");
        System.out.println("stringValue = " + stringValue);
        System.out.println("intValue4 = " + intValue4);
        System.out.println("stringValue2 = " + stringValue2);
        System.out.println("floatValue4 = " + floatValue4);



        // TODO: 5. 숫자를 문자열로 변환하기
        // 정수 456과 실수 7.89를 문자열로 변환하기
        int intValue5 = 456;
        float floatValue5 = 7.89f;

        String stringValue3 = String.valueOf(intValue5);
        String stringValue4 = String.valueOf(floatValue5);

        System.out.println("------ 5. 숫자를 문자열로 변환 ------");
        System.out.println("intValue5 = " + intValue5);
        System.out.println("floatValue5 = " + floatValue5);
        System.out.println("stringValue3 = " + stringValue3 + ", stringValue3 class = " + stringValue3.getClass());
        System.out.println("stringValue4 = " + stringValue4 + ", stringValue4 class = " + stringValue4.getClass());
    }
}
