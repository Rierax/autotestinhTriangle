package lyashkov.triangle;

import org.junit.jupiter.api.Test;

public class Triangle {
    double sideA;                //double sideA = 10;
    double sideB;                //double sideB = 10;
    double sideC;                //double sideC = 10;
    double injectionAB;              //double injectionAB = 60;

    public Triangle(double sideA, double sideB, double sideC, double injectionAB) {
        this.sideA = sideA;
        this.sideB = sideB;
        this.sideC = sideC;
        this.injectionAB = injectionAB;
        assert sideA >= 0;
        assert sideB >=0;
        assert sideC >= 0;
        assert injectionAB >=0;
    }

    @Test
    public double getAreaOfGeron() {
        double semiperiod = (sideA + sideB + sideC)/2;
        double trger = (Math.sqrt(semiperiod * (semiperiod - sideA) * (semiperiod - sideB) * (semiperiod - sideC)));
        return trger;
    }

    public double getAreaOfInjection() {
        double radians = Math.toRadians(injectionAB);
        double injectionPeriod = (sideA * sideB * radians) / 2;
        return injectionPeriod;
    }
}