package com.soltrix.service;

import com.soltrix.dto.SignupRequest;
import com.soltrix.entity.Cart;
import com.soltrix.entity.Role;
import com.soltrix.entity.User;
import com.soltrix.repository.CartRepository;
import com.soltrix.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public User registerUser(SignupRequest signupRequest) {
        if (userRepository.existsByEmail(signupRequest.getEmail())) {
            throw new RuntimeException("Error: Email is already in use!");
        }

        Role role = signupRequest.isAdmin() ? Role.ROLE_ADMIN : Role.ROLE_CUSTOMER;

        User user = User.builder()
                .name(signupRequest.getName())
                .email(signupRequest.getEmail())
                .password(passwordEncoder.encode(signupRequest.getPassword()))
                .role(role)
                .build();

        User savedUser = userRepository.save(user);

        // Auto-create a shopping cart for the user
        Cart cart = Cart.builder()
                .user(savedUser)
                .build();
        cartRepository.save(cart);

        return savedUser;
    }
}
