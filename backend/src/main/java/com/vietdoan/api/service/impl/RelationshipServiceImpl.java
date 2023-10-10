package com.vietdoan.api.service.impl;

import com.vietdoan.api.entities.User;
import com.vietdoan.api.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@Service
public class RelationshipServiceImpl implements com.vietdoan.api.service.RelationshipService {
    private final UserRepository userRepository;
    @Override
    public List<User> reqSVLst(User user, Map<String, String> json) {
        //TODO Sửa lại logic lấy friends
        List<User> users = userRepository.findAll();
        return users;
    }
}
