package coordinate.view;

import coordinate.domain.Points;

import java.util.Scanner;

public class InputView {
    public static final Scanner scanner = new Scanner(System.in);

    public static Points inputPoints() {
        System.out.println("좌표를 입력하세요.");
        scanner.nextLine();
        return null;
    }
}
