package com.woowa.rentcar.view;

import com.woowa.rentcar.domain.CarName;
import com.woowa.rentcar.domain.Distance;

import java.util.Scanner;

public class InputView {
    private static Scanner scanner = new Scanner(System.in);

    public static CarName car() {
        OutputView.car();
        try {
            return new CarName(scanner.nextLine());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return car();
        }
    }

    public static Distance distance() {
        OutputView.distance();
        try {
            return new Distance(scanner.nextLine());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return distance();
        }
    }
}
