package coordinate.domain;

public abstract class Figure implements Shape {
    Points points;
    String name;
    String operationName;

    Figure(Points points, String name, String operationName) {
        this.points = points;
        this.name = name;
        this.operationName = operationName;
    }

    public abstract double calculateFigure();

    public String getName() {
        return name;
    }

    public String getOperationName() {
        return operationName;
    }
}
