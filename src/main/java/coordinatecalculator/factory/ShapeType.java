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

    private final int size;

    ShapeType(final int size) {
        this.size = size;
    }

    public Shape create(List<Coordinate> coordinates) {
        return null;
    }

    public static ShapeType valueOf(int size) {
        return Arrays.stream(values())
                .filter(shapeType -> shapeType.size == size)
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}
