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

    // сумма двух сторон больше третий, сумма углов не превышает 180, числа не могут быть отрицательными



    @Test
    public void testForNotNull() {
        Assertions.assertNotNull(sideA);
        Assertions.assertNotNull(sideB);
        Assertions.assertNotNull(sideC);
        Assertions.assertNotNull(injectionAB);
    }

    @Test
    public void testOfSideS() {
        assert(sideA >= 1);
        assert(sideB >= 1);
        assert(sideC >= 1);
        System.out.println("стороны не равны нулю");
    }

    @Test
    public void testOfInjectionS() {
        assert(1 <= injectionAB);
        assert(injectionAB < 178);
        System.out.println("сумма сторон треугольника не превышает 180 градусов");
    }

    @Test
    public void getTestOfSideAB() {
        double sumOfAB = sideA + sideB;
        assert(sumOfAB > sideC);
        System.out.println("1 удовлетворяет требованиям построения треугольника");
    }

    @Test
    public void getTestOfSideAC() {
        double sumOfAC = sideA + sideC;
        assert(sumOfAC > sideB);
        System.out.println("2 удовлетворяет требованиям построения треугольника");
    }

    @Test
    public void getTestOfSideBC() {
        double sumOfBC = sideB + sideC;
        assert(sumOfBC > sideA);
        System.out.println("3 удовлетворяет требованиям построения треугольника");
    }

    @Test
    public void getAreaOfGeron() {
        double semiperiod = (sideA + sideB + sideC)/2;
        double area = (Math.sqrt(semiperiod * (semiperiod - sideA) * (semiperiod - sideB) * (semiperiod - sideC)));
        assertEquals(43.30127018922193, area, "Test not complete");
        System.out.println("площадь по теореме герона определена верно");
    }

    @Test
    public void getAreaOfInjection() {
        double radians = Math.toRadians(injectionAB);
        double area = (sideA * sideB * radians) / 2;
        assertEquals(52.35987755982988, area, "Test injection not complete");
        System.out.println("площадь по углу и двум сторонам определена верно");
    }
}