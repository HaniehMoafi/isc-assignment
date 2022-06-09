package ir.co.isc.exception;

public class UserException extends RuntimeException {

    public static String USER_NOT_FOUND = "user not found";
    public static String DUPLICATE_USER = "user with this national code was saved previously";


    public UserException(String s) {
        super(s);
    }
}
