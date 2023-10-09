package com.vietdoan.api.service.impl;

import com.vietdoan.api.constants.ErrorMessage;
import com.vietdoan.api.dto.UserDto;
import com.vietdoan.api.entities.User;
import com.vietdoan.api.exception.NotFoundException;
import com.vietdoan.api.repository.UserRepository;
import com.vietdoan.api.service.UserService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final ModelMapper    modelMapper = new ModelMapper();

    @Override
    public UserDto reqGetProfile(User user) {
        Optional<User> userOptional = userRepository.findById(user.getId());
        if (userOptional.isEmpty())
            throw new NotFoundException(ErrorMessage.NOT_FOUND.getMessage());

        return modelMapper.map(userOptional.get(), UserDto.class);
    }
}
