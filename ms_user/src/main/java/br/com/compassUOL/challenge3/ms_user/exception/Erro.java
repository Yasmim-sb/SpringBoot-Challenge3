package br.com.compassUOL.challenge3.ms_user.exception;

import br.com.compassUOL.challenge3.ms_user.enums.ErroCode;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.http.HttpStatus;

public class Erro {
    @JsonProperty("Code")
    private final int code;

    @JsonProperty("Status")
    private final String status;

    @JsonProperty("Message")
    private final String message;


    public Erro(ErroCode erroCode, UserNotFoundException exception) {
        this.code= exception.getStatus().value();
        this.status = erroCode.name();
        this.message = erroCode.getMessage();
    }

//    public Erro(ErroCode erroCode){
//        this.code = HttpStatus.INTERNAL_SERVER_ERROR.value();
//        this.status = erroCode.name();
//        this.message = erroCode.getMessage();
//    }
}
