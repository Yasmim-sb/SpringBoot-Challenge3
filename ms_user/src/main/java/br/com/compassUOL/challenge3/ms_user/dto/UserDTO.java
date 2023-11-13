package br.com.compassUOL.challenge3.ms_user.dto;

//import br.com.compassUOL.challenge3.ms_user.user.UserRole;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

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
    private String cpf;

    @DateTimeFormat(pattern = "YYYY-MM-DD")
    private Date birthdate;

    @NotBlank
    @Column(unique = true)
    private String email;

    @NotBlank
    @Size(min = 6, message = "The field must have at least 6 characters")
    private String password;

    @NotNull
    private boolean active;

    public UserDTO(String firstName, String lastName, String email, String password, Date birthdate, String cpf, Long id) {
        this.cpf=cpf;
        this.firstName=firstName;
        this.lastName=lastName;
        this.email=email;
        this.password=password;
        this.cpf=cpf;
        this.birthdate=birthdate;
        this.id=id;
    }
}
