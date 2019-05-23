package coordinatecalculator.model;

public class Rectangle {

    private Points diagonalPoint;

    public Rectangle(Points points) {
        this.diagonalPoint = generateDiagonalPoint(points);
        if(diagonalPoint.getPoints().size() != 2){
            throw new IllegalArgumentException("잘못된 직사각형 형식 입니다.");
        }
    }

    public Points generateDiagonalPoint(Points points) {
        diagonalPoint = Points.create();
        diagonalPoint.addPoint(points.getPoint(0));
        for (int i = 1; i < points.getPoints().size(); i++) {
            checkRectangle(points, i);
        }

        return diagonalPoint;
    }

    private void checkRectangle(Points points, int index) {
        if(diagonalPoint.getPoint(0).getyPoint().getValue() != points.getPoint(index).getyPoint().getValue()
            && diagonalPoint.getPoint(0).getxPoint().getValue() != points.getPoint(index).getxPoint().getValue()){
            diagonalPoint.addPoint(points.getPoint(index));
        }
    }

    public double calculateRectangleArea(){
        return (double) Math.abs((diagonalPoint.getPoint(0).getyPoint().getValue() - diagonalPoint.getPoint(1).getyPoint().getValue())
                * (diagonalPoint.getPoint(0).getxPoint().getValue() - diagonalPoint.getPoint(1).getxPoint().getValue()));
    }
}
