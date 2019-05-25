package com.woowacourse.javacoordinate.domain.coordinate;

import com.woowacourse.javacoordinate.domain.point.Point;
import com.woowacourse.javacoordinate.domain.point.Points;

import java.util.ArrayList;
import java.util.List;

public class CoordinateSystem {
    private final List<CoordinateLine> coordinateLines;

    public CoordinateSystem(Points points) {
        coordinateLines = drawCoordinate(points);
    }

    private static List<CoordinateLine> drawCoordinate(Points points) {
        List<CoordinateLine> coordinateLines = new ArrayList<>();

        for (int yAxis = Point.MIN_BOUNDARY; yAxis <= Point.MAX_BOUNDARY; yAxis++) {
            coordinateLines.add(createLine(points, yAxis));
        }

        return coordinateLines;
    }

    private static CoordinateLine createLine(Points points, int yAxis) {
        List<Boolean> line = initLine();

        for (int i = 0; i < points.getSize(); i++) {
            Point point = points.getPoints().get(i);
            int x = point.getX();
            int y = point.getY();
            checkMark(yAxis, line, x, y);
        }

        return new CoordinateLine(line);
    }

    private static List<Boolean> initLine() {
        List<Boolean> line = new ArrayList<>();

        for (int i = 0; i <= Point.MAX_BOUNDARY; i++) {
            line.add(false);
        }
        return line;
    }

    private static void checkMark(int yAxis, List<Boolean> line, int x, int y) {
        if (yAxis == y) {
            line.set(x, true);
        }
    }

    public boolean isMarked(int x, int y) {
        if (coordinateLines.get(y) == null) {
            return false;
        }

        return coordinateLines.get(y).isMarked(x);
    }

    public List<CoordinateLine> getCoordinateLines() {
        return coordinateLines;
    }
}
