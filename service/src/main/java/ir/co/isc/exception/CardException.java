package ir.co.isc.exception;

public class CardException extends RuntimeException {

    public static String CARD_NOT_FOUND = "card not found";
    public static String DUPLICATE_CARD = "card with this type and issuer code for this user was saved previously";
    public static String WRONG_CARD_DATA = "card number or account number is wrong";


    public CardException(String s) {
        super(s);
    }
}
