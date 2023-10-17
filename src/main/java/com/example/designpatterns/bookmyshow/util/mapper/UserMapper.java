package com.example.designpatterns.bookmyshow.util.mapper;

import com.example.designpatterns.bookmyshow.model.dto.UserDto;
import com.example.designpatterns.bookmyshow.model.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {

    UserMapper MAPPER = Mappers.getMapper(UserMapper.class);

    User toUser(final UserDto userDto);

    UserDto toUserDto(final User user);
}
