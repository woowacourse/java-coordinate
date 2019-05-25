package coordinatecalculator.view;

import java.util.Scanner;

public class InputView {
    private static Scanner reader = new Scanner(System.in);

    public static String askPoints() {
        System.out.println("좌표를 입력하세요!");
        return reader.nextLine();
    }
}
