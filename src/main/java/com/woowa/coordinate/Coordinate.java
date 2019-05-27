package com.woowa.coordinate;

import com.woowa.coordinate.domain.Line;
import com.woowa.coordinate.domain.Point;
import com.woowa.coordinate.view.InputView;
import com.woowa.coordinate.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class Coordinate {
    public static void main(String[] args){
        String input = InputView.request();
        double distance = new Line(pointsGenerator(hypenProcessor(input))).distance();
        OutputView.lineDistance(distance);
    }

    public static String[] hypenProcessor(String input) {
        return input.replace("(", "").replace(")", "").split("-");
    }

    public static List<Point> pointsGenerator(String[] input) {
        ArrayList<Point> result = new ArrayList<>();
        for (String elements : input) {
            String[] point = elements.split(",");
            result.add(new Point(Integer.parseInt(point[0]), Integer.parseInt(point[1])));
        }
        return result;
    }
}
