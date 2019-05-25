package coordinatecalculator;

import coordinatecalculator.model.Figure;
import coordinatecalculator.model.FigureFactory;
import coordinatecalculator.view.InputView;

public class CoordinateLauncher {
    public static void main(String[] args) {
        Figure figure = generateFigure();


    }

    private static Figure generateFigure() {
        try {
            String points = InputView.askPoints();
            return FigureFactory.generateFigure(points);
        } catch (Exception e) {
            System.out.println("잘못된 입력입니다");
            return generateFigure();
        }
    }
}
