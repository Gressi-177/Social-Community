package com.vietdoan.api.service;

import com.vietdoan.api.dto.UserDto;
import com.vietdoan.api.entities.User;

public interface UserService {
    UserDto reqGetProfile(User user);
}
