package coordinate.domain;

import java.util.Objects;

public class Point {
    private double point;

    Point(String input) {
        point = checkPoint(input);
    }

    double sub_Point(Point point) {
        return (this.point - point.point);
    }

    protected double checkPoint(String input) {
        if (!isDouble(input)) {
            throw new IllegalArgumentException("숫자를 입력해 주세요.");
        }

        double point = Double.parseDouble(input);

        if (isNotAllowedNumber(point)) {
            throw new IllegalArgumentException("0 이상 24 이하의 수를 입력하세요.");
        }

        return point;
    }

    private boolean isNotAllowedNumber(double point_x) {

        return (point_x > 24 || point_x < 0);
    }

    private boolean isDouble(String input) {
        try {
<<<<<<< HEAD
            Integer.parseInt(point_x);
            Integer.parseInt(point_y);
        } catch (IllegalArgumentException e){
=======
            Double.parseDouble(input);
            return true;
        } catch (IllegalArgumentException e) {
>>>>>>> fair/imkimheejoo
            return false;
        }
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point1 = (Point) o;
        return Double.compare(point1.point, point) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(point);
    }
}
