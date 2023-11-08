package br.com.compassUOL.challenge3.ms_user.service;

import br.com.compassUOL.challenge3.ms_user.dto.LoginDTO;
import br.com.compassUOL.challenge3.ms_user.dto.UserDTO;
import br.com.compassUOL.challenge3.ms_user.entity.Login;
import br.com.compassUOL.challenge3.ms_user.entity.User;
import br.com.compassUOL.challenge3.ms_user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import static org.apache.logging.log4j.util.Strings.isBlank;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final LoginMapper loginMapper;

//    public LoginDTO createLogin(@RequestParam String email, String password){
//        var login = new Login();
//        login.setEmail(login.getEmail());
//        login.setPassword(login.getPassword());
//        var conversion=  loginMapper.LoginDTOToLogin(login);
//        return conversion;
//    }

    public LoginDTO createLogin(@RequestParam String email, String password) throws Exception {
        if (isBlank(email) || isBlank(password)) {
            throw new Exception("Invalid email or password.");
        }

        var login = new Login();
        login.setEmail(email);
        login.setPassword(password);

        var conversion = loginMapper.LoginDTOToLogin(login);

        if (conversion == null) {
            throw new Exception("Failed to convert Login to LoginDTO.");
        }

        return conversion;
    }
}
