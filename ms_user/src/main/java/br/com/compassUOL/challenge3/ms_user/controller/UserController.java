package br.com.compassUOL.challenge3.ms_user.controller;

import br.com.compassUOL.challenge3.ms_user.dto.UserDTO;
import br.com.compassUOL.challenge3.ms_user.entity.User;
import br.com.compassUOL.challenge3.ms_user.repository.UserRepository;
import br.com.compassUOL.challenge3.ms_user.service.UserMapper;
import br.com.compassUOL.challenge3.ms_user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1")
public class UserController {

    private final UserService userService;
    private final UserMapper userMapper;
    private final UserRepository userRepository;



    @PostMapping("/users")
    public ResponseEntity<UserDTO> createUser(@RequestBody @Validated UserDTO user){

        UserDTO create = userService.createUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(create);
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<Optional<User>> getUserById(@PathVariable Long id){
        var userDTO= userRepository.findById(id);
        return ResponseEntity.ok().body(userDTO);
    }

}
