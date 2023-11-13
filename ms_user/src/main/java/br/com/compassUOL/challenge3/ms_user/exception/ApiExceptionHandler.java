package br.com.compassUOL.challenge3.ms_user.exception;

import br.com.compassUOL.challenge3.ms_user.enums.ErroCode;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler(UserNotFoundException.class)
    public final ResponseEntity<Object> handlerUserNotFound(UserNotFoundException exception){
        var exc = new Erro(exception.getErroCode(), exception);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exc);
    }
    @ExceptionHandler(Exception.class)
    public final ResponseEntity<Object> handlerAllExceptions(){
        var problem = new Erro(ErroCode.SYSTEM_ERROR);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(problem);
    }

}
