package coordinatecalculator.model;

public enum FigureMaker {
    Line_MAKER {
        Figure makeFigure(Points points) {return new Line(points);}
    },
    TRIANGLE_MAKER {
        Figure makeFigure(Points points) {return new Triangle(points);}
    },
    RECTANGLE_MAKER {
        Figure makeFigure(Points points) {return new Rectangle(points);}
    };

    abstract Figure makeFigure(Points points);
}
