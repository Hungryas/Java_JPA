package Week08.service.exception;

public class RequiredFieldMissedException extends RuntimeException {
    public RequiredFieldMissedException(String field) {
        super("Field %s id required!".formatted(field));
    }
}
