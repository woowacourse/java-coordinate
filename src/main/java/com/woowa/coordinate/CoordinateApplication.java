package com.woowa.coordinate;

import com.woowa.coordinate.domain.Line;
import com.woowa.coordinate.domain.Points;
import com.woowa.coordinate.domain.Rectangle;
import com.woowa.coordinate.domain.Triangle;
import com.woowa.coordinate.view.InputView;
import com.woowa.coordinate.view.OutputView;

public class CoordinateApplication {
    public static void main(String[] args){
        Points points = InputView.getRequest();
        if (points.size() == 2) {
            double area = new Line(points).area();
            OutputView.lineDistance(area);
        }
        if (points.size() == 3) {
            double area = new Triangle(points).area();
            OutputView.triangleArea(area);
        }
        if (points.size() == 4) {
            double area = new Rectangle(points).area();
            OutputView.squareArea(area);
        }
    }
}
