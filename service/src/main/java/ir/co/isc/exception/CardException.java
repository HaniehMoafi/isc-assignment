package ir.co.isc.exception;

public class CardException extends RuntimeException {

    public static String CARD_NOT_FOUND = "card not found";


    public CardException(String s) {
        super(s);
    }
}
