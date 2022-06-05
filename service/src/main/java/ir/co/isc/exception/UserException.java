package ir.co.isc.exception;

public class UserException extends RuntimeException {

    public static String USER_NOT_FOUND = "user not found";


    public UserException(String s) {
        super(s);
    }
}
