package lyashkov.triangle;

public class TriangleCheckedException extends Exception {

    public TriangleCheckedException() {
        super();
    }

    public TriangleCheckedException(String massage) {
        super(massage);
    }

    public TriangleCheckedException(String message, Throwable cause) {
        super(message, cause);
    }

    public TriangleCheckedException(Throwable cause) {
        super(cause);
    }
}