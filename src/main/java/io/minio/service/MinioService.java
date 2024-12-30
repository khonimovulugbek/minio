package io.minio.service;

import io.minio.DeleteBucketEncryptionArgs;
import io.minio.GetObjectResponse;
import io.minio.ObjectWriteResponse;
import io.minio.StatObjectResponse;
import io.minio.http.Method;
import io.minio.messages.*;

import java.io.InputStream;
import java.util.List;
import java.util.Map;

/**
 * Author: Khonimov Ulugbek
 * Date: 10/27/2024 2:02 AM
 * Info:
 */
public interface MinioService {
    boolean bucketExists(String bucketName);

    DeleteBucketEncryptionArgs deleteBucketEncryption(String bucketName);

    void deleteBucketLifecycle(String bucketName);

    void deleteBucketTags(String bucketName);

    void deleteBucketPolicy(String bucketName);

    void deleteBucketReplication(String bucketName);

    void deleteBucketNotification(String bucketName);

    void deleteObjectLockConfiguration(String bucketName);

    SseConfiguration getBucketEncryption(String bucketName);

    LifecycleConfiguration getBucketLifecycle(String bucketName);

    NotificationConfiguration getBucketNotification(String bucketName);

    String getBucketPolicy(String bucketName);

    ReplicationConfiguration getBucketReplication(String bucketName);

    Tags getBucketTags(String bucketName);

    VersioningConfiguration getBucketVersioning(String bucketName);

    ObjectLockConfiguration getObjectLockConfiguration(String bucketName);

    List<Bucket> listBuckets();

    void createBucket(String bucketName);

    void removeBucket(String bucketName);

    void setBucketEncryption(String bucketName, SseConfiguration sseConfiguration);

    void setBucketLifecycle(String bucketName, List<LifecycleRule> rules);

    void setBucketNotification(String bucketName, List<QueueConfiguration> queueConfigurationList);

    void setBucketPolicy(String bucketName, String policyJson);

    void setBucketReplication(String bucketName, List<ReplicationRule> rules);

    void setBucketTags(String bucketName, Map<String, String> tags);

    void setBucketVersioning(String bucketName, VersioningConfiguration versioningConfiguration);

    void copyObject(String bucketName, String sourceBucketName, String objectName);

    void disableObjectLegalHold(String bucketName, String objectName);

    void enableObjectLegalHold(String bucketName, String objectName);

    GetObjectResponse getObject(String bucketName, String objectName);

    void downloadObject(String bucketName, String objectName, String fileName);

    Retention getObjectRetention(String bucketName, String objectName, String versionId);

    Tags getObjectTags(String bucketName, String objectName);

    String getPreSignedObjectUrl(String bucketName, String objectName, Method method);

    ObjectWriteResponse putObject(String bucketName, String objectName, InputStream inputStream);

    ObjectWriteResponse putObject(String bucketName, String objectName, String contentType, InputStream inputStream);

    ObjectWriteResponse uploadObject(String bucketName, String objectName, String fileName);

    ObjectWriteResponse uploadObject(String bucketName, String objectName, String fileName, String contentType);

    void removeObject(String bucketName, String objectName);

    void removeObject(String bucketName, String objectName, String versionId);

    StatObjectResponse statObject(String bucketName, String objectName);

    StatObjectResponse statObject(String bucketName, String objectName, String versionId);
}
