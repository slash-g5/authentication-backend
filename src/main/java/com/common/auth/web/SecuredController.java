package com.common.auth.web;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/demo")
public class SecuredController {
    @PostMapping("/secured/info")
    public ResponseEntity<String> getSecuredHello(){
        return ResponseEntity.ok("Hello From Secured World");
    }
}
