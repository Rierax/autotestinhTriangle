package lyashkov.triangle;

import com.sun.istack.internal.NotNull;
import static java.lang.Double.sum;


public class Triangle {

    double sideA;
    double sideB;
    double sideC;
    double injectionAB;


    public Triangle(@NotNull double sideA, @NotNull double sideB, @NotNull double sideC, @NotNull double injectionAB) {
        if (sideA >= 1) {
            if (sideB >= 1) {
                if (sideC >= 1) {
                } else {
                    throw new RuntimeException("сторона C не может равняться нулю или быть отрицательной");
                }
            } else {
                throw new RuntimeException("сторона B не может равняться нулю или быть отрицательной");
            }
        }
        else {
            throw new RuntimeException("сторона A не может равняться нулю или быть отрицательной");
        }

        if(sum(sideA, sideB) > sideC) {
            if(sum(sideC, sideB) > sideA) {
                if(sum(sideC, sideA) > sideB) {
                } else {
                    throw new RuntimeException("сумма сторон треугольника не может быть больше третьей стороны");
                }
            } else {
                throw new RuntimeException("сумма сторон треугольника не может быть больше третьей стороны");
            }
        } else {
            throw new RuntimeException("сумма сторон треугольника не может быть больше третьей стороны");
        }

        if (injectionAB >= 1) {
            if (injectionAB < 178) {
            } else {
                throw new RuntimeException("сумма углов не может превышать 180 градусов");
            }
        } else {
            throw new RuntimeException("угол не может равняться нулю или быть отрицательным");
        }

        this.sideA = sideA;
        this.sideB = sideB;
        this.sideC = sideC;
        this.injectionAB = injectionAB;
    }

    // сумма двух сторон больше третий, сумма углов не превышает 180, числа не могут быть отрицательными, числа должны быть, герон + стороны и угол


    public double getAreaOfInjection() {
            double radians = Math.toRadians(injectionAB);
            return (sideA * sideB * radians) / 2;
    }

    public double getAreaOfHeron() {
        double semiperiod = (sideA + sideB + sideC) / 2;
        return (Math.sqrt(semiperiod * (semiperiod - sideA) * (semiperiod - sideB) * (semiperiod - sideC)));
    }
}
