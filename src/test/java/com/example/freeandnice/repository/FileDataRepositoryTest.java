package com.example.freeandnice.repository;

import com.example.freeandnice.entities.Bid;
import com.example.freeandnice.entities.FileData;
import com.example.freeandnice.utils.DataUtils;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)
class FileDataRepositoryTest {

        @Mock
        FileDataRepository fileDataRepository;
        @Test
        public void testUpload() {
            FileData fileData =  DataUtils.getFileDataPersisted(); //
            fileDataRepository.save(fileData);
            assertThat(fileDataRepository.findById(fileData.getId())).isNotNull();
        }

}