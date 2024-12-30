package io.minio.controller;

import constants.MinioConstants;
import io.minio.dto.FileResponse;
import io.minio.service.FileService;
import io.minio.service.MinioService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * Author: Khonimov Ulugbek
 * Date: 12/30/2024 10:49 AM
 * Info:
 */
@RestController
@RequestMapping("/v1/minio")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class MinioController {
    private final FileService fileService;
    private final MinioService minioService;

    @PostMapping(value = "/upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public FileResponse uploadFile(@RequestParam("file") MultipartFile file) {
        return fileService.uploadFileToMinio(file);
    }

    @PostMapping("/bucket-policy")
    public String bucketPolicy(@RequestParam String bucketName) {
        minioService.setBucketPolicy(bucketName, MinioConstants.MINIO_ALLOW_POLICY);
        return minioService.getBucketPolicy(bucketName);

    }
}
