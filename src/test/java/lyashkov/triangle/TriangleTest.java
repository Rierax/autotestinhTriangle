package lyashkov.triangle;

import org.junit.jupiter.api.*;

import static java.lang.Double.sum;
import static org.junit.jupiter.api.Assertions.*;


class TriangleTest {

    Triangle foreTest = new Triangle(10.0, 10.0, 10.0, 60);

    @Test
    void testAreaOfInjection() {
        assertTrue(RealHelper.differentNumber(52.35, foreTest.getAreaOfInjection(), 1));
        System.out.println("площадь по углу и двум сторонам определена верно");
    }

    @Test
    void testAreaOfHeron() {
        assertTrue(RealHelper.differentNumber(43.30, foreTest.getAreaOfHeron(), 1));
        System.out.println("площадь по теореме герона определена верно");
    }

    @Test
    public void negativeTestOfSideA() {
        Exception exception = assertThrows(RuntimeException.class, () -> {
            Triangle triangle = new Triangle(0, 10.0, 10.0, 60);
        });

        System.out.println("исключение sideA = 0");
    }

    @Test
    public void negativeTestOfSideB() {
        Exception exception = assertThrows(RuntimeException.class, () -> {
            Triangle triangle = new Triangle(10, 0, 10.0, 60);
        });
        System.out.println("исключение sideB = 0");
    }

    @Test
    public void negativeTestOfSideC() {
        Exception exception = assertThrows(RuntimeException.class, () -> {
            Triangle triangle = new Triangle(10.0, 10.0, 0, 60);
        });
        System.out.println("исключение sideC = 0");
    }

    @Test
    public void negativeTestSumOfSideAB() {
        Exception exception = assertThrows(RuntimeException.class, () -> {
            Triangle triangle = new Triangle(10.0, 10.0, 21.0, 60);
            Assertions.assertTrue(sum(triangle.sideA, triangle.sideB) > triangle.sideC);
        });
        System.out.println("исключение сумма сторон AB > C");
    }

    @Test
    public void negativeTestSumOfSideAC() {
        Exception exception = assertThrows(RuntimeException.class, () -> {
            Triangle triangle = new Triangle(10.0, 21.0, 10.0, 60);
            Assertions.assertTrue(sum(triangle.sideA, triangle.sideC) > triangle.sideB);
        });
        System.out.println("исключение сумма сторон AC > B");
    }

    @Test
    public void negativeTestSumOfSideBC() {
        Exception exception = assertThrows(RuntimeException.class, () -> {
            Triangle triangle = new Triangle(21.0, 10.0, 10.0, 60);
            Assertions.assertTrue(sum(triangle.sideB, triangle.sideC) > triangle.sideA);
        });
        System.out.println("исключение сумма сторон BC > A");
    }

    @Test
    public void negativeTestOfZeroInjectionAB() {
        Exception exception = assertThrows(RuntimeException.class, () -> {
            Triangle triangle = new Triangle(10.0, 10.0, 10.0, 0);
        });
        System.out.println("исключение InjectionAB = 0");
    }

    @Test
    public void negativeTestOfFullInjectionAB() {
        Exception exception = assertThrows(RuntimeException.class, () -> {
            Triangle triangle = new Triangle(10.0, 10.0, 10, 180);
        });
        System.out.println("исключение InjectionAB = 180");
    }
}