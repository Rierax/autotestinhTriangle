package lyashkov.triangle;

import com.sun.istack.internal.NotNull;

import java.util.Arrays;
import java.util.List;

import static java.lang.Double.sum;


public class Triangle {

    double sideA;
    double sideB;
    double sideC;
    double injectionAB;

    public Triangle(@NotNull double sideA, @NotNull double sideB, @NotNull double sideC, @NotNull double injectionAB) {
        if (injectionAB < 1 | injectionAB > 178) {
            throw new TriangleUncheckedException("Не корректный угол");
        }

        this.sideA = sideA;
        this.sideB = sideB;
        this.sideC = sideC;
        this.injectionAB = injectionAB;
    }

    public String getRectangular() {
        if (injectionAB == 90) {
            return "Треугольник прямоугольный";
        }
        if (injectionAB > 90) {
            return "Треугольник тупоугольный";
        }
        if (injectionAB < 90) {
            return "Треугольник остроугольный";
        } else {
            return "0";
        }
    }

    public String arrayListOfTypeTriangle() {
        List<String> type = Arrays.asList("Треугольник", "равносторонний", "разносторонний", "равнобедренный");
        if (sideA == sideB & sideB == sideC) {
            return type.get(0) + " " + type.get(1);
        }
        if (sideA != sideB & sideB != sideC) {
            return type.get(0) + " " + type.get(2);
        }
        if (sideA == sideB & sideB != sideC | sideB == sideC & sideC != sideA | sideA == sideC & sideC != sideB) {
            return type.get(0) + " " + type.get(3);
        }
        return "0";
    }


    public double getAreaOfInjection() {
            double radians = Math.toRadians(injectionAB);
            return (sideA * sideB * radians) / 2;
    }

    public double getAreaOfHeron() {
        double semiperiod = (sideA + sideB + sideC) / 2;
        return (Math.sqrt(semiperiod * (semiperiod - sideA) * (semiperiod - sideB) * (semiperiod - sideC)));
    }

    public void tryToCatchExceptionOfSideS() throws TriangleCheckedException {
        try {
            if (sideA < 1 | sideB < 1 | sideC < 1) {
                throw new TriangleCheckedException("Сторона не может равняться нулю или быть отрицательной");
            }
            if (sum(sideA, sideB) <= sideC | sum(sideC, sideB) <= sideA | sum(sideC, sideA) <= sideB) {
                throw new TriangleCheckedException("Сумма двух сторон должна быть больше третьей");
            }
        } catch(TriangleCheckedException e) {
            System.out.println("Exception: " + e.getMessage());
            throw new TriangleCheckedException();
        }
    }
}
