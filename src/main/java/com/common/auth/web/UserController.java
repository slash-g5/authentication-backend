package com.common.auth.web;

import com.common.auth.model.request.RegisterRequest;
import com.common.auth.model.response.RegisterResponse;
import com.common.auth.service.UserRegistrationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class UserController {
    private final UserRegistrationService userRegistrationService;
    @PostMapping("/register")
    public ResponseEntity<RegisterResponse> register(@RequestBody RegisterRequest request){
        RegisterResponse registerResponse = userRegistrationService.registerUser(request);
        return ResponseEntity.ok(registerResponse);
    }
    @GetMapping("/demo")
    public ResponseEntity<String> helloWorld(){
        return ResponseEntity.ok("Hello from (UN)Secured World");
    }
}
