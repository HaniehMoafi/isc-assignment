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

import javax.validation.ConstraintViolationException;

@ControllerAdvice
public class ControllerExceptionHandler extends ResponseEntityExceptionHandler {


/*    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ExceptionResponse> handleUncaughtException(MethodArgumentNotValidException ex, WebRequest request) {
        List<String> messages = new ArrayList<>();
        ExceptionResponse response = new ExceptionResponse();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            messages.add("this field can not be empty : " + fieldName);
        });
        response.setExceptions(messages);
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);

    }*/

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

    @ExceptionHandler(ConstraintViolationException.class)
    protected ResponseEntity<DefaultResponse> handleUncaughtException(ConstraintViolationException ex, WebRequest request) {
        DefaultResponse response = new DefaultResponse();

        response.setMessage(findField(ex.getMessage()));
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    private String findField(String msg) {
        String[] splits = msg.split("\\.");
        String message = splits[splits.length - 1];
        return message;
    }

    @ExceptionHandler(Exception.class)
    protected ResponseEntity<DefaultResponse> handleUncaughtException(Exception ex, WebRequest request) {
        DefaultResponse response = new DefaultResponse();
        response.setMessage(ex.getMessage());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
}
