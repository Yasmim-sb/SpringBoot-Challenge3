package br.com.compassUOL.challenge3.ms_user.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginDTO {


    @JsonIgnore
    private Long id;

    @NotBlank
    @Column(unique = true)
    @Email(message = "invalid format")
    private String email;

    @NotBlank
    @Size(min = 6, message = "The field must have at least 6 characters")
    private String password;
}
