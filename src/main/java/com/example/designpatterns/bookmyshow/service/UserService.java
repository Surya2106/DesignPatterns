package com.example.designpatterns.bookmyshow.service;

import com.example.designpatterns.bookmyshow.model.dto.UserDto;
import com.example.designpatterns.bookmyshow.model.entity.User;
import com.example.designpatterns.bookmyshow.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import static com.example.designpatterns.bookmyshow.util.mapper.UserMapper.MAPPER;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public UserDto createUser(final UserDto userDto) {
        final User user = MAPPER.toUser(userDto);
        final User userEntity = userRepository.save(user);
        return MAPPER.toUserDto(userEntity);
    }

    public String updateUser(final User inputUser) {
        return "";
    }
}
