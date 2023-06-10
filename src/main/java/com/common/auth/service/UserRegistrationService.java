package com.common.auth.service;

import com.common.auth.entity.user.Role;
import com.common.auth.entity.user.User;
import com.common.auth.model.request.RegisterRequest;
import com.common.auth.model.response.RegisterResponse;
import com.common.auth.repo.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserRegistrationService {
    private final UserRepo userRepo;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    public RegisterResponse registerUser(RegisterRequest registerRequest){
        User user = User.builder()
                .firstName(registerRequest.getFirstName())
                .lastName(registerRequest.getLastName())
                .email(registerRequest.getEmail())
                .password(passwordEncoder.encode(registerRequest.getPassword()))
                .role(Role.USER)
                .build();
        userRepo.save(user);
        String token = jwtService.generateToken(user);
        return RegisterResponse.builder()
                .message(token)
                .build();
    }
}
