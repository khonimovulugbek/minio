package io.minio.properties;

/**
 * Author: Khonimov Ulugbek
 * Date: 12/30/2024 10:27 AM
 * Info:
 */
public record MinioCdnDTO(
        String host,
        String accessKey,
        String secretKey,
        String bucketName,
        String publicPath,
        String alias) {
}
