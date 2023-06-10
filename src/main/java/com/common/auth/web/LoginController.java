package com.common.auth.web;

import com.common.auth.model.request.LoginRequest;
import com.common.auth.model.response.AuthenticationResponse;
import com.common.auth.service.UserLoginService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class LoginController {
    private final UserLoginService userLoginService;
    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> performAuth(@RequestBody LoginRequest request){
        AuthenticationResponse authenticationResponse = userLoginService.performLogin(request);
        return ResponseEntity.ok(authenticationResponse);
    }
}
