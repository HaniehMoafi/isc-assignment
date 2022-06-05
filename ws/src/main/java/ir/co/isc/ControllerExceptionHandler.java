package ir.co.isc;

import ir.co.isc.exception.CardException;
import ir.co.isc.model.CardDefaultResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ControllerExceptionHandler extends ResponseEntityExceptionHandler {


    @ExceptionHandler(CardException.class)
    protected ResponseEntity<CardDefaultResponse> handleUncaughtException(CardException ex, WebRequest request) {
        CardDefaultResponse response = new CardDefaultResponse();
        response.setMessage(ex.getMessage());
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }


}
