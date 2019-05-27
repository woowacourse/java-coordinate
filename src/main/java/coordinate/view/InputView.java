package coordinate.view;

import coordinate.domain.PointFactory;
import coordinate.domain.Points;
import coordinate.domain.PointsFactory;

import java.util.List;
import java.util.Scanner;

public class InputView {

    private static final Scanner SCANNER = new Scanner(System.in);

    public static void readFigure(PointFactory pointFactory) {
        System.out.println("좌표를 입력하세요.");

        try {
            Points points = numbersToPoints(inputToCoordinateNumbers(SCANNER.nextLine()), pointFactory);
       //   return FigureFactory.createFigure(points);
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
            readFigure(pointFactory);
        }
    }


    private static List<Integer> inputToCoordinateNumbers(String input) {
        return CoordinateNumberSplitter.split(input);
    }

    private static Points numbersToPoints(List<Integer> numbers, PointFactory pointFactory) {
        return PointsFactory.of(pointFactory, numbers);
    }
}
