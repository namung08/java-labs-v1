package chapter7.labs.lab2;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 텍스트 파일을 생성하고 처리하는 실습
 *
 * 이 실습에서는 Java의 파일 입출력 기능을 활용하여
 * 텍스트 파일을 생성, 읽기, 검색, 수정하는 다양한 작업을 수행합니다.
 */
public class TextFileIOLab {
    // 파일 경로 상수
    private static final String FILE_PATH = "chapter7/labs/lab2/sample.txt";

    public static void main(String[] args) {
        // TODO: 사용자 입력을 받기 위한 Scanner 객체를 생성하세요.
        Scanner scanner = new Scanner(System.in);
        // TODO: 프로그램 메인 루프를 구현하세요.
        // 1. showMenu() 메소드를 호출하여 메뉴 표시
        // 2. getIntInput() 메소드를 호출하여 사용자 선택 받기 (1~7 사이의 값)
        // 3. switch 문을 사용하여 사용자 선택에 따른 메소드 호출
        //    - 1: createTextFile()
        //    - 2: readTextFile()
        //    - 3: searchTextInFile()
        //    - 4: replaceTextInFile()
        //    - 5: countFileStats()
        //    - 6: appendToFile()
        //    - 7: 프로그램 종료
        // 4. 계속하려면 Enter 키를 누르도록 안내 메시지 출력
        boolean running = true;
        do {
            showMenu();
            int input = getIntInput(scanner, 1, 7);
            switch (input) {
                case 1:
                    createTextFile(scanner);
                    buffer(scanner);
                    break;
                case 2:
                    readTextFile();
                    buffer(scanner);
                    break;
                case 3:
                    searchTextInFile(scanner);
                    buffer(scanner);
                    break;
                case 4:
                    replaceTextInFile(scanner);
                    buffer(scanner);
                    break;
                case 5:
                    countFileStats();
                    buffer(scanner);
                    break;
                case 6:
                    appendToFile(scanner);
                    buffer(scanner);
                    break;
                case 7:
                    running = false;
                    System.out.println("Thanks for using this program");
                    break;
                default:
                    System.out.println("Invalid input");
                    break;
            }
        } while (running);
        scanner.close();
    }

    private static void buffer(Scanner scanner) {
        System.out.println("The task is complete. Press Enter to continue...");
        scanner.nextLine();
    }

    /**
     * 메뉴 출력
     */
    private static void showMenu() {
        // TODO: 텍스트 파일 처리 프로그램의 메뉴를 출력하세요.
        // 1. 텍스트 파일 생성하기
        // 2. 텍스트 파일 읽기
        // 3. 텍스트 파일에서 검색하기
        // 4. 텍스트 파일에서 문자열 치환하기
        // 5. 파일 통계 계산하기 (라인 수, 단어 수, 문자 수)
        // 6. 파일에 내용 추가하기
        // 7. 종료
        System.out.println("Welcome to TextFileIOLab");
        System.out.println("1. Create a text file");
        System.out.println("2. Read text file");
        System.out.println("3. To search from a text file");
        System.out.println("4. Replace string in text file");
        System.out.println("5. Calculating file statistics (number of lines, words, characters)");
        System.out.println("6. To add content to a file");
        System.out.println("7. Exit");
        System.out.print("Enter your choice: ");
    }

