package com.example.freeandnice.service;



import com.example.freeandnice.payload.request.AuthenticationRequest;
import com.example.freeandnice.payload.request.RegisterRequest;
import com.example.freeandnice.payload.response.AuthenticationResponse;

import java.text.ParseException;

public interface AuthenticationService {
    AuthenticationResponse register(RegisterRequest request) throws ParseException;
    AuthenticationResponse authenticate(AuthenticationRequest request);

    boolean activateUser(String code);
}
