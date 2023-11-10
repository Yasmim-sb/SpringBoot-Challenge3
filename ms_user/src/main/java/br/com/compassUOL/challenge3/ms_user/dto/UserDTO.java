package br.com.compassUOL.challenge3.ms_user.dto;

import br.com.compassUOL.challenge3.ms_user.user.UserRole;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserDTO {

    private Long id;

    @NotBlank
    @Size(min = 3, message = "The field must have at least 3 characters")
    private String firstName;

    @NotBlank
    @Size(min = 3, message = "The field must have at least 3 characters")
    private String lastName;

    @NotBlank
    @Column(unique = true)
    private String cpf;//formato correto

    private Date birthdate; //formato ISO-8601

    @NotBlank
    @Column(unique = true)
    private String email;// formato valido

    @NotBlank
    @Size(min = 6, message = "The field must have at least 6 characters")
    private String password;//criptografada para ser salva no banco

    @NotNull
    private boolean active;

    private UserRole role;
    private String login;

    public UserDTO(String email, String password, UserRole userRole){
        this.role=userRole;
        this.email=email;
        this.password=password;
    }
}
