package com.rysiki.recipes;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ImportResource;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RequestMapping("/")
@RestController
public class AuthController {

    @Autowired
    private BasicAuthenticationProvider basicAuthenticationProvider;

    @Data
    public static class UserCredentials {
        String username;
        String password;
    }

    @PostMapping("login")
    ResponseEntity login(@RequestBody UserCredentials userCredentials) {
        UsernamePasswordAuthenticationToken authReq =
                new UsernamePasswordAuthenticationToken(userCredentials.getUsername(), userCredentials.getPassword());
        Authentication authentication = basicAuthenticationProvider.authenticate(authReq);
        if(authentication != null) {
            SecurityContextHolder.getContext().setAuthentication(authentication);
            return ResponseEntity.ok(HttpEntity.EMPTY);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("logout")
    ResponseEntity logout() {
        SecurityContextHolder.getContext().setAuthentication(null);
        return ResponseEntity.ok(HttpEntity.EMPTY);
    }
}
