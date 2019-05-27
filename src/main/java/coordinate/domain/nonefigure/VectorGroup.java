package coordinate.domain.nonefigure;

import coordinate.domain.figure.Line;

import java.util.ArrayList;
import java.util.List;

public class VectorGroup {
    private final List<Vector> vectors;

    private VectorGroup(List<Line> lines) {
        vectors = new ArrayList<>();
        lines.forEach(line -> vectors.add(line.toVector()));
    }

    public static VectorGroup create(List<Line> lines) {
        return new VectorGroup(lines);
    }

    public boolean checkDegreesAreAll90() {
        for (int i = 0; i < vectors.size(); i++) {
            int xProduct = vectors.get(i).getX() * vectors.get((i + 1) % vectors.size()).getX();
            int yProduct = vectors.get(i).getY() * vectors.get((i + 1) % vectors.size()).getY();
            int innerProduct = xProduct + yProduct;
            if (innerProduct != 0) {
                return false;
            }
        }
        return true;
    }
}
