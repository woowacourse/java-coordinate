package com.woowa.coordinate;

import com.woowa.coordinate.domain.figure.Figure;
import com.woowa.coordinate.view.InputView;
import com.woowa.coordinate.view.OutputView;

public class CoordinateApplication {
    public static void main(String[] args) {
        Figure figure = InputView.getFigure();
        OutputView.area(figure);
    }
}
