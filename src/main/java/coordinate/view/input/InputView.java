package coordinate.view.input;

import java.util.Scanner;

public class InputView {
    private static Scanner scanner = new Scanner(System.in);

    public static String inputPoints() {
        System.out.println("좌표를 입력하세요.");
        return scanner.nextLine();
    }
}
