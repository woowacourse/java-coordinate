package com.woowa.rentcar;

import com.woowa.rentcar.domain.Car;
import com.woowa.rentcar.domain.CarFactory;
import com.woowa.rentcar.domain.Distance;
import com.woowa.rentcar.domain.RentCompany;
import com.woowa.rentcar.view.InputView;

public class Main {
    public static void main(String[] args){
        RentCompany rentCompany = RentCompany.create();
        InputView.title();
        String carName = InputView.car();
        Distance distance = InputView.distance();
        Car car = CarFactory.newInstance(carName, distance);
        rentCompany.addCar(car);
        System.out.println(rentCompany.generateReport());
    }
}
