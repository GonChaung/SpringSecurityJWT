package com.twd.SpringSecurityJWT.controller;

import com.twd.SpringSecurityJWT.dto.ReqRes;
import com.twd.SpringSecurityJWT.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    public AuthService authService;

    @PostMapping("/signup")
    public ResponseEntity<ReqRes> signUp(@RequestBody ReqRes signUpRequest) {
        return ResponseEntity.ok(authService.signUp(signUpRequest));
    }

    @PostMapping("/signin")
    public ResponseEntity<ReqRes> signIn(@RequestBody ReqRes singInRequest) {
        ReqRes res = authService.signIn(singInRequest);
        if (res.getStatusCode() == 500) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(res);
        }
        return ResponseEntity.ok(res);
    }


    @PostMapping("/refresh")
    public ResponseEntity<ReqRes> refreshToken(@RequestBody ReqRes refreshTokenRequest){
        return ResponseEntity.ok(authService.refreshToken(refreshTokenRequest));
    }

}
