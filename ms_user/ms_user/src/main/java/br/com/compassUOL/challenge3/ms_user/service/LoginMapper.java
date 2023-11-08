package br.com.compassUOL.challenge3.ms_user.service;

import br.com.compassUOL.challenge3.ms_user.dto.LoginDTO;
import br.com.compassUOL.challenge3.ms_user.dto.UserDTO;
import br.com.compassUOL.challenge3.ms_user.entity.Login;
import br.com.compassUOL.challenge3.ms_user.entity.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface LoginMapper {
    Login loginToLoginDTO(LoginDTO LoginDTO);
    LoginDTO LoginDTOToLogin(Login Login);
}
