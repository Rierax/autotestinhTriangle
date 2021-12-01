package lyashkov.triangle;

public class RealHelper {

    public static boolean differentNumber(double numberOne, double numberTwo, double epsilon) {
        return (Math.abs(numberOne - numberTwo) < epsilon);
    }
}
/* if(true) {
            throw new RuntimeException(" не  верно");
        }*/