package com.common.auth.service;

import com.common.auth.model.request.LoginRequest;
import com.common.auth.model.response.AuthenticationResponse;
import com.common.auth.repo.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserLoginService {
    private final AuthenticationManager authenticationManager;
    private final UserRepo userRepo;
    private final JwtService jwtService;
    public AuthenticationResponse performLogin(LoginRequest loginRequest){
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                loginRequest.getEmail(),
                loginRequest.getPassword()
                )
        );
        var user = userRepo.findByEmail(loginRequest.getEmail())
                .orElseThrow();
        var jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }
}
