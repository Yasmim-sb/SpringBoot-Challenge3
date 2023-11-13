package br.com.compassUOL.challenge3.ms_user.service;

import br.com.compassUOL.challenge3.ms_user.dto.LoginDTO;
import br.com.compassUOL.challenge3.ms_user.dto.UserDTO;
import br.com.compassUOL.challenge3.ms_user.entity.Login;
import br.com.compassUOL.challenge3.ms_user.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")

public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    User userDTOToUser(UserDTO userDTO);
    UserDTO userToUserDTO(User user);

    Login loginDTOToLogin(LoginDTO loginDTO);
    LoginDTO loginTOLoginDto(Login login);

}
