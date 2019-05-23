package coordinate;

import coordinate.domain.Figure;
import coordinate.domain.FigureFactory;
import coordinate.domain.Points;
import coordinate.view.InputView;
import coordinate.view.OutputView;

public class CoordinateApp {
    public static void main(String[] args) {
        Points points = new Points(InputView.intputCoordinate());
        FigureFactory figureFactory= new FigureFactory();
        Figure figure = figureFactory.create(points);
        OutputView.printCoordinate(points);
        OutputView.printArea(figure);
    }
}
