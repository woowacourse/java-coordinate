package coordinatecalculator.factory;

import coordinatecalculator.domain.*;

import java.util.Arrays;
import java.util.List;

enum ShapeType {
    LINE(Line.VERTEX_OF_LINE) {
        public Shape create(List<Coordinate> coordinates) {
            return new Line(coordinates);
        }
    },
    TRIANGLE(Triangle.VERTEX_OF_TRIANGLE) {
        public Shape create(List<Coordinate> coordinates) {
            return new Triangle(coordinates);
        }
    },
    RECTANGLE(Rectangle.VERTEX_OF_RECTANGLE) {
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
