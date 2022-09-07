package com.kurdsoft.kikojast.user;


import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {

    User toUser(UserDTO userDTO);
    UserDTO toUserDto(User user);
    List<UserDTO> toUserDTOS(List<User> users);
}
