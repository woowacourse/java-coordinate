package coordinatecalculator.domain;

import coordinatecalculator.domain.parent.Figure;

public enum FigureType {
    LINE("LINE") {
        @Override
        public Figure getFigure(Points points) {
            return Line.newInstance(points);
        }
    },
    TRIANGLE("TRIANGLE") {
        @Override
        public Figure getFigure(Points points) {
            return Triangle.newInstance(points);
        }
    },
    RECTANGLE("RECTANGLE") {
        @Override
        public Figure getFigure(Points points) {
            return Rectangle.newInstance(points);
        }
    };

    FigureType(String countOfPoints) {
    }

    public abstract Figure getFigure(Points points);
}
