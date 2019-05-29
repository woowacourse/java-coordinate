package coordinate.domain;

class OutOfRangeException extends RuntimeException {
    OutOfRangeException(String message) {
        super(message);
    }
}
