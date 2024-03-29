package com.bookz.store.controller;


import com.bookz.store.LoginResponse;
import com.bookz.store.dtos.LoginUserDto;
import com.bookz.store.dtos.RegisterUserDto;
import com.bookz.store.model.Userr;
import com.bookz.store.service.AuthenticationService;
import com.bookz.store.service.JwtService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/auth")
@RestController
public class AuthenticationController {
    private final JwtService jwtService;

    private final AuthenticationService authenticationService;

    public AuthenticationController(JwtService jwtService, AuthenticationService authenticationService) {
        this.jwtService = jwtService;
        this.authenticationService = authenticationService;
    }


    @PostMapping("/signup")
    public ResponseEntity<Userr> register(@RequestBody RegisterUserDto registerUserDto) {
        System.out.println("To ye ahooye ghanari");
        Userr registeredUser = authenticationService.signup(registerUserDto);
        return ResponseEntity.ok(registeredUser);
    }

    @GetMapping ("/hi")
    public String h(){
        return "hiiii its meeeee";
    }

    @GetMapping("/login")
    public ResponseEntity<LoginResponse> authenticate(@RequestBody LoginUserDto loginUserDto) {
        Userr authenticatedUser = authenticationService.authenticate(loginUserDto);

        String jwtToken = jwtService.generateToken(authenticatedUser);

        LoginResponse loginResponse = new LoginResponse().setToken(jwtToken).setExpiresIn(jwtService.getExpirationTime());

        return ResponseEntity.ok(loginResponse);
    }
}
