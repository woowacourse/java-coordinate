package coordinatecalculator.view;

import coordinatecalculator.model.Coordinate;
import coordinatecalculator.model.FigureFactory;
import coordinatecalculator.model.PlaneFigure;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {
    private static final Scanner SCANNER = new Scanner(System.in);

    public static PlaneFigure createFigure(){
        try{
            return FigureFactory.createFigure(inputCoordinates());
        } catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            return createFigure();
        }
    }

    private static List<Coordinate> inputCoordinates() {
        System.out.println("좌표를 입력해주세요.");
        try {
            return Arrays.stream(SCANNER.nextLine().split("(?<=\\))(-)(?=\\()"))
                    .map(InputView::toCoordinate)
                    .collect(Collectors.toList());
        } catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            return inputCoordinates();
        }
    }

    private static Coordinate toCoordinate(String coordinate) {
        String[] splitted = coordinate.substring(1, coordinate.length() - 1).split(",");
        try {
            return new Coordinate(Integer.parseInt(splitted[0]), Integer.parseInt(splitted[1]));
        } catch (NumberFormatException e){
            throw new IllegalArgumentException("올바른 수를 입력해주세요.");
        }
    }
}
