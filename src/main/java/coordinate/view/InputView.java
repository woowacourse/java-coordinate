package coordinate.view;

import java.util.Scanner;

public class InputView {
    private static final String ASK_COORDINATE = "좌표를 입력하세요.";

    private static final Scanner scanner = new Scanner(System.in);

    public static String askCoordinate(){
        System.out.println(ASK_COORDINATE);
        return scanner.nextLine();
    }
}
