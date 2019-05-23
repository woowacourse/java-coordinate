package coordinate.view;

import coordinate.controller.CoordinateController;

import java.util.List;

public class OuputView {
    public void run() {
        CoordinateController coordinateController = new CoordinateController();
        List<Integer> input = coordinateController.getCoordinates();

        for (int i : input) {
            System.out.println(i);
        }
    }
}
