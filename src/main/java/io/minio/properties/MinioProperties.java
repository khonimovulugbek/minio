package io.minio.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * Author: Khonimov Ulugbek
 * Date: 12/30/2024 10:26 AM
 * Info:
 */
@Component
@ConfigurationProperties(prefix = "minio")
@Data
public class MinioProperties {
    private Map<String, MinioCdnDTO> servers;
    private String inRotation;
}
