package com.woowa.coordinate;

import com.woowa.coordinate.domain.Line;
import com.woowa.coordinate.domain.Point;
import com.woowa.coordinate.domain.Points;
import com.woowa.coordinate.view.InputView;
import com.woowa.coordinate.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class CoordinateApplication {
    public static void main(String[] args){
        List<Point> points = InputView.request();
        double distance = new Line(points).distance();
        OutputView.lineDistance(distance);
    }
}
