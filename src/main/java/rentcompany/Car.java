package rentcompany;

public abstract class Car {

    abstract double getDistancePerLiter();

    abstract double getTripDistance();

    abstract String getName();

    double getChargeQuantity() {
        return getTripDistance() / getDistancePerLiter();
    }

    int validDistance(int distance) {
        if(getTripDistance() < 0){
            throw new IllegalArgumentException("거리는 양수이어야 합니다.");
        }
        return distance;
    }
}
