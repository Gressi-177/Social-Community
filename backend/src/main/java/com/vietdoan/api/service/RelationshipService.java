package com.vietdoan.api.service;

import com.vietdoan.api.entities.User;

import java.util.List;
import java.util.Map;

public interface RelationshipService {
    public List<User> reqSVLst(User user, Map<String, String> json);
}
