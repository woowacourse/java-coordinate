package coordinate.view;

import java.util.Scanner;

public class InputView {

    private static final Scanner SCANNER = new Scanner(System.in);

    public static String readPoints(String notifyingMessage) {
        System.out.println(notifyingMessage);
        System.out.println("좌표를 입력하세요.");

        try {
            return SCANNER.nextLine();
        } catch (IllegalArgumentException e) {
            return readPoints(e.getMessage());
        }
    }
}
