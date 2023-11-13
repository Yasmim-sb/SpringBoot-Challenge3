package br.com.compassUOL.challenge3.ms_user.exception;

import br.com.compassUOL.challenge3.ms_user.enums.ErroCode;
import lombok.Getter;
import org.springframework.http.HttpStatus;

import java.io.Serial;

@Getter
public class UserNotFoundException extends RuntimeException{
    @Serial
    private static final long serialVersionUID = 1L;

    private final ErroCode erroCode;
    private final HttpStatus status;

    public UserNotFoundException() {
        super(ErroCode.NOT_FOUND.name());
        this.status = HttpStatus.NOT_FOUND;
        this.erroCode = ErroCode.NOT_FOUND;
    }
}
