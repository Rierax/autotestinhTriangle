package lyashkov.triangle;

import org.junit.jupiter.api.Test;

public class Main {

    public static void main(String[] args) {
        Triangle triangle = new Triangle(10,10,10,60);
        System.out.println(triangle.getAreaOfInjection());
        System.out.println(triangle.getAreaOfGeron());
    }
}
