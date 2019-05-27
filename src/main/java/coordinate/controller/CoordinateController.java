package coordinate.controller;

import coordinate.CoordinateApplication;
import coordinate.domain.Board;
import coordinate.domain.Points;
import coordinate.domain.Shape;
import coordinate.domain.ShapeFactory;
import coordinate.dto.CoordinateDto;

public class CoordinateController {
    public static CoordinateDto request(Points points) {
        Shape shape = ShapeFactory.create(points);
        Board board =  new Board(points);

        return new CoordinateDto(board, shape);
    }
}
