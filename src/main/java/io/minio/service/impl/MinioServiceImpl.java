package io.minio.service.impl;

import io.minio.*;
import io.minio.http.Method;
import io.minio.messages.*;
import io.minio.service.MinioService;
import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * Author: Khonimov Ulugbek
 * Date: 10/27/2024 2:09 AM
 * Info:
 */
@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class MinioServiceImpl implements MinioService {
    private final MinioClient minioClient;

    @Override
    public boolean bucketExists(String bucketName) {
        try {
            return minioClient.bucketExists(
                    BucketExistsArgs.builder()
                            .bucket(bucketName)
                            .build());
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public DeleteBucketEncryptionArgs deleteBucketEncryption(String bucketName) {
        return DeleteBucketEncryptionArgs.builder()
                .bucket(bucketName)
                .build();
    }

    @Override
    public void deleteBucketLifecycle(String bucketName) {
        try {
            minioClient.deleteBucketLifecycle(
                    DeleteBucketLifecycleArgs.builder()
                            .bucket(bucketName)
                            .build());
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }

    }

    @Override
    public void deleteBucketTags(String bucketName) {
        try {
            minioClient.deleteBucketTags(DeleteBucketTagsArgs.builder()
                    .bucket(bucketName)
                    .build());
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());

        }
    }

    // TODO : get it
    @Override
    public void deleteBucketPolicy(String bucketName) {
        try {
            minioClient.deleteBucketPolicy(DeleteBucketPolicyArgs.builder()
                    .bucket(bucketName)
                    .build());
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());

        }
    }

    @Override
    public void deleteBucketReplication(String bucketName) {
        try {
            minioClient.deleteBucketReplication(
                    DeleteBucketReplicationArgs.builder()
                            .bucket(bucketName)
                            .build());
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());

        }
    }

    @Override
    public void deleteBucketNotification(String bucketName) {
        try {
            minioClient.deleteBucketNotification(
                    DeleteBucketNotificationArgs.builder()
                            .bucket(bucketName)
                            .build());
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());

        }
    }

    @Override
    public void deleteObjectLockConfiguration(String bucketName) {
        try {
            minioClient.deleteObjectLockConfiguration(
                    DeleteObjectLockConfigurationArgs.builder()
                            .bucket(bucketName)
                            .build());
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());

        }
    }

    @Override
    public SseConfiguration getBucketEncryption(String bucketName) {
        try {
            return minioClient.getBucketEncryption(
                    GetBucketEncryptionArgs.builder()
                            .bucket(bucketName)
                            .build());
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());

        }
    }

    @Override
    public LifecycleConfiguration getBucketLifecycle(String bucketName) {
        try {
            return minioClient.getBucketLifecycle(
                    GetBucketLifecycleArgs.builder()
                            .bucket(bucketName)
                            .build());
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());

        }
    }

    @Override
    public NotificationConfiguration getBucketNotification(String bucketName) {
        try {
            return minioClient.getBucketNotification(
                    GetBucketNotificationArgs.builder()
                            .bucket(bucketName)
                            .build());
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());

        }
    }
// TODO : get it

    @Override
    public String getBucketPolicy(String bucketName) {
        try {
            return minioClient.getBucketPolicy(GetBucketPolicyArgs.builder()
                    .bucket(bucketName)
                    .build());
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());

        }
    }

    @Override
    public ReplicationConfiguration getBucketReplication(String bucketName) {
        try {
            return minioClient.getBucketReplication(
                    GetBucketReplicationArgs.builder()
                            .bucket(bucketName)
                            .build());
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());

        }
    }

    @Override
    public Tags getBucketTags(String bucketName) {
        try {
            return minioClient.getBucketTags(GetBucketTagsArgs.builder()
                    .bucket(bucketName)
                    .build());
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());

        }
    }

    @Override
    public VersioningConfiguration getBucketVersioning(String bucketName) {
        try {
            return minioClient.getBucketVersioning(
                    GetBucketVersioningArgs.builder()
                            .bucket(bucketName)
                            .build());
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());

        }
    }

    @Override
    public ObjectLockConfiguration getObjectLockConfiguration(String bucketName) {
        try {
            return minioClient.getObjectLockConfiguration(
                    GetObjectLockConfigurationArgs.builder()
                            .bucket(bucketName)
                            .build());
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());

        }
    }
// TODO : get it

    @Override
    public List<Bucket> listBuckets() {
        try {
            return minioClient.listBuckets();
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());

        }
    }
