package lyashkov.triangle;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TriangleTest {

    Triangle foreTest = new Triangle(5,10,10,60);

    @Test
    void testForNotNull() {
        Assertions.assertAll(
                () -> assertNotNull(foreTest.sideA),
                () -> assertNotNull(foreTest.sideB),
                () -> assertNotNull(foreTest.sideC),
                () -> assertNotNull(foreTest.injectionAB));
        System.out.println("стороны и угол прописаны");
    }

    @Test
    public void testOfSideS() {
        Assertions.assertAll(
                () -> assertTrue(foreTest.sideA >= 1),
                () -> assertTrue(foreTest.sideB >= 1),
                () -> assertTrue(foreTest.sideC >= 1));
        System.out.println("стороны не равны нулю");
    }

    @Test
    public void testOfInjectionS() {
        Assertions.assertAll(
                () -> assertTrue(foreTest.injectionAB >= 1),
                () -> assertTrue(foreTest.injectionAB <178));
        System.out.println("сумма сторон треугольника не превышает 180 градусов");
    }

    @Test
    public void getTestOfNotException() {
        double sumOfAB = foreTest.sideA + foreTest.sideB;
        double sumOfAC = foreTest.sideA + foreTest.sideC;
        double sumOfBC = foreTest.sideB + foreTest.sideC;
        Assertions.assertAll(
                () -> assertTrue(sumOfAB > foreTest.sideC),
                () -> assertTrue(sumOfAC > foreTest.sideB),
                () -> assertTrue(sumOfBC > foreTest.sideA));
        System.out.println("сумма сторон не превышает длину третьей");
    }

    @Test
    void getAreaOfInjection() {
        double radians = Math.toRadians(foreTest.injectionAB);
        double area = (foreTest.sideA * foreTest.sideB * radians) / 2;
        assertEquals( area, foreTest.getAreaOfInjection(), "Test injection not complete");
        System.out.println("площадь по углу и двум сторонам определена верно");
    }

    @Test
    void getAreaOfGeron() {
        double semiperiod = (foreTest.sideA + foreTest.sideB + foreTest.sideC)/2;
        double area = (Math.sqrt(semiperiod * (semiperiod - foreTest.sideA) * (semiperiod - foreTest.sideB) * (semiperiod - foreTest.sideC)));
        assertEquals(area, foreTest.getAreaOfGeron(), "Test not complete");
        System.out.println("площадь по теореме герона определена верно");
    }
}