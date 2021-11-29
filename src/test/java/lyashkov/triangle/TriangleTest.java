package lyashkov.triangle;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;


class TriangleTest {

    Triangle foreTest = new Triangle(10,10,10,60);

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
    public void testOfSide() {
        Assertions.assertAll(
                () -> assertTrue(foreTest.sideA >= 1),
                () -> assertTrue(foreTest.sideB >= 1),
                () -> assertTrue(foreTest.sideC >= 1));
        System.out.println("стороны не равны нулю");
    }

    @Test
    public void testOfInjection() {
        Assertions.assertAll(
                () -> assertTrue(foreTest.injectionAB >= 1),
                () -> assertTrue(foreTest.injectionAB <178));
        System.out.println("сумма сторон треугольника не превышает 180 градусов");
    }

    @Test
    public void testSumOfSide() {
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
    void testAreaOfInjection() {
        assertTrue(RealHelper.differentNumber(52.35, foreTest.getAreaOfInjection(),1));
        System.out.println("площадь по углу и двум сторонам определена верно");
    }

    @Test
    void testAreaOfHeron() {
        double semiperiod = (foreTest.sideA + foreTest.sideB + foreTest.sideC)/2;
        double area = (Math.sqrt(semiperiod * (semiperiod - foreTest.sideA) * (semiperiod - foreTest.sideB) * (semiperiod - foreTest.sideC)));
        assertEquals(area, foreTest.getAreaOfHeron(), "Test Heron not complete");
        System.out.println("площадь по теореме герона определена верно");
    }

    @Test
    public void negativeTestOfSide() {
     /*   Exception exception = assertThrows(RuntimeException.class, () -> {
            Integer.parseInt(“1a”);
        });*/
        Assertions.assertAll(
                () -> assertFalse(foreTest.sideA < 1),
                () -> assertFalse(foreTest.sideB < 1),
                () -> assertFalse(foreTest.sideC < 1));
        System.out.println("Негативный - стороны равны нулю");
    }

    @Test
    public void negativeTestOfInjection() {
        Assertions.assertAll(
                () -> assertFalse(foreTest.injectionAB < 1),
                () -> assertFalse(foreTest.injectionAB >178));
        System.out.println("Негативный - сумма сторон треугольника превышает 180 градусов");
    }
}