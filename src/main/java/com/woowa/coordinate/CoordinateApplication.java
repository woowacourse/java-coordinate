package com.woowa.coordinate;

import com.woowa.coordinate.domain.GenerateFigure;
import com.woowa.coordinate.domain.figure.Figure;
import com.woowa.coordinate.domain.Points;
import com.woowa.coordinate.view.InputView;
import com.woowa.coordinate.view.OutputView;

public class CoordinateApplication {
    public static void main(String[] args){
        Points points = InputView.getRequest();
        Figure figure = GenerateFigure.getFigure(points);
        OutputView.area(figure);
    }
}
