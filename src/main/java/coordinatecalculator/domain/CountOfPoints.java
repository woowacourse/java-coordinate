package coordinatecalculator.domain;

import coordinatecalculator.domain.parent.Figure;

public enum CountOfPoints {
    _2("LINE") {
        @Override
        public Figure getFigure(Points points) {
            return Line.newInstance(points);
        }
    },
    _3("TRIANGLE") {
        @Override
        public Figure getFigure(Points points) {
            return Triangle.newInstance(points);
        }
    },
    _4("RECTANGLE") {
        @Override
        public Figure getFigure(Points points) {
            return Rectangle.newInstance(points);
        }
    };

    CountOfPoints(String countOfPoints) {
    }

    public abstract Figure getFigure(Points points);
}
