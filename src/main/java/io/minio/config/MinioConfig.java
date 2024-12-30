package io.minio.config;

import io.minio.MinioClient;
import io.minio.properties.MinioCdnDTO;
import io.minio.properties.MinioProperties;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Author: Khonimov Ulugbek
 * Date: 12/30/2024 10:32 AM
 * Info:
 */
@Configuration
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class MinioConfig {
    private final MinioProperties minioProperties;

    @Bean
    public MinioClient minioClient() {
        String inRotation = minioProperties.getInRotation();
        MinioCdnDTO minioCdnDTO = minioProperties.getServers().get(inRotation);
        return MinioClient.builder()
                .endpoint(minioCdnDTO.host())
                .credentials(minioCdnDTO.accessKey(), minioCdnDTO.secretKey())
                .build();
    }
}
