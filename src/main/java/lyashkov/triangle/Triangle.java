package lyashkov.triangle;

import org.junit.jupiter.api.Assertions;


public class Triangle {

    double sideA;
    double sideB;
    double sideC;
    double injectionAB;


    public Triangle(double sideA, double sideB, double sideC, double injectionAB) {
        /*if (){

        } else {
            throw new RuntimeException(" не  верно");
        }*/
        this.sideA = sideA;
        this.sideB = sideB;
        this.sideC = sideC;
        this.injectionAB = injectionAB;
    }

    // сумма двух сторон больше третий, сумма углов не превышает 180, числа не могут быть отрицательными, числа должны быть, герон + стороны и угол


    public double getAreaOfInjection() {
        Assertions.assertAll(
                () -> Assertions.assertEquals(true,sideA >= 1,"Не соответствует условиям A"),
                () -> Assertions.assertEquals(true,sideB >= 1,"Не соответствует условиям B"),
                () -> Assertions.assertEquals(true,injectionAB >= 1,"Не соответствует условиям поиска по углу"),
                () -> Assertions.assertEquals(true, injectionAB < 178, "Сумма углов треугольника не может превышать 180 градусов")
        );
            double radians = Math.toRadians(injectionAB);
            return (sideA * sideB * radians) / 2;
    }

    public double getAreaOfHeron() {
        double sumOfAB = sideA + sideB;
        double sumOfAC = sideA + sideC;
        double sumOfBC = sideB + sideC;
        Assertions.assertAll(
                () -> Assertions.assertEquals(true,sideA >=1,"Сторона A не может равняться нулю"),
                () -> Assertions.assertEquals(true,sideB >=1,"Сторона B не может равняться нулю"),
                () -> Assertions.assertEquals(true,sideC >=1,"Сторона C не может равняться нулю"),
                () -> Assertions.assertEquals(true, sumOfAB > sideC, "Сумма сторон AB превышает длинну третьей стороны"),
                () -> Assertions.assertEquals(true, sumOfAC > sideB, "Сумма сторон AC превышает длинну третьей стороны"),
                () -> Assertions.assertEquals(true, sumOfBC > sideA, "Сумма сторон BC превышает длинну третьей стороны")
        );
        double semiperiod = (sideA + sideB + sideC) / 2;
        return (Math.sqrt(semiperiod * (semiperiod - sideA) * (semiperiod - sideB) * (semiperiod - sideC)));
    }


}
