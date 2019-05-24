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
            drawVertical(MAX_HEIGHT_WIDTH - i, points);
            System.out.println();
        }
        drawHorizontal(MAX_HEIGHT_WIDTH);
    }

    private void drawVertical(int currentY, Points points) {
        String numOrBlank = "  ";
        if (currentY % 2 == 0) {
            numOrBlank = String.format("%2s", Integer.toString(currentY));
        }
        List<Integer> currentXGroup = points.getPoints().stream().filter(x -> x.getY() == currentY && x.getY()>0).map(e -> e.getX()).collect(Collectors.toList());
        if (currentXGroup.size() > 0 && currentXGroup.get(0) == 0) {
            System.out.print(numOrBlank + "●");
            currentXGroup.remove(0);
        } else {
            System.out.print(numOrBlank + "|");
        }
        drawDotX(currentXGroup);
    }


    private void drawDotX(List<Integer> currentXGroup) {
        StringBuilder sb = new StringBuilder();
        int beforeX =0 ;
        for (int currentX : currentXGroup) {
            for (int i = 0; i < ((currentX-beforeX)*(HorizontalCorrectionValue)/2)-1; i++) {
                sb.append(" ");
            }
            sb.append("●");
            beforeX = currentX;
        }
        System.out.print(sb.toString());
    }


    void drawHorizontal(int num) {
        String firstLine = "  +";
        for (int i = 0; i < num * HorizontalCorrectionValue / 2; i++) {
            firstLine += "—";
        }
        String secondLine = "  0";
        for (int i = 0; i < num / 2; i++) {
            secondLine += String.format("%" + HorizontalCorrectionValue + "s", Integer.toString((i + 1) * 2));
        }
        System.out.println(firstLine);
        System.out.println(secondLine);
    }
}
