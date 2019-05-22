package coordinate;

import coordinate.domain.Points;

public class UI {
    private boolean[][] coordinates;

    public UI() {
        this.coordinates = new boolean[25][25];
    }

    public void drawPoints(Points points){
        for (int i = 0; i < points.size(); i++) {
            coordinates[points.get(i).getX()][points.get(i).getY()] = true;
        }
    }

    public boolean[][] getCoordinates() {
        return coordinates;
    }
}
