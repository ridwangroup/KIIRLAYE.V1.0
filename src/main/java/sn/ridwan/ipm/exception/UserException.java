package sn.ridwan.ipm.exception;

public class UserException extends RuntimeException {
    public UserException() {
        super();
    }
    public UserException(String exc) {
        super(exc);
    }
}
