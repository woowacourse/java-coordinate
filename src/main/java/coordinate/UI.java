package coordinate;

import coordinate.domain.Coordinate;
import coordinate.domain.Points;

public class UI {
    private boolean[][] coordinates;

    public UI(Points points) {
        this.coordinates = new boolean[Coordinate.MAX_BOUND][Coordinate.MAX_BOUND];
        drawPoints(points);
    }

    private void drawPoints(Points points) {
        for (int i = 0; i < points.size(); i++) {
            coordinates[points.get(i).getX()][points.get(i).getY()] = true;
        }
    }

    public boolean[][] getCoordinates() {
        return coordinates.clone();
    }
}
