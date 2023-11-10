package br.com.compassUOL.challenge3.ms_user.exception;

import br.com.compassUOL.challenge3.ms_user.enums.ErroCode;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class UserNotFoundException extends RuntimeException{

    private final ErroCode erroCode;
    private final HttpStatus status;

    public UserNotFoundException(ErroCode erroCode){
        super(ErroCode.NOT_FOUND.name());
        this.erroCode = erroCode;
        this.status= HttpStatus.NOT_FOUND;
    }
}
