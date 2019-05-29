package coordinate.view;

import coordinate.domain.*;

import java.util.List;
import java.util.Scanner;

public class InputView {

    private static final Scanner SCANNER = new Scanner(System.in);

//    public static Figure readFigure(PointFactory pointFactory) {
//        System.out.println("좌표를 입력하세요.");
//
//        try {
//            Points points = numbersToPoints(inputToCoordinateNumbers(SCANNER.nextLine()), pointFactory);
//            return FigureFactory.createFigure(points);
//        } catch (IllegalArgumentException e) {
//            System.err.println(e.getMessage());
//            return readFigure(pointFactory);
//        }
//    }

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
