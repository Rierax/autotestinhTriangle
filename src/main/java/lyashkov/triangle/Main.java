package lyashkov.triangle;

public class Main {

    public static void main(String[] args) {
        Triangle triangle = new Triangle(10,10.0,10.0,60);
        System.out.println(triangle.getAreaOfHeron() + " - " + triangle.arrayListOfTypeTriangle());
        System.out.println(triangle.getAreaOfInjection() + " - " + triangle.getRectangular());
    }
}
