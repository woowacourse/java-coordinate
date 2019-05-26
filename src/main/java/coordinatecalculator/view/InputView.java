package coordinatecalculator.view;

import java.util.Scanner;

public class InputView {
    private static final String INPUT_MESSAGE = "좌표를 입력하세요.";

    public static String inputPoints() {
        Scanner scanner = new Scanner(System.in);
        System.out.println(INPUT_MESSAGE);
        return scanner.nextLine();
    }
}
