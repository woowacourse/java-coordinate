package coordinatecalculator.model.coordinate;

import java.util.ArrayList;
import java.util.List;

public class CoordinatePlane {
    private static final int WIDTH = 24;
    private static final int HEIGHT = 24;

    private String plane;

    public CoordinatePlane(Coordinates coordinates) {
        this.plane = drawPoints(coordinates);
    }

    private String drawPoints(Coordinates coordinates) {
        List<StringBuilder> plane = drawDefaultPlane();

        for(int i=0, len = coordinates.size(); i<len;i++){
            int y = Math.abs(24 - coordinates.get(i).getY());
            plane.get(y).setCharAt(coordinates.get(i).getX() * 2, '●');
        }

        return drawNumbers(plane).stream()
                .reduce(new StringBuilder(), (a, b) -> a.append(b + "\n"))
                .toString();
    }

    private List<StringBuilder> drawDefaultPlane() {
        List<StringBuilder> rows = new ArrayList<>();
        for (int i = 0; i < HEIGHT; i++) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("| ");
            for (int j = 0; j < WIDTH; j++) {
                stringBuilder.append("  ");
            }
            rows.add(stringBuilder);
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("+-");
        for (int j = 0; j < WIDTH; j++) {
            stringBuilder.append("--");
        }
        rows.add(stringBuilder);

        return rows;
    }

    private List<StringBuilder> drawNumbers(List<StringBuilder> rows) {
        for (int i = 0; i < HEIGHT; i++) {
            int index = Math.abs(HEIGHT - i);
            if (i % 2 == 0) {
                rows.get(i).insert(0, String.format("%2d", index));
                continue;
            }
            rows.get(i).insert(0, "  ");
        }
        rows.get(HEIGHT).insert(0, "  ");
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append(" 0 ");
        for (int i = 1; i <= WIDTH; i++) {
            if (i % 2 == 0) {
                stringBuilder.append(String.format("%2d", i));
                continue;
            }
            stringBuilder.append("  ");
        }
        rows.add(stringBuilder);
        return rows;
    }

    public String getPlane(){
        return plane;
    }
}
