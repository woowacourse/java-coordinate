package carcompany2;

import java.math.BigDecimal;
import java.math.RoundingMode;

public interface Car {
    default String getName() {
        return getClass().getSimpleName();
    }

    double getDistancePerLiter();

    double getTripDistance();

    default double getChargeQuantity() {
        BigDecimal tripDistance = new BigDecimal(getTripDistance());
        BigDecimal distancePerLiter = new BigDecimal(getDistancePerLiter());

        return tripDistance.divide(distancePerLiter, 3, RoundingMode.FLOOR).doubleValue();
    }
}
