package coordinate.view;

import java.util.Scanner;

public class InputView {
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final String GET_COORDINATE_MESSAGE = "좌표를 입력하세요.";

    public static String getPoints() {
        OutputView.printMessage(GET_COORDINATE_MESSAGE);
        return SCANNER.nextLine();
    }

}
