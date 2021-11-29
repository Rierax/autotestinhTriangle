import lyashkov.triangle.Smoke;
import lyashkov.triangle.Triangle;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import static org.junit.jupiter.api.Assertions.*;

@Smoke
public class TestTriangleIT {

    Double sideA = 10.0;
    Double sideB = 10.0;
    Double sideC = 10.0;
    Double injectionAB = 60.0;


    @Test
    public void testForNotNull() {
        Assertions.assertAll(
                () -> assertNotNull(sideA),
                () -> assertNotNull(sideB),
                () -> assertNotNull(sideC),
                () -> assertNotNull(injectionAB));
        System.out.println("стороны и угол прописаны");
    }

    @Test
    public void testOfSideS() {
        Assertions.assertAll(
                () -> assertTrue(sideA >= 1),
                () -> assertTrue(sideB >= 1),
                () -> assertTrue(sideC >= 1));
        System.out.println("стороны не равны нулю");
    }

    @Test
    public void testOfInjectionS() {
        Assertions.assertAll(
                () -> assertTrue(injectionAB >= 1),
                () -> assertTrue(injectionAB <178));
        System.out.println("сумма сторон треугольника не превышает 180 градусов");
    }

    @Test
    public void getTestOfNotException() {
        double sumOfAB = sideA + sideB;
        double sumOfAC = sideA + sideC;
        double sumOfBC = sideB + sideC;
        Assertions.assertAll(
                () -> assertTrue(sumOfAB > sideC),
                () -> assertTrue(sumOfAC > sideB),
                () -> assertTrue(sumOfBC > sideA));
        System.out.println("сумма сторон не превышает длину третьей");
    }

    @Test
    public void getAreaNegative() {
        Assertions.assertThrows(RuntimeException.class, () ->{

        });
    }
}

/* @Test
    public void getAreaOfInjection() {
        double radians = Math.toRadians(injectionAB);
        double area = (sideA * sideB * radians) / 2;
        assertEquals(52.35987755982988, area, "Test injection not complete");
        System.out.println("площадь по углу и двум сторонам определена верно");
    }

    @Test
    public void getAreaOfGeron() {
        double semiperiod = (sideA + sideB + sideC)/2;
        double area = (Math.sqrt(semiperiod * (semiperiod - sideA) * (semiperiod - sideB) * (semiperiod - sideC)));
        assertEquals(43.30127018922193, area, "Test not complete");
        System.out.println("площадь по теореме герона определена верно");
    }

    */