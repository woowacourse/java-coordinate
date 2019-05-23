package coordinate.controller;

import coordinate.view.InputView;

public class CoordinateController {
    public String getCoordinates() {
        InputView inputView = new InputView();
        return inputView.inputCoordinates();
    }
}
