package coordinate.domain;

import java.util.ArrayList;
import java.util.List;

public class Axis {
    private List<Boolean> axis;

    private Axis(int size) {
        this.axis = new ArrayList<>();
        for (int positionNo = 0; positionNo < size; positionNo++) {
            axis.add(false);
        }
    }

    static Axis of(int size) {
        return new Axis(size);
    }

    void mark(int positionNo) {
        axis.set(positionNo, true);
    }

    public boolean isMarked(int positionNo) {
        return axis.get(positionNo);
    }
}
