package coordinate.view;

import java.util.Scanner;

public class InputView {
    private static final Scanner SCAN = new Scanner(System.in);

    public String inputCoordinates() {
        System.out.println("좌표를 입력하세요.");
        return SCAN.nextLine();
    }
}
