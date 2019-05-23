package coordinate.view;

import coordinate.controller.CoordinateController;

public class OuputView {
    public void run() {
        CoordinateController coordinateController = new CoordinateController();
        String input = coordinateController.getCoordinates();
    }
}
