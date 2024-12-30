package constants;

/**
 * Author: Khonimov Ulugbek
 * Date: 12/30/2024 11:07 AM
 * Info:
 */
public interface MinioConstants {
    String MINIO_ALLOW_POLICY = """
            {
                "Version": "2012-10-17",
                "Statement": [
                    {
                        "Effect": "Allow",
                        "Principal": {
                            "AWS": [
                                "*"
                            ]
                        },
                        "Action": [
                            "s3:GetBucketLocation",
                            "s3:ListBucket"
                        ],
                        "Resource": [
                            "arn:aws:s3:::*"
                        ]
                    },
                    {
                        "Effect": "Allow",
                        "Principal": {
                            "AWS": [
                                "*"
                            ]
                        },
                        "Action": [
                            "s3:GetObject"
                        ],
                        "Resource": [
                            "arn:aws:s3:::*"
                        ]
                    }
                ]
            }
            """;
}
