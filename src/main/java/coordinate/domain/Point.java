package coordinate.domain;

public class Point {
    private double point_x;
    private double point_y;

    Point(String input_x, String input_y) {

        if (!isInteger(input_x, input_y) || isContains(input_x, input_y)) {
            throw new IllegalArgumentException("공백없는 숫자를 입력해 주세요");
        }

        double point_x = Double.parseDouble(input_x);
        double point_y = Double.parseDouble(input_y);

        if (isAllowedNumber(point_x, point_y)) {
            throw new IllegalArgumentException("24이하의 수를 입력해 주세요.");
        }

        this.point_x = point_x;
        this.point_y = point_y;
    }

    private boolean isAllowedNumber(double point_x, double point_y) {
        return (point_x > 24 || point_y < 0) && (point_x > 24 || point_y < 0);
    }

    private boolean isContains(String input_x, String input_y) {
        return input_x.contains(" ") || input_y.contains(" ");
    }

    private boolean isInteger(String point_x, String point_y) {
        try {
            Double.parseDouble(point_x);
            Double.parseDouble(point_y);
        } catch (IllegalArgumentException e) {
            return false;
        }
        return true;
    }

    double sub_x(Point point) {
        return (this.point_x - point.point_x);
    }

    double sub_y(Point point) {
        return (this.point_y - point.point_y);
    }
}
