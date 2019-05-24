package coordinatecalculator.factory;

import coordinatecalculator.domain.*;

import java.util.Arrays;
import java.util.List;

enum ShapeType {
    LINE(ShapeMaker.COORDINATES_FOR_LINE) {
        public Shape create(List<Coordinate> coordinates) {
            return new Line(coordinates);
        }
    },
    TRIANGLE(ShapeMaker.COORDINATES_FOR_TRIANGLE) {
        public Shape create(List<Coordinate> coordinates) {
            return new Triangle(coordinates);
        }
    },
    RECTANGLE(ShapeMaker.COORDINATES_FOR_RECTANGLE) {
        public Shape create(List<Coordinate> coordinates) {
            return new Rectangle(coordinates);
        }
    };

    private final int countOfCoordinate;

    ShapeType(final int countOfCoordinate) {
        this.countOfCoordinate = countOfCoordinate;
    }

    public Shape create(List<Coordinate> coordinates) {
        return null;
    }

    public static ShapeType valueOf(int countOfCoordinate) {
        return Arrays.stream(values())
                .filter(shapeType -> shapeType.countOfCoordinate == countOfCoordinate)
                .findFirst()
                .orElseThrow( () -> new IllegalArgumentException("해당 도형이 없어요") ) ;
    }
}
