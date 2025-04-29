package chapter2.labs.lab4;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import static chapter2.labs.lab3.ForLoopLab.multiplicationTable;

/**
 * while 반복문을 사용한 반복 실습
 */
public class WhileLoopLab {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 1. 사용자로부터 숫자를 입력받아 0이 입력될 때까지 합을 계산하여 출력하는 프로그램
        System.out.println("숫자를 입력하세요 (0을 입력하면 종료):");

        // TODO: 사용자로부터 숫자를 입력받고, 0이 입력될 때까지의 합계를 계산하여 출력하세요.
        // 1. 합계를 저장할 변수를 선언하세요.
        // 2. while 반복문을 사용하여 사용자로부터 숫자를 입력받으세요.
        // 3. 입력받은 숫자가 0이 아니면 합계에 더하고, 0이면 반복문을 종료하세요.
        // 4. 최종 합계를 출력하세요.

        System.out.println("총 합은: " + sumOfNonZeroNumbers(scanner) + "입니다.");

        // 2. 1부터 100까지의 짝수만 출력하는 프로그램
        System.out.println("\n1부터 100까지의 짝수 출력:");

        // TODO: while 반복문을 사용하여 1부터 100까지의 짝수만 출력하세요.
        // 1. 변수를 1로 초기화하세요.
        // 2. while 반복문을 사용하여 변수가 100 이하인 동안 반복하세요.
        // 3. 변수가 짝수인 경우에만 출력하세요.
        // 4. 변수를 1씩 증가시키세요.

        evenOutput();

        // 3. 구구단 출력 (do-while 사용)
        // TODO: do-while 반복문을 사용하여 사용자가 2-9 사이의 숫자를 입력할 때까지 반복하고,
        // 입력받은 단의 구구단을 출력하세요.

        multiplicationTable2(scanner);


        // 4. 숫자 맞추기 게임
        System.out.println("\n숫자 맞추기 게임:");

        // 컴퓨터가 1에서 100 사이의 임의의 숫자를 선택 (예시로 73 사용)
        Random random = new Random();
        int targetNumber = random.nextInt(100);

        // TODO: while 반복문을 사용하여 사용자가 숫자를 맞출 때까지 반복하세요.
        // 1. 사용자로부터 숫자를 입력받으세요.
        // 2. 시도 횟수를 증가시키세요.
        // 3. 입력받은 숫자가 목표 숫자보다 크면 "더 작은 숫자를 입력하세요."를 출력하세요.
        // 4. 입력받은 숫자가 목표 숫자보다 작으면 "더 큰 숫자를 입력하세요."를 출력하세요.
        // 5. 입력받은 숫자가 목표 숫자와 같으면 "정답입니다!"와 시도 횟수를 출력하고 반복문을 종료하세요.

        guessingTheNumber(scanner, targetNumber);


        // 5. 피보나치 수열 출력하기
        System.out.println("\n피보나치 수열 출력:");
        System.out.println("출력할 피보나치 수열의 개수를 입력하세요: ");
        int count;
        do {
            count = scanner.nextInt();
            if (count < 2) {
                System.out.println("2보다 큰 수를 입력해 주세요");
            } else {
                break;
            }
        } while (true);

        // TODO: while 반복문을 사용하여 입력받은 개수만큼 피보나치 수열을 출력하세요.
        // 피보나치 수열은 0, 1로 시작하며, 그 다음 숫자부터는 바로 앞의 두 숫자의 합입니다.
        // 예: 0, 1, 1, 2, 3, 5, 8, 13, 21, ...

        fibonacciSequence(count);


        scanner.close();
    }

    public static Integer sumOfNonZeroNumbers(Scanner scanner) {
        int sum = 0;
        int number;
        do {
            number = scanner.nextInt();
            sum += number;
        } while (number != 0);
        return sum;
    }

    public static void evenOutput() {
        int i = 1;
        while (i <= 100) {
            if (i % 2 == 0) {
                System.out.println(i);
            }
            i++;
        }
    }

    public static void multiplicationTable2(Scanner scanner) {
        int number;
        do {
            System.out.println("\n출력할 구구단의 단을 입력하세요 (2-9): ");
            number = scanner.nextInt();
            if (number >= 2 && number <= 9) {
                multiplicationTable(number);
            }
        } while (number >= 2 && number <= 9);
    }

    public static void guessingTheNumber(Scanner scanner, Integer correctNumber) {
        int number;
        int numberOfTime = 0;
        do {
            number = scanner.nextInt();
            if (number == correctNumber) {
                System.out.println("정답입니다!");
                System.out.println("총 시도 횟수는" + numberOfTime + "입니다.");
                break;
            }
            if (number > correctNumber) {
                System.out.println("더 작은 숫자를 입력하세요.");
                numberOfTime++;
            } else {
                System.out.println("더 큰 숫자를 입력하세요.");
                numberOfTime++;
            }
        }
        while (number != correctNumber);
    }

    public static void fibonacciSequence(int counter) {
        List<Integer> fibonacciSequence = new ArrayList<>();
        fibonacciSequence.add(0);
        fibonacciSequence.add(1);
        StringBuilder result = new StringBuilder(fibonacciSequence.get(0) + ", " + fibonacciSequence.get(1));
        int temp = 0;
        while (fibonacciSequence.size() < counter) {
            int sum = fibonacciSequence.get(temp) + fibonacciSequence.get(temp + 1);
            fibonacciSequence.add(temp + 2, sum);
            result.append(", ").append(fibonacciSequence.get(temp + 2));
            temp++;
        }
        System.out.println(result);
    }
}
