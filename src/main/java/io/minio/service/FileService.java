package io.minio.service;

import io.minio.dto.FileResponse;
import org.springframework.web.multipart.MultipartFile;

/**
 * Author: Khonimov Ulugbek
 * Date: 10/26/2024 2:26 PM
 * Info:
 */
public interface FileService {
    FileResponse uploadFileToMinio(MultipartFile file);
}
