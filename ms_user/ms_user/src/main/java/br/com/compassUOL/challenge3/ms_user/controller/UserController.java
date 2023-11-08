package br.com.compassUOL.challenge3.ms_user.controller;

import br.com.compassUOL.challenge3.ms_user.dto.UserDTO;
import br.com.compassUOL.challenge3.ms_user.entity.Login;
import br.com.compassUOL.challenge3.ms_user.entity.User;
import br.com.compassUOL.challenge3.ms_user.service.UserMapper;
import br.com.compassUOL.challenge3.ms_user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1")
public class UserController {

    private final UserService userService;
    private final UserMapper userMapper;


//    @PostMapping("/login")
//    public ResponseEntity<UserDTO> createLogin(@RequestBody Login login){
//        UserDTO user = userService.createLogin(login.getEmail(), login.getPassword());
//       return ResponseEntity.ok(user);
//    }
}
