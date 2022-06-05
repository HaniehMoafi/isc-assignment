package ir.co.isc;

import ir.co.isc.exception.CardException;
import ir.co.isc.exception.UserException;
import ir.co.isc.model.DefaultResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ControllerExceptionHandler extends ResponseEntityExceptionHandler {


    @ExceptionHandler(CardException.class)
    protected ResponseEntity<DefaultResponse> handleUncaughtException(CardException ex, WebRequest request) {
        DefaultResponse response = new DefaultResponse();
        response.setMessage(ex.getMessage());
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(UserException.class)
    protected ResponseEntity<DefaultResponse> handleUncaughtException(UserException ex, WebRequest request) {
        DefaultResponse response = new DefaultResponse();
        response.setMessage(ex.getMessage());
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }
}
