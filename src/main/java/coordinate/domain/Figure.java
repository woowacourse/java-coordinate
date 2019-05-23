package coordinate.domain;

import java.util.Collections;
import java.util.List;

public abstract class Figure {
    private String resultMessage;
    protected Points points;

    public Figure(String resultMessage, Points points) {
        this.resultMessage = resultMessage;
        this.points = points;
    }

    public abstract double calculateResult();

    public String getResultMessage() {
        return resultMessage;
    }

    public List<Point> getPoints() {
        return Collections.unmodifiableList(points.getPoints());
    }
}
