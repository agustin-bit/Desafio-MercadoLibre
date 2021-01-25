package meli.challenge.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ExceptionControllerAdvice {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ExceptionMessage> methodArgumentNotValidException(HttpServletRequest request, Exception e) {
        ExceptionMessage exceptionMessage = ExceptionMessage.builder().status(HttpStatus.BAD_REQUEST.value()).message(e.getMessage()).uri(request.getRequestURI()).build();
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exceptionMessage);
    }

}
