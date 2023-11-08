package br.com.compassUOL.challenge3.ms_user.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginDTO {

    @NotBlank
    @Column(unique = true)
    @Email(message = "invalid format")
    private String email;// usar o @Valid no post

    @NotBlank
    @Size(min = 6, message = "The field must have at least 6 characters")
    private String password;//criptografada para ser salva no banco
}
