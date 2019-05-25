package coordinatecalculator.factory;

import coordinatecalculator.domain.*;

import java.util.Arrays;

enum ShapeType {
    LINE(Line.VERTEX_OF_LINE) {
        @Override
        public Shape create(Coordinates coordinates) {
            return new Line(coordinates);
        }
    },
    TRIANGLE(Triangle.VERTEX_OF_TRIANGLE) {
        @Override
        public Shape create(Coordinates coordinates) {
            return new Triangle(coordinates);
        }
    },
    RECTANGLE(Rectangle.VERTEX_OF_RECTANGLE) {
        @Override
        public Shape create(Coordinates coordinates) {
            return new Rectangle(coordinates);
        }
    };

    private final int countOfCoordinate;

    ShapeType(final int countOfCoordinate) {
        this.countOfCoordinate = countOfCoordinate;
    }

    public abstract Shape create(final Coordinates coordinates);

    public static ShapeType valueOf(final int countOfCoordinate) {
        return Arrays.stream(values())
                .filter(shapeType -> shapeType.countOfCoordinate == countOfCoordinate)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("해당하는 도형이 없습니다!"));
    }

}
