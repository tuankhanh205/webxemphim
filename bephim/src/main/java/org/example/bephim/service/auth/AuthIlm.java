package org.example.bephim.service.auth;

import lombok.RequiredArgsConstructor;
import org.example.bephim.dto.request.user.UserRequest;
import org.example.bephim.dto.response.user.UserResponse;
import org.example.bephim.entity.User;
import org.example.bephim.enums.RoleEnum;
import org.example.bephim.repository.UserRepository;
import org.example.bephim.security.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service

public class AuthIlm implements AuthService {

    private final UserRepository userRepository;
    private final JwtService jwtService;

    public AuthIlm(UserRepository userRepositor, JwtService jwtService) {
        this.userRepository = userRepositor;
        this.jwtService = jwtService;
    }

    @Override
    public UserResponse register(UserRequest userRequest) {
        User user=new User();
        String passWord=userRequest.getPassWord();
        String userName=userRequest.getUserName();
        BCryptPasswordEncoder encoder=new BCryptPasswordEncoder();
        validate(userName,passWord);
        String passWordEncode= encoder.encode(passWord);
        user.setUsername(userName);
        user.setPassWord(passWordEncode);
        user.setRole(RoleEnum.CLIENT);
        userRepository.save(user);
        return maptoResponse(user);
    }

    @Override
    public UserResponse.Auth login(UserRequest userRequest) {
        User user=userRepository.findByUsername(userRequest.getUserName()).orElseThrow(()->new RuntimeException("ko co userName nay"));
        BCryptPasswordEncoder encoder=new BCryptPasswordEncoder();
        boolean password=encoder.matches(userRequest.getPassWord(), user.getPassWord());
        if(!userRequest.getUserName().isEmpty()&&!userRequest.getPassWord().isEmpty()){
           if(user.getUsername().equals(userRequest.getUserName())&&password){
               String accessToken=jwtService.generateAccessToken(user.getUsername(),user.getRole().name());
               String refreshToken= jwtService.generateRefreshToken(user.getUsername());
               UserResponse.Auth auth=new UserResponse.Auth(accessToken,refreshToken);
               return auth;
           }
           else{
               throw new RuntimeException("sai tai khoan hoac mat khau");
           }
        }
        else{
            throw new RuntimeException("chua nhap day du");
        }

    }

    void validate(String userName,String passWord){
     Optional<User> user=userRepository.findByUsername(userName);
        if(user.isPresent()){
            throw new RuntimeException("userName da ton tai");
        }
        if(passWord.length()<6||passWord.length()>14){
            throw new RuntimeException("passWord length 6>14");
        }
    }
    UserResponse maptoResponse(User user) {
        UserResponse userResponse=new UserResponse();
        userResponse.setUserName(user.getUsername());
        userResponse.setPassWord(user.getPassWord());
        return userResponse;
    }
}
