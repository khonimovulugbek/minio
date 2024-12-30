package io.minio.helper;


import io.minio.properties.MinioCdnDTO;
import io.minio.properties.MinioProperties;

import java.util.*;

/**
 * Author: Khonimov Ulugbek
 * Date: 12/30/2024 10:29 AM
 * Info:
 */
public class MinioHelper {
    public static MinioCdnDTO currentMinioCdn() {
        MinioProperties properties = BeanUtil.getBean(MinioProperties.class);
        String rotation = properties.getInRotation();
        MinioCdnDTO minioCdnDTO = properties.getServers().get(rotation);
        if (minioCdnDTO == null) throw new RuntimeException("Minio is not defined in rotation " + rotation);
        return minioCdnDTO;
    }

    public static String currentBucketName() {
        return currentMinioCdn().bucketName();
    }

    public static String currentPublicPath() {
        MinioCdnDTO minioCdnDTO = currentMinioCdn();
        return minioCdnDTO.publicPath();
    }

}
