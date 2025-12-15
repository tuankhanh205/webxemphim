package org.example.bephim.controller.auth;

import lombok.RequiredArgsConstructor;
import org.example.bephim.dto.request.user.UserRequest;
import org.example.bephim.dto.response.user.UserResponse;
import org.example.bephim.service.auth.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

   private final   AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/register")
    public UserResponse register(@RequestBody UserRequest userRequest){
        return authService.register(userRequest);
    }
    @PostMapping("/login")
    UserResponse.Auth login (@RequestBody UserRequest userRequest){
        return authService.login(userRequest);
}
}
