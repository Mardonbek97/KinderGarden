package com.example.kindergarden.Controller;

import com.example.kindergarden.Entity.KInderGardenUsers;
import com.example.kindergarden.config.MD5Config;
import com.example.kindergarden.dto.KinderGardenUsersDTO;
import com.example.kindergarden.repository.KinderGardenUsersRepository;
import com.example.kindergarden.service.KinderGardenUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private KinderGardenUsersRepository kinderGardenUsersRepository;
    private PasswordEncoder passwordEncoder;
    private AuthenticationManager authenticationManager;

    @Autowired
    private KinderGardenUserService kinderGardenUserService;

    @PostMapping("/register")
    public String register(@RequestBody KInderGardenUsers user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        kinderGardenUsersRepository.save(user);
        return "User registered successfully";
    }

    @GetMapping("/getall")
    public List<KInderGardenUsers> findAll(){
      return  kinderGardenUserService.getAll();
    }

}
