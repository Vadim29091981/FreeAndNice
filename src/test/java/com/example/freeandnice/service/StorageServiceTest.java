package com.example.freeandnice.service;

import com.example.freeandnice.entities.FileData;
import com.example.freeandnice.repository.FileDataRepository;
import com.example.freeandnice.utils.DataUtils;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.IOException;


import static org.assertj.core.api.Assertions.assertThat;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class StorageServiceTest {

    @Mock
    FileDataRepository fileDataRepository;

    @InjectMocks
    StorageService storageService;

    @Test
    public void testUpload() {
        FileData fileData = DataUtils.getFileDataTransient();  //

        FileData savedData = null;
        try {
            savedData = storageService.uploadImageToFileSystemAvatarUser(fileData);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        assertThat(savedData).isNotNull();
    }


}