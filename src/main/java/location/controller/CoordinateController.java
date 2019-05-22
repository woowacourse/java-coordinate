package location.controller;

import location.domain.Line;
import location.domain.Points;
import location.domain.Rectangle;
import location.view.InputView;

public class CoordinateController {

    public static void main(String[] args) {
        Points points = new Points(InputView.inputCoordinate());
        if(points.size() == 2) {
            Line line = new Line(points.get(0), points.get(1));
            System.out.println(line.calculateLine());
        }
        if(points.size() == 4){
            Rectangle rectangle = new Rectangle(points.get(0), points.get(1), points.get(2), points.get(3));
            System.out.println(rectangle.calculateArea());
        }
    }
}
