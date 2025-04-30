package chapter3.labs.lab5;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 학생 성적 관리 프로그램 (종합 프로젝트)
 */
public class StudentManagementSystem {
    // TODO: 학생 성적 등급을 나타내는 Grade Enum을 정의하세요.
    // A(90-100), B(80-89), C(70-79), D(60-69), F(0-59) 등급이 있어야 합니다.

    // 최대 학생 수
    private static final int MAX_STUDENTS = 100;

    // 학생 정보 배열
    private static String[] names = new String[MAX_STUDENTS]; // 이름 배열
    private static int[] scores = new int[MAX_STUDENTS]; // 성적 배열
    private static int studentCount = 0; // 현재 저장된 학생 수

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        System.out.println("===== 학생 성적 관리 프로그램 =====");

        while (running) {
            printMenu();
            int choice = getMenuChoice(scanner);

            switch (choice) {
                case 1:
                    // TODO: 성적 입력 기능을 구현하세요.
                    // 학생 이름과 성적을 입력받아 배열에 저장합니다.
                    System.out.println("성적을 입력할 학생의 이름을 입력하세요:");
                    String name = scanner.nextLine();
                    System.out.println("성적을 입력해 주세요:");
                    int score = scanner.nextInt();
                    names[studentCount] = name;
                    scores[studentCount] = score;
                    studentCount++;
                    scanner.reset();
                    break;
                case 2:
                    // TODO: 성적 수정 기능을 구현하세요.
                    // 학생 이름을 입력받아 해당 학생의 성적을 수정합니다.
                    if (studentCount == 0) {
                        System.out.println("등록된 학생이 없습니다.");
                        break;
                    }
                    System.out.println("수정할 학생의 이름을 입력해 주세요:");
                    String changeName = scanner.nextLine();
                    int count = getCountForName(changeName);
                    System.out.println("성적을 입력해 주세요:");
                    int changeScore = scanner.nextInt();

                    scores[count] = changeScore;

                    break;
                case 3:
                    // TODO: 성적 조회 기능을 구현하세요.
                    // 모든 학생의 이름, 성적, 등급을 출력합니다.
                    // 전체 성적의 합계, 평균, 최고 성적, 최저 성적도 출력합니다.
                    if (studentCount == 0) {
                        System.out.println("등록된 학생이 없습니다.");
                        break;
                    }
                    for (int i = 0; i <= studentCount - 1; i++) {
                        System.out.printf("%s 의 성적은 %d 이며, 등급은 %s 입니다.", names[i], scores[i], Grade.getGrade(scores[i]));
                        System.out.println();
                    }
                    System.out.printf("합계: %d, 평균: %f, 최고 성적: %d, 최저 성적: %d", sumScore(scores), avgScore(sumScore(scores), studentCount), findMaxScore(scores), findMinScore(scores));
                    System.out.println();

                    break;
                case 4:
                    // TODO: 검색 기능을 구현하세요.
                    // 학생 이름을 입력받아 해당 학생의 성적과 등급을 조회합니다.
                    if (studentCount == 0) {
                        System.out.println("등록된 학생이 없습니다.");
                        break;
                    }
                    System.out.println("검색할 학생의 이름을 입력해 주세요:");
                    String searchName = scanner.nextLine();
                    int searchCount = getCountForName(searchName);
                    System.out.printf("%s의 성적: %d, 등급: %s", names[searchCount], scores[searchCount], Grade.getGrade(scores[searchCount]));
                    System.out.println();
                    break;
                case 5:
                    // TODO: 통계 기능을 구현하세요.
                    // 등급별 학생 수와 비율을 출력합니다.
                    if (studentCount == 0) {
                        System.out.println("등록된 학생이 없습니다.");
                        break;
                    }
                    for (Grade grade : Grade.values()) {
                        numberAndRatioByGrade(grade);
                        System.out.println();
                    }
                    break;
                case 6:
                    System.out.println("프로그램을 종료합니다.");
                    running = false;
                    break;
                default:
                    System.out.println("잘못된 메뉴 선택입니다. 다시 선택해주세요.");
                    break;
            }
        }

        scanner.close();
    }

    // 메뉴 출력 메소드
    private static void printMenu() {
        System.out.println("\n===== 메뉴 =====");
        System.out.println("1. 성적 입력");
        System.out.println("2. 성적 수정");
        System.out.println("3. 성적 조회");
        System.out.println("4. 학생 검색");
        System.out.println("5. 통계 보기");
        System.out.println("6. 종료");
        System.out.print("메뉴를 선택하세요: ");
    }

    // 메뉴 선택 입력 메소드
    private static int getMenuChoice(Scanner scanner) {
        try {
            return scanner.nextInt();
        } catch (Exception e) {
            scanner.nextLine(); // 버퍼 비우기
            return -1; // 잘못된 입력
        } finally {
            scanner.nextLine(); // 버퍼 비우기
        }
    }

    // TODO: 성적으로부터 등급을 계산하는 메소드를 구현하세요.
    // 입력받은 성적에 따라 Grade Enum 상수를 반환합니다.
    enum Grade {
        A, B, C, D, F;

        public static Grade getGrade(int score) {
            if (score >= 90) {
                return Grade.A;
            } else if (score >= 80) {
                return Grade.B;
            } else if (score >= 70) {
                return Grade.C;
            } else if (score >= 60) {
                return Grade.D;
            } else {
                return Grade.F;
            }
        }
    }


    // TODO: 전체 성적의 합계를 계산하는 메소드를 구현하세요.
    private static int sumScore(int[] scores) {
        int sum = 0;
        for (int score : scores) {
            sum += score;
        }
        return sum;
    }

    // TODO: 전체 성적의 평균을 계산하는 메소드를 구현하세요.
    private static Float avgScore(int sum, int count) {
        return (float) (sum / count);
    }


    // TODO: 최고 성적을 찾는 메소드를 구현하세요.
    private static int findMaxScore(int[] scores) {
        int[] scoresCopy = scores.clone();
        Arrays.sort(scoresCopy);
        return scoresCopy[MAX_STUDENTS - 1];
    }


    // TODO: 최저 성적을 찾는 메소드를 구현하세요.
    private static int findMinScore(int[] scores) {
        int[] scoresCopy = scores.clone();
        Arrays.sort(scoresCopy);
        return scoresCopy[MAX_STUDENTS - studentCount];
    }

    // TODO: 학생 이름으로 배열에서 위치(인덱스)를 찾는 메소드를 구현하세요.
    private static int getCountForName(String name) {
        int count = 0;
        for (String s : names) {
            if (s.equals(name)) {
                break;
            }
            count++;
        }
        return count;
    }


    private static void numberAndRatioByGrade(Grade grade) {
        int count = 0;
        float percentage = 0f;
        for (int score : scores) {
            if (grade == Grade.getGrade(score)) {
                count++;
            }
        }
        percentage = (float) count / (float) studentCount;

        System.out.printf("%s 등급의 학생은 총 %d 명 있으며 비율은 %f 입니다.", grade.name(), count, percentage);
    }
}
