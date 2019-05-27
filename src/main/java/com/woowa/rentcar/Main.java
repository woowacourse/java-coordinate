package com.woowa.rentcar;

import com.woowa.rentcar.domain.Car;
import com.woowa.rentcar.domain.CarFactory;
import com.woowa.rentcar.domain.CarName;
import com.woowa.rentcar.domain.Distance;
import com.woowa.rentcar.domain.RentCompany;
import com.woowa.rentcar.view.InputView;
import com.woowa.rentcar.view.OutputView;

public class Main {
    public static void main(String[] args){
        RentCompany rentCompany = RentCompany.create();
        InputView.title();
        while (true) {
            CarName carName  = InputView.car();
            if (carName.equals(new CarName("end"))) {
                break;
            }
            Distance distance = InputView.distance();
            Car car = CarFactory.newInstance(carName, distance);
            rentCompany.addCar(car);
        }
        OutputView.print(rentCompany.generateReport());
    }
}
