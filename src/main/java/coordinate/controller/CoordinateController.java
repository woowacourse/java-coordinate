package coordinate.controller;

import coordinate.view.InputView;

import java.util.List;

public class CoordinateController {
    public List<Integer> getCoordinates() {
        InputView inputView = new InputView();
        return inputView.inputCoordinates();
    }
}
