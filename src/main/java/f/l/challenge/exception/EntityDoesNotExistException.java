package f.l.challenge.exception;

public class EntityDoesNotExistException extends RuntimeException {
    public EntityDoesNotExistException(final String message) {
        super(message);
    }
}
