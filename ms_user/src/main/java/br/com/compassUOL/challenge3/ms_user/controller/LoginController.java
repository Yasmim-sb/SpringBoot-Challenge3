package br.com.compassUOL.challenge3.ms_user.controller;

import br.com.compassUOL.challenge3.ms_user.dto.AuthenticationDto;
import br.com.compassUOL.challenge3.ms_user.dto.LoginDTO;
import br.com.compassUOL.challenge3.ms_user.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/login")
public class LoginController {
    private final UserService userService;
    private AuthenticationManager authenticationManager;

    @PostMapping
    public ResponseEntity<LoginDTO> createLogin(@RequestBody @Valid LoginDTO login) {
        var usernamePassword= new UsernamePasswordAuthenticationToken(login.getEmail(), login.getPassword());
        var verif = this.authenticationManager.authenticate(usernamePassword);

        return ResponseEntity.ok().build();
    }
}
