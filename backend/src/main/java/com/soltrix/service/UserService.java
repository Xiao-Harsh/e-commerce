package com.soltrix.service;

import com.soltrix.dto.SignupRequest;
import com.soltrix.entity.User;

public interface UserService {
    User registerUser(SignupRequest signupRequest);
}
