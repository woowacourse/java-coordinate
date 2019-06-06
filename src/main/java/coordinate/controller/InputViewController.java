package coordinate.controller;

import coordinate.domain.Points;
import coordinate.view.InputView;

public class InputViewController {
    private final InputView inputView;

    public InputViewController(InputView inputView) {
        this.inputView = inputView;
    }

    public Points inputCoordinates() {
        return inputView.inputCoordinates();
    }
}
