package coordinatecalculator.factory;

import coordinatecalculator.domain.*;

import java.util.Arrays;
import java.util.List;

enum ShapeType {
    LINE(ShapeMaker.COORDINATES_FOR_LINE) {
        @Override
        public Shape create(List<Coordinate> coordinates) {
            return new Line(coordinates);
        }
    },
    TRIANGLE(ShapeMaker.COORDINATES_FOR_TRIANGLE) {
        @Override
        public Shape create(List<Coordinate> coordinates) {
            return new Triangle(coordinates);
        }
    },
    RECTANGLE(ShapeMaker.COORDINATES_FOR_RECTANGLE) {
        @Override
        public Shape create(List<Coordinate> coordinates) {
            return new Rectangle(coordinates);
        }
    };

    private final int countOfCoordinate;

    ShapeType(final int countOfCoordinate) {
        this.countOfCoordinate = countOfCoordinate;
    }

    public abstract Shape create(final List<Coordinate> coordinates);

    public static ShapeType valueOf(final int countOfCoordinate) {
        return Arrays.stream(values())
                .filter(shapeType -> shapeType.countOfCoordinate == countOfCoordinate)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("해당하는 도형이 없습니다!"));
    }

}
