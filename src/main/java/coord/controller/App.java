package coord.controller;

import coord.model.Points;
import coord.view.InputView;

public class App {
    public static void main(String[] argc) {
        Points points = InputView.inputCoordinates();
    }
}