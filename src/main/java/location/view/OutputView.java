package location.view;

import location.domain.Points;

public class OutputView {
    int pointSize;
    Double value;

    public OutputView(int pointSize, Double value) {
        this.pointSize = pointSize;
        this.value = value;
    }

    public void printResultText() {
        System.out.println(ShapeMsgEnum.valueOf(pointSize) + value);
    }

    public void printResultMap(Points points) {
        new CoordinateDrawer(points);
    }
}
