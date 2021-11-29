package lyashkov.triangle;

public class Main {

    public static void main(String[] args) {
        Triangle triangle = new Triangle(10.0,10.0,10.0,60);
        System.out.println(triangle.getAreaOfHeron());
        System.out.println(triangle.getAreaOfInjection());
    }
}
