package coordinate.view.input;

import java.util.Scanner;
import java.util.regex.Matcher;

public class InputView {
    private static Scanner scanner = new Scanner(System.in);

    public static Matcher inputPoints() {
        System.out.println("좌표를 입력하세요.");
        return InputCheck.matchPoint(scanner.nextLine());
    }
}
