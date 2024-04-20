package com.example.freeandnice.service;


import com.example.freeandnice.entities.FileData;
import com.example.freeandnice.entities.User;
import com.example.freeandnice.repository.FileDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Optional;
import java.util.UUID;
@Service
public class StorageService {


    @Autowired
    private FileDataRepository fileDataRepository;
    //Раскомментировать и изменить под свою локальную структуру

    // private final String FOLDER_PATH="C:/Users/Admin/Desktop/kotitonttu/src/main/resources/";
    //Закомментировать в случае локального использования
    private final String FOLDER_PATH="/var/www/vuary/user_folder/";

    public FileData uploadImageToFileSystemAvatarUser(FileData fileData) throws IOException {
        String fileName = UUID.randomUUID().toString();

        String filePath = FOLDER_PATH + fileName + ".png";

        fileDataRepository.save(fileData);
      //  file.transferTo(new File(filePath));

        return fileData;
    }
    public FileData uploadImageToFileSystemDefaultAvatar() throws IOException {
        String fileName = "defaultAvatar.png";

        String filePath = FOLDER_PATH + fileName + ".png";

        FileData fileData=fileDataRepository.save(FileData.builder()
                .name("defaultAvatar.png")
                .type("image/jpeg")
                .filePath(filePath).build());
        return fileData;
    }

    public byte[] downloadImageFromFileSystem(String fileName) throws IOException {
        Optional<FileData> fileData = fileDataRepository.findByName(fileName);
        String filePath=fileData.get().getFilePath();
        byte[] images = Files.readAllBytes(new File(filePath).toPath());
        return images;
    }



}