// TODO : get it

    @Override
    public void createBucket(String bucketName) {
        try {
            minioClient.makeBucket(
                    MakeBucketArgs.builder()
                            .bucket(bucketName)
                            .build());
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());

        }
    }

    // TODO : get it
    @Override
    public void removeBucket(String bucketName) {
        try {
            minioClient.removeBucket(RemoveBucketArgs.builder()
                    .bucket(bucketName)
                    .build());
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());

        }
    }

    @Override
    public void setBucketEncryption(String bucketName, SseConfiguration sseConfiguration) {
        try {
            minioClient.setBucketEncryption(
                    SetBucketEncryptionArgs.builder().bucket(bucketName)
                            .config(sseConfiguration)
                            .build());
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());

        }
    }

    @Override
    public void setBucketLifecycle(String bucketName, List<LifecycleRule> rules) {
        try {
/*            List<LifecycleRule> rules = new LinkedList<>();
            rules.add(
                    new LifecycleRule(
                            Status.ENABLED,
                            null,
                            null,
                            new RuleFilter("documents/"),
                            "rule1",
                            null,
                            null,
                            new Transition((ZonedDateTime) null, 30, "GLACIER")));
            rules.add(
                    new LifecycleRule(
                            Status.ENABLED,
                            null,
                            new Expiration((ZonedDateTime) null, 365, null),
                            new RuleFilter("logs/"),
                            "rule2",
                            null,
                            null,
                            null));*/
            LifecycleConfiguration config = new LifecycleConfiguration(rules);
            minioClient.setBucketLifecycle(
                    SetBucketLifecycleArgs.builder()
                            .bucket(bucketName)
                            .config(config)
                            .build());
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());

        }
    }

    @Override
    public void setBucketNotification(String bucketName, List<QueueConfiguration> queueConfigurationList) {
        try {
/*
            List<EventType> eventList = new LinkedList<>();
            eventList.add(EventType.OBJECT_CREATED_PUT);
            eventList.add(EventType.OBJECT_CREATED_COPY);

            QueueConfiguration queueConfiguration = new QueueConfiguration();
            queueConfiguration.setQueue("arn:minio:sqs::1:webhook");
            queueConfiguration.setEvents(eventList);
            queueConfiguration.setPrefixRule("images");
            queueConfiguration.setSuffixRule("pg");

            List<QueueConfiguration> queueConfigurationList = new LinkedList<>();
            queueConfigurationList.add(queueConfiguration);
*/
            NotificationConfiguration config = new NotificationConfiguration();
            config.setQueueConfigurationList(queueConfigurationList);

            minioClient.setBucketNotification(
                    SetBucketNotificationArgs.builder().bucket(bucketName)
                            .config(config)
                            .build());
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());

        }
    }

    // TODO : get This
    @Override
    public void setBucketPolicy(String bucketName, String policyJson) {
        try {
            minioClient.setBucketPolicy(
                    SetBucketPolicyArgs.builder().bucket(bucketName)
                            .config(policyJson)
                            .build());
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());

        }
    }

    @Override
    public void setBucketReplication(String bucketName, List<ReplicationRule> rules) {
        try {
/*
            Map<String, String> tags = new HashMap<>();
            tags.put("key1", "value1");
            tags.put("key2", "value2");

            ReplicationRule rule =
                    new ReplicationRule(
                            new DeleteMarkerReplication(Status.DISABLED),
                            new ReplicationDestination(
                                    null, null, "REPLACE-WITH-ACTUAL-DESTINATION-BUCKET-ARN", null, null, null, null),
                            null,
                            new RuleFilter(new AndOperator("TaxDocs", tags)),
                            "rule1",
                            null,
                            1,
                            null,
                            Status.ENABLED);

            List<ReplicationRule> rules = new LinkedList<>();
            rules.add(rule);
*/
            ReplicationConfiguration config =
                    new ReplicationConfiguration("REPLACE-WITH-ACTUAL-ROLE", rules);

            minioClient.setBucketReplication(
                    SetBucketReplicationArgs.builder().bucket(bucketName)
                            .config(config)
                            .build());
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());

        }
    }

    @Override
    public void setBucketTags(String bucketName, Map<String, String> tags) {
        try {
//            Map<String, String> map = new HashMap<>();
//            map.put("Project", "Project One");
//            map.put("User", "jsmith");
            minioClient.setBucketTags(SetBucketTagsArgs.builder()
                    .bucket(bucketName)
                    .tags(tags)
                    .build());
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());

        }
    }

    @Override
    public void setBucketVersioning(String bucketName, VersioningConfiguration versioningConfiguration) {
        try {
            minioClient.setBucketVersioning(
                    SetBucketVersioningArgs.builder()
                            .bucket(bucketName)
                            .config(versioningConfiguration)
                            .build());
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());

        }
    }

    // TODO : get it
    @Override
    public void copyObject(String bucketName, String sourceBucketName, String objectName) {
        try {
            minioClient.copyObject(
                    CopyObjectArgs.builder()
                            .bucket(bucketName)
                            .object(objectName)
                            .source(
                                    CopySource.builder()
                                            .bucket(sourceBucketName)
                                            .object(objectName)
                                            .build())
                            .build());
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());

        }
    }

    @Override
    public void disableObjectLegalHold(String bucketName, String objectName) {
        try {
            minioClient.disableObjectLegalHold(
                    DisableObjectLegalHoldArgs.builder()
                            .bucket(bucketName)
                            .object(objectName)
                            .build());
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());

        }
    }

    @Override
    public void enableObjectLegalHold(String bucketName, String objectName) {
        try {
            minioClient.enableObjectLegalHold(
                    EnableObjectLegalHoldArgs.builder()
                            .bucket(bucketName)
                            .object(objectName)
                            .build());
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());

        }
    }

    // TODO : Get this
    @Override
    public GetObjectResponse getObject(String bucketName, String objectName) {
        try {
            return minioClient.getObject(
                    GetObjectArgs.builder()
                            .bucket(bucketName)
                            .object(objectName)
                            .build());
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());

        }
    }

    @Override
    public void downloadObject(String bucketName, String objectName, String fileName) {
        try {
            minioClient.downloadObject(
                    DownloadObjectArgs.builder()
                            .bucket(bucketName)
                            .object(objectName)
                            .filename(fileName)
                            .build());
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());

        }
    }

    @Override
    public Retention getObjectRetention(String bucketName, String objectName, String versionId) {
        try {
            return minioClient.getObjectRetention(
                    GetObjectRetentionArgs.builder()
                            .bucket(bucketName)
                            .object(objectName)
                            .versionId(versionId)
                            .build());
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());

        }
    }

    @Override
    public Tags getObjectTags(String bucketName, String objectName) {
        try {
            return minioClient.getObjectTags(
                    GetObjectTagsArgs.builder()
                            .bucket(bucketName)
                            .object(objectName)
                            .build());
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());

        }
    }

    // TODO : get it
    @Override
    public String getPreSignedObjectUrl(String bucketName, String objectName, Method method) {
        try {
            return minioClient.getPresignedObjectUrl(
                    GetPresignedObjectUrlArgs.builder()
                            .method(method)
                            .bucket(bucketName)
                            .object(objectName)
                            .expiry(7, TimeUnit.DAYS)
                            .build());
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());

        }
    }

    // TODO : Get this
    @Override
    public ObjectWriteResponse putObject(String bucketName, String objectName, InputStream inputStream) {
        try {
            return minioClient.putObject(
                    PutObjectArgs.builder()
                            .bucket(bucketName)
                            .object(objectName).stream(
                                    inputStream, inputStream.available(), -1)
                            .build());
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());

        }
    }

    // TODO : get it
    @Override
    public ObjectWriteResponse putObject(String bucketName, String objectName, String contentType, InputStream inputStream) {
        try {
            return minioClient.putObject(
                    PutObjectArgs.builder()
                            .bucket(bucketName)
                            .object(objectName).stream(
                                    inputStream, inputStream.available(), -1)
                            .contentType(contentType)
                            .build());
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());

        }
    }

    @Override
    public ObjectWriteResponse uploadObject(String bucketName, String objectName, String fileName) {
        try {
            return minioClient.uploadObject(
                    UploadObjectArgs.builder()
                            .bucket(bucketName)
                            .object(objectName)
                            .filename(fileName)
                            .build());
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());

        }
    }

    @Override
    public ObjectWriteResponse uploadObject(String bucketName, String objectName, String fileName, String contentType) {
        try {
            return minioClient.uploadObject(
                    UploadObjectArgs.builder()
                            .bucket(bucketName)
                            .object(objectName)
                            .filename(fileName)
                            .contentType(contentType)
                            .build());
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());

        }
    }

    // TODO : get it
    @Override
    public void removeObject(String bucketName, String objectName) {
        try {
            minioClient.removeObject(
                    RemoveObjectArgs.builder()
                            .bucket(bucketName)
                            .object(objectName)
                            .build());
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());

        }
    }

    // TODO : get it
    @Override
    public void removeObject(String bucketName, String objectName, String versionId) {
        try {
            minioClient.removeObject(
                    RemoveObjectArgs.builder()
                            .bucket(bucketName)
                            .object(objectName)
                            .versionId(versionId)
                            .build());
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());

        }
    }

    @Override
    public StatObjectResponse statObject(@NotNull final String bucketName,
                                         @NotNull final String objectName) {
        try {
            return minioClient.statObject(
                    StatObjectArgs.builder()
                            .bucket(bucketName)
                            .object(objectName)
                            .build());
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());

        }
    }

    @Override
    public StatObjectResponse statObject(@NotNull final String bucketName,
                                         @NotNull final String objectName,
                                         @NotNull final String versionId) {
        try {
            return minioClient.statObject(
                    StatObjectArgs.builder()
                            .bucket(bucketName)
                            .object(objectName)
                            .versionId(versionId)
                            .build());
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());

        }
    }


}
