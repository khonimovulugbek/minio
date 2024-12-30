package io.minio.service.impl;

import io.minio.dto.FileResponse;
import io.minio.helper.MinioHelper;
import io.minio.helper.StringHelper;
import io.minio.service.FileService;
import io.minio.service.MinioService;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;

/**
 * Author: Khonimov Ulugbek
 * Date: 12/30/2024 10:40 AM
 * Info:
 */
@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class FileServiceImpl implements FileService {
    private final MinioService minioService;

    @Override
    @SneakyThrows
    public FileResponse uploadFileToMinio(MultipartFile file) {
        String bucketName = MinioHelper.currentBucketName();
        boolean bucketExists = minioService.bucketExists(bucketName);
        if (!bucketExists) minioService.createBucket(bucketName);
        String fileName = StringHelper.generateFileName(file);
        String datePath = StringHelper.fileDatePath();
        InputStream inputStream = file.getInputStream();
        String filePath = minioService.putObject(bucketName, datePath + fileName, inputStream).object();
        return new FileResponse(fileName, MinioHelper.currentPublicPath() + filePath);
    }
}
