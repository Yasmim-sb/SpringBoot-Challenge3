package br.com.compassUOL.challenge3.ms_user.service;

import br.com.compassUOL.challenge3.ms_user.dto.UserDTO;
import br.com.compassUOL.challenge3.ms_user.entity.User;
import br.com.compassUOL.challenge3.ms_user.enums.ErroCode;
import br.com.compassUOL.challenge3.ms_user.exception.UserBadRequestException;
import br.com.compassUOL.challenge3.ms_user.exception.UserNotFoundException;
import br.com.compassUOL.challenge3.ms_user.repository.LoginRepository;
import br.com.compassUOL.challenge3.ms_user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper= UserMapper.INSTANCE;


    public Object createUser(UserDTO user){

        if(this.userRepository.findByEmail(user.getEmail()) != null && userRepository.findByCpf(user.getCpf())!=null){
            return new UserBadRequestException(ErroCode.NOT_FOUND);
        }

        String encryptedPassword = new BCryptPasswordEncoder().encode(user.getPassword());
        User newUser = new User(user.getEmail(), encryptedPassword, user.getCpf(), user.getFirstName(),
        user.getBirthdate(), user.getLastName(), user.isActive());
        var repository = this.userRepository.save(newUser);
        return userMapper.userToUserDTO(repository);
    }

    public UserDTO updateUser(Long id,UserDTO user) {
        User existingUser = userRepository.findById(id)
        .orElseThrow(() -> new UserNotFoundException());

        existingUser.setEmail(user.getEmail());
        existingUser.setPassword(user.getPassword());
        existingUser.setFirstName(user.getFirstName());
        existingUser.setLastName(user.getLastName());
        existingUser.setBirthdate(user.getBirthdate());
        existingUser.setCpf(user.getCpf());
        var save = userRepository.save(existingUser);
        var convertion = userMapper.userToUserDTO(save);

        return convertion;
    }

    public UserDTO updatePwd(Long id, String password) {
        User userExisting = userRepository.findById(id)
        .orElseThrow(() -> new UserNotFoundException());

        userExisting.setId(userExisting.getId());
        userExisting.setPassword(userExisting.getPassword());

        var save = userRepository.save(userExisting);
        var convertion = userMapper.userToUserDTO(save);
        return convertion;
    }
}
