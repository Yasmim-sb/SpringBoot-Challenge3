package br.com.compassUOL.challenge3.ms_user.service;

import br.com.compassUOL.challenge3.ms_user.dto.UserDTO;
import br.com.compassUOL.challenge3.ms_user.entity.User;
import br.com.compassUOL.challenge3.ms_user.enums.ErroCode;
import br.com.compassUOL.challenge3.ms_user.exception.UserBadRequestException;
import br.com.compassUOL.challenge3.ms_user.repository.LoginRepository;
import br.com.compassUOL.challenge3.ms_user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import static java.sql.DriverManager.getConnection;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    private final LoginRepository loginRepository;
    private final UserMapper userMapper= UserMapper.INSTANCE;
    private  UserBadRequestException userBadRequestException;

//    public LoginDTO createLogin(LoginDTO loginDTO) {
//
//        Login login = new Login();
//        login.setId(loginDTO.getId());
//        login.setEmail(loginDTO.getEmail());
//        login.setPassword(loginDTO.getPassword());
//
//        return  userMapper.loginTOLoginDto(loginRepository.save(login));
//
//    }

//    public UserDTO createUser(UserDTO user) {
//        user.setFirstName(user.getFirstName());
//        user.setLastName(user.getLastName());
//        user.setCpf(user.getCpf());
//        user.setBirthdate(user.getBirthdate());
//        user.setEmail(user.getEmail());
//        user.setPassword(user.getPassword());
//        user.setActive(user.isActive());
//        var convertion = userMapper.userDTOToUser(user);
//        var save= userRepository.save(convertion);
//        var ok = userMapper.userToUserDTO(save);
//        return ok;
//    }
    public UserDTO createUser(UserDTO user){
//
//        if(this.userRepository.findByLogin(user.getEmail()) != null)
////            return ResponseEntity.badRequest().build();
//            return new UserBadRequestException(ErroCode.NOT_FOUND);
        String encryptedPassword = new BCryptPasswordEncoder().encode(user.getPassword());
        User newUser = new User(user.getLogin(), encryptedPassword, user.getRole());
        var repository = this.userRepository.save(newUser);
        return userMapper.userToUserDTO(repository);
    }
}
