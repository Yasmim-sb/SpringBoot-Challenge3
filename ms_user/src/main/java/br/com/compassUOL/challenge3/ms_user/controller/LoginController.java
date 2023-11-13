package br.com.compassUOL.challenge3.ms_user.controller;

import br.com.compassUOL.challenge3.ms_user.dto.LoginDTO;
import br.com.compassUOL.challenge3.ms_user.entity.User;
import br.com.compassUOL.challenge3.ms_user.infra.security.TokenService;
import br.com.compassUOL.challenge3.ms_user.user.LoginResponseDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/users")
public class LoginController {
    private final AuthenticationManager authenticationManager;
    private final TokenService tokenService;

    @PostMapping("/login")
    public ResponseEntity createLogin(@RequestBody @Valid LoginDTO login) {
        var usernamePassword= new UsernamePasswordAuthenticationToken(login.getEmail(), login.getPassword());
        var verif = this.authenticationManager.authenticate(usernamePassword);
        var token = tokenService.generateToken((User) verif.getPrincipal());

        return ResponseEntity.ok(new LoginResponseDto(token));
    }
}