    /**
     * 사용자로부터 정수 입력 받기
     */
    private static int getIntInput(Scanner scanner, int min, int max) {
        // TODO: 사용자로부터 min과 max 사이의 정수를 입력받아 반환하세요.
        // 1. 사용자 입력을 정수로 변환 시도
        // 2. 입력값이 min과 max 사이의 값인지 확인
        // 3. 잘못된 입력이 들어온 경우 적절한 메시지 출력 후 다시 입력 요청
        // 4. 유효한 입력을 받을 때까지 반복
        int input = 0;
        while (true) {
            try {
                input = Integer.parseInt(scanner.nextLine());
                if (input < min || input > max) {
                    System.out.println("Please enter a number between " + min + " and " + max + "\n Please input it again: ");
                } else {
                    // min 보다 크거나 같고 max 보다 작거나 같을 경우 반복 종료
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println("ERROR: Please enter a number");
            } catch (Exception e) {
                System.out.println("ERROR: An unknown error has occurred.");
            }
        }

        return input;
    }

    /**
     * 텍스트 파일 생성
     */
    private static void createTextFile(Scanner scanner) {
        // TODO: "텍스트 파일 생성하기" 타이틀을 출력하세요.
        System.out.println("------ 1. Create a text file ------");
        // TODO: 파일이 이미 존재하는지 확인하세요.
        // 1. File 객체를 생성하고 exists() 메소드를 사용하여 확인
        // 2. 파일이 이미 존재하면 덮어쓸지 사용자에게 물어보기
        // 3. 사용자가 'n'을 입력하면 메소드 종료

        // 파일 생성
        File file = new File(FILE_PATH);
        // 파일의 유무 확인 존재 -> true / 없음 -> false
        if (file.exists()) {
            System.out.println("File already exists");
            // 덮어쓰기에 대한 사용자의 요청
            String overwirte = getWord(scanner, "Do you want to overwrite it? (y/n)").toLowerCase();
            // 사용자가 "n" 또는 "no" 를 입력 시 메서드 종료
            if (overwirte.equals("n") || overwirte.equals("no")) {
                return;
            }
        }

        // TODO: 사용자로부터 파일에 저장할 내용을 입력받으세요.
        // 1. 빈 줄이 입력될 때까지 사용자 입력을 받기
        // 2. 입력된 각 줄에 줄 번호 표시하기
        // 3. 입력받은 내용을 List<String>에 저장

        // 입력을 계속 받을지에 대한 여부
        // 입력받은 내용을 담을 List
        List<String> writeStrings = inputText(scanner);

        // TODO: BufferedWriter를 사용하여 입력받은 내용을 파일에 쓰세요.
        // 1. try-with-resources 구문 사용
        // 2. FileWriter와 BufferedWriter 생성
        // 3. 리스트의 각 줄을 파일에 쓰기 (newLine() 메소드 활용)
        // 4. 예외 처리 및 성공 메시지 출력

        // file의 주소를 통해 해당 파일을 조회하고 파일에 쓰는 작업에 대한 try-with-resources 를 선으로 불러 자동으로 닫히게 함
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            // List 인 writeStrings 를 처음부터 한 줄씩 읽음
            for (String writeString : writeStrings) {
                // file에 writeString 을 입력
                writer.write(writeString);
                // 줄 바꿈을 위한 명령
                writer.newLine();
            }
            System.out.println("File has been created");
        } catch (IOException e) {
            System.out.println("ERROR: An unknown error has occurred.");
        }
    }

    /**
     * 테스트용 텍스트 파일 생성 (사용자 입력 없이 더미 데이터로 10줄 작성)
     */
    private static void createTextFileForTest() {
        System.out.println("------ 1. Create a text file (Test Mode) ------");

        File file = new File(FILE_PATH);

        // 파일이 이미 존재하면 삭제 후 생성 (테스트 목적)
        if (file.exists()) {
            System.out.println("기존 파일이 존재합니다. 테스트를 위해 파일을 덮어씁니다.");
            file.delete();  // 기존 파일 삭제
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            for (int i = 1; i <= 10; i++) {
                writer.write("이것은 더미 데이터의 " + i + "번째 줄입니다.");
                writer.newLine();  // 줄바꿈
            }
            System.out.println("더미 데이터를 포함한 파일이 성공적으로 생성되었습니다.");
        } catch (IOException e) {
            System.err.println("파일 생성 중 오류가 발생했습니다: " + e.getMessage());
        }
    }

