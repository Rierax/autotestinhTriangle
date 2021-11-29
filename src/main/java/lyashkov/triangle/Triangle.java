package lyashkov.triangle;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Triangle {

    double sideA;
    double sideB;
    double sideC;
    double injectionAB;


    public Triangle(double sideA, double sideB, double sideC, double injectionAB) {
        this.sideA = sideA;
        this.sideB = sideB;
        this.sideC = sideC;
        this.injectionAB = injectionAB;
    }

    // сумма двух сторон больше третий, сумма углов не превышает 180, числа не могут быть отрицательными, числа должны быть, герон + стороны и угол


    public double getAreaOfInjection() {
        double radians = Math.toRadians(injectionAB);
        double area = (sideA * sideB * radians) / 2;
        return area;
    }

    public double getAreaOfGeron() {
        double semiperiod = (sideA + sideB + sideC) / 2;
        double area = (Math.sqrt(semiperiod * (semiperiod - sideA) * (semiperiod - sideB) * (semiperiod - sideC)));
        return area;
    }
}
