package br.com.compassUOL.challenge3.ms_user.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErroCode {
    NOT_FOUND("Not Found"),
    BAD_REQUEST("Invalid data"),
    SYSTEM_ERROR("Error Server");

    private final String message;
}
