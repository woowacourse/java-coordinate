package location.view;

import location.domain.Points;

import java.util.List;
import java.util.stream.Collectors;

public class CoordinateDrawer {
    int MAX_HEIGHT_WIDTH = 24;
    int HorizontalCorrectionValue = 6;

    public CoordinateDrawer(Points points) {
        drawMap(points);
    }

    void drawMap(Points points) {
        for (int i = 0; i < MAX_HEIGHT_WIDTH; i++) {
            drawVertical(MAX_HEIGHT_WIDTH - i);
            drawDot(MAX_HEIGHT_WIDTH - i, points);
            System.out.println();
        }
        drawHorizontal(MAX_HEIGHT_WIDTH);
    }

    void drawVertical(int currentY) {
        String numOrBlank = "  ";
        if (currentY % 2 == 0) {
            numOrBlank = String.format("%2s", Integer.toString(currentY));
        }
        System.out.print(numOrBlank + "| ");
    }

    private void drawDot(int currentY, Points points) {
        List<Integer> currentXGroup = points.getPoints().stream().filter(x -> x.getY() == currentY).map(e -> e.getX()).collect(Collectors.toList());
        for (int currentX : currentXGroup) {
            drawDotXs((currentX - 1) * HorizontalCorrectionValue/2);
        }
    }

    private void drawDotXs(int currentX) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < currentX; i++) {
            sb.append(" ");
        }
        sb.append("●");
        System.out.print(sb.toString());
    }


    void drawHorizontal(int num) {
        String firstLine = "  +";
        for (int i = 0; i < num*HorizontalCorrectionValue/2; i++) {
            firstLine += "-";
        }
        String secondLine = " 0 ";
        for (int i = 0; i < num / 2; i++) {
            secondLine += String.format("%"+HorizontalCorrectionValue+"s", Integer.toString((i + 1) * 2));
        }
        System.out.println(firstLine);
        System.out.println(secondLine);
    }
}
