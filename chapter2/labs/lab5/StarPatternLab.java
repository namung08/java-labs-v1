package chapter2.labs.lab5;

import java.util.Scanner;

/**
 * 별표(*) 패턴 출력 실습
 */
public class StarPatternLab {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("패턴 출력을 위한 높이를 입력하세요: ");
//        int height = scanner.nextInt();

        int height = 5;
        // 1. 직각삼각형 패턴 (왼쪽 정렬)
        System.out.println("\n1. 직각삼각형 패턴 (왼쪽 정렬)");
        // 예시 (높이 5):
        // *
        // **
        // ***
        // ****
        // *****

        // TODO: 위와 같은 패턴을 출력하세요.

        triangle1(height);

        // 2. 직각삼각형 패턴 (오른쪽 정렬)
        System.out.println("\n2. 직각삼각형 패턴 (오른쪽 정렬)");
        // 예시 (높이 5):
        //     *
        //    **
        //   ***
        //  ****
        // *****

        // TODO: 위와 같은 패턴을 출력하세요.

        triangle2(height);

        // 3. 피라미드 패턴
        System.out.println("\n3. 피라미드 패턴");
        // 예시 (높이 5):
        //     *
        //    ***
        //   *****
        //  *******
        // *********

        // TODO: 위와 같은 패턴을 출력하세요.

        triangle3(height);


        // 4. 역삼각형 패턴
        System.out.println("\n4. 역삼각형 패턴");
        // 예시 (높이 5):
        // *********
        //  *******
        //   *****
        //    ***
        //     *

        // TODO: 위와 같은 패턴을 출력하세요.

        triangle4(height);


        // 5. 다이아몬드 패턴
        System.out.println("\n5. 다이아몬드 패턴");
        // 예시 (높이 5, 실제 높이는 9):
        //     *
        //    ***
        //   *****
        //  *******
        // *********
        //  *******
        //   *****
        //    ***
        //     *

        // TODO: 위와 같은 패턴을 출력하세요.

        triangle5(height);


        // 6. 모래시계 패턴
        System.out.println("\n6. 모래시계 패턴");
        // 예시 (높이 5, 실제 높이는 9):
        // *********
        //  *******
        //   *****
        //    ***
        //     *
        //    ***
        //   *****
        //  *******
        // *********

        // TODO: 위와 같은 패턴을 출력하세요.

        triangle6(height);


        // 7. 숫자 피라미드 패턴
        System.out.println("\n7. 숫자 피라미드 패턴");
        // 예시 (높이 5):
        //     1
        //    121
        //   12321
        //  1234321
        // 123454321

        // TODO: 위와 같은 패턴을 출력하세요.

        triangle7(height);

        scanner.close();
    }

    public static void triangle1(int height) {
        for (int i = 1; i <= height; i++) {
            for (int j = 1; j <= height; j++) {
                System.out.print("*");
                if (i == j) {
                    break;
                }
            }
            System.out.println();
        }
    }

    public static void triangle2(int height) {
        for (int i = 1; i <= height; i++) {
            for (int j = 1; j <= height; j++) {
                if (height - i >= j) {
                    System.out.print(" ");
                } else {
                    System.out.print("*");
                }
            }
            System.out.println();
        }
    }

    // 예시 (높이 5):
    //     *
    //    ***
    //   *****
    //  *******
    // *********

    // 예시 2
    //   *
    //  ***
    // *****
    public static void triangle3(int height) {
        for (int i = 1; i <= height; i++) {
            pyramid(height, i);
        }
    }

    public static void triangle4(int height) {
        for (int i = height; i >= 1; i--) {
            pyramid(height, i);
        }
    }

    public static void pyramid(int height, int i) {
        for (int j = 1; j <= height; j++) {
            if (height - i >= j) {
                System.out.print(" ");
            } else {
                System.out.print("*");
            }
        }
        for (int j = 1; j <= i - 1; j++) {
            System.out.print("*");
        }
        System.out.println();
    }

    public static void triangle5(int height) {
        triangle3(height);
        for (int i = height - 1; i >= 1; i--) {
            pyramid(height, i);
        }
    }

    public static void triangle6(int height) {
        triangle4(height);
        for (int i = 2; i <= height; i++) {
            pyramid(height, i);
        }
    }

    public static void triangle7(int height) {
        for (int i = 1; i <= height; i++) {
            int count = 1;
            for (int j = 1; j <= height; j++) {
                if (height - i >= j) {
                    System.out.print(" ");
                } else {
                    System.out.print(count);
                    count++;
                }
            }
            for (int j = 1; j <= i - 1; j++) {
                System.out.print(count - j - 1);
            }
            System.out.println();
        }
    }
}
