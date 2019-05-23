package coordinatecalculator.model;

public class Rectangle {

    Points points;

    public Rectangle(Points points) {
        this.points = points;
    }

    public boolean isValid() {
        Points temp = Points.create();
        temp.addPoint(points.getPoint(0));
        for (int i = 1; i < points.getPoints().size(); i++) {
            checkRectangle(temp, i);
        }
        return temp.getPoints().size() == 2;
    }

    private void checkRectangle(Points temp, int i) {
        if(temp.getPoint(0).getyPoint().getValue() != points.getPoint(i).getyPoint().getValue()
            && temp.getPoint(0).getxPoint().getValue() != points.getPoint(i).getxPoint().getValue()){
            temp.addPoint(points.getPoint(i));
        }
    }


}
