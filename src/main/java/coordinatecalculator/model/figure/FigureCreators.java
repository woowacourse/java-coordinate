package coordinatecalculator.model.figure;

import coordinatecalculator.model.coordinate.Coordinate;
import coordinatecalculator.model.figure.impl.Line;
import coordinatecalculator.model.figure.impl.Rectangle;
import coordinatecalculator.model.figure.impl.Triangle;

import java.util.Arrays;
import java.util.List;

public enum FigureCreators {
    LINE_CREATOR(2) {
        @Override
        public Line create(List<Coordinate> coordinates) {
            return new Line(coordinates);
        }
    },
    TRIANGLE_CREATOR(3) {
        @Override
        public Triangle create(List<Coordinate> coordinates) {
            return new Triangle(coordinates);
        }
    },
    RECTANGLE_CREATOR(4) {
        @Override
        public Rectangle create(List<Coordinate> coordinates) {
            return new Rectangle(coordinates);
        }
    };

    public abstract PlaneFigure create(List<Coordinate> coordinates);

    private int countOfCoordinates;

    FigureCreators(int countOfCoordinates) {
        this.countOfCoordinates = countOfCoordinates;
    }

    private boolean matchCountOfCoordinates(int countOfCoordinates) {
        return this.countOfCoordinates == countOfCoordinates;
    }

    public static FigureCreators findFigureCreator(int countOfCoordinates) {
        return Arrays.stream(FigureCreators.values())
                .filter(figureCreator -> figureCreator.matchCountOfCoordinates(countOfCoordinates))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("잘못된 좌표값 개수입니다."));
    }
}