    /**
     * 텍스트 파일 읽기
     */
    private static void readTextFile() {
        // TODO: "텍스트 파일 읽기" 타이틀을 출력하세요.
        System.out.println("------ 2. Read text file ------");
        // TODO: 파일이 존재하는지 확인하세요.
        // 파일이 존재하지 않으면 에러 메시지 출력 후 리턴
        // 파일을 읽음
        File file = new File(FILE_PATH);
        if (!file.exists()) {
            System.out.println("File does not exist");
            return;
        }
        // TODO: BufferedReader를 사용하여 파일 내용을 읽고 출력하세요.
        // 1. try-with-resources 구문 사용
        // 2. FileReader와 BufferedReader 생성
        // 3. readLine() 메소드를 사용하여 한 줄씩 읽기
        // 4. 각 줄 앞에 줄 번호 붙여서 출력
        // 5. 예외 처리 및 완료 메시지 출력
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String text = null;
            int line = 0;
            while ((text = reader.readLine()) != null) {
                line++;
                System.out.println("Line " + line + ": " + text);
            }

            System.out.println("File has been read");
        } catch (FileNotFoundException e) {
            System.out.println("File does not exist");
        } catch (IOException e) {
            System.out.println("Error reading file");
        }
    }

    /**
     * 텍스트 파일에서 문자열 검색
     */
    private static void searchTextInFile(Scanner scanner) {
        // TODO: "텍스트 파일에서 검색하기" 타이틀을 출력하세요.
        System.out.println("------ 3. Search text in file ------");
        // TODO: 파일이 존재하는지 확인하세요.
        // 파일이 존재하지 않으면 에러 메시지 출력 후 리턴
        File file = new File(FILE_PATH);
        if (!file.exists()) {
            System.out.println("File does not exist");
            return;
        }
        // TODO: 사용자로부터 검색할 텍스트와 대소문자 구분 여부를 입력받으세요.
        String searchText = getWord(scanner, "Enter text to search: ");
        System.out.println("");
        String answer = getWord(scanner, "Are you sure you want to distinguish between uppercase and lowercase letters? (y/n)").toLowerCase();
        boolean distinguish = answer.equals("y") || answer.equals("yes");

        // 대소문자 구분 여부
        // distinguish == true -> 구분을 함
        // distinguish == false -> 구분을 하지 않음
        // 정규식 생성을 메서드에서 담당
        Pattern pattern = getCaseSensitiveRegex(searchText, distinguish);
        // TODO: BufferedReader를 사용하여 파일을 읽으면서 검색어 찾기
        // 1. try-with-resources 구문 사용
        // 2. 대소문자 구분 여부에 따라 검색 전략 결정
        // 3. 일치하는 부분 찾으면 해당 줄 출력 (검색어 하이라이트)
        // 4. Pattern, Matcher 클래스를 활용하여 검색어 하이라이트
        // 5. 검색 결과 통계 출력 (몇 개의 일치 항목을 찾았는지)
        // 6. 예외 처리
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            // 파일의 문자를 담기위한 리스트
            List<String> strings = new LinkedList<>(reader.lines().toList());

            // 일치한 문자가 있을 경우 해당 문자열을 저장하기 위한 list
            List<String> words = new LinkedList<>();
            for (String string : strings) {
                // 문자열에서 위에서 생성한 정규식과 완벽히 일치하는지 확인하는 메서드
                Matcher matcher = pattern.matcher(string);
                // 만약 잋치하는 문자열을 찾을 경우 해당 문자열을 words List 에 저장
                if (matcher.find()) {
                    words.add(string);
                }
            }
            // 찾은 문자열의 크기를 출력
            System.out.println("Found " + words.size() + " words");

            // 찾은 문자열을 출력을 한건데 출력을 우선 하고 사용자가 y를 입력할 때 마다 다음 문자열 출력
            // 또한 일치하는 문자열을 하이라이트 처리
            int index = 0;
            do {
                // 하이 라이트를 주기 위해 문자열을 " " 를 기준으로 분할
                List<String> word = List.of(words.get(index).split(" "));
                // 완성된 리스트를 문자열로 변환해 저장하기 위한 코드
                StringBuilder builder = new StringBuilder();
                for (String w : word) {
                    Matcher matcher = pattern.matcher(w);
                    if (matcher.find()) {
                        highlight(builder, w);
                    } else {
                        builder.append(w);
                    }
                    builder.append(" ");
                }
                // 찾은 문자열 출력
                System.out.println("Searching for: " + builder);

                if (words.size() < 2) {
                    System.out.println("Terminates output.");
                    break;
                }
                // 사용자가 다음 줄을 볼지 안볼지를 받기 위한 scanner
                answer = getWord(scanner, "Would you like to output the following search results?? (y/n)").toLowerCase();
                if (answer.equals("y") || answer.equals("yes")) {
                    index++;
                } else if (answer.equals("n") || answer.equals("no")) {
                    System.out.println("Terminates output.");
                    break;
                }
            } while (true);

        } catch (FileNotFoundException e) {
            System.out.println("File does not exist");
        } catch (IOException e) {
            System.out.println("Error reading file");
        }
    }

    /**
     * 텍스트 파일에서 문자열 치환
     */
    private static void replaceTextInFile(Scanner scanner) {
        // TODO: "텍스트 파일에서 문자열 치환하기" 타이틀을 출력하세요.
        System.out.println("------ 4. Replace text in file ------");
        // TODO: 파일이 존재하는지 확인하세요.
        // 파일이 존재하지 않으면 에러 메시지 출력 후 리턴
        File file = new File(FILE_PATH);
        if (!file.exists()) {
            System.out.println("File does not exist");
            return;
        }

        // TODO: 사용자로부터 다음 정보를 입력받으세요:
        // 1. 찾을 텍스트
        String findText = getWord(scanner, "Enter text to find: ");
        // 2. 변경할 텍스트
        String replaceText = getWord(scanner, "Enter text to replace: ");
        // 3. 대소문자 구분 여부 (y/n)
        String answer;
        do {
            answer = getWord(scanner, "Are you sure you want to distinguish between uppercase and lowercase letters? (y/n)").toLowerCase();
            // 원하는 답이 나왔을 경우 반복 종료
        } while (!answer.equals("y") && !answer.equals("yes") && !answer.equals("n") && !answer.equals("no"));

        boolean distinguish = answer.equals("y") || answer.equals("yes");
        // 4. 모든 일치 항목 변경 또는 첫 일치 항목만 변경 여부 (y/n)
        String change;
        do {
            change = getWord(scanner, "Do you want to change all matches? (y/n)").toLowerCase();
        } while (!change.equals("y") && !change.equals("yes") && !change.equals("n") && !change.equals("no"));
        boolean allChanges = change.equals("y") || change.equals("yes");

        // TODO: 파일 내용을 List<String>으로 읽어오세요.
        // 1. try-with-resources 구문 사용
        List<String> strings = new LinkedList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            // 2. BufferedReader를 사용하여 모든 줄을 리스트에 저장
            strings = reader.lines().toList();
        } catch (FileNotFoundException e) {
            System.out.println("File does not exist");
        } catch (IOException e) {
            System.out.println("Error reading file");
        }

        // TODO: 각 줄에서 검색어를 찾아 치환하세요.
        // 1. 대소문자 구분 여부와 모든/첫 일치 항목 변경 여부에 따라 적절한 메소드 사용
        //    - String.replace() 또는 String.replaceAll()
        //    - 정규식 패턴 사용 시 Pattern.CASE_INSENSITIVE 플래그 활용
        Pattern pattern = getCaseSensitiveRegex(findText, distinguish);
        // 2. 몇 개의 라인이 변경되었는지 카운트
        int count = 0;
        // strings 가 불변객체여서 가변 객체로 만들기 위한 작업
        List<String> mutableStrings = new ArrayList<>(strings);

        for (int index = 0; index < mutableStrings.size(); index++) {
            Matcher matcher = pattern.matcher(mutableStrings.get(index));
            if (matcher.find()) {
                count++;
                mutableStrings.set(index, matcher.replaceAll(replaceText));
                if (!allChanges) {
                    break;
                }
            }
        }


        // TODO: 변경된 내용을 파일에 다시 쓰세요.
        // 1. try-with-resources 구문 사용
        // 2. BufferedWriter를 사용하여 수정된 내용 쓰기
        // 3. 변경된 라인 수 출력
        // 4. 예외 처리
        // append 모드가 아닌 처음부터 새로 쓰기위한 FileWriter 의 2번째 매게변수를 false 로 설정
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            for (String string : mutableStrings) {
                writer.write(string);
                writer.newLine();
            }
            System.out.println("Replaced Completed");
            System.out.println("Replaced " + count + " words");
        } catch (IOException e) {
            System.out.println("ERROR: An unknown error has occurred.");
        }
    }

    /**
     * 파일 통계 계산 (라인 수, 단어 수, 문자 수)
     */
    private static void countFileStats() {
        // TODO: "파일 통계 계산하기" 타이틀을 출력하세요.
        System.out.println("------ 5. Count file stats ------");
        // TODO: 파일이 존재하는지 확인하세요.
        // 파일이 존재하지 않으면 에러 메시지 출력 후 리턴
        File file = new File(FILE_PATH);
        if (!file.exists()) {
            System.out.println("File does not exist");
            return;
        }

        // TODO: 파일 통계를 계산하세요.
        // 1. try-with-resources 구문 사용
        // 2. BufferedReader를 사용하여 파일 읽기
        // 3. 라인 수 계산 (반복문에서 라인 카운트 증가)
        // 4. 단어 수 계산 (각 라인을 공백으로 분할하여 단어 카운트)
        // 5. 문자 수 계산 (각 라인의 길이 합산)

        // 줄 수
        int lineNum = 0;
        // 단어 수
        int stringNum = 0;
        // 문자 수
        int charNum = 0;
        List<String> strings = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            // 매 라인을 읽고 해당 라인의 내용이 null 이 아닐 경우 무한 반복
            String line = null;
            while ((line = reader.readLine()) != null) {
                // 해당 라인을 읽음
                strings.addAll(List.of(line.split(" ")));
                lineNum++;
                stringNum = strings.size();
            }
            for (String string : strings) {
                charNum += string.length();
            }
        } catch (FileNotFoundException e) {
            System.out.println("File does not exist");
        } catch (IOException e) {
            System.out.println("Error reading file");
        } finally {
            // TODO: 계산된 통계 정보를 출력하세요.
            // 1. 라인 수
            // 2. 단어 수
            // 3. 문자 수
            // 4. 예외 처리
            System.out.println("lineNum: " + lineNum);
            System.out.println("stringNum: " + stringNum);
            System.out.println("charNum: " + charNum);
        }
    }

    /**
     * 파일에 내용 추가
     */
    private static void appendToFile(Scanner scanner) {
        // TODO: "파일에 내용 추가하기" 타이틀을 출력하세요.
        System.out.println("------ 6. Append to file ------");
        // TODO: 파일이 존재하는지 확인하세요.
        // 파일이 존재하지 않으면 에러 메시지 출력 후 리턴
        File file = new File(FILE_PATH);
        if (!file.exists()) {
            System.out.println("File does not exist");
            return;
        }
        // TODO: 사용자로부터 추가할 내용을 입력받으세요.
        // 1. 빈 줄이 입력될 때까지 사용자 입력을 받기
        // 2. 입력된 각 줄에 줄 번호 표시하기
        // 3. 입력받은 내용을 List<String>에 저장
        List<String> writeStrings = inputText(scanner);

        // TODO: BufferedWriter를 사용하여 입력받은 내용을 파일에 추가하세요.
        // 1. try-with-resources 구문 사용
        // 2. FileWriter(파일경로, true)를 사용하여 append 모드로 열기
        // 3. 구분선("--- 추가된 내용 ---") 추가
        // 4. 리스트의 각 줄을 파일에 추가
        // 5. 예외 처리 및 성공 메시지 출력
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file, true))) {
            writer.newLine();
            writer.write("--- append into ---");
            for (String writeString : writeStrings) {
                writer.write(writeString);
                writer.newLine();
            }

            System.out.println("Appended Completed");
        } catch (IOException e) {
            System.out.println("ERROR: An unknown error has occurred.");
        }
    }

    private static List<String> inputText(Scanner scanner) {
        List<String> writeStrings = new LinkedList<>();
        // 처음부터 입력받을 내용에 대한 초기화 라인
        int line = 0;
        while (true) {
            // 입력을 받기 시작전 사용자가 입력할 라인에 대해서 알려주기 위해 line++ 을 함
            line++;
            String writeString = getWord(scanner, "Line " + line + ": ");
            // 사용자가 입력한 내용이 null 또는 "" 일 경우 반복을 종료함
            if (writeString == null || writeString.isEmpty()) {
                break;
            }
            // 위 if 문에 걸리지 않을 경우 내용을 추가
            writeStrings.add(writeString);
        }
        return writeStrings;
    }

    /**
     * 정규식 반환
     *
     * @param text        정규식으로 만들 문자열
     * @param distinguish 대소문자 구분 여부
     */
    private static Pattern getCaseSensitiveRegex(String text, boolean distinguish) {
        if (distinguish) {
            return Pattern.compile(text);
        } else {
            return Pattern.compile(text, Pattern.CASE_INSENSITIVE);
        }
    }

    private static void highlight(StringBuilder builder, String word) {
        builder.append("'").append(word).append("'");
    }

    private static String getWord(Scanner scanner, String message) {
        System.out.println(message);
        return scanner.nextLine();
    }
}
