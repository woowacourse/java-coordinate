package rentcar.domain;

public abstract class Car implements CarInterface {
    double getChargeQuantity(){
        return getTripDistance() / getDistancePerLiter();
    }

}
