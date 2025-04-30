package chapter3.labs.lab4;

import java.util.Scanner;

/**
 * Enum(열거형) 활용하기 실습
 */
public class EnumLab {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 1. 요일 Enum 활용하기
        System.out.println("===== 요일 Enum 활용하기 =====");
        System.out.println("요일을 입력하세요 (월, 화, 수, 목, 금, 토, 일): ");
        // TODO: 입력받은 요일에 해당하는 DayOfWeek Enum 상수를 찾아 switch 문에서 활용하세요.
        // 평일(월~금)인 경우 "평일입니다."를, 주말(토, 일)인 경우 "주말입니다."를 출력하세요.
        boolean b1 = true;
        while (b1) {
            String input = scanner.nextLine();

            DayOfWeek day = DayOfWeek.getDayOfWeek(input);

            if (day != null) {
                switch (day) {
                    case MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY:
                        System.out.println(day.getDesc());
                        b1 = false;
                        break;
                    default:
                        System.out.println("다시 입력해 주세요.");
                        break;
                }
            }
        }

        // 2. 계절 Enum 활용하기
        System.out.println("\n===== 계절 Enum 활용하기 =====");
        System.out.println("월을 입력하세요 (1-12): ");
        int month = scanner.nextInt();

        // TODO: 입력받은 월에 해당하는 Season Enum 상수를 찾아 해당 계절의 특징을 출력하세요.
        // Season Enum에 평균 기온과 특징을 필드로 추가하고, 이를 활용하세요.

        Season season = Season.getSeason(month);

        if (season != null) {
            switch (season) {
                case SPRING, AUTUMN, SUMMER, WINTER:
                    System.out.println("해당 달의 평군 기온은 " + season.getTemperature() + " 입니다.");
            }
        }

        // 3. 상태 전이 Enum 활용하기
        System.out.println("\n===== 상태 전이 Enum 활용하기 =====");

        // TODO: TaskStatus Enum을 구현하고, 상태 전이 로직을 활용하여 작업 상태를 변경하세요.
        // TaskStatus는 PENDING, IN_PROGRESS, COMPLETED, ARCHIVED 상태를 가지며,
        // nextStatus() 메소드를 통해 다음 상태로 전이할 수 있어야 합니다.
        // 사용자가 "next"를 입력할 때마다 상태를 다음 단계로 변경하고, 현재 상태를 출력하세요.
        // 사용자가 "exit"를 입력하면 종료합니다.

        boolean b2 = true;
        TaskStatus ts = TaskStatus.PENDING;
        while (b2) {
            System.out.printf("현재 상태는 %s 입니다.", ts.getStatus());
            System.out.println("다음 상태로 진입 하시겠습니까?");

            String input = scanner.nextLine();

            switch (input) {
                case "next" -> ts = ts.nextStatus();
                case "exit" -> b2 = false;
            }
        }

        // 4. 연산자 Enum 활용하기
        System.out.println("\n===== 연산자 Enum 활용하기 =====");
        scanner.nextLine(); // 버퍼 비우기

        // TODO: Operator Enum을 구현하고, 두 수에 대한 사칙연산을 수행하세요.
        // Operator는 ADD(+), SUBTRACT(-), MULTIPLY(*), DIVIDE(/) 연산을 가지며,
        // calculate() 메소드를 통해 두 수에 대한 연산을 수행할 수 있어야 합니다.
        // 사용자로부터 두 수와 연산자를 입력받아 계산 결과를 출력하세요.

        System.out.println("1번 숫자를 입력해 주세요:");
        int x = scanner.nextInt();
        System.out.println("2번 숫자를 입력해 주세요:");
        int y = scanner.nextInt();
        System.out.println("사용할 연산 방식을 입력해 주세요(+, -, *, /)");
        String input = scanner.nextLine();

        Operator operator;
        switch (input) {
            case "+" -> {
                operator = Operator.ADD;
                operator.calc(x, y);
            }
            case "-" -> {
                operator = Operator.SUBTRACT;
                operator.calc(x, y);
            }
            case "*" -> {
                operator = Operator.MULTIPLY;
                operator.calc(x, y);
            }
            case "/" -> {
                operator = Operator.DIVIDE;
                operator.calc(x, y);
            }
        }
        scanner.close();
    }
}

enum DayOfWeek {
    MONDAY("월", "평일입니다."),
    TUESDAY("화", "평일입니다."),
    WEDNESDAY("수", "평일입니다."),
    THURSDAY("목", "평일입니다."),
    FRIDAY("금", "평일입니다."),
    SATURDAY("토", "주말입니다."),
    SUNDAY("일", "주말입니다.");

    private final String kor;
    private String desc;

    DayOfWeek(String kor, String desc) {
        this.kor = kor;
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }

    public String getKor() {
        return kor;
    }

    public static DayOfWeek getDayOfWeek(String weekKor) {
        for (DayOfWeek day : DayOfWeek.values()) {
            if (day.getKor().equals(weekKor)) {
                return day;
            }
        }
        return null;
    }
}

enum Season {
    SPRING(new int[]{3, 4, 5}, "13.5℃"),
    SUMMER(new int[]{6, 7, 8}, "24.7℃"),
    AUTUMN(new int[]{9, 10, 11}, "15.1℃"),
    WINTER(new int[]{12, 1, 2}, "2.4℃"),
    ;

    private final int[] month;
    private final String temperature;

    Season(int[] month, String temperature) {
        this.month = month;
        this.temperature = temperature;
    }

    public String getTemperature() {
        return temperature;
    }

    public static Season getSeason(int month) {
        for (Season season : Season.values()) {
            for (int m : season.month) {
                if (m == month) {
                    return season;
                }
            }
        }
        return null;
    }
}

enum TaskStatus {
    PENDING("준비", "실행 상태로 진입합니다..") {
        @Override
        public TaskStatus nextStatus() {
            return IN_PROGRESS;
        }
    },
    IN_PROGRESS("실행중", "완료 상태로 진입합니다.") {
        @Override
        public TaskStatus nextStatus() {
            return COMPLETED;
        }
    },
    COMPLETED("완료", "보관 상태로 진입합니다.") {
        @Override
        public TaskStatus nextStatus() {
            return ARCHIVED;
        }
    },
    ARCHIVED("보관", "초기 상태로 돌아갑니다.") {
        @Override
        public TaskStatus nextStatus() {
            return PENDING;
        }
    };

    private final String status;
    private final String next;

    public String getStatus() {
        return status;
    }

    public String getNext() {
        return next;
    }

    TaskStatus(String status, String next) {
        this.status = status;
        this.next = next;
    }

    public abstract TaskStatus nextStatus();
}

enum Operator {
    ADD {
        @Override
        public int calc(int x, int y) {
            return x + y;
        }
    },
    SUBTRACT {
        @Override
        public int calc(int x, int y) {
            return x - y;
        }
    },
    MULTIPLY {
        @Override
        public int calc(int x, int y) {
            return x * y;
        }
    },
    DIVIDE {
        @Override
        public int calc(int x, int y) {
            return x / y;
        }
    };

    public abstract int calc(int x, int y);
}
