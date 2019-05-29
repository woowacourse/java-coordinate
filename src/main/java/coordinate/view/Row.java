package coordinate.view;

import java.util.ArrayList;
import java.util.List;

import static coordinate.view.UserInterface.MAX_INDEX;
import static coordinate.view.UserInterface.MIN_INDEX;

public class Row {
    private final List<Boolean> coordinate;

    Row() {
        List<Boolean> coordinate = new ArrayList<>();
        for (int i = MIN_INDEX; i < MAX_INDEX; i++) {
            coordinate.add(false);
        }
        this.coordinate = coordinate;
    }

    void placePoint(int index) {
        coordinate.set(index, true);
    }

    public boolean getCoordinate(int x) {
        return coordinate.get(x);
    }
}
