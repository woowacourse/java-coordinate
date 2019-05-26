package coordinatecalculator.view;

import java.util.Scanner;

public class InputView {
    public static String inputPoints() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("좌표를 입력하세요.");
        return scanner.nextLine();
    }
}
