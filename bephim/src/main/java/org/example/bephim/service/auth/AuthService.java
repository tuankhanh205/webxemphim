package org.example.bephim.service.auth;

import org.example.bephim.dto.request.user.UserRequest;
import org.example.bephim.dto.response.user.UserResponse;
import org.springframework.stereotype.Service;

@Service
public interface AuthService {
    UserResponse register(UserRequest userRequest);
    UserResponse.Auth login (UserRequest userRequest);
}
