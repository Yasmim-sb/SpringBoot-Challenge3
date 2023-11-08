package br.com.compassUOL.challenge3.ms_user.controller;

import br.com.compassUOL.challenge3.ms_user.dto.LoginDTO;
import br.com.compassUOL.challenge3.ms_user.entity.Login;
import br.com.compassUOL.challenge3.ms_user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1")
public class LoginController {
    private final UserService userService;

    @PostMapping("/login")
    public ResponseEntity<LoginDTO> createLogin(@RequestBody Login login) throws Exception {
        LoginDTO logindto = userService.createLogin(login.getEmail(), login.getPassword());
        return ResponseEntity.status(HttpStatus.CREATED).body(logindto);
    }
}
