package com.example.freeandnice.service;

import com.example.freeandnice.entities.FileData;
import com.example.freeandnice.entities.RefreshToken;
import com.example.freeandnice.repository.RefreshTokenRepository;
import com.example.freeandnice.repository.UserRepository;
import com.example.freeandnice.service.impl.RefreshTokenServiceImpl;
import com.example.freeandnice.utils.DataUtils;
import org.antlr.v4.runtime.Token;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)
class RefreshTokenServiceTest {
    @Mock
    RefreshTokenRepository refreshTokenRepository;
    @Mock
    UserRepository userRepository;
    @InjectMocks
    RefreshTokenServiceImpl refreshTokenService;

    @Test
    public void testTokenCreation() {
        //      BDDMockito.given(fileDataRepository.findByName(anyString())).willReturn(null);
        //       BDDMockito.given(fileDataRepository.save(any(FileData.class))).willReturn(DataUtils.getFileDataPersisted());
       // Assertions.assertEquals(new RuntimeException("User not found"), refreshTokenService.createRefreshToken(1L) );
        userRepository.save(DataUtils.getUser());
        RefreshToken token = refreshTokenService.createRefreshToken(DataUtils.getUser().getId());
        assertThat(token).isNotNull();
    }


}
