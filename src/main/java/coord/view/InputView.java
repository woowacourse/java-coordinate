package coord.view;

import coord.model.Points;

import java.util.Scanner;

public class InputView {
    private static final Scanner input = new Scanner(System.in);

    public static Points inputCoordinates() {
        System.out.println("좌표를 입력하세요.");
        try {
            return Parser.parseCoordinates(input.nextLine());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputCoordinates();
        }
    }
}