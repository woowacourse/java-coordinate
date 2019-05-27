package coordinatecalculator.view;

import coordinatecalculator.model.coordinate.Coordinate;
import coordinatecalculator.model.figure.PlaneFigure;
import coordinatecalculator.model.figure.FigureCreators;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final String COORDINATES_SPLIT_REGEX = "(?<=\\))(-)(?=\\()";
    private static final String VALUE_SPLIT_REGEX = ",";
    private static final int FIRST_INDEX = 1;
    private static final int LAST_INDEX = -1;
    private static final int X_VALUE_INDEX = 0;
    private static final int Y_VALUE_INDEX = 1;

    public static PlaneFigure createFigure() {
        try {
            List<Coordinate> coordinates = inputCoordinates();
            return FigureCreators.findFigureCreator(coordinates.size()).create(coordinates);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return createFigure();
        }
    }

    private static List<Coordinate> inputCoordinates() {
        System.out.println("좌표를 입력해주세요.");
        try {
            return Arrays.stream(SCANNER.nextLine().split(COORDINATES_SPLIT_REGEX))
                    .map(InputView::toCoordinate)
                    .collect(Collectors.toList());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputCoordinates();
        }
    }

    private static Coordinate toCoordinate(String coordinate) {
        String[] splittedCoordinates = coordinate.substring(FIRST_INDEX, coordinate.length() + LAST_INDEX).split(VALUE_SPLIT_REGEX);
        try {
            return new Coordinate(Integer.parseInt(splittedCoordinates[X_VALUE_INDEX]), Integer.parseInt(splittedCoordinates[Y_VALUE_INDEX]));
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("올바른 수를 입력해주세요.");
        }
    }
}
