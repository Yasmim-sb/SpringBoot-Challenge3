package br.com.compassUOL.challenge3.ms_user.controller;

import br.com.compassUOL.challenge3.ms_user.dto.UserDTO;
import br.com.compassUOL.challenge3.ms_user.repository.UserRepository;
import br.com.compassUOL.challenge3.ms_user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1")
public class UserController {

    private final UserService userService;
    private final UserRepository userRepository;



    @PostMapping("/users")
    public ResponseEntity<UserDTO> createUser(@RequestBody @Validated UserDTO user){

        UserDTO create = (UserDTO) userService.createUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(create);
    }

    @PutMapping("users/{id}")
    public ResponseEntity<UserDTO> updateUser(@PathVariable Long id, @RequestBody UserDTO userDTO){
        var updateUser = userService.updateUser(id, userDTO);
        return ResponseEntity.ok().body(updateUser);
    }
//    @PutMapping("users/{id}/password")
//    public ResponseEntity<UserDTO> updatePassword(@PathVariable Long id, @RequestParam String password){
//
//        var updateUser = userService.updatePwd(id, password);
//        return ResponseEntity.ok().body(updateUser);
//    }

    @GetMapping("/users/{id}")
    public ResponseEntity<UserDTO> getUserById(@PathVariable Long id){
        var user = userRepository.findById(id);
        return ResponseEntity.ok().body(new UserDTO(user.get().getFirstName(), user.get().getLastName(),
        user.get().getEmail(), user.get().getPassword(),
        user.get().getBirthdate(), user.get().getCpf(),
        user.get().getId()));
    }

}
