package lyashkov.triangle;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

class PositiveTest {

    Triangle foreTest = new Triangle(10.0, 10.0, 10.0, 60);

    /*    @BeforeEach
        void justMassage () {
            System.out.println("sad");
      }

        /*  @TestFactory
        Collection<DynamicTest> checkingForInputNumbers() {
            List<Triangle> triangles = Arrays.asList(
                    new Triangle(1,1,1,1),
                    new Triangle(20,10,10,1),
                    new Triangle(10,20,10,1),
                    new Triangle(10,10,20,1)
            );
            double minNumber = 1;
            triangles.stream()
                    .map(Triangle ->
                        DynamicTest.dynamicTest(Triangle.toString(),
                                () -> Assertions.assertTrue(foreTest.sideA >= minNumber)))
                    .collect(Collectors.toList());
        }
    */
    @Test
    @DisplayName("Площаль по сторонам и углу верна")
    void AreaOfInjectionIsTrueWithDelta() {
        assertEquals(52.35, foreTest.getAreaOfInjection(), 1);
    }

    @Test
    @DisplayName("Площадь по Герону верна")
    void AreaOfHeronIsTrue() {
        assertEquals(43.30, foreTest.getAreaOfHeron(), 1);
    }

    @Test
    @DisplayName("Проверка ссылаемого текста 1")
    public void expectThatTriangleIsRectangular() {
        Triangle triangle = new Triangle(10,10,10,90);
        String expect = new String("Треугольник прямоугольный").intern();
        assertSame(triangle.getRectangular(), expect);
    }

    @Test
    @DisplayName("Проверка ссылаемого текста 2")
    public void expectThatTriangleIsAcute() {
        Triangle triangle = new Triangle(10,10,10,89);
        String expect = new String("Треугольник остроугольный").intern();
        assertSame(triangle.getRectangular(), expect);
    }

    @Test
    @DisplayName("Проверка ссылаемого текста 3")
    public void expectThatTriangleIsObtuse() {
        Triangle triangle = new Triangle(10,10,10,91);
        String expect = new String("Треугольник тупоугольный").intern();
        assertSame(triangle.getRectangular(), expect);
    }

    @Test
    @DisplayName("Проверка массива 1")
    public void expectThatTriangleIsEquilateralWithArray() {
        Triangle triangle = new Triangle(10,10,10,60);
        assertEquals(triangle.arrayListOfTypeTriangle(),"Треугольник равносторонний");
    }

    @Test
    @DisplayName("Проверка массива 2")
    public void expectThatTriangleIsVersatileWithArray() {
        Triangle triangle = new Triangle(9,10,11,60);
        assertEquals(triangle.arrayListOfTypeTriangle(),"Треугольник разносторонний");
    }

    @Test
    @DisplayName("Проверка массива 3")
    public void expectThatTriangleIsWithArray() {
        Triangle triangle = new Triangle(9,10,11,60);
        assertEquals(triangle.arrayListOfTypeTriangle(),"Треугольник разносторонний");
    }
}

