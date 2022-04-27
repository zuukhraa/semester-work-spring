package ru.itis.shagiakhmetova.services;

import org.springframework.web.multipart.MultipartFile;
import javax.servlet.http.HttpServletResponse;

public interface FileService {
    void uploadAvatar(MultipartFile multipartFile, Long accountId);
    void getFileByStorageName(String storageFileName, HttpServletResponse response);

}

