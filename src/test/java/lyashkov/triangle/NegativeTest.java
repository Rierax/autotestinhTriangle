package lyashkov.triangle;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class NegativeTest {

    @Test
    @DisplayName("TimeOut")
    void timeout() {
        Assertions.assertTimeout(Duration.ofMillis(500),
                () -> Thread.currentThread().sleep(400)
        );
    }

    @Test
    @DisplayName("sideA = 0")
    public void lengthOfSideAis0() {
        Exception exception = assertThrows(TriangleCheckedException.class, () -> {
            Triangle triangle = new Triangle(0, 10.0, 10.0, 60);
            triangle.tryToCatchExceptionOfSideS();
        });
    }

    @Test
    @DisplayName("sideB = 0")
    public void lengthOfSideBis0() {
        Exception exception = assertThrows(TriangleCheckedException.class, () -> {
            Triangle triangle = new Triangle(10, 0, 10.0, 60);
            triangle.tryToCatchExceptionOfSideS();
        });
    }

    @Test
    @DisplayName("sideC = 0")
    public void lengthOfSideCis0() {
        Exception exception = assertThrows(TriangleCheckedException.class, () -> {
            Triangle triangle = new Triangle(10.0, 10.0, 0, 60);
            triangle.tryToCatchExceptionOfSideS();
        });
    }

    @Test
    @DisplayName("сумма сторон AB > C")
    public void incorrectSumOfSideAB() {
        Exception exception = assertThrows(TriangleCheckedException.class, () -> {
            Triangle triangle = new Triangle(10.0, 10.0, 20.0, 60);
            triangle.tryToCatchExceptionOfSideS();
        });
    }

    @Test
    @DisplayName("сумма сторон AC > B")
    public void incorrectSumOfSideAC() {
        Exception exception = assertThrows(TriangleCheckedException.class, () -> {
            Triangle triangle = new Triangle(10.0, 20.0, 10.0, 60);
            triangle.tryToCatchExceptionOfSideS();
        });
    }

    @Test
    @DisplayName("сумма сторон BC > A")
    public void incorrectSumOfSideBC() {
        Exception exception = assertThrows(TriangleCheckedException.class, () -> {
            Triangle triangle = new Triangle(20.0, 10.0, 10.0, 60);
            triangle.tryToCatchExceptionOfSideS();
        });
    }

    @Test
    @DisplayName("InjectionAB = 0")
    public void incorrectInjectionABis0() {
        Exception exception = assertThrows(TriangleUncheckedException.class, () -> {
            Triangle triangle = new Triangle(10.0, 10.0, 10.0, 0);
        });
    }

    @Test
    @DisplayName("InjectionAB = 180")
    public void incorrectInjectionABis180() {
        Exception exception = assertThrows(TriangleUncheckedException.class, () -> {
            Triangle triangle = new Triangle(10.0, 10.0, 10, 179);
        });
    }
}
