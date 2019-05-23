package coordinate.view;

import java.util.Scanner;

public class InputView {
    private static final Scanner input = new Scanner(System.in);

    public static String inputCoordinates() {
        System.out.println("좌표를 입력하세요");
        return input.nextLine();
    }
}
