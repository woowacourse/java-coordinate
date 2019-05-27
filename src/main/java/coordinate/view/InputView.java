package coordinate.view;

import coordinate.domain.Points;
import coordinate.domain.PointsGenerator;

import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static Points inputPoints() {
        try {
            System.out.println("좌표를 입력하세요.");
            String input = scanner.nextLine();
            return PointsGenerator.of(input);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputPoints();
        }
    }
}
