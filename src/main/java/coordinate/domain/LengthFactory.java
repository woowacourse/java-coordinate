package coordinate.domain;

import java.util.ArrayList;
import java.util.List;

class LengthFactory {

    static List<Double> generateLengths(Points points) {
        List<Double> lengths = new ArrayList<>();
        for (int i = 0; i < points.getSize(); i++) {
            for (int j = i + 1; j < points.getSize(); j++) {
                lengths.add(points.getPoint(i).calculateLength(points.getPoint(j)));
            }
        }
        return lengths;
    }
}
