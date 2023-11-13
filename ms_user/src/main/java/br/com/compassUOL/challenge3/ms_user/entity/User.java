package br.com.compassUOL.challenge3.ms_user.entity;

//import br.com.compassUOL.challenge3.ms_user.user.UserRole;
import br.com.compassUOL.challenge3.ms_user.user.UserRole;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Date;
import java.util.List;

@Entity
@Data
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name= "users_tb")
public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(min = 3, message = "The field must have at least 3 characters")
    private String firstName;

    @NotBlank
    @Size(min = 3, message = "The field must have at least 3 characters")
    private String lastName;

    @NotBlank
    @Column(unique = true)
    @CPF(message = "invalid format")
    private String cpf;

    @DateTimeFormat(pattern = "YYYY-MM-DD")
    private Date birthdate;

    @NotBlank
    @Column(unique = true)
    @Email(message = "invalid format")
    private String email;

    @NotBlank
    @Size(min = 6, message = "The field must have at least 6 characters")
    private String password;

    @NotNull
    private boolean active;


    @JsonIgnore
    private UserRole role;


    public User(String email, String encryptedPassword, String cpf, String firstName,
                Date birthdate, String lastName, Boolean active ) {
        this.cpf=cpf;
        this.email=email;
        this.password=encryptedPassword;
        this.birthdate= birthdate;
        this.active=active;
        this.lastName=lastName;
        this.firstName=firstName;
        this.role= UserRole.USER_ROLE;

    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if(this.role == UserRole.ADMIN) return List.of(new SimpleGrantedAuthority("ROLE_ADM"), new SimpleGrantedAuthority("ROLE_USER"));
        else return List.of(new SimpleGrantedAuthority("ROLE_USER"));
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
