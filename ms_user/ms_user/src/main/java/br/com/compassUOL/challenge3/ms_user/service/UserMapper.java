package br.com.compassUOL.challenge3.ms_user.service;

import br.com.compassUOL.challenge3.ms_user.dto.UserDTO;
import br.com.compassUOL.challenge3.ms_user.entity.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    User userToUserDTO(UserDTO userDTO);
    UserDTO userDTOToUser(User user);
}
