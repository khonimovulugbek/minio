package io.minio.helper;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;
import java.util.Objects;
import java.util.UUID;

/**
 * Author: Khonimov Ulugbek
 * Date: 12/30/2024 10:41 AM
 * Info:
 */
public class StringHelper {

    public static String parseJwt(HttpServletRequest request) {
        String headerAuth = request.getHeader("Authorization");

        if (StringUtils.hasText(headerAuth) && headerAuth.startsWith("Bearer ")) {
            return headerAuth.substring(7);
        }
        return null;
    }

    public static String fileDatePath() {
        LocalDate now = LocalDate.now();
        int year = now.getYear();
        int monthValue = now.getMonthValue();
        int dayOfMonth = now.getDayOfMonth();
        return "/" + year + "/" + monthValue + "/" + dayOfMonth + "/";
    }

    public static String getFileExtension(
            final MultipartFile file
    ) {
        return Objects.requireNonNull(file.getOriginalFilename())
                .substring(file.getOriginalFilename()
                        .lastIndexOf(".") + 1);
    }

    public static String generateFileName(final MultipartFile file) {
        String extension = getFileExtension(file);
        return UUID.randomUUID() + "." + extension;
    }
}
