package lyashkov.triangle;

public class TriangleUncheckedException extends RuntimeException {

    public TriangleUncheckedException() {
        super();
    }

    public  TriangleUncheckedException(String massage) {
        super(massage);
    }

    public TriangleUncheckedException(String message, Throwable cause) {
        super(message, cause);
    }

    public TriangleUncheckedException(Throwable cause) {
        super(cause);
    }
}
