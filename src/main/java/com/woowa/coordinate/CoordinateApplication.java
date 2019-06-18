package com.woowa.coordinate;

import com.woowa.coordinate.domain.Line;
import com.woowa.coordinate.domain.Point;
import com.woowa.coordinate.domain.Points;
import com.woowa.coordinate.domain.Rectangle;
import com.woowa.coordinate.utils.InputParser;
import com.woowa.coordinate.view.InputView;
import com.woowa.coordinate.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class CoordinateApplication {
    public static void main(String[] args){
        List<Point> points = InputView.getRequest();
        if (points.size() == 2) {
            double distance = new Line(points).distance();
            OutputView.lineDistance(distance);
        }
        if (points.size() == 4) {
            double area = new Rectangle(InputParser.parsePoint(points)).area();
            OutputView.squareArea(area);
        }
    }
}
