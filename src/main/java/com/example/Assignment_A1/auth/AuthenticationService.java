package com.example.Assignment_A1.auth;

import com.example.Assignment_A1.config.JwtService;

import com.example.Assignment_A1.repository.UserRepository;
import com.example.Assignment_A1.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static com.example.Assignment_A1.model.Role.CASHIER;

@Service
@RequiredArgsConstructor

public class AuthenticationService {



    private final UserRepository userRepository;


    private final PasswordEncoder passwordEncoder;


    private  final JwtService jwtService;

    private final UserService userService;


    private final AuthenticationManager authenticationManager;

//    public AuthenticationResponse register(RegisterRequest request){
//        var user = User.builder()
//                .username(request.getUsername())
//                .password(passwordEncoder.encode(request.getPassword()))
//                .roles(String.valueOf(Role.CASHIER))
//                .build();
//       userRepository.save(user);
//        var jwtToken = jwtService.generateToken(user);
//        return AuthenticationResponse.builder().token(jwtToken).build();
//    }

    public AuthenticationResponse register(RegisterRequest request) {
        var user = User.builder()
                .username(request.getUsername())
                .password(request.getPassword())
                .roles(String.valueOf(CASHIER))
                .build();
//        User u = new User(user.getUsername(), user.getPassword())

       // userRepository.save( user);
        com.example.Assignment_A1.model.User u = new com.example.Assignment_A1.model.User(user.getUsername(), user.getPassword(), CASHIER);
        userService.addUser(u);
        var jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }

    public AuthenticationResponse auth(AuthenticationRequest request) {
        //authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(),request.getPassword()));
//        var us = userService.findByUsername(request.getUsername());
//        UserDetails user = null;
//        if(us != null){
        var user = User.builder()
                    .username(request.getUsername())
                    .password(request.getPassword())
                    .roles(String.valueOf(CASHIER))
                    .build();
    //}
//        User u = new User(user.getUsername(), user.getPassword())

            // userRepository.save( user);
            //com.example.Assignment_A1.model.User u = new com.example.Assignment_A1.model.User(user.getUsername(), user.getPassword(), CASHIER);
            //userService.addUser(u);
            var jwtToken = jwtService.generateToken(user);
         //authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(),request.getPassword()));
            return AuthenticationResponse.builder()
                    .token(jwtToken)
                    .build();

    }

    public AuthenticationResponse authenticate(AuthenticationRequest request){
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(),request.getPassword()));
        Optional<com.example.Assignment_A1.model.User> user = userService.findByUsername(request.getUsername());

        System.out.println(user.get().getUsername());

        var us = User.builder().username(request.getUsername()).password(request.getPassword()).build();
        var jwtToken = jwtService.generateToken(us);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }

    public AuthenticationResponse login(AuthenticationRequest request) {
         authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getUsername(),
                request.getPassword()
                )
        );
       // System.out.println(request.getUsername() + passwordEncoder.encode(request.getPassword()));
        var user = userRepository.findByUsername(request.getUsername()).orElseThrow();
      //  if(user != null) {
            var token = jwtService.generateToken(user);
            return AuthenticationResponse.builder().token(token).build();

    }
}




