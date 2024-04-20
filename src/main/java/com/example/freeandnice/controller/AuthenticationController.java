package com.example.freeandnice.controller;



import com.example.freeandnice.entities.User;
import com.example.freeandnice.payload.request.RegisterRequest;
import com.example.freeandnice.payload.response.AuthenticationResponse;
import com.example.freeandnice.repository.UserRepository;
import com.example.freeandnice.service.AuthenticationService;
import com.example.freeandnice.service.JwtService;
import com.example.freeandnice.service.RefreshTokenService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirements;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.text.ParseException;


@Tag(name = "Authentication", description = "The Authentication API. Contains operations like login, logout, refresh-token etc.")
@RestController
@RequestMapping("/api")
@SecurityRequirements()
@RequiredArgsConstructor
public class AuthenticationController {
    private final AuthenticationService authenticationService;
    private final RefreshTokenService refreshTokenService;
    private final JwtService jwtService;
    private final UserRepository userRepository;
    @Operation(summary = "Регистрация пользователя", description = "Этот эндпоинт позволяет пользователю зарегистрироваться.")
    @PostMapping(value = "/register", consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.MULTIPART_FORM_DATA_VALUE})
    public ResponseEntity<Object> register(@RequestPart RegisterRequest request) throws IOException, ParseException {
        AuthenticationResponse authenticationResponse = authenticationService.register(request);
        User user = userRepository.findByEmail(request.getEmail()).orElse(null);
        ResponseCookie jwtCookie = jwtService.generateJwtCookie(authenticationResponse.getAccessToken());
        ResponseCookie refreshTokenCookie = refreshTokenService.generateRefreshTokenCookie(authenticationResponse.getRefreshToken());
        return ResponseEntity.ok()
                .header(HttpHeaders.SET_COOKIE, jwtCookie.toString())
                .header(HttpHeaders.SET_COOKIE, refreshTokenCookie.toString()).body(null);
    }
}